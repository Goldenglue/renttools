package com.goldenglue.rent;

import com.goldenglue.rent.configs.CustomUserDetails;
import com.goldenglue.rent.entities.Role;
import com.goldenglue.rent.entities.WebUser;
import com.goldenglue.rent.repositories.UserRepository;
import com.goldenglue.rent.services.WebUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class RentApplication {
    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(RentApplication.class, args);
    }

    @Autowired
    public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repository, WebUserService userService) throws Exception {
        if (repository.count() == 0)
            userService.addNewUser(new WebUser("admin", passwordEncoder.encode("adminPassword"), Arrays.asList(new Role("USER"), new Role("ACTUATOR"), new Role("ADMIN"))));
        builder.userDetailsService(userDetailsService(repository)).passwordEncoder(passwordEncoder);
    }

    private UserDetailsService userDetailsService(final UserRepository repository) {
        return username -> new CustomUserDetails(repository.findByUsername(username));
    }
}
