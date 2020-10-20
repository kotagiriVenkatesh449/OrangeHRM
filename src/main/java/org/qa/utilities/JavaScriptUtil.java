package org.qa.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.qa.base.TestBase;

public class JavaScriptUtil extends TestBase {

	public static void scrollIntoView(WebElement Element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", Element);
	}

	public static void scrollByPixel(String x_pixels, String y_pixels) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy('" + x_pixels + "', '" + y_pixels + "' ");
	}

	public static void scrollPageDown() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public static void ClickElementByJS(WebElement Element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click", Element);
	}

	public static void MouseHoverClick() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("$('ul.menus.menu-secondary.sf-js-enabled.sub-menu li').hover()");
	}

	public static void naviagate(String pageurl) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.location='" + pageurl + "'");
	}

	public static void flash(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 10; i++) {
			changeColor("rgb(0,200,0)", element);// 1
			changeColor(bgcolor, element);// 2
		}
	}

	private static void changeColor(String color, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void drawBorder(WebElement Element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border= '3px solid red'", Element);
	}

	public void sendKeysUsingJSWithId(String id, String value) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("document.getElementById('" + id + "').value='" + value + "'");
	}

	public void sendKeysUsingJSWithName(String name, String value) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("document.getElementByName('" + name + "').value='" + value + "'");
	}

	public static void refreshBrowser() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(0");
	}

	public static String getInnerTextByJS() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String InnerText = js.executeScript("return document.documentElement.innerText;").toString();
		return InnerText;
	}

	public static String getTitleByJS() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String Title = js.executeScript("return document.title;").toString();
		return Title;
	}

	public static String getUrlByJS() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String URL = js.executeScript("return document.URL;").toString();
		return URL;
	}

	public static String getDomainByJS() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String Domain = js.executeScript("return document.domain;").toString();
		return Domain;
	}

	public static void generateAlert(String message) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('" + message + "')");
	}

	public String getBrowserInfo() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String uAgent = js.executeScript("return navigator.userAgent;").toString();
		return uAgent;
	}

	public static void checkPageIsReady() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Initially bellow given if condition will check ready state of page.
		if (js.executeScript("return document.readyState").toString().equals("complete")) {
			System.out.println("Page Is loaded.");
			return;
		}

		// This loop will rotate for 25 times to check If page Is ready after
		// every 1 second.
		// You can replace your value with 25 If you wants to Increase or
		// decrease wait time.
		for (int i = 0; i < 20; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			// To check page ready state.
			if (js.executeScript("return document.readyState").toString().equals("complete")) {
				break;
			}
		}
	}
}
