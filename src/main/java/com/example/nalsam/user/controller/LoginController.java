package com.example.nalsam.user.controller;

import com.example.nalsam.user.domain.User;
import com.example.nalsam.user.dto.SessionConst;
import com.example.nalsam.user.dto.request.LoginRequest;
import com.example.nalsam.user.exception.UserNotFoundException;
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

    // URL : main url.
    //(1): 세션정보를 가져오기 위하여 request 로 요청
    @GetMapping("/main")
    public ResponseEntity<User> home(HttpServletRequest request) {

        // (1):  argument가 false : 세션이 있으면 세션을, 없다면 null을 반환 한다.
        HttpSession session = request.getSession(false);

        // (2): (1)에서 유효한 Session을 찾지 못한 경우 userId는 null이 되며, null값을 return시킨다.
        if(session == null) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }

        // (3): (1)에서 유효한 Session을 통해 정상적인 userId를 반환받았을 경우, user 정보를 찾는다.
        String userLoginId = (String) session.getAttribute(SessionConst.sessionId);
        User findUser = userService.findUserByLoginId(userLoginId); //(3)

        // (4): userLoginId를 통하여 user 를 찾지 못했을 경우 user는 null이 되며, 예외를 보낸다.
        if(findUser == null) { //(4)
            throw new UserNotFoundException();
        }
        // (5): responseEntity 찾은 유저를 return시킨다.
        return ResponseEntity.ok().body(findUser); //(5)
    }


    @PostMapping("/login") // http 서블릿 세션 로그인
    public ResponseEntity<User> login(@RequestBody LoginRequest loginRequest, HttpServletRequest httpServletRequest) {

        // (0) User 정보 확인 -> 오류시 exception 발생
        // Todo : checkUserInfo 는 예외를 발생시키니까, findUser에서 로직 만들어서 null값 반환하기.
        System.out.println("LoginId: " + loginRequest.getLoginId());
        System.out.println("password: " +  loginRequest.getPassword());

        userService.checkUserInfo(loginRequest);

        // 올바른 정보인경우 User객체가 반환되고, 아니라면 null이 반환된다.
        User loginUser = userService.findUserByLoginId(loginRequest.getLoginId());

//        // (2) null일 경우 올바른 정보가 입력되지 않았으므로 /로 redirect 시킨다.
//        if(loginUser == null) { //(2)
//            return "redirect:/";
//        }

        // (3): 요청받은 정보가 올바른 회원정보임이 확인되었으니, 세션을 생성한다.
        // http 서블릿 세션을 활용하기 위해서는 httpServleRequest 가 필요함 : 세션이 있으면 세션 반환, 없으면 세션 생성
        // 이때 request.getSession() 에서 getSession() 의 파라미터안에는 true, false 두가지가 올 수 있음
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute(SessionConst.sessionId,loginUser.getLoginId());

        // (4) 생성된 session에 세션정보를 추가한다. 사용자의 userId를 저장한후 /으로 redirect한다.
        return ResponseEntity.ok().body(loginUser);
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