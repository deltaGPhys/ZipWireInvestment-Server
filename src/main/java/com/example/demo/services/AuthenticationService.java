package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    UserRepository userRepository;

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public User showUser(Long id) {
        return userRepository.findById(id).get();
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public User update(Long id, User userToUpdate) {
        //User originalUser = userRepository.findById(id).get();
        //return repository.save(originalUser);
        return null;
    }

    public Boolean delete(Long id) {
        userRepository.deleteById(id);
        return true;
    }

    public User existingUserCheck (Long id) {
        return null;
    }




}
