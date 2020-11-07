package br.ctg.challenge.store.validation.rule;

import br.ctg.challenge.commons.validation.rule.AbstractRule;
import br.ctg.challenge.store.model.vo.StoreVo;
import br.ctg.challenge.store.validation.condition.ConditionNameNotInformed;
import br.ctg.challenge.store.validation.condition.ConditionStateNotInformed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RuleStoreStateAdressIsMandatory extends AbstractRule<StoreVo> {

    @Autowired
    private ConditionStateNotInformed conditionStateNotInformed;

    @Override
    protected String aplicarRegra(StoreVo objetoValidavel) {
        return getMensagemValidacao("validacao.stado.endereco.loja.obrigatorio");
    }

    @Override
    public void adicionarCondicoes() {
        addCondicao(conditionStateNotInformed);
    }
}
