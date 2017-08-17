package com.goldenglue.rent.services;

import com.goldenglue.rent.entities.WebUser;
import com.goldenglue.rent.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class WebUserService {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public void addNewUser(WebUser webUser) {
        userRepository.save(webUser);
    }
}
