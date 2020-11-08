package br.ctg.challenge.order.validation.rule;

import br.ctg.challenge.commons.validation.rule.AbstractRule;
import br.ctg.challenge.order.model.vo.ConfirmationVo;
import br.ctg.challenge.order.validation.condition.ConditionPaymantDontExistsOrIsNotValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RuleMustHaveAValidPayment extends AbstractRule<ConfirmationVo> {
    @Autowired
    private ConditionPaymantDontExistsOrIsNotValid conditionPaymantDontExistsOrIsNotValid;
    @Override
    protected String aplicarRegra(ConfirmationVo objetoValidavel) {
        return getMensagemValidacao("validacao.id.pagamento.obrigatorio");
    }

    @Override
    public void adicionarCondicoes() {
        addCondition(conditionPaymantDontExistsOrIsNotValid);
    }
}
