package org.qa.testcasesforbasepages;

import org.qa.base.TestBase;
import org.qa.pages.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTestcases extends TestBase {

	public static LoginPage lp;
	public LoginPageTestcases(){
		super();
	}
	
	@BeforeTest
	public void setup() {
		init();
		lp= new LoginPage();
	}
	
	@Test
	public void logintest() throws InterruptedException {
		lp.login("Admin","admin123");
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
