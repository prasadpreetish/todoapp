package com.todoapp.Service;

import org.springframework.stereotype.Service;

import com.todoapp.Entities.UserDtls;

@Service
public interface UserService {
    public boolean createUser(UserDtls user);
}
