package com.sample.phm.controller;

import com.sample.phm.entity.LoginRequest;
import com.sample.phm.entity.LoginResponse;
import com.sample.phm.entity.User;
import com.sample.phm.entity.UserResponse;
import com.sample.phm.exception.BadUserCredentialsException;
import com.sample.phm.exception.UserNotFoundExcetion;
import com.sample.phm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Sign in a new user
     * @param user
     * @return User
     * @throws BadUserCredentialsException
     */
    @PostMapping("/user")
    public User signUpUser(@Valid @RequestBody User user) throws BadUserCredentialsException {
        try {
            userService.addUser(user);
            return user;
        }catch (Exception e) {
            throw new BadUserCredentialsException(e.getMessage());
        }
    }

    /**
     * Get the List of all users present into the database
     * @return ArrayList<User>
     */
    @GetMapping("/user")
    public ArrayList<User> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Get a user having same id from database
     * @param id
     * @return User
     * @throws UserNotFoundExcetion
     */
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Integer id) throws UserNotFoundExcetion {
        return userService.getUserById(id);
    }

    /**
     * Login an Existing user email and password
     * @param request
     * @return LoginResponse
     * @throws UserNotFoundExcetion
     */
    @PostMapping("/user/login")
    public LoginResponse loginUser(@RequestBody LoginRequest request) throws UserNotFoundExcetion {
        String email = request.getEmail();
        String password = request.getPassword();
        if(userService.userLogin(email,password))
            return new LoginResponse(HttpStatus.FOUND, true, "Successfully logged IN!");
        else
            throw new UserNotFoundExcetion("Invalid Credentials of user");
    }
}