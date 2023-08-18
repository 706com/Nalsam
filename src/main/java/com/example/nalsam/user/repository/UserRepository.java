package com.example.nalsam.user.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.nalsam.user.domain.User;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByLoginId(String loginId);

    boolean existsByLoginId(String loginId);
}
