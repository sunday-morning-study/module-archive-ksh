package com.study.modulearchive.application.out;

import com.study.modulearchive.domain.item.Item;

import java.util.List;

public interface FIndItemPort {
    List<Item> findAll();
    Item findOne(Long itemId);

}
