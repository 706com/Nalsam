package com.example.nalsam.user.controller;

import com.example.nalsam.user.dto.request.TestRequest;
import com.example.nalsam.user.dto.request.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.nalsam.user.domain.Test;
import com.example.nalsam.user.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/save")
    public ResponseEntity<Void> createUser(@RequestBody UserRequest userRequest){

        userService.saveUserProfile(userRequest);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/test")
    public ResponseEntity<Test> createUserTest(@RequestBody TestRequest testRequest){

        return ResponseEntity.ok().body(userService.saveTest(testRequest));
    }
}
