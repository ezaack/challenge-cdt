package br.ctg.challenge.store.model.entity;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.ctg.challenge.store.model.enumeration.EnumUF;
import br.ctg.challenge.store.model.enumeration.converter.EnumUFConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="TB_STORE")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String street;
    private Integer number;

    private String neighborhood;
    @Convert(converter = EnumUFConverter.class)
    private EnumUF state;
    private String complement;
    private String zipcode;
}
