package com.example.nalsam.user.controller;

import com.example.nalsam.user.domain.User;
import com.example.nalsam.user.dto.SessionConst;
import com.example.nalsam.user.dto.request.LoginRequest;
import com.example.nalsam.user.exception.UserNotFoundException;
import com.example.nalsam.user.service.SessionService;
import com.example.nalsam.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Member;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
//@RequestMapping("/login")
//로그인 시 세션을 생성하여 home으로 보내주거나 로그아웃 시 세션을 삭제
public class LoginController {

//    private final LoginService loginService;

    private final UserService userService;

    private final SessionService sessionService;

    // URL : / 요청 (home)을 처리 url.
    //(1): 세션정보를 가져오기 위하여 request를 argument로 sessionManager.getSession를 호출한다.
    @GetMapping("/")
    public String home(HttpServletRequest request, Model model) {

        // (1): 세션정보를 가져오기 위하여 request를 argument로 sessionManager.getSession를 호출한다.
        String userLoginId = sessionService.getSession(request);

        // (2): (1)에서 유효한 Session을 찾지 못한 경우 mebmerId는 null이 되며, login 페이지로 이동시킨다.
        if(userLoginId == null) {
            return "login";
        }

        // (3): (1)에서 유효한 Session을 통해 정상적인 memberId를 반환받았을 경우, user 정보를 찾는다.
        User findUser = userService.findUserByLoginId(userLoginId); //(3)

        // (4): userLoginId를 통하여 user 를 찾지 못했을 경우 user는 null이 되며, login 페이지로 이동시킨다.
        if(findUser == null) { //(4)
            return "login";
        }
        // (5): model에 member를 추가하여 home 페이지로 이동시킨다.
        model.addAttribute("user", findUser); //(5)
        return "home"; //(5)
    }


    @PostMapping("/login") // http 서블릿 세션 활용 로그인
    public String login(@RequestBody LoginRequest loginRequest, HttpServletResponse httpServletRespone) {

        // (0) User 정보 확인 -> 오류시 exception 발생
        System.out.println("LoginId: " + loginRequest.getLoginId());
        System.out.println("password: " +  loginRequest.getPassword());

        userService.checkUserInfo(loginRequest);

        // 올바른 정보인경우 Member객체가 반환되고, 아니라면 null이 반환된다.
        User loginUser = userService.findUserByLoginId(loginRequest.getLoginId());

        // (2) null일 경우 올바른 정보가 입력되지 않았으므로 /로 redirect 시킨다.
        if(loginUser == null) { //(2)
            return "redirect:/";
        }

        // (3): 요청받은 정보가 올바른 회원정보임이 확인되었으니, 세션을 생성한다.
        // MemberId와 response를 argument로 sessionManager.createSession를 호출한다.
        sessionService.createSession(loginUser.getLoginId(), httpServletRespone);

        // (4) 정상적으로 세션저장소에 회원정보를 등록하고, response에도 쿠키에 세션정보를 실어 등록하였으므로 /으로 redirect한다.
        return "redirect:/";

//        loginService.login(loginUser,httpServletRequest);
//        // http 서블릿 세션을 활용하기 위해서는 httpservlerequest 가 필요함 : 세션이 있으면 세션 반환, 없으면 세션 생성
//        // 이때 request.getSession() 에서 getSession() 의 파라미터안에는 true, false 두가지가 올 수 있음
//        HttpSession session = httpServletRequest.getSession();
//
//        // 세션에 회원 정보(LoginMember) 저장 후 홈으로 반환
//        session.setAttribute("user", loginUser);
    }

    @PostMapping("/logout") // http 서블릿 세션 활용 로그아웃
    // 세션 종료를 위해서는 sessionManager 에 만들어두었던 expireCookie 를 사용하자
    public String logout(HttpServletRequest request){

        sessionService.expireCookie(request);
//        if(session != null){
//            // invalidate 는 세션을 삭제하는 기능
//            session.invalidate();
//        }

        System.out.println("session : " + request);
        return "redirect:/";
    }

}