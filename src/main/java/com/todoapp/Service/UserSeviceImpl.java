package com.todoapp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.todoapp.Entities.UserDtls;
import com.todoapp.Repositories.userRepo;

@Service
public class UserSeviceImpl implements UserService {

    @Autowired
    private userRepo uRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public boolean createUser(UserDtls user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); //encoding the password while saving them
        UserDtls temp=uRepo.save(user);
        if(temp!=null)return true;
        return false;
    }
}
