package br.ctg.challenge.order.services.order.impl;

import javax.transaction.Transactional;

import br.ctg.challenge.order.model.entity.Order;
import br.ctg.challenge.order.model.enumeration.EnumOrderStatus;
import br.ctg.challenge.order.model.repository.OrderRepository;
import br.ctg.challenge.order.model.vo.OrderVO;
import br.ctg.challenge.order.services.order.PersistOrderItemService;
import br.ctg.challenge.order.services.item.PersistItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersistOrderItemServiceImpl implements PersistOrderItemService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private PersistItemService persistItemService;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public OrderVO persist(OrderVO orderVo) {

        Order order = orderRepository.save(
                Order.builder()
                        .complement(orderVo.getComplement())
                        .status(EnumOrderStatus.CREATED)
                        .build()
        );

        orderVo.getItems().stream().forEach(
                itemVo -> {
                    itemVo.setOrderId(order.getId());
                    itemVo.setId(
                            persistItemService.persist(itemVo).getId()
                    );
                }
        );

        orderVo.setId(order.getId());
        return orderVo;
    }
}
