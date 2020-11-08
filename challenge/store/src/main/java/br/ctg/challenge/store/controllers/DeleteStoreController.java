package br.ctg.challenge.store.controllers;

import br.ctg.challenge.commons.exception.CtgValidationException;
import br.ctg.challenge.store.model.vo.StoreVo;
import br.ctg.challenge.store.services.DeleteStoreService;
import br.ctg.challenge.store.services.UpdateStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/store")
public class DeleteStoreController {

    @Autowired
    private DeleteStoreService deleteStoreService;

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable("id") Long idStore) {
        try {
            deleteStoreService.delete(idStore);
            return ResponseEntity.ok().build();
        } catch (CtgValidationException e) {
            return ResponseEntity.badRequest().body(e.getViolationMessages());
        }
    }
}
