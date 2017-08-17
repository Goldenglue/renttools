package com.goldenglue.rent.services;

import com.goldenglue.rent.entities.Item;
import com.goldenglue.rent.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item findItemById(Long id) {
        return itemRepository.findOne(id);
    }

    public Item findItemByName(String name) {
        return itemRepository.findItemByName(name);
    }

    public void insertItem(Item item) {
        itemRepository.save(item);
    }
}
