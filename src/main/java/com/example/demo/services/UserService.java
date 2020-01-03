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

    public User updateUser(Long id, User nerOwnerData) {
        User originalUser = show(id);
        originalUser.setFirstName(nerOwnerData.getFirstName());
        originalUser.setLastName(nerOwnerData.getLastName());
        originalUser.setEmail(nerOwnerData.getEmail());
        originalUser.setPassword(nerOwnerData.getPassword());
        originalUser.setAccounts(nerOwnerData.getAccounts());
        originalUser.setRent(nerOwnerData.getRent());
        originalUser.setSalary(nerOwnerData.getSalary());
        return userRepository.save(originalUser);
    }

    public User updateUserPassword (Long id, User user){
        return null;
    }

    public User show(Long id) {
        if(userRepository.findById(id).isPresent()){
            return userRepository.findById(id).get();
        }
        return null;
    }

    public Boolean delete(Long id) {
        userRepository.deleteById(id);
        return true;
    }

    public Iterable<User> showAll(){
        return userRepository.findAll();
    }

}
