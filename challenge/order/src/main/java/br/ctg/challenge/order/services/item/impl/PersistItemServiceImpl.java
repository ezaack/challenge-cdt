package br.ctg.challenge.order.services.item.impl;

import javax.transaction.Transactional;

import br.ctg.challenge.order.model.entity.Item;
import br.ctg.challenge.order.model.repository.ItemRepository;
import br.ctg.challenge.order.model.vo.ItemVO;
import br.ctg.challenge.order.services.item.PersistItemService;
import br.ctg.challenge.order.validation.validator.ValidatorOrderConfirmation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersistItemServiceImpl implements PersistItemService {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ValidatorOrderConfirmation validatorOrderConfirmation;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public ItemVO persist(ItemVO itemVo) {
        Item item = itemRepository.save(
            Item.builder()
                    .unitaryPrice(itemVo.getUnitaryPrice())
                    .orderId(itemVo.getOrderId())
                    .quantity(itemVo.getQuantity())
                    .description(itemVo.getDescription())
                    .build()
        );
        itemVo.setId(item.getId());
        return itemVo;
    }
}
