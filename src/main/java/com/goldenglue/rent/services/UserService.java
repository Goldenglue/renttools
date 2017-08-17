package com.goldenglue.rent.services;

import com.goldenglue.rent.entities.User;
import com.goldenglue.rent.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public void addNewUser(User user) {
        userRepository.save(user);
    }
}
