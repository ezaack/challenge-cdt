package br.ctg.challenge.commons.validation.validator;

import java.util.List;

public interface Validator<S> {


    void adicionarRegrasCondicoesESubValidaddores();

    List<String> validateAndReturnViolations(S objetoValidavel);

    void validateAndThrowViolationAsException(S objetoValidavel);

}
