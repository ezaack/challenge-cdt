package br.ctg.challenge.store.helper;

import br.ctg.challenge.store.model.entity.Store;
import br.ctg.challenge.store.model.vo.StoreVo;

public abstract class BuildStoreVoFromEntityHelper {

    public static StoreVo build(Store store) {
        return StoreVo.builder()
                .name(store.getName())
                .neighborhood(store.getNeighborhood())
                .street(store.getStreet())
                .complement(store.getComplement())
                .state(store.getState())
                .number(store.getNumber())
                .build();
    }
}
