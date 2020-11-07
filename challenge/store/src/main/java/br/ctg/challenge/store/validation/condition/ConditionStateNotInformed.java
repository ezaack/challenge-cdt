package br.ctg.challenge.store.validation.condition;

import br.ctg.challenge.commons.validation.condition.Condition;
import br.ctg.challenge.store.model.vo.StoreVo;
import org.springframework.stereotype.Component;

@Component
public class ConditionStateNotInformed implements Condition<StoreVo> {
    @Override
    public Boolean conditionTriggered(StoreVo objetoValidavel) {
        return objetoValidavel.getState() == null;
    }
}
