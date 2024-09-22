package com.study.modulearchive.application;

import com.study.modulearchive.application.in.CreateItemUseCase;
import com.study.modulearchive.application.in.GetItemUseCase;
import com.study.modulearchive.application.in.UpdateItemUseCase;
import com.study.modulearchive.application.out.FIndItemPort;
import com.study.modulearchive.application.out.SaveItemPort;
import com.study.modulearchive.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService implements CreateItemUseCase, GetItemUseCase, UpdateItemUseCase {

    private final FIndItemPort fIndItemPort;
    private final SaveItemPort saveItemPort;


    @Transactional
    @Override
    public void saveItem(Item item) {
        saveItemPort.save(item);
    }

    @Transactional
    @Override
    public void updateItem(Long itemId, String name, int price, int stockQuantity) {
        Item item = fIndItemPort.findOne(itemId);
        item.setName(name);
        item.setPrice(price);
        item.setStockQuantity(stockQuantity);
    }

    @Override
    public List<Item> findItems() {
        return fIndItemPort.findAll();
    }

    @Override
    public Item findOne(Long itemId) {
        return fIndItemPort.findOne(itemId);
    }

}
