package br.ctg.challenge.order.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.OffsetDateTime;
import java.util.List;

import br.ctg.challenge.order.model.enumeration.EnumOrderStatus;
import br.ctg.challenge.order.model.enumeration.EnumUF;
import br.ctg.challenge.order.model.enumeration.converter.EnumUFConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public OffsetDateTime confirmationDateTime;

    @Enumerated(EnumType.STRING)
    private EnumOrderStatus enumOrderStatus;

    private String street;
    private Integer number;

    private String neighborhood;
    @Convert(converter = EnumUFConverter.class)
    private EnumUF state;
    private String complement;
    private String zipcode;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> items;
}
