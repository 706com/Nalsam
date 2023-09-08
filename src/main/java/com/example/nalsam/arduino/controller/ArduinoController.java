package com.example.nalsam.arduino.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.nalsam.arduino.service.ArduinoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/arduino")
public class ArduinoController {
	private final ArduinoService arduinoService;

	@RequestMapping("/healthdata")
    public void updateHealthData(@RequestBody String request)
    {
		String HealthData[] = request.replace("\"", "").replace("\\r\\n", "").split("/");
    	if(!HealthData[0].equals("-1"))
    		arduinoService.updateHealthData(Integer.parseInt(HealthData[0]), Integer.parseInt(HealthData[1]));
    }
}
