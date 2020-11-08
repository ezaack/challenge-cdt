package br.ctg.challenge.order.model.vo;

import java.math.BigDecimal;

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
public class ItemVO {

    private Long id;
    private Long orderId;
    private String description;
    private Integer quantity;
    private BigDecimal unitaryPrice;
}
