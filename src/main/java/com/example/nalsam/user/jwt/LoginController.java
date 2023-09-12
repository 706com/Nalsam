package com.example.nalsam.user.jwt;

import com.example.nalsam.user.dto.request.LoginRequest;
import com.example.nalsam.user.dto.request.UserRequest;
import com.example.nalsam.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
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

//    @PostMapping("/logout") // http 서블릿 세션 로그아웃
//    public ResponseEntity<Void> logout(HttpServletRequest request){
//
//        HttpSession session = request.getSession(false);
//
////        // 세션이 없으면 리다이렉트
////        if(session == null){
////            return "redirect:/";
////        }
//
//        // invalidate 는 세션을 삭제하는 기능
//        session.invalidate();
//        return ResponseEntity.noContent().build();
//    }
}