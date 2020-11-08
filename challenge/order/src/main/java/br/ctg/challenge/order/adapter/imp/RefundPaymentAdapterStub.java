package br.ctg.challenge.order.adapter.imp;

import br.ctg.challenge.order.adapter.RefundPaymentAdapter;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * This stub replaces an HTTP client adapter for Payment Microservice
 */
@Service
@Log4j2
public class RefundPaymentAdapterStub implements RefundPaymentAdapter {
    @Override
    public void refund(Long idPayment) {
        log.info("Payment refunded");
    }
}
