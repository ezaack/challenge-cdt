package br.ctg.challenge.store.services.impl;

import javax.transaction.Transactional;

import br.ctg.challenge.store.helper.BuildStoreEntityFromVoHelper;
import br.ctg.challenge.store.model.entity.Store;
import br.ctg.challenge.store.model.repository.StoreRepository;
import br.ctg.challenge.store.model.vo.StoreVo;
import br.ctg.challenge.store.services.UpdateStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateStoreServiceImpl implements UpdateStoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Override
    @Transactional
    public StoreVo persistir(StoreVo store) {


        storeRepository.save(
                BuildStoreEntityFromVoHelper.build(store)
        );

        return store;
    }
}
