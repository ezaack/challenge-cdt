package br.ctg.challenge.store.validation.condition;

import br.ctg.challenge.commons.validation.condition.Condition;
import br.ctg.challenge.store.model.vo.StoreVo;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class ConditionIdInformed implements Condition<StoreVo> {
    @Override
    public Boolean conditionTriggered(StoreVo objetoValidavel) {
        return objetoValidavel.getId() == null;
    }
}
