package com.todoapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todoapp.Entities.UserDtls;
import com.todoapp.Service.UserSeviceImpl;

@RestController
@RequestMapping("/home")
public class homeController {

    @Autowired
    private UserSeviceImpl uService;

    @GetMapping("/")
    public ResponseEntity<String> index(){
        String message="welcome to To-do app";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDtls user){
        if(uService.createUser(user)==true){
            String message="user details saved successfully";
            return new ResponseEntity<>(message,HttpStatus.OK);
        }        
        return new ResponseEntity<>("failed to save user",HttpStatus.NOT_ACCEPTABLE);
    }
}
