//package com.example.nalsam.user.jwt;
//
//import com.example.nalsam.user.domain.User;
//import com.example.nalsam.user.dto.request.LoginRequest;
//import com.example.nalsam.user.dto.response.UserResponse;
//import com.example.nalsam.user.repository.UserRepository;
//import com.example.nalsam.user.service.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//
//@RequiredArgsConstructor
//@Service
//@Transactional
//public class LoginService {
//
//    private final UserRepository userRepository;
//
//    private final UserService userService;
//
//    private final JwtTokenProvider jwtTokenProvider;
//
//
//    public TokenResponse signIn(LoginRequest request){
//        // 계정 로그인 정보 확인 (아이디 패스워드)
//        userService.checkUserInfo(request);
//
//        User user = userService.findUserByLoginId(request.getLoginId());
//
//        String token = jwtTokenProvider.createToken();
//
//        return token;
//
//    }
//
//}
