package br.ctg.challenge.order.controllers;

import br.ctg.challenge.commons.exception.CtgValidationException;
import br.ctg.challenge.order.model.vo.OrderVO;
import br.ctg.challenge.order.services.order.PersistOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/order")
public class ConfirmOrderController {

    @Autowired
    private PersistOrderService persistStoreService;

    @PatchMapping(value ="/confirm" ,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity post(@RequestBody OrderVO order) {
        try {
            return ResponseEntity.ok(persistStoreService.persist(order));
        } catch (CtgValidationException e) {
            return ResponseEntity.badRequest().body(e.getViolationMessages());
        }
    }
}
