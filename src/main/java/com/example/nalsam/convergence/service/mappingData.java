package com.example.nalsam.convergence.service;

import com.example.nalsam.convergence.dto.ConvergenceRequest;
import com.example.nalsam.user.domain.Users;
import com.example.nalsam.user.service.UserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class mappingData {
    private UserService userService;

    public void putConvergenceData(ConvergenceRequest convergenceRequest){
        String loginId = convergenceRequest.getLoginId();
        Users user = userService.findUserByLoginId(loginId);

        return convergenceData.builder()
    }
}
