package br.ctg.challenge.order.services.order.impl;

import br.ctg.challenge.order.adapter.GetPeymentAdapter;
import br.ctg.challenge.order.adapter.RefundPaymentAdapter;
import br.ctg.challenge.order.adapter.imp.RefundPaymentAdapterStub;
import br.ctg.challenge.order.model.enumeration.EnumOrderStatus;
import br.ctg.challenge.order.model.repository.OrderRepository;
import br.ctg.challenge.order.services.order.RefundOrderService;
import br.ctg.challenge.order.validation.validator.RefundOrderConfirmation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RefundOrderServiceImpl implements RefundOrderService {
    @Autowired
    private RefundOrderConfirmation refundOrderConfirmation;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private GetPeymentAdapter getPeymentAdapter;
    @Autowired
    private RefundPaymentAdapter refundPaymentAdapter;

    @Override
    public void refund(Long orderId) {
        refundOrderConfirmation.validateAndThrowViolationAsException(orderId);

        refundPayment(orderId);
        updateOrdersStatus(orderId);
    }

    private void updateOrdersStatus(Long orderId) {
        orderRepository.findById(
                orderId
        ).ifPresent(
                order -> {
                    order.setStatus(EnumOrderStatus.REFUNDED);
                    orderRepository.save(order);
                }
        );
    }

    private void refundPayment(Long orderId) {
        getPeymentAdapter.getByOrder(orderId).ifPresent(
                payment -> refundPaymentAdapter.refund(payment.getId())
        );
    }
}
