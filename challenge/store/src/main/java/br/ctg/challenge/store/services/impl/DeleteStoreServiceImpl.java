package br.ctg.challenge.store.services.impl;

import javax.transaction.Transactional;

import br.ctg.challenge.store.model.repository.StoreRepository;
import br.ctg.challenge.store.model.vo.StoreVo;
import br.ctg.challenge.store.services.DeleteStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteStoreServiceImpl implements DeleteStoreService {
    @Autowired
    private StoreRepository storeRepository;

    @Override
    @Transactional
    public void delete(Long id) {
        storeRepository.deleteById(id);
    }
}
