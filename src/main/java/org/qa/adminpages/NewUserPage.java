package org.qa.adminpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qa.base.TestBase;
import org.qa.utilities.TestUtil;

public class NewUserPage extends TestBase{

	@FindBy(xpath = "//*[@id=\"systemUser_employeeName_empName\"]")
	WebElement Employeename;
	
	@FindBy(xpath = "//*[@id=\"systemUser_userName\"]")
	WebElement Username;
	
	@FindBy(xpath = "//*[@id=\"systemUser_userType\"]")
	WebElement userRole;
	
	@FindBy(xpath = "//*[@id=\"systemUser_status\"]")
	WebElement status;
	
	@FindBy(xpath = "//*[@id=\"systemUser_password\"]")
	WebElement password;
	
	@FindBy(xpath = "//*[@id=\"systemUser_confirmPassword\"]")
	WebElement conformpassword;
	
	@FindBy(xpath = "//*[@id=\"btnSave\"]")
	WebElement save;
	
	@FindBy(xpath = "//*[@id=\"btnCancel\"]")
	WebElement cancel;
	
	public NewUserPage() {
		PageFactory.initElements(driver, this);
	}
//	**********************Actions***************************************
	public void createnewuser(String empname, String un, String Pwd, String cnpwd) {
		TestUtil.SelectDropdown(userRole, "value", "1");
		Employeename.sendKeys(empname);
		Username.sendKeys(un);
		TestUtil.SelectDropdownbyIndex(status, 0);
		password.sendKeys(Pwd);
		conformpassword.sendKeys(cnpwd);
		save.click();
	}
}
