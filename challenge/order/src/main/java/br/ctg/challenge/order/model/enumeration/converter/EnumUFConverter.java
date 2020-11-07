package br.ctg.challenge.order.model.enumeration.converter;


import javax.persistence.AttributeConverter;

import br.ctg.challenge.order.model.enumeration.EnumUF;

public class EnumUFConverter implements AttributeConverter<EnumUF, String> {
    @Override
    public String convertToDatabaseColumn(EnumUF etapa) {
        return etapa != null ? etapa.getSigla() : null;
    }

    @Override
    public EnumUF convertToEntityAttribute(String codigo) {
        try {
            return EnumUF.getByUf(codigo);
        }catch(Exception ex) {
            return EnumUF.getByOrdinal(codigo);
        }
    }
}