package br.ctg.challenge.order.model.repository;


import br.ctg.challenge.order.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository  extends JpaRepository<Order, Long> {
}
