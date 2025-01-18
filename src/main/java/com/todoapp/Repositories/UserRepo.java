package com.todoapp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todoapp.Entities.UserDtls;

@Repository
public interface UserRepo extends JpaRepository<UserDtls,Integer> {

}
