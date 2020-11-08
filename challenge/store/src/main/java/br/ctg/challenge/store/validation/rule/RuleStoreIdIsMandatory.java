package br.ctg.challenge.store.validation.rule;

import br.ctg.challenge.commons.validation.rule.AbstractRule;
import br.ctg.challenge.store.model.vo.StoreVo;
import br.ctg.challenge.store.validation.condition.ConditionIdInformed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RuleStoreIdIsMandatory extends AbstractRule<StoreVo> {

    @Autowired
    private ConditionIdInformed conditionIdInformed;

    @Override
    protected String aplicarRegra(StoreVo objetoValidavel) {
        return getMensagemValidacao("validacao.id.store.obrigatorio");
    }

    @Override
    public void adicionarCondicoes() {
        addCondition(conditionIdInformed);
    }
}
