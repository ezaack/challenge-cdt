package br.ctg.challenge.order.controllers;

import br.ctg.challenge.commons.exception.CtgValidationException;
import br.ctg.challenge.order.services.order.RefundOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/order")
public class RefundOrderController {

    @Autowired
    private RefundOrderService refundOrderService;

    @PatchMapping(value = "/refund")
    public ResponseEntity post(@RequestBody Long idOrder) {
        try {
            refundOrderService.refund(idOrder);
            return ResponseEntity.ok().build();
        } catch (CtgValidationException e) {
            return ResponseEntity.badRequest().body(e.getViolationMessages());
        }
    }
}
