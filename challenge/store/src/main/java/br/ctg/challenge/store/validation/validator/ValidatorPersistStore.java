package br.ctg.challenge.store.validation.validator;

import br.ctg.challenge.commons.validation.validator.AbstractValidator;
import br.ctg.challenge.store.model.vo.StoreVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidatorPersistStore extends AbstractValidator<StoreVo> {
    @Autowired
    private SubvalidatorBasicDataStore subvalidatorBasicDataStore;
    @Autowired
    private SubvalidatorAdressStore subvalidatorAdressStore;

    @Override
    public void adicionarRegrasCondicoesESubValidaddores() {
        addValidator(subvalidatorBasicDataStore);
        addValidator(subvalidatorAdressStore);
    }
}
