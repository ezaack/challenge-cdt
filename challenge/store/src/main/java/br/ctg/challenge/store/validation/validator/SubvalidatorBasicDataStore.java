package br.ctg.challenge.store.validation.validator;

import br.ctg.challenge.commons.validation.validator.AbstractValidator;
import br.ctg.challenge.store.model.vo.StoreVo;
import br.ctg.challenge.store.validation.rule.RuleStoreNameIsMandatory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubvalidatorBasicDataStore extends AbstractValidator<StoreVo> {
    @Autowired
    private RuleStoreNameIsMandatory regraNomeDeveSerInformado;
    @Override
    public void adicionarRegrasCondicoesESubValidaddores() {
        addRule(regraNomeDeveSerInformado);
    }
}
