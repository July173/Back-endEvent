package com.back.control_event.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.back.control_event.model.user;
import com.back.control_event.model.person;
import com.back.control_event.repository.IUserRepository;
import com.back.control_event.repository.IPersonRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class userService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IPersonRepository personRepository;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

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

    public user updateUserWithPerson(int id, user payload) {
        user existing = userRepository.findById(id).orElse(null);
        if (existing == null) return null;

        if (payload.getEmail() != null) {
            existing.setEmail(payload.getEmail());
        }
        if (payload.getPassword() != null && !payload.getPassword().isBlank()) {
            String raw = payload.getPassword();
            // Evitar doble hash si ya viene en formato BCrypt
            if (!(raw.startsWith("$2a$") || raw.startsWith("$2b$") || raw.startsWith("$2y$"))) {
                raw = passwordEncoder.encode(raw);
            }
            existing.setPassword(raw);
        }

        if (payload.getPerson() != null) {
            person existingPerson = existing.getPerson();
            person p = payload.getPerson();
            if (p.getFull_name() != null) existingPerson.setFull_name(p.getFull_name());
            if (p.getNumber_identification() != 0) existingPerson.setNumber_identification(p.getNumber_identification());
            if (p.getType_identification() != null) existingPerson.setType_identification(p.getType_identification());
            personRepository.save(existingPerson);
            existing.setPerson(existingPerson);
        }

        return userRepository.save(existing);
    }
}
