package br.ctg.challenge.order.services.order;

import br.ctg.challenge.order.model.vo.OrderVO;

public interface PersistOrderService {

    OrderVO persist(OrderVO order);
}
