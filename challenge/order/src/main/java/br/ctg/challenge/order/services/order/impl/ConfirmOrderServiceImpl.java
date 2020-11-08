package br.ctg.challenge.order.services.order.impl;

import java.time.OffsetDateTime;

import br.ctg.challenge.order.model.enumeration.EnumOrderStatus;
import br.ctg.challenge.order.model.repository.OrderRepository;
import br.ctg.challenge.order.model.vo.ConfirmationVo;
import br.ctg.challenge.order.services.order.ConfirmOrderService;
import br.ctg.challenge.order.validation.validator.ValidatorOrderConfirmation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfirmOrderServiceImpl implements ConfirmOrderService {
    @Autowired
    private ValidatorOrderConfirmation validatorOrderConfirmation;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void confirm(ConfirmationVo confirmationVo) {
        validatorOrderConfirmation.validateAndThrowViolationAsException(confirmationVo);
        orderRepository.findById(
                confirmationVo.getIdOrder()
        ).ifPresent(
                order -> {
                    order.setStatus(EnumOrderStatus.CONFIRMED);
                    order.setConfirmationDateTime(OffsetDateTime.now());
                    orderRepository.save(order);
                }
        );
    }
}
