package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthenticationService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    @Override
//    public User registerNewUserAccount(User userToCheck) throws EmailExistsException {
//       if (emailExist(userToCheck.getEmail())) {
//          throw new EmailExistsException(
//                    "There is an account with that email adress:" + userToCheck.getEmail());
//        }
//        User user = new User();
//        user.setFirstName(userToCheck.getFirstName());
//        user.setLastName(userToCheck.getLastName());
//
//        user.setPassword(passwordEncoder.encode(userToCheck.getPassword()));
//
//        user.setEmail(userToCheck.getEmail());
//        //user.setRole(new Role(Integer.valueOf(1), user));
//        return userRepository.save(user);
//    }

    public Iterable<User> findAll(){
        return userRepository.findAll();
    }

    public Iterable<String> findAllEmails() {
        ArrayList<String> userEmails = new ArrayList<>();
        Iterable<User> allUsers = userRepository.findAll();
         for (User user : allUsers){
             userEmails.add(user.getEmail());
         }
         return userEmails;
    }

    public User showUser(Long id) {
        if(userRepository.findById(id).isPresent()) {
            return userRepository.findById(id).get();
        }
        else return null;
    }

    public User createUser (User newUser) {
        newUser.setFirstName(newUser.getFirstName());
        newUser.setLastName(newUser.getLastName());
        newUser.setEmail(newUser.getEmail());
        newUser.setPassword(newUser.getPassword());
        newUser.setAccounts(newUser.getAccounts());
        newUser.setRent(newUser.getRent());
        newUser.setSalary(newUser.getSalary());
        return userRepository.save(newUser);
    }

    public User update(User newUserData) {
        User getUser = showUser(newUserData.getId());
        getUser.setFirstName(newUserData.getFirstName());
        getUser.setLastName(newUserData.getLastName());
        getUser.setEmail(newUserData.getEmail());
        //getUser.setPassword(newUserData.getPassword());
        getUser.setRent(newUserData.getRent());
        getUser.setSalary(newUserData.getSalary());
        return userRepository.save(getUser);
    }

    public User updatePassword (User user){
    return null;
    }

    public Boolean delete(Long id) {
        userRepository.deleteById(id);
        return true;
    }

    public User existingUserCheck (String email) {

        return null;
    }




}
