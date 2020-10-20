package org.qa.adminpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qa.base.TestBase;
import org.qa.utilities.TestUtil;

public class UsersPage extends TestBase{
	@FindBy(xpath = "//*[@id=\"searchSystemUser_userName\"]")
	WebElement username;

	@FindBy(xpath = "//*[@id=\"searchSystemUser_employeeName_empName\"]")
	WebElement Employeename;
	
	@FindBy(xpath = "//*[@id=\"searchBtn\"]")
	WebElement search;
	
	@FindBy(xpath = "//*[@id=\"searchSystemUser_userType\"]")
	WebElement userRole;
	
	@FindBy(xpath = "//*[@id=\"searchSystemUser_status\"]")
	WebElement Status;
	
	@FindBy(xpath = "//*[@id=\"btnAdd\"]")
	WebElement AddUser;
	
	public UsersPage(){
		PageFactory.initElements(driver, this);
	}
//	 *****************ACTIONS**********
	public  void usersearch(String un, String emp){
		username.sendKeys(un);
		TestUtil.SelectDropdown(userRole, "value","1");
		TestUtil.SelectDropdownbyIndex(Status, 2);
		Employeename.sendKeys(emp);
		search.click();
	}
	
	public void Addnewuser() {
		AddUser.click();
	}
}
