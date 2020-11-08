package br.ctg.challenge.order.model.vo;

import java.time.OffsetDateTime;
import java.util.List;

import br.ctg.challenge.order.model.enumeration.EnumOrderStatus;
import br.ctg.challenge.order.model.enumeration.EnumUF;
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
public class OrderVO {

    private Long id;
    public OffsetDateTime confirmationDateTime;
    private EnumOrderStatus enumOrderStatus;
    private String street;
    private Integer number;
    private String neighborhood;
    private EnumUF state;
    private String complement;
    private String zipcode;
    private List<ItemVO> items;
}
