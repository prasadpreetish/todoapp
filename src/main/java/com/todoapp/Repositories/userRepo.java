package com.todoapp.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todoapp.Entities.UserDtls;

@Repository
public interface userRepo extends JpaRepository<UserDtls,Integer> {
    Optional<UserDtls> findByEmail(String email);
}
