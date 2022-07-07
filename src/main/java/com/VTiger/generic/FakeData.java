package com.VTiger.generic;

import java.util.Random;

import com.github.javafaker.Faker;

/**
 *  @author AMAR-G
 * @Description : This Class is going to create Fake Data which
 * is reqd for Test Execution.
 * */
public class FakeData 
{
	Faker faker = new Faker();

	/**
	 * @author AMAR-G
	 * @description :This method is going to generate a random name
	 * @return String Random name
	 */
	public String firstName() 
	{
		return faker.name().firstName();
	}

	/**
	 * @author AMAR-G
	 *@description :This method is going to generate a random lastname
	 * @return String Random lastname
	 */
	public String lastname() {
		return faker.name().lastName();
	}

	/**
	 * @author AMAR-G
	 * 
	 * @return
	 */
	public String companyname() {
		return faker.company().name();
	}
	/**
	 * 
	 * @return int 
	 */

	public int randomNumber() {
		Random random = new Random();
		int number=random.nextInt(1000);
		return number;
	}

}
