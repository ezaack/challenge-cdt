package br.ctg.challenge.commons.adapters;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Log4j2
public abstract class AbstractGetHttpClient<R> {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper mapper;

    public ResponseEntity<R> get(String url, Map<String, String> headerParam, Class<R> clazzResposta, List<MediaType> accept, Map<String, String> queryParam) {
        try {
            HttpHeaders headers = new HttpHeaders();
            if (accept != null) {
                headers.setAccept(accept);
            }
            headerParam.forEach(
                    (s, s2) -> headers.set(s, s2)
            );

            HttpEntity<String> entity = new HttpEntity<>(headers);

            return restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    clazzResposta);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }

    }

    public ResponseEntity<R> get(String url, Map<String, String> headerParam, Class<R> clazzResposta) {
        return get(url, headerParam, clazzResposta, null, new HashMap<>());
    }

    public ResponseEntity<R> get(String url, Map<String, String> headerParam, Class<R> clazzResposta, Map<String, String> queryParam) {
        return get(url, headerParam, clazzResposta, null, queryParam);
    }

    public ResponseEntity<R> get(String url, Class<R> clazzResposta, Map<String, String> queryParam) {
        return get(url, new HashMap<>(), clazzResposta, null, queryParam);
    }

    public ResponseEntity<R> get(String url, Class<R> clazzResposta) {
        return get(url, new HashMap<>(), clazzResposta, null, new HashMap<>());
    }

}
