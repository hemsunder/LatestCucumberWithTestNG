package com.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {
	
	private WebDriver driver;
	
	private By logout = By.linkText("Logout");
	private By search_TB = By.xpath("//input[@placeholder='Search']");
	private By search_img = By.xpath("//input[@name='search']//parent::div//button//i");
	private By myaccountsubmenu = By.xpath("(//div[@id='content']//ul)[1]");
	private By myaccountsubmenuOptions = By.xpath("((//div[@id='content']//ul)[1])/li");
	
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isLogoutExists() {
		return driver.findElement(logout).isDisplayed();
	}
	
	public boolean isSearchFeildExists() {
		return driver.findElement(search_TB).isDisplayed();
	}
	
	public ProductPage enterProductName(String prname) {
		driver.findElement(search_TB).sendKeys(prname);
		driver.findElement(search_img).click();
		return new ProductPage(driver);
	}
	
	public boolean myaccountSubmenu() {
		return driver.findElement(myaccountsubmenu).isDisplayed();
	}
	
	public List<String> getMyaccountsubmenu() {
		List<WebElement> list = driver.findElements(myaccountsubmenuOptions);
		List<String> menuoptionsList = new ArrayList<>();
		
		for(WebElement e:list) {
			String submenuoption = e.getText();
			menuoptionsList.add(submenuoption);
		}
		return menuoptionsList;	
	}
	
	
	
	
	
	

}
