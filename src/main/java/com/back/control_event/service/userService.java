package com.back.control_event.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.back.control_event.model.user;
import com.back.control_event.repository.IUserRepository;

@Service
public class userService {
    @Autowired
    private IUserRepository userRepository;

    public List<user> getAll() {
        return userRepository.findAll();
    }

    public user getById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public user save(user user) {
        return userRepository.save(user);
    }

    public user update(user user) {
        return userRepository.save(user);
    }
}
