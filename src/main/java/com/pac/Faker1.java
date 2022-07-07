package com.pac;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class Faker1 {

	@Test
	public void faker()
	{

		Faker faker = new Faker();
		System.out.println(faker.name().firstName());

		System.out.println(faker.name().lastName());

		System.out.println(faker.phoneNumber().cellPhone());

		System.out.println(faker.address().fullAddress());

		System.out.println(faker.company().industry());
		System.out.println(faker.name().firstName());
	}

}
