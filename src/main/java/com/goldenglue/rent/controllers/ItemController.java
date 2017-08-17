package com.goldenglue.rent.controllers;

import com.goldenglue.rent.configs.CustomUserDetails;
import com.goldenglue.rent.entities.Item;
import com.goldenglue.rent.entities.User;
import com.goldenglue.rent.services.ItemService;
import com.goldenglue.rent.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user/items")
    public List<Item> getItemsByUser() {
        CustomUserDetails userDetails = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        User user = userService.getUser(userDetails.getUsername());
        return itemService.findAllByOwner(user);
    }

    @GetMapping(value = "/user/items/{id}")
    public Item getItemById(@RequestBody User user, Long id) {
        return itemService.findByOwnerAndId(user, id);
    }

    @PostMapping(value = "/user/items")
    public String addItem(@RequestBody Item item) {
        CustomUserDetails userDetails = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        item.setOwner(userService.getUser(userDetails.getUsername()));
        itemService.insert(item);
        return "Added new item: " + item.getName();
    }
}
