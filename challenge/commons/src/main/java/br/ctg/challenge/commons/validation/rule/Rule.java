package br.ctg.challenge.commons.validation.rule;

public interface Rule<S> {

    String validate(S objetoValidavel);

    void adicionarCondicoes();
}
