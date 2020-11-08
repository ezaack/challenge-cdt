package br.ctg.challenge.store.controllers;

import br.ctg.challenge.commons.exception.CtgValidationException;
import br.ctg.challenge.store.services.RetrieveStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/store")
public class GetStoreController {

    @Autowired
    private RetrieveStoreService retrieveStoreService;

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable("id") Long idStore) {
        try {
            return ResponseEntity.ok(
                    retrieveStoreService.retrieve(idStore));
        } catch (CtgValidationException e) {
            return ResponseEntity.badRequest().body(e.getViolationMessages());
        }
    }
}
