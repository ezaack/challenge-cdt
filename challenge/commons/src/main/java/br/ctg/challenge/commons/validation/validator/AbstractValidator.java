package br.ctg.challenge.commons.validation.validator;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.ctg.challenge.commons.exception.CtgValidationException;
import br.ctg.challenge.commons.validation.condition.Condition;
import br.ctg.challenge.commons.validation.rule.Rule;

public abstract class AbstractValidator<S> implements Validator<S> {

    private List<Condition> conditions = new ArrayList<>();
    private List<Rule> rules = new ArrayList<>();
    private List<Validator> subvalidators = new ArrayList<>();

    @PostConstruct
    public void init() {
        adicionarRegrasCondicoesESubValidaddores();
    }

    public abstract void adicionarRegrasCondicoesESubValidaddores();

    public List<String> validateAndReturnViolations(S objetoValidavel) {
        List<String> mensagensValidacao = new ArrayList<>();

        if ((conditions.isEmpty() || conditions.stream().filter(c -> !c.conditionTriggered(objetoValidavel)).count() == 0)
                &&
                !rules.isEmpty()) {
            mensagensValidacao.addAll(rules.stream().map(r -> r.validate(objetoValidavel)).filter(r -> r != null).collect(Collectors.toList()));
            if (!subvalidators.isEmpty()) {
                mensagensValidacao.addAll(subvalidators.stream().map(v -> v.validateAndReturnViolations(objetoValidavel)).reduce(
                        (a, b) -> {
                            a.addAll(b);
                            return a;
                        }).get()
                );
            }

        }
        return mensagensValidacao;
    }

    public void validateAndThrowViolationAsException(S objetoValidavel) {
        List<String> mensagensValidacao = validateAndReturnViolations(objetoValidavel);

        if (!mensagensValidacao.isEmpty()) {
            throw new CtgValidationException("Existem erros de validação", mensagensValidacao);
        }
    }

    protected void addCondtion(Condition condicao) {
        conditions.add(condicao);
    }

    protected void addRule(Rule regra) {
        rules.add(regra);
    }

    protected void addValidator(Validator validador) {
        subvalidators.add(validador);
    }
}
