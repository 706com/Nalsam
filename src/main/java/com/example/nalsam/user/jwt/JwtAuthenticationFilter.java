package com.example.nalsam.user.jwt;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.security.core.Authentication;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/* <JWT 인증과정>
Jwt 인증을 위해 생성되는 토큰. 요청과 함께 바로 실행됨.
요청이 들어오면 헤더에서 토큰 추출.
그리고 유효성 검사.
 */

@RequiredArgsConstructor
@Slf4j
public class JwtAuthenticationFilter extends GenericFilterBean {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        // 1. Request Header 에서 jwt 받아오기
        String token = resolveToken((HttpServletRequest) request);
        // 토큰을 가지고 있는지와 && 토큰이 유효한 것인지 검증
        if(token != null && jwtTokenProvider.validateToken(token)){
            // 검증이 모두 끝나면(유효한 토큰이면)
            // 토큰을 인증받은 유저인 UsernamePasswordAuthenticationToken을 리턴
            Authentication authentication = jwtTokenProvider.getAuthentication(token);
            // SecurityContext 안에 Authentication 객체 저장.
            // == 과정이 끝나면, 이 유저는 토큰이 유효한 유저임이 증명되고 SecurityContext 에 저장
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request,response);
    }

    // Request의 Header에서 jwt 가져오기.
    public String resolveToken(HttpServletRequest request){
        //Authorization 이 Bearer 임을 확인
        String bearerToken = request.getHeader("Authorization");
        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer")){
            return bearerToken.substring(7);
        }
        log.debug("토큰이 존재하지 않습니다.");
        return null;
    }
}
