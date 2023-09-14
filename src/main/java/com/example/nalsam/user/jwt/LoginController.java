package com.example.nalsam.user.jwt;

import com.example.nalsam.user.dto.request.LoginRequest;
import com.example.nalsam.user.dto.request.UserRequest;
import com.example.nalsam.user.dto.response.UserResponse;
import com.example.nalsam.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private final LoginService loginService;

    private final CustomUserDetailService customUserDetailService;

    public LoginController(LoginService loginService, CustomUserDetailService customUserDetailService) {
        this.loginService = loginService;
        this.customUserDetailService = customUserDetailService;
    }


    @PostMapping("/login") // http 서블릿 세션 로그인
    public ResponseEntity<JwtToken> login(@RequestBody LoginRequest loginRequest) {

        JwtToken token = loginService.login(loginRequest);

        return ResponseEntity.ok().body(token);

    }

    // < 회원 저장 API >
    @PostMapping("/signup")
    public ResponseEntity<Void> signup(@RequestBody UserRequest userRequest){

        loginService.createUser(userRequest);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/mainn") // http 서블릿 세션 로그아웃
    public ResponseEntity<String> main(){

//        UserDetails userDetails = customUserDetailService.loadUserByUsername(loginId);
//
//        String test =  userDetails.getUsername();
//        System.out.println(userDetails.getUsername());
        String user = SecurityContextHolder.getContext().getAuthentication().getName();

        return ResponseEntity.ok().body(user);
    }
}