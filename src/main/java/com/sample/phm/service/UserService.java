package com.sample.phm.service;

import com.sample.phm.entity.User;
import com.sample.phm.exception.BadUserCredentialsException;
import com.sample.phm.exception.UserNotFoundExcetion;
import com.sample.phm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public boolean addUser(User user) throws BadUserCredentialsException{
        try{
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            throw new BadUserCredentialsException("Please provide a valid user Credential");
        }
    }

    public ArrayList<User> getAllUsers() {
        return (ArrayList<User>) userRepository.findAll();
    }

    public User getUserById(Integer id) throws UserNotFoundExcetion {
        Optional<User> user = userRepository.findById(id);

        if(!user.isPresent()) {
            throw new UserNotFoundExcetion("User with this id is not present");
        }
        return user.get();
    }

    public boolean userLogin(String email, String password) {
        User user = userRepository.findByEmail(email);
        if(user != null
                && user.getEmail().equals(email)
                && user.getPassword().equals(password)) return true;
        else return false;
    }
}
