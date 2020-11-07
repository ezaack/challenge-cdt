package br.ctg.challenge.store.model.repository;

import br.ctg.challenge.store.model.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
