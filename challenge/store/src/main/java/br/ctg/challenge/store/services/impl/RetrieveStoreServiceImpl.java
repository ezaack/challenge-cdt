package br.ctg.challenge.store.services.impl;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import br.ctg.challenge.store.helper.BuildStoreVoFromEntityHelper;
import br.ctg.challenge.store.model.repository.StoreRepository;
import br.ctg.challenge.store.model.vo.StoreVo;
import br.ctg.challenge.store.services.RetrieveStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RetrieveStoreServiceImpl implements RetrieveStoreService {
    @Autowired
    private StoreRepository storeRepository;

    @Override
    @Transactional
    public StoreVo retrieve(Long identificador) {
        return storeRepository.findById(identificador).map(
                store -> BuildStoreVoFromEntityHelper.build(store)
        ).get();
    }

    @Override
    @Transactional
    public List<StoreVo> retrieve() {
        return storeRepository.findAll().stream().map(
                store -> BuildStoreVoFromEntityHelper.build(store)
        ).collect(Collectors.toList());
    }
}
