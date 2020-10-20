package org.qa.utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static WebDriverWait wait;
	public static Wait<WebDriver> fwait;

//	************************************************************************************************************************

//	**************************************  DO_ACTIONS *********************************************************************

	public static void Type(WebElement Element, String Data) {
//		 Element =  (WebElement) locator;
//		WebElement Element =(WebElement) locator;
//		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		elementTobeDisplayed_wait(Element);
		elementToBeClickable_wait(Element);
		Element.sendKeys(Data);
	}

	public static void doClear(WebElement Element) {
		elementTobeDisplayed_wait(Element);
		Element.clear();
	}

	public static void doClick(WebElement Element) throws InterruptedException {
		elementToBeClickable_wait(Element);
//		fwait.wait();
		Element.click();
	}

	public static void Radiobutton(WebElement Element) {
		elementToBeClickable_wait(Element);
		if (!Element.isSelected()) {
			Element.click();
		} else {
			System.out.println(Element + "Element is already Selected");
		}
	}

	public static void CheckBox(WebElement Element) {
		elementToBeClickable_wait(Element);
		if (!Element.isSelected()) {
			Element.click();
		} else {
			System.out.println(Element + "Element is already Selected");
		}
	}

	public static String get_Title() {
//		 String Title =Titlecontains(Title);
		String title = driver.getTitle();
		return title;
	}

	public static boolean IsEnabled_Element(WebElement Element) {
		boolean flag = Element.isEnabled();
		return flag;
	}

	public static boolean IsDisplayed_Element(WebElement Element) {
		boolean flag = Element.isDisplayed();
		return flag;
	}

	public static void get_AllLinks(WebElement Element) {
		List<WebElement> links = (List<WebElement>) Element;
		for (int i = 1; i < links.size(); i++) {
			System.out.println(links.get(i).getText());
		}
	}

//	**************************************** ALERT ACTIONS*******************************************************************

	public static void alert(String Action) {
		if (Action.equalsIgnoreCase("Accept")) {
			Alert alert = driver.switchTo().alert();
			String Message = alert.getText();
			System.out.println("You Performed Action For : " + Message);
			alert.accept();
		} else if (Action.equalsIgnoreCase("Dismiss")) {
			Alert alert = driver.switchTo().alert();
			String Message = alert.getText();
			System.out.println("You Dismissed Action For : " + Message);
		} else {
			System.out.println("Please Enter Accept or Dismiss To Perform Action");
		}
	}

	public static void Alert_with_Message(String DataMessage) {
		Alert alert = driver.switchTo().alert();
		String Message = alert.getText();
		System.out.println("You Performed Action For" + Message);
		alert.sendKeys(DataMessage);
		alert.accept();
	}

//	*************************************************************************************************************************

//  ********************************************* MOUSE_HOVER ****************************************************************

	public static void Mousehover(WebElement Element) {
		Actions action = new Actions(driver);
		elementTobeDisplayed_wait(Element);
		action.moveToElement(Element).perform();
	}
//	***************************************************************************************************************************
	
//	********************************************** SELECT DROPDOWN ************************************************************

	public static void SelectDropdown(WebElement Element, String Selectby, String Data) {
		elementTobeDisplayed_wait(Element);
		Select select = new Select(Element);
		if (Selectby.equalsIgnoreCase("Text")) {
			select.selectByVisibleText(Data);
		} else if (Selectby.equalsIgnoreCase("value")) {
			select.selectByValue(Data);
		} else {
			System.out.println("Please Enter 'Text' for selectByVisibleText OR  'Value' for deselectByValue");
		}
	}

	public static void SelectDropdownbyIndex(WebElement Element, int Data) {
		elementTobeDisplayed_wait(Element);
		Select select = new Select(Element);
		select.selectByIndex(Data);
	}

//	*************************************************************************************************************************

//  ********************************************  SCREENSHOT *****************************************************************

	public static void Screenshot() {

		File Src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png");
		try {
			FileUtils.copyFile(Src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	**************************************************************************************************************************

//	************************************FILE_UPLOAD/DOWNLOAD******************************************************************

	public static void FileUpload(WebElement Element, String FilePath) throws InterruptedException {
		Thread.sleep(1000);
		Element.sendKeys(FilePath);
	}

	public static void FileDownload(WebElement Element) throws InterruptedException {
		Element.click();
		Thread.sleep(10000);
	}
	
	
//	***************************************************************************************************************************

//	******************************************* DRAG AND DROP******************************************************************

	public static void DragAndDrop(WebElement Source, WebElement Target) {
		Actions action = new Actions(driver);
		action.dragAndDrop(Source, Target).perform();
	}

	
//	***************************************************************************************************************************

//	****************************************** SWITCH FRAMES AND WINDOWS ******************************************************

	public static void SwitchToFrame(String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	public static void SwitchToFramebyIndex(int Index) {
		driver.switchTo().frame(Index);
	}

	public static void WindowHandles() {
		Set<String> handles = driver.getWindowHandles();
		for (String windowhandle : handles) {

		}
	}
	

//	****************************************** WEBDRIVER WAIT *****************************************************************

	public static void Titlecontains(String title) {
		wait.until(ExpectedConditions.titleContains(title));
	}

	public static void Alertispresent(WebElement Element) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public static void elementTobeDisplayed_wait(WebElement Element) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(Element));
	}

	public static void elementToBeClickable_wait(WebElement Element) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(Element));
	}

	public static void invisibilityOfAllElements_wait(WebElement Element) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfAllElements(Element));
	}

	public static void frameTobeAvailableSwitchit(WebElement Element) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(Element));
	}

	public static void NoSuchElementException_wait() {
		fwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
	}

	public static WebElement fluentWait(final WebElement Element) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return Element;
			}
		});
		return element;
	};
	

//	****************************************************************************************************************************************

//	****************************************** DROP FILE ***********************************************************************************

	public static void DropFile(File filePath, WebElement target, int offsetX, int offsetY) {
		if (!filePath.exists())
			throw new WebDriverException("File not found: " + filePath.toString());

//	    WebDriver driver = ((RemoteWebElement)target).getWrappedDriver();
		WebDriver driver = ((org.openqa.selenium.remote.RemoteWebElement) target).getWrappedDriver();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 30);

		String JS_DROP_FILE = "var target = arguments[0]," + "    offsetX = arguments[1],"
				+ "    offsetY = arguments[2]," + "    document = target.ownerDocument || document,"
				+ "    window = document.defaultView || window;" + "" + "var input = document.createElement('INPUT');"
				+ "input.type = 'file';" + "input.style.display = 'none';" + "input.onchange = function () {"
				+ "  var rect = target.getBoundingClientRect(),"
				+ "      x = rect.left + (offsetX || (rect.width >> 1)),"
				+ "      y = rect.top + (offsetY || (rect.height >> 1)),"
				+ "      dataTransfer = { files: this.files };" + ""
				+ "  ['dragenter', 'dragover', 'drop'].forEach(function (name) {"
				+ "    var evt = document.createEvent('MouseEvent');"
				+ "    evt.initMouseEvent(name, !0, !0, window, 0, 0, 0, x, y, !1, !1, !1, !1, 0, null);"
				+ "    evt.dataTransfer = dataTransfer;" + "    target.dispatchEvent(evt);" + "  });" + ""
				+ "  setTimeout(function () { document.body.removeChild(input); }, 25);" + "};"
				+ "document.body.appendChild(input);" + "return input;";

		WebElement input = (WebElement) jse.executeScript(JS_DROP_FILE, target, offsetX, offsetY);
		input.sendKeys(filePath.getAbsoluteFile().toString());
		wait.until(ExpectedConditions.stalenessOf(input));
	}

}
