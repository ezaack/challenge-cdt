package br.ctg.challenge.store.model.enumeration;

import lombok.Getter;

@Getter
public enum EnumUF {
    AM("Amazonas", "AM", "Manaus"),
    AL("Alagoas", "AL", "Maceió"),
    AC("Acre", "AC", "Rio Branco"),
    AP("Amapá", "AP", "Macapá"),
    BA("Bahia", "BA", "Salvador"),
    PA("Pará", "PA", "Belém"),
    MT("Mato Grosso", "MT", "Cuiabá"),
    MG("Minas Gerais", "MG", "Belo Horizonte"),
    MS("Mato Grosso do Sul", "MS", "Campo Grande"),
    GO("Goiás", "GO", "Goiânia"),
    MA("Maranhão", "MA", "São Luís"),
    RS("Rio Grande do Sul", "RS", "Porto Alegre"),
    TO("Tocantins", "TO", "Palmas"),
    PI("Piauí", "PI", "Teresina"),
    SP("São Paulo", "SP", "São Paulo"),
    RO("Rondônia", "RO", "Porto Velho"),
    RR("Roraima", "RR", "Boa Vista"),
    PR("Paraná", "PR", "Curitiba"),
    CE("Ceará", "CE", "Fortaleza"),
    PE("Pernambuco", "PE", "Recife"),
    SC("Santa Catarina", "SC", "Florianópolis"),
    PB("Paraíba", "PB", "João Pessoa"),
    RN("Rio Grande do Norte", "RN", "Natal"),
    ES("Espírito Santo", "ES", "Vitória"),
    RJ("Rio de Janeiro", "RJ", "Rio de Janeiro"),
    SE("Sergipe", "SE", "Aracaju"),
    DF("Distrito Federal", "DF", "Brasília");

    private final String nome;
    private final String sigla;
    private final String capital;

    EnumUF(String nome, String sigla, String capital) {
        this.nome = nome;
        this.sigla = sigla;
        this.capital = capital;
    }

    public static EnumUF getByUf(String uf) {
        for (EnumUF euf : values()) {
            if (uf != null && euf.getSigla().equalsIgnoreCase(uf)) {
                return euf;
            }
        }

        return null;
    }
    public static EnumUF getByOrdinal(String ord) {
        for (EnumUF euf : values()) {
            if (ord != null && (euf.getSigla().equalsIgnoreCase(ord)) || Integer.valueOf(ord).equals(euf.ordinal())  ) {
                return euf;
            }
        }
        return null;
    }
}
