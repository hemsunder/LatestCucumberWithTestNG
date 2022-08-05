package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
	
	
	private WebDriver driver;
	
	private By product = By.xpath("//div[@id='content']/h1");
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getProductname() {
		return driver.findElement(product).getText();
	}
	
	

}
