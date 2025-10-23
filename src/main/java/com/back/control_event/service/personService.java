package com.back.control_event.service;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.back.control_event.dto.LoginDTO;
import com.back.control_event.dto.RegisterDTO;
import com.back.control_event.model.person;
import com.back.control_event.model.role;
import com.back.control_event.model.user;
import com.back.control_event.repository.IPersonRepository;
import com.back.control_event.repository.IRoleRepository;
import com.back.control_event.repository.IUserRepository;

@Service
public class personService {
    @Autowired
    private IPersonRepository personRepository;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IRoleRepository roleRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private static final Pattern EMAIL_REGEX = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    public List<person> getAll() {
        return personRepository.findAll();
    }

    public person getById(int id) {
        return personRepository.findById(id).orElse(null);
    }

    public person save(person person) {
        return personRepository.save(person);
    }

    public person update(person person) {
        return personRepository.save(person);
    }

    public user registerUser(RegisterDTO dto) {
        if (dto.getEmail() == null || !EMAIL_REGEX.matcher(dto.getEmail()).matches()) {
            throw new IllegalArgumentException("email inválido");
        }
        if (userRepository.findByEmail(dto.getEmail()) != null) {
            throw new IllegalArgumentException("email ya registrado");
        }
        if (personRepository.existsByDocument(dto.getNumberIdentification())) {
            throw new IllegalArgumentException("número de identificación ya registrado");
        }
        person person = new person();
        person.setFull_name(dto.getFullName());
        person.setNumber_identification(dto.getNumberIdentification());
        person.setType_identification(dto.getTypeIdentification());
        person savedPerson = personRepository.save(person);

        user user = new user();
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setPerson(savedPerson);
        role role = roleRepository.findById(dto.getRoleId()).orElse(null);
        user.setRole(role);
        return userRepository.save(user);
    }

    public boolean login(LoginDTO dto) {
        user user = userRepository.findByEmail(dto.getEmail());
        if (user != null && passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            return true;
        }
        return false;
    }

    public Integer authenticate(LoginDTO dto) {
        user user = userRepository.findByEmail(dto.getEmail());
        if (user != null && passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            return user.getId_user();
        }
        return null;
    }
}
