package br.ctg.challenge.order.services.order;

import br.ctg.challenge.order.model.vo.ConfirmationVo;

public interface ConfirmOrderService {
    void confirm(ConfirmationVo confirmationVo);
}
