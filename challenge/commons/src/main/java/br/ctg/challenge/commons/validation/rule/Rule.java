package br.ctg.challenge.commons.validation.rule;

public interface Rule<S> {

    String validar(S objetoValidavel);

    void adicionarCondicoes();
}
