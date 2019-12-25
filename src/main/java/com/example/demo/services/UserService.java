package com.example.demo.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.*;
import com.example.demo.repositories.UserRepository;
import com.example.demo.entities.*;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User createUser(User owner) {
        return userRepository.save(owner);
    }

    public User updateUser(long id, User nerOwnerData) {
        User originalUser = userRepository.findById(id).get();
        originalUser.setFirstName(nerOwnerData.getFirstName());
        originalUser.setLastName(nerOwnerData.getLastName());
        originalUser.setEmail(nerOwnerData.getEmail());
        originalUser.setPassword(nerOwnerData.getPassword());
        originalUser.setAccounts(nerOwnerData.getAccounts());
        originalUser.setRent(nerOwnerData.getRent());
        originalUser.setSalary(nerOwnerData.getSalary());
        return userRepository.save(originalUser);
    }

    public User show(long id) {
        return userRepository.findById(id).get();
    }

    public Boolean delete(long id) {
        userRepository.deleteById(id);
        return true;
    }

    public Iterable<User> showAll(){
        return userRepository.findAll();
    }

}
