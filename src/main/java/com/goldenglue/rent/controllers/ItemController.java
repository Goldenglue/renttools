package com.goldenglue.rent.controllers;

import com.goldenglue.rent.entities.Item;
import com.goldenglue.rent.entities.User;
import com.goldenglue.rent.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/user/items")
    public List<Item> getItemById(@RequestBody User user) {
        return itemService.findAllByOwner(user);
    }

    @GetMapping("/user/items/{id}")
    public Item getItemById(@RequestBody User user, Long id) {
        return itemService.findByOwnerAndId(user, id);
    }

    @PostMapping("/user/items")
    public String addItem(@RequestBody User user, @RequestBody Item item) {
        item.setOwner(user);
        itemService.insertItem(item);
        return "Added new item: " + item.getName();
    }
}
