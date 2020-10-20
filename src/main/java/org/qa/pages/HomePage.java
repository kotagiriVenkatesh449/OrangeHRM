package org.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qa.adminpages.UsersPage;
import org.qa.base.TestBase;
import org.qa.utilities.ElementActionBy;
import org.qa.utilities.TestUtil;

public class HomePage extends TestBase {
	@FindBy(xpath = "//*[@id=\"menu_admin_viewAdminModule\"]")
	WebElement Admin;

	@FindBy(xpath = "//*[@id=\"menu_admin_UserManagement\"]")
	WebElement  UsersManagement;
	
	@FindBy(xpath = "//*[@id=\"menu_admin_viewSystemUsers\"]")
	WebElement Users;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	By admin = By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]");
	By  usersManagement=  By.xpath("//*[@id=\"menu_admin_UserManagement\"]");
	By  users= By.xpath("//*[@id=\"menu_admin_viewSystemUsers\"]");
	
	
//	************ACTIONS********
	public  UsersPage Navigate_userpage() {
//		TestUtil.Mousehover(Admin);
//		TestUtil.Mousehover(UsersManagement);
//		TestUtil.Mousehover(Users);
//		Users.click();
		
		ElementActionBy.doMouseHover(admin);
		ElementActionBy.doMouseHover(usersManagement);
		ElementActionBy.doMouseHover(users);
		ElementActionBy.doClick(users);
		return new UsersPage();
	}
}
