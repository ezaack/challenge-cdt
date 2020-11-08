package br.ctg.challenge.order.model.vo;

import java.time.OffsetDateTime;

import br.ctg.challenge.order.model.enumeration.EnumPaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaymentVo {
    private Long id;
    private EnumPaymentStatus enumPaymentStatus;
    private OffsetDateTime dateTimePayment;
    private String credCardNumber;
}
