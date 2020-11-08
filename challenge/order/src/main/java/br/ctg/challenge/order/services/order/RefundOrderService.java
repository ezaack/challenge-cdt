package br.ctg.challenge.order.services.order;

import br.ctg.challenge.order.model.vo.ConfirmationVo;

public interface RefundOrderService {
    void refund(Long orderId);
}
