package br.ctg.challenge.store.validation.rule;

import br.ctg.challenge.commons.validation.rule.AbstractRule;
import br.ctg.challenge.store.model.vo.StoreVo;
import br.ctg.challenge.store.validation.condition.ConditionNameNotInformed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RuleStoreNameIsMandatory extends AbstractRule<StoreVo> {

    @Autowired
    private ConditionNameNotInformed conditionNameNotInformed;

    @Override
    protected String aplicarRegra(StoreVo objetoValidavel) {
        return getMensagemValidacao("validacao.nome.loja.obrigatorio");
    }

    @Override
    public void adicionarCondicoes() {
        addCondition(conditionNameNotInformed);
    }
}
