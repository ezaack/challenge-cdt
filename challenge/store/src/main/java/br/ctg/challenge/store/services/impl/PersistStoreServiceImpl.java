package br.ctg.challenge.store.services.impl;

import javax.transaction.Transactional;

import br.ctg.challenge.store.helper.BuildStoreEntityFromVoHelper;
import br.ctg.challenge.store.model.entity.Store;
import br.ctg.challenge.store.model.repository.StoreRepository;
import br.ctg.challenge.store.model.vo.StoreVo;
import br.ctg.challenge.store.services.PersistStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersistStoreServiceImpl implements PersistStoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Override
    @Transactional
    public StoreVo persistir(StoreVo store) {

        Store storePersistida = storeRepository.save(
                BuildStoreEntityFromVoHelper.build(store)
        );

        store.setId(storePersistida.getId());
        return store;
    }
}
