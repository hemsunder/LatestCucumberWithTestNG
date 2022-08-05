package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;

	
	//1. By Locators:
	private By email_TB = By.id("input-email"); 
	private By password_TB = By.id("input-password"); 
	private By login_Btn = By.xpath("//input[@value='Login']");
	private By logo = By.xpath("//div[@id='logo']//img");
	
	//2. Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//3. Page Actions
	public String getTitle() {
		return driver.getTitle();
	}
	
	public boolean isLogoExists() {
		return driver.findElement(logo).isDisplayed();
	}

	public void enterUsername(String username) {
		driver.findElement(email_TB).sendKeys(username);
	}
	
	public void enterPassword(String pwd) {
		driver.findElement(password_TB).sendKeys(pwd);
	}
	
	public AccountsPage clickOnLoginbutton() {
		driver.findElement(login_Btn).click();
		return new AccountsPage(driver);
	}
	
	public AccountsPage doLogin(String un, String pwd) {
		enterUsername(un);
		enterPassword(pwd);
		clickOnLoginbutton();
		return new AccountsPage(driver);
		
	}
	
	
	
}
