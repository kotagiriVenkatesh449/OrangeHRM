package org.qa.testcasesforadminpages;

import org.qa.adminpages.NewUserPage;
import org.qa.adminpages.UsersPage;
import org.qa.base.TestBase;
import org.qa.pages.HomePage;
import org.qa.pages.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewUserPageTestCases extends TestBase {

	public static LoginPage lp ;
	public static HomePage hp ;
	public static UsersPage up;
	public static NewUserPage np;
	@BeforeTest
	public static void setup() throws InterruptedException {
		init();
		lp = new LoginPage();
		lp.login("Admin", "admin123");
		hp = new HomePage();
		hp.Navigate_userpage();
		up = new UsersPage();
		np= new NewUserPage();
	}

	@Test
	public static void Addnewusertestcase() throws InterruptedException {
		up.Addnewuser();
		np.createnewuser("sana khan","Hanuman" ,"demo@123456", "demo@123456");
		Thread.sleep(5000);
	}

	@AfterTest
	public static void teardown() {
		driver.quit();
	}
}
