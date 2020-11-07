package br.ctg.challenge.store.helper;

import br.ctg.challenge.store.model.entity.Store;
import br.ctg.challenge.store.model.vo.StoreVo;

public abstract class BuildStoreEntityFromVoHelper {

    public static Store build(StoreVo store) {
        return Store.builder()
                .id(store.getId())
                .name(store.getName())
                .neighborhood(store.getNeighborhood())
                .street(store.getStreet())
                .complement(store.getComplement())
                .state(store.getState())
                .number(store.getNumber())
                .build();
    }
}
