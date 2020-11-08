package br.ctg.challenge.order.validation.validator;

import br.ctg.challenge.commons.validation.validator.AbstractValidator;
import br.ctg.challenge.order.validation.rule.RuleMustHaveAValidPayment;
import br.ctg.challenge.order.validation.rule.RuleOrderIdMustBeValid;
import br.ctg.challenge.order.validation.rule.RuleOrderMustHaveTenDaysAtMost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RefundOrderConfirmation extends AbstractValidator<Long> {
    @Autowired
    private RuleMustHaveAValidPayment ruleMustHaveAValidPayment;
    @Autowired
    private RuleOrderIdMustBeValid ruleOrderIdMustBeValid;
    @Autowired
    private RuleOrderMustHaveTenDaysAtMost ruleOrderMustHaveTenDaysAtMost;

    @Override
    public void adicionarRegrasCondicoesESubValidaddores() {
        addRule(ruleMustHaveAValidPayment);
        addRule(ruleOrderIdMustBeValid);
    }
}
