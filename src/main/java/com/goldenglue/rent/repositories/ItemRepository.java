package com.goldenglue.rent.repositories;

import com.goldenglue.rent.entities.Item;
import com.goldenglue.rent.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findAllByOwner(User owner);

    Item findByOwnerAndId(User owner, Long id);
}
