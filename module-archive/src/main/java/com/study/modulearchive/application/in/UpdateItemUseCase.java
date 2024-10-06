package com.study.modulearchive.application.in;

public interface UpdateItemUseCase {
    void updateItem(Long itemId, String name, int price, int stockQuantity);

}
