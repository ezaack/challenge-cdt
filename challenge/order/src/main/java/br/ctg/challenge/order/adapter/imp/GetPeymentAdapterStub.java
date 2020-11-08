package br.ctg.challenge.order.adapter.imp;

import javax.annotation.PostConstruct;
import java.util.Optional;

import br.ctg.challenge.order.adapter.GetPeymentAdapter;
import br.ctg.challenge.order.model.vo.PaymentVo;
import lombok.Setter;
import org.springframework.stereotype.Service;
/**
 * This stub replaces an HTTP client adapter for Payment Microservice
 */
@Service
@Setter
public class GetPeymentAdapterStub implements GetPeymentAdapter {

    private PaymentVo paymentVo;

    @PostConstruct
    public void init(){
        paymentVo = new PaymentVo();
    }
    @Override
    public Optional<PaymentVo> get(Long idPayment) {
        return Optional.of(paymentVo);
    }

    @Override
    public Optional<PaymentVo> getByOrder(Long idOrder) {
        return Optional.of(paymentVo);
    }
}
