package com.study.modulearchive.application.in;

import com.study.modulearchive.domain.item.Item;

import java.util.List;

public interface GetItemUseCase {
    List<Item> findItems();
    Item findOne(Long itemId);

}
