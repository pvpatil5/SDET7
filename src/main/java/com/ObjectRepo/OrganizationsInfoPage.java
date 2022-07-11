package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsInfoPage {

	WebDriver driver;
	public  OrganizationsInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	@FindBy (xpath="//img[@title='Create Organization...']")
	private WebElement createorglinkbtn;
	public WebElement getCreateorglinkbtn() {
		return createorglinkbtn;
	}

	@FindBy(name="search_text")
	private WebElement searchorgtxtbox;

	@FindBy(id="bas_searchfield")
	private WebElement selectorgtypeDD;


	public WebElement getSearchorgtxtbox() {
		return searchorgtxtbox;
	}


	public WebElement getSelectorgtypeDD() {
		return selectorgtypeDD;
	}


	public WebElement getSearchorgbtn() {
		return searchorgbtn;
	}


	@FindBy(name="submit")
	private WebElement searchorgbtn;


	@FindBy(xpath="//a[@title='Organizations']")
	private WebElement searchedorgname;


	public WebElement getSearchedorgname() {
		return searchedorgname;
	}
}
