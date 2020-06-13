package com.example.ReditAPI.DAO;

import com.example.ReditAPI.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
}
