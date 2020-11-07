package br.ctg.challenge.commons.exception;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

@Getter
public class CtgValidationException extends RuntimeException {

    private List<String> mensagensValidacao;

    public CtgValidationException(String message, List<String> mensagensValidacao) {
        super(message);
        this.mensagensValidacao = mensagensValidacao;
    }

    public CtgValidationException(String message, String... mensagensValidacao) {
        super(message);
        this.mensagensValidacao = Arrays.asList(mensagensValidacao);
    }
}
