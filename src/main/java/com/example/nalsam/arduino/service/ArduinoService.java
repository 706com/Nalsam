package com.example.nalsam.arduino.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.nalsam.arduino.repository.ArduinoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArduinoService {
	private final ArduinoRepository arduinoRepository;

    @Transactional
    public void updateHealthData(Integer oxygenSaturation, Integer heartrate){
    	arduinoRepository.findByLoginId("kwak1").updateHealthData(oxygenSaturation, heartrate);
    }
}