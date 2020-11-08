package br.ctg.challenge.order.adapter;

public interface ValidatePaymentAdapter {

    Boolean isValid(Long idPayment, Long idOrder);
}
