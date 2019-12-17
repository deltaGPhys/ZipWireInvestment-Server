package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public User showUser(Long id) {
        if(userRepository.findById(id).isPresent()) {
            return userRepository.findById(id).get();
        }
        else return null;
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public User update(Long id, User newUserData) {
        User getUser = showUser(id);
        getUser.setFirstName(newUserData.getFirstName());
        getUser.setLastName(newUserData.getLastName());
        getUser.setEmail(newUserData.getEmail());
        //getUser.setPassword(newUserData.getPassword());
        getUser.setRent(newUserData.getRent());
        getUser.setSalary(newUserData.getSalary());
        return userRepository.save(getUser);
    }

    public Boolean delete(Long id) {
        userRepository.deleteById(id);
        return true;
    }

    public User existingUserCheck (Long id) {
        return null;
    }




}
