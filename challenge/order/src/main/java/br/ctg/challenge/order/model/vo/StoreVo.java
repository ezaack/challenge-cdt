package br.ctg.challenge.order.model.vo;

import br.ctg.challenge.order.model.enumeration.EnumUF;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class StoreVo {

    private Long id;
    private String name;
    private String street;
    private Integer number;
    private String neighborhood;
    private EnumUF state;
    private String complement;
}
