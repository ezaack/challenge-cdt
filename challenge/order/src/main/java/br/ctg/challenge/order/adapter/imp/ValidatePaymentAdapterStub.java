package br.ctg.challenge.order.adapter.imp;

import javax.annotation.PostConstruct;

import br.ctg.challenge.order.adapter.ValidatePaymentAdapter;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

/**
 * This stub replaces an HTTP client adapter for Payment Microservice
 */
@Service
@Getter
@Setter
public class ValidatePaymentAdapterStub implements ValidatePaymentAdapter {
    private Boolean ret;

    @PostConstruct
    public void init(){
        ret = true;
    }
    @Override
    public Boolean isValid(Long idPayment, Long idOrder) {
        return ret;
    }
}
