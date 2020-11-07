package br.ctg.challenge.store.validation.validator;

import br.ctg.challenge.commons.validation.validator.AbstractValidator;
import br.ctg.challenge.store.model.vo.StoreVo;
import br.ctg.challenge.store.validation.rule.RuleStoreStateAdressIsMandatory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubvalidatorAdressStore extends AbstractValidator<StoreVo> {

    @Autowired
    private RuleStoreStateAdressIsMandatory ruleStoreStateAdressIsMandatory;

    @Override
    public void adicionarRegrasCondicoesESubValidaddores() {
        addRegra(ruleStoreStateAdressIsMandatory);
    }
}
