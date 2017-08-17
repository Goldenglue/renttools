package com.goldenglue.rent.repositories;

import com.goldenglue.rent.entities.WebUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<WebUser, Long> {
    WebUser findByUsername(String username);

}
