package br.ctg.challenge.order.validation.rule;

import br.ctg.challenge.commons.validation.rule.AbstractRule;
import br.ctg.challenge.order.model.vo.ConfirmationVo;
import br.ctg.challenge.order.validation.condition.ConditionInvalidOrderId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RuleOrderMustHaveTenDaysAtMost extends AbstractRule<ConfirmationVo> {
    @Autowired
    private ConditionInvalidOrderId conditionInvalidOrderId;
    @Override
    protected String aplicarRegra(ConfirmationVo objetoValidavel) {
        return getMensagemValidacao("validacao.pedido.com.mais.de.dez.dia");
    }

    @Override
    public void adicionarCondicoes() {
        addCondition(conditionInvalidOrderId);
    }
}
