package br.ctg.challenge.order.services.order;

import br.ctg.challenge.order.model.vo.OrderVO;

public interface PersistOrderItemService {

    OrderVO persist(OrderVO order);
}
