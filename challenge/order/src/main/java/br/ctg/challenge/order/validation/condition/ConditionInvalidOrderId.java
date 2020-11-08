package br.ctg.challenge.order.validation.condition;

import br.ctg.challenge.commons.validation.condition.Condition;
import br.ctg.challenge.order.adapter.ValidatePaymentAdapter;
import br.ctg.challenge.order.model.repository.OrderRepository;
import br.ctg.challenge.order.model.vo.ConfirmationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConditionInvalidOrderId implements Condition<ConfirmationVo> {
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public Boolean conditionTriggered(ConfirmationVo validable) {
        return orderRepository.findById(validable.getIdOrder()).isEmpty();
    }
}
