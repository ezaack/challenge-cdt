package br.ctg.challenge.commons.validation.validator;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.ctg.challenge.commons.exception.CtgValidationException;
import br.ctg.challenge.commons.validation.condition.Condition;
import br.ctg.challenge.commons.validation.rule.Rule;

public abstract class AbstractValidator<S> implements Validator<S> {

    private List<Condition> condicoes = new ArrayList<>();
    private List<Rule> regras = new ArrayList<>();
    private List<Validator> validadores = new ArrayList<>();

    @PostConstruct
    public void init() {
        adicionarRegrasCondicoesESubValidaddores();
    }

    public abstract void adicionarRegrasCondicoesESubValidaddores();

    public List<String> validarERetornar(S objetoValidavel) {
        List<String> mensagensValidacao = new ArrayList<>();

        if ((condicoes.isEmpty() || condicoes.stream().filter(c -> !c.conditionTriggered(objetoValidavel)).count() == 0)
                &&
                !regras.isEmpty()) {
            mensagensValidacao.addAll(regras.stream().map(r -> r.validar(objetoValidavel)).filter(r -> r != null).collect(Collectors.toList()));
            if (!validadores.isEmpty()) {
                mensagensValidacao.addAll(validadores.stream().map(v -> v.validarERetornar(objetoValidavel)).reduce(
                        (a, b) -> {
                            a.addAll(b);
                            return a;
                        }).get()
                );
            }

        }
        return mensagensValidacao;
    }

    public void validarELancarExcessao(S objetoValidavel) {
        List<String> mensagensValidacao = validarERetornar(objetoValidavel);

        if (!mensagensValidacao.isEmpty()) {
            throw new CtgValidationException("Existem erros de validação", mensagensValidacao);
        }
    }

    protected void addCondicao(Condition condicao) {
        condicoes.add(condicao);
    }

    protected void addRegra(Rule regra) {
        regras.add(regra);
    }

    protected void addValidador(Validator validador) {
        validadores.add(validador);
    }
}
