package br.ctg.challenge.store.controllers;

import br.ctg.challenge.commons.exception.CtgValidationException;
import br.ctg.challenge.store.model.vo.StoreVo;
import br.ctg.challenge.store.services.PersistStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/store")
public class PersistStoreController {

    @Autowired
    private PersistStoreService persistStoreService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity post(@RequestBody StoreVo loja) {
        try {
            return ResponseEntity.ok(persistStoreService.persistir(loja));
        } catch (CtgValidationException e) {
            return ResponseEntity.badRequest().body(e.getViolationMessages());
        }
    }
}
