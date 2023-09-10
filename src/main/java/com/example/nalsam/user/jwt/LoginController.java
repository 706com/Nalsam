package com.example.nalsam.user.jwt;

import com.example.nalsam.user.domain.User;
import com.example.nalsam.user.dto.SessionConst;
import com.example.nalsam.user.dto.request.LoginRequest;
import com.example.nalsam.user.exception.UserNotFoundException;
import com.example.nalsam.user.repository.UserRepository;
import com.example.nalsam.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    private final JwtTokenProvider jwtTokenProvider;



    @PostMapping("/login") // http 서블릿 세션 로그인
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {

        userService.checkUserInfo(loginRequest);

        User user = userService.findUserByLoginId(loginRequest.getLoginId());

        return ResponseEntity.ok().body(jwtTokenProvider.createToken(user.getLoginId()));

    }

    @PostMapping("/logout") // http 서블릿 세션 로그아웃
    public ResponseEntity<Void> logout(HttpServletRequest request){

        HttpSession session = request.getSession(false);

//        // 세션이 없으면 리다이렉트
//        if(session == null){
//            return "redirect:/";
//        }

        // invalidate 는 세션을 삭제하는 기능
        session.invalidate();
        return ResponseEntity.noContent().build();
    }

}