package com.example.nalsam.user.service;

import com.example.nalsam.user.dto.SessionConst;
import com.example.nalsam.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
//세션을 생성하여 세션 저장소에 토큰과 로그인 객체를 맵핑하여 저장하고, 세션을 삭제하기 위해 사용되는 세션 관리자
public class SessionService {

    // 동시성 문제가 있는 경우 ConcurrentHashMap 를 사용해야 함.
    // 동시성 문제란 한마디로 '동시에' 스레드가 많이 발생하는 경우가 있는 것을 의미함 => 로그인은 동시에 많이 발생할 수 있음
    private Map<String, String> sessionStore = new ConcurrentHashMap<>();

    /*
     *  세션 생성
     *  1. SessionId 생성 (임의의 추정 불가능한 랜덤 값)
     *  2. 세션 저장소에 SessionId 와 보관할 값 저장
     *  3. SessionId 로 응답 쿠키를 생성해서 클라이언트에 전달
     * */

    public void createSession(String value, HttpServletResponse response){

        // (1): 예측불가한 임의의 token값을 생성한다.
        String token = UUID.randomUUID().toString();

        // (2): (1)에서 생성한 token값을 Key로, Parameter로 전달받은 memberId를 Value로 Store Map(세션 저장소)에 put한다.
        sessionStore.put(token, value);


        // (3): SessionConst.sessionId는 미리 interface로 생성해둔 상수이다.
        // SessionConst.sessionId를 Key로, (1)에서 생성한 token을 Value로 하여 Cookie를 생성한다.
        Cookie mySessionCookie = new Cookie(SessionConst.sessionId, token);


        // (4): response에 Cookie를 등록한다.
        response.addCookie(mySessionCookie);
        System.out.println(mySessionCookie);

    }

    /* 세션 조회 방법 2 : findCookie 를 따로 생성해서 해당 메서드를 사용해 쿠키값을 찾아옴 */

    public String getSession(HttpServletRequest request){

        // (1): request요청의 Cookie에 서버에서 관리되는 쿠키정보가 있는지 찾는다.
        // reqeust를 argument로 findCookie를 호출한다.
        Cookie sessionCookie = findCookie(request);


        // (2): (1)에서 유효한 쿠키를 찾지못하고 return 받은 sessionCookie가 null이라면 null을 return 한다.
        if(sessionCookie == null){
            return null;
        }
        // (3): 유효한 쿠키를 찾았을 경우 Cookie의 Value(token값)을 통하여 Store Map(세션저장소)에서 memberId를 찾아온다.
        return sessionStore.get(sessionCookie.getValue());
    }


    public Cookie findCookie(HttpServletRequest request){

        // (1): request 요청에 Cookie가 없을 경우 null을 return 한다.
        if(request.getCookies() == null) { //(1)
            return null;
        }

        //(2) : request 요청에 Cookie중 서버에서 관리하는 Session Key인 상수SessionConst.sessionId
        // 즉 LOGIN_MEMBER가 있는지 찾고 있다면 해당 Cookie를 return 한다.
        return Arrays.stream(request.getCookies()) // arrays 를 스트림을 바꿔줌
                .filter(cookie -> cookie.getName().equals(SessionConst.sessionId))
                /*
                findfirst 와 findAny 둘중 하나를 쓸 수 있는데
                1. findAny : 순서 상관X! 빨리 나오면 꺼내옴
                2. findfirst : 순서 중요! 순서에 따라서 돌다가 맞으면 꺼내옴
                 */
                .findAny()
                .orElse(null);
    }


    /*
     * 3. 세션 만료 : Session 만료는 그냥 지워버리면 된다
     */
    public void expireCookie(HttpServletRequest request){
        // (1): request요청의 Cookie에 서버에서 관리되는 쿠키정보가 있는지 찾는다.
        // reqeust를 argument로 findCookie를 호출한다. findCookie 메서드에 대해서는 위에서 설명했으니 참고하자.
        Cookie sessionCookie = findCookie(request);

        // findCookie 로 세션을 가져와서 해당 값이 null 이 아니면 세션 스토어에 저장, 매핑된 값을 삭제!

        // (2): 만약 유효한 sessionCookie를 찾았을경우 Cookie의 Value(token값)을 통하여 store Map(세션저장소)에서 세션을 삭제한다.
        if(sessionCookie != null){
            sessionStore.remove(sessionCookie.getValue());
        }
    }

}
