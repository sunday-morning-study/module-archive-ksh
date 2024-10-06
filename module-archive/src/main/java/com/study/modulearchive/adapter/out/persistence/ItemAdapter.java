package com.study.modulearchive.adapter.out.persistence;

import com.study.modulearchive.application.out.FIndItemPort;
import com.study.modulearchive.application.out.SaveItemPort;
import com.study.modulearchive.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemAdapter implements FIndItemPort, SaveItemPort {

    private final ItemRepository itemRepository;

    @Override
    public void save(Item item) {
        itemRepository.save(item);
    }

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }

}
