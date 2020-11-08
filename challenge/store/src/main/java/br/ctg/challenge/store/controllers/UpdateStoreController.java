package br.ctg.challenge.store.controllers;

import br.ctg.challenge.commons.exception.CtgValidationException;
import br.ctg.challenge.store.model.vo.StoreVo;
import br.ctg.challenge.store.services.UpdateStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/store")
public class UpdateStoreController {

    @Autowired
    private UpdateStoreService updateStoreService;

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity put(@RequestBody StoreVo loja) {
        try {
            return ResponseEntity.ok(updateStoreService.update(loja));
        } catch (CtgValidationException e) {
            return ResponseEntity.badRequest().body(e.getViolationMessages());
        }
    }
}
