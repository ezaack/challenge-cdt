package br.ctg.challenge.commons.exception;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

@Getter
public class CtgValidationException extends RuntimeException {

    private List<String> violationMessages;

    public CtgValidationException(String message, List<String> violationMessages) {
        super(message);
        this.violationMessages = violationMessages;
    }

    public CtgValidationException(String message, String... violationMessages) {
        super(message);
        this.violationMessages = Arrays.asList(violationMessages);
    }
}
