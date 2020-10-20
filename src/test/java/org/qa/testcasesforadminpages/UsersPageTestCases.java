package org.qa.testcasesforadminpages;

import org.qa.adminpages.UsersPage;
import org.qa.base.TestBase;
import org.qa.pages.HomePage;
import org.qa.pages.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UsersPageTestCases extends TestBase {

	public static LoginPage lp ;
	public static HomePage hp ;
	public static UsersPage up;

	public UsersPageTestCases() {
		super();
	}

	@BeforeTest
	public static void setup() throws InterruptedException {
		init();
		lp = new LoginPage();
		lp.login("Admin", "admin123");
		hp = new HomePage();
		hp.Navigate_userpage();
		up = new UsersPage();
	}

	@Test
	public static void searchchecktestcase() throws InterruptedException {
		up.usersearch("Venkatesh", "vk143");
		Thread.sleep(5000);
	}

	@AfterTest
	public static void teardown() {
		driver.quit();
	}
}
