package com.xcos.mediaappapis.service;


import com.xcos.mediaappapis.model.User;
import com.xcos.mediaappapis.repository.MyUserRepository;
import jakarta.validation.Valid;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    private PasswordEncoder passwordEncoder;

    private final MyUserRepository myUserRepository;

    public UserService(MyUserRepository myUserRepository, PasswordEncoder passwordEncoder) {
        this.myUserRepository = myUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void createUser(User user){
        User user1 = new User();
        user1.setId(user.getId());
        user1.setPassword(passwordEncoder.encode(user.getPassword()));
        user1.setName(user.getName());
        user1.setLocalDate(user.getLocalDate());
      myUserRepository.save(user1);
    }

    public List<User> getAllUsers() {
        return myUserRepository.findAll();
    }

    public boolean deleteUser(String id){
        myUserRepository.deleteById(id);
        return true;
    }

    public boolean updateUser(String id, User upUser) {
        User previousUser = myUserRepository.findById(id).orElse(null);
        if(previousUser == null) {
            return false;
        }else{
            myUserRepository.deleteById(id);
            previousUser.setLocalDate(upUser.getLocalDate());
            previousUser.setName(upUser.getName());
            previousUser.setPassword(upUser.getPassword());
            previousUser.setId(upUser.getId());
            myUserRepository.save(previousUser);
            return true;
        }

    }







}
