package com.pac;

import java.util.Random;

import org.openqa.selenium.chrome.ChromeOptions;

import com.github.javafaker.Faker;

public class RandonNumber {

	public static void main(String[] args) {

		
		
		Faker faker = new Faker();
		
		Random random = new Random();

		int number=random.nextInt(1000);
		System.out.println(number);

	
		
		String name = faker.name().firstName();
		String suffix="@gmail.com";

		String mailid= name+number+suffix;
		System.out.println(mailid);
	}

}
