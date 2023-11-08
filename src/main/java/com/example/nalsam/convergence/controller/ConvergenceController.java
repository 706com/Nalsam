package com.example.nalsam.convergence.controller;

import com.example.nalsam.chatbot.dto.request.SymtomCaution;
import com.example.nalsam.convergence.dto.ConvergenceData;
import com.example.nalsam.convergence.dto.ConvergenceRequest;
import com.example.nalsam.convergence.dto.ConvergenceResponse;
import com.example.nalsam.convergence.service.ConvergenceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Slf4j
public class ConvergenceController {
    private final ConvergenceService convergenceService;

    @PostMapping("/convergence")
    public ResponseEntity<ConvergenceResponse> convergenc(@RequestBody ConvergenceRequest request){
        ConvergenceData convergenceData = convergenceService.colletConvergenceData(request);
        System.out.println("심박수 : "+convergenceData.getHeartRate());
        System.out.println("산소포화도 : "+convergenceData.getOxygenSaturation());
        ConvergenceResponse convergenceResponse = convergenceService.measureConvergenceScore(convergenceData);
        return ResponseEntity.ok(convergenceResponse);
    }

}
