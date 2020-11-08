package br.ctg.challenge.order.adapter.imp;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import br.ctg.challenge.commons.adapters.AbstractGetHttpClient;
import br.ctg.challenge.order.model.vo.StoreVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class GetStoreAdapter extends AbstractGetHttpClient<StoreVo> {
    @Autowired
    private Environment env;
    private Map<Boolean, Function<ResponseEntity<StoreVo>, StoreVo>> trataRetornoMap = new HashMap<>();

    @PostConstruct
    public void init() {
        trataRetornoMap.put(true, resposta -> resposta.getBody());
        trataRetornoMap.put(false, resposta -> {
            throw new RuntimeException(
                    String.valueOf(resposta.getStatusCode().value()),
                    null
            );
        });
    }

    public Optional<StoreVo> get(Long idStore) {
        ResponseEntity<StoreVo> response = get(
                env.getProperty("url.service.get.store") + "/" + idStore,
                StoreVo.class);

        return Optional.of(trataRetornoMap.get(HttpStatus.OK.equals(response.getStatusCode())).apply(response));
    }
}
