package br.ctg.challenge.store.services;


import java.util.List;

import br.ctg.challenge.store.model.vo.StoreVo;

public interface RetrieveStoreService {

    StoreVo retrieve(Long identificador);

    List<StoreVo> retrieve();
}
