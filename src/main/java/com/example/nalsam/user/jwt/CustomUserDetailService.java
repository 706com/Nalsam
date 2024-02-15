package com.example.nalsam.user.jwt;

import com.example.nalsam.user.domain.Users;
import com.example.nalsam.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    //시큐리티 세션 -> Authentication -> UserDetails
    //시큐리티 세션(내부 Authentication객체(내부 UserDetails(User)))
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByLoginId(username)
                .map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException("해당하는 유저를 찾을 수 없습니다."));
    }

    // 해당하는 User 의 데이터가 존재한다면 UserDetails 객체로 만들어서 리턴
    private UserDetails createUserDetails(Users users) {
        log.info(users.getRoles().get(0));
        log.info(users.getUsername());
        log.info(users.getPassword());
//        return User.builder()
//                .username(users.getUsername())
//                .password(passwordEncoder.encode(users.getPassword()))
//                .roles(users.getRoles().toArray(new String[0]))
////                .roles(new SimpleGrantedAuthority(users.getRoles().toString()))
//                .build();
        return new User(users.getUsername(),users.getPassword(),users.getAuthorities());
    }
}
