package com.example.nalsam.user.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.nalsam.user.domain.User;


public interface UserRepository extends JpaRepository<User,Long> {
}
