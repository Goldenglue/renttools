package com.goldenglue.rent.services;

import com.goldenglue.rent.entities.Item;
import com.goldenglue.rent.entities.User;
import com.goldenglue.rent.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> findAllByOwner(User user) {
        return itemRepository.findAllByOwner(user);
    }

    public Item findByOwnerAndId(User user, Long id) {
        return itemRepository.findByOwnerAndId(user, id);
    }

    public void insertItem(Item item) {
        itemRepository.save(item);
    }
}
