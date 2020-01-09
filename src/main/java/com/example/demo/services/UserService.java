package com.example.demo.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.*;
import com.example.demo.repositories.UserRepository;
import com.example.demo.entities.*;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User updateNameAndEmail (User user){
        User getUser = showByUserId(user.getId());
        getUser.setFirstName(user.getFirstName());
        getUser.setLastName(user.getLastName());
        getUser.setEmail(user.getEmail());
        return userRepository.save(getUser);
    }

    public User updateUser(Long id, User nerOwnerData) throws Exception {
        User originalUser = showByUserId(id);
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

    public User showByUserId (Long userId) {
        if(userRepository.findById(userId).isPresent()){
            return userRepository.findById(userId).get();
        }
        return null;
    }

    public User showUserByUserName (String email) {
        return userRepository.findUserByEmail(email);
    }

    public Boolean delete(Long id) {
        userRepository.deleteById(id);
        return true;
    }

    public Iterable<User> showAll(){
        return userRepository.findAll();
    }

}
