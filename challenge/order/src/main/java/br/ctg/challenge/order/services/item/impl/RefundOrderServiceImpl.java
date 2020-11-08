package br.ctg.challenge.order.services.item.impl;

import br.ctg.challenge.order.model.enumeration.EnumOrderStatus;
import br.ctg.challenge.order.model.repository.OrderRepository;
import br.ctg.challenge.order.services.item.RefundOrderService;
import br.ctg.challenge.order.validation.validator.RefundOrderConfirmation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RefundOrderServiceImpl implements RefundOrderService {
    @Autowired
    private RefundOrderConfirmation refundOrderConfirmation;
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public void refund(Long orderId) {
        refundOrderConfirmation.validateAndThrowViolationAsException(orderId);
        orderRepository.findById(
                orderId
        ).ifPresent(
                order -> {
                    order.setStatus(EnumOrderStatus.REFUNDED);
                    orderRepository.save(order);
                }
        );
    }
}
