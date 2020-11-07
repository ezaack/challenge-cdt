package br.ctg.challenge.commons.validation.rule;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import br.ctg.challenge.commons.validation.condition.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

public abstract class AbstractRule<S> implements Rule<S> {
    @Autowired
    private MessageSource localResolver;

    private List<Condition<S>> condicoes = new ArrayList<>();

    @PostConstruct
    public void init() {
        adicionarCondicoes();
    }

    @Override
    public String validar(S objetoValidavel) {
        if (!condicoes.isEmpty() && condicoes.stream().filter(c -> !c.conditionTriggered(objetoValidavel)).count() == 0) {
            return aplicarRegra(objetoValidavel);
        }

        return null;
    }

    protected void addCondicao(Condition condicao) {
        condicoes.add(condicao);
    }

    protected String getMensagemValidacao(String key, String... param) {
        return localResolver.getMessage(key, param, LocaleContextHolder.getLocale());
    }

    protected abstract String aplicarRegra(S objetoValidavel);

    public abstract void adicionarCondicoes();
}
