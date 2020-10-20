package org.qa.testcasesforbasepages;

import org.qa.adminpages.UsersPage;
import org.qa.base.TestBase;
import org.qa.pages.HomePage;
import org.qa.pages.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTestcases extends TestBase{

	public static LoginPage lp;
	public static HomePage hp;
	public static UsersPage up;
	public HomePageTestcases() {
		super();
	}
	
	@BeforeTest
	public void setup() throws InterruptedException {
		init();
		lp = new LoginPage();
		lp.login("Admin","admin123");
		hp = new HomePage();
		up = new UsersPage();
	}
	@Test
	public static void navigate_userspagetestcase() throws InterruptedException {
		hp.Navigate_userpage();
		Thread.sleep(5000);
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
