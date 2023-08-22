package com.example.nalsam.user.service;

import com.example.nalsam.user.domain.User;
import com.example.nalsam.user.dto.request.LoginRequest;
import com.example.nalsam.user.exception.PasswordNotCorrectException;
import com.example.nalsam.user.exception.UserNotFoundException;
import com.example.nalsam.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

//@Service
//@RequiredArgsConstructor
//public class LoginService {
//
//    private final UserRepository memberRepository;
//
//    public User login(User loginUser , HttpServletRequest httpServletRequest) {
//
//        // http 서블릿 세션을 활용하기 위해서는 httpservlerequest 가 필요함 : 세션이 있으면 세션 반환, 없으면 세션 생성
//        // 이때 request.getSession() 에서 getSession() 의 파라미터안에는 true, false 두가지가 올 수 있음
//        HttpSession session = httpServletRequest.getSession();
//
//        // 세션에 회원 정보(LoginMember) 저장 후 홈으로 반환
//        session.setAttribute("user", loginUser);
//
//        return ;
//    }
//
//}