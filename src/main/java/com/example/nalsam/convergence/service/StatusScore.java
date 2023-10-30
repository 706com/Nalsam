package com.example.nalsam.convergence.service;

public class StatusScore {
	
	private int age;
	private String symtom[];
	private int score = 0;
	
	StatusScore(int age, String symtomStr){
		this.age = age;
		this.symtom = symtomStr.trim().split(",");
	}
	
	public int measureStatus() {
		boolean flag = false;
		
		for(String i : symtom) {
			if(i.equals("천식")) {
				flag = true;
			}
		}
		
		if(flag) {
			if(age < 16) {
				score += 6;
			}else if(age > 15 && age < 61) {
				score += 10;
			}else {
				score += 4;
			}
		}else {
			if(age < 16) {
				score += 8;
			}else if(age > 15 && age < 61) {
				score += 10;
			} else {
				score += 7;
			}
		}
		return score;
	}
}
