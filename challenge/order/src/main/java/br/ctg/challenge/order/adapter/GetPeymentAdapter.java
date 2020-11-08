package br.ctg.challenge.order.adapter;

import java.util.Optional;

import br.ctg.challenge.order.model.vo.PaymentVo;

public interface GetPeymentAdapter {

    Optional<PaymentVo> get(Long idPayment);
    Optional<PaymentVo> getByOrder(Long idOrder);
}
