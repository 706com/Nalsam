package user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import user.domain.Test;
import user.domain.TestRequest;
import user.domain.UserRequest;
import user.service.UserService;

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
