package com.example.nalsam.convergence.controller;

import com.example.nalsam.convergence.dto.ConvergenceRequest;
import com.example.nalsam.convergence.dto.ConvergenceResponse;
import com.example.nalsam.convergence.service.OutingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/convergence")
public class ConvergenceController {
    // Todo : 객체 요청 -> 대기질 6가지, 날씨 3가지 , 사용자정보 6가지
    private OutingService outingService;

    public ConvergenceController(OutingService outingService) {
        this.outingService = outingService;
    }
    
    @GetMapping("/get")
    ResponseEntity<ConvergenceResponse> getConvergenceData(@RequestBody ConvergenceRequest request){
        outingService.method(request);
        //Todo : Response 안에 넣어야 할 데이터 : outingService 에서 점수, String 출력
        return ResponseEntity.ok( "RESPONSE 넣기");
    }
    
}
