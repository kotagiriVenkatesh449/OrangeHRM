package org.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qa.base.TestBase;
import org.qa.utilities.ElementActionBy;
import org.qa.utilities.TestUtil;

public class LoginPage extends TestBase {

	@FindBy(xpath = "//*[@id=\"aboutDisplayLink\"]")
	static
	WebElement About;
	
	@FindBy(xpath = "//*[@id=\"txtUsername\"]")
	static
	WebElement user;
	
	@FindBy(xpath = "//*[@id=\"txtPassword\"]")
	static
	WebElement pass;
	
	@FindBy(xpath = "//*[@id=\"btnLogin\"]")
	static
	WebElement login;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	static By username = By.xpath("//*[@id=\"txtUsername\"]");
	static By password = By.xpath("//*[@id=\"txtPassword\"]");
	static By loginbtn = By.xpath("//*[@id=\"btnLogin\"]");
	
//	***********ACTIONS**********
	
	
	public static HomePage login(String un, String pwd) throws InterruptedException {
//		TestUtil.Type(user, un);
//		user.sendKeys(un);
//		pass.sendKeys(pwd);
//		login.click();
//		Thread.sleep(5000);
		
		ElementActionBy.doType(username, un);
		ElementActionBy.doType(password, pwd);
		ElementActionBy.doClick(loginbtn);
		Thread.sleep(5000);
		return new HomePage();
	}
}
