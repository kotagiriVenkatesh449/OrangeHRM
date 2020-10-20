package org.qa.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.qa.base.TestBase;

public class ElementActions extends TestBase {
	public static WebDriverWait wait= new WebDriverWait(driver, 10);
	
	public static WebElement getelement(By locator) {
		WebElement element = null;
		element = driver.findElement(locator);
		return element;
	}

	public static void type(By locator, String Data) {
		WebElement ele =wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		ele.sendKeys(Data);
	}
}
