package com.name859.util;

public class Number {

	public int getRandomNumber(int maxNumber) {
		return (int)(Math.random() * maxNumber) + 1;
	}
	
	public int getRandomNumber(int minNumber, int maxNumber) {
		int randomNumber = (int)(Math.random() * maxNumber) + 1;
		
		while (randomNumber < minNumber) {
			randomNumber = (int)(Math.random() * maxNumber) + 1;
		}
		
		return randomNumber;
	}
	
	public String makePhoneNumber(int randomNumber) {
		String number = Integer.toString(randomNumber);
		
		if (randomNumber < 1000) {
			number = "0"+ randomNumber;
			if (randomNumber < 100) {
				number = "00"+ randomNumber;
				if (randomNumber < 10) {
					number = "000"+ randomNumber;
				}
			}
		}
		
		return "010-"+ number +"-"+ number;
	}
	
}
