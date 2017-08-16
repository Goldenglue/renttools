package com.goldenglue.rent.controllers;

import com.goldenglue.rent.entities.Item;
import com.goldenglue.rent.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {
    @Autowired
    ItemService itemService;

    @GetMapping("/itemId")
    public Item getItemById(@RequestParam Long id) {
        return itemService.findItemById(id);
    }

    @GetMapping("/itemName")
    public Item getItemByName(@RequestParam String name) {
        return itemService.findItemByName(name);
    }

    @PostMapping("/item")
    public String addItem(@RequestBody Item item) {
        itemService.insertItem(item);
        return "Added new item: " + item.getName();
    }
}
