package br.ctg.challenge.order.validation.condition;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;

import br.ctg.challenge.commons.validation.condition.Condition;
import br.ctg.challenge.order.model.repository.OrderRepository;
import br.ctg.challenge.order.model.vo.ConfirmationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConditionOrderOlderThanTenDays implements Condition<ConfirmationVo> {
    public static final int MAX_NUMBER_OF_DAYS_FOR_REFUND = 10;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Boolean conditionTriggered(ConfirmationVo validable) {
        return orderRepository.findById(validable.getIdPaymant()).map(
                order -> OffsetDateTime.now().minus(
                        MAX_NUMBER_OF_DAYS_FOR_REFUND,
                        ChronoUnit.DAYS
                ).isAfter(order.getConfirmationDateTime())
        ).get();
    }
}
