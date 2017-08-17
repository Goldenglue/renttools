package com.goldenglue.rent.repositories;

import com.goldenglue.rent.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    Item findItemByName(String name);
}
