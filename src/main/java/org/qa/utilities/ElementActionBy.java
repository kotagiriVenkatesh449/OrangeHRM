package org.qa.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.qa.base.TestBase;

/**
 * 
 * @author = KotagiriVenkatesh
 *
 */

public class ElementActionBy extends TestBase {

	public static WebDriverWait wait = new WebDriverWait(driver, 10);

	/**
	 * 
	 * @param selector
	 * @return this method will return the WebElement
	 */
	public static WebElement getElement(By selector) {
		waitForPresenceOfElement(selector);
		WebElement element = driver.findElement(selector);
		return element;
	}

	/**
	 * 
	 * @param selector
	 * @return this method will return list<WebElement>.
	 */
	public static List<WebElement> getElements(By selector) {
		waitForPresenceOfElement(selector);
		List<WebElement> Elements = driver.findElements(selector);
		return Elements;
	}

	/**
	 * This method is for performing SendKeys Action on WebElement.
	 * 
	 * @param selector
	 * @param Data
	 */
	public static void doType(By selector, String Data) {
		waitForPresenceOfElement(selector);
		getElement(selector).sendKeys(Data);
	}

	/**
	 * This method is for performing Clear Action on WebElement.
	 * 
	 * @param selector
	 */
	public static void doClear(By selector) {
		waitForPresenceOfElement(selector);
		getElement(selector).clear();
	}

	/**
	 * This method performs Click Action on WenElement.
	 * 
	 * @param selector
	 */
	public static void doClick(By selector) {
//		waitForElementPresenceOf(selector);
		waitForElemetClickable(selector);
		getElement(selector).click();
	}

	/**
	 * This method performs RadioButton Click Action on WenElement.
	 * 
	 * @param selector
	 */
	public static void doRadioButtonClick(By selector) {
		waitForPresenceOfElement(selector);
		try {
			if (!getElement(selector).isSelected()) {
				doClick(selector);
			} else {
				System.out.println(selector + " " + "Already selected");
			}
		} catch (Exception e) {
			System.out.println("Element unable to select " + " " + selector);
			System.out.println(e);
		}
	}

	/**
	 * This method performs CheckBoxButton Click Action on WenElement.
	 * 
	 * @param selector
	 */
	public static void doCheckBox(By selector) {
		waitForPresenceOfElement(selector);
		try {
			if (!getElement(selector).isSelected()) {
				doClick(selector);
			} else {
				System.out.println(selector + " " + "Already selected");
			}
		} catch (Exception e) {
			System.out.println("Element unable to select " + " " + selector);
			System.out.println(e);
		}
	}

	/**
	 * This method performs FileUpload Action.
	 * 
	 * @param selector
	 * @param FilePath
	 */
	public static void doFileUpload(By selector, String FilePath) {
		waitForPresenceOfElement(selector);
		waitForVisibilityOfElement(selector);
		try {
			doType(selector, FilePath);
		} catch (Exception e) {
			System.out.println("File Cannot Upload");
			System.out.println(e);
		}
	}

	/**
	 * This Method Performs FileDownload Action. 
	 * 
	 * @param selector
	 * @param LocationToSaveFile
	 */
	public static void doFileDownload(By selector) {
		waitForPresenceOfElement(selector);
		waitForVisibilityOfElement(selector);
		try {
			doClick(selector);
			Thread.sleep(10000);
		} catch (Exception e) {
			System.out.println("File Cannot Download ");
			System.out.println(e);
		}
	}
	
	/**
	 * This Method Performs GetTitle of Page.
	 * 
	 * @return
	 */
	public static String dogetTitle() {
		String Title = driver.getTitle();
		return Title;
	}
	
	/**
	 * This Method Performs GetCurrentUrl of Page
	 * 
	 * @return
	 */
	public static String  doGetUrl() {
		String URL = driver.getCurrentUrl();
		return URL;	
	}
	
	public static void doGetAllLinks(By selector) {
		waitForPresenceOfAllElements(selector);
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/**
	 * This method performs Drag And Drop.
	 * 
	 * @param Sourceselector
	 * @param Targetselector
	 */
	public static void doDragAndDrop(By Sourceselector, By Targetselector) {
		waitForVisibilityOfElement(Sourceselector);
		waitForVisibilityOfElement(Targetselector);
		try {
			Actions action = new Actions(driver);
			WebElement Source = getElement(Sourceselector);
			WebElement target = getElement(Targetselector);
			action.dragAndDrop(Source, target).build().perform();
			;
		} catch (Exception e) {
			System.out.println("Cannot Perform Drag And Drop On : " + Sourceselector + "" + Targetselector);
			System.out.println(e);
		}
	}

	/**
	 * This method performs MouseHover.
	 * 
	 * @param selector
	 */
	public static void doMouseHover(By selector) {
		waitForVisibilityOfElement(selector);
		Actions action = new Actions(driver);
		try {
			WebElement element = getElement(selector);
			action.moveToElement(element).build().perform();
		} catch (Exception e) {
			System.out.println("Cannot Perform MouseHover : " + " " + selector);
			System.out.println(e);
		}
	}

	/**
	 * This Method Performs DropDowns By VisibleText And Value
	 * 
	 * @param selector
	 * @param Action
	 * @param Data
	 */
	public static void doSelect(By selector, String Action, String Data) {
		waitForPresenceOfElement(selector);
		try {
			List<WebElement> element = getElements(selector);
			Select select = new Select((WebElement) element);
			if (Action.equalsIgnoreCase("VisibleText")) {
				select.selectByVisibleText(Data);
			} else if (Action.equalsIgnoreCase("value")) {
				select.deselectByValue(Data);
			} else {
				System.out.println(
						"Please make sure i.e Enter Action As VisibleText for selectby visibletext  OR Vlaue for selectby Value ");
			}
		} catch (Exception e) {
			System.out.println("element cannot perform Dropdown on:  " + selector);
			System.out.println(e);
		}
	}

	/**
	 * This Method Performs DropDowns By IndexValue
	 * 
	 * @param selector
	 * @param index
	 */
	public static void doSelectbyindex(By selector, int index) {
		waitForPresenceOfElement(selector);
		try {
			List<WebElement> element = getElements(selector);
			Select select = new Select((WebElement) element);
			select.selectByIndex(index);
		} catch (Exception e) {
			System.out.println("element cannot perform Dropdown on:  " + selector);
			System.out.println(e);
		}
	}

	/**
	 * This Method Is for Taking Screenshot
	 * 
	 * @throws IOException
	 */
	public static void Screenshot() throws IOException {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		long shotname = System.currentTimeMillis();
		File Dest = new File(System.getProperty("user.dir") + "\\ORANGEHRM\\Screenshots\\" + shotname + " " + ".png");
		FileUtils.copyFile(src, Dest);
	}

	/**
	 * This Method performs Alert Action to Accept or Dismiss Alert.
	 * 
	 * @param Action
	 */
	public static void doAlert(String Action) {
		waitForAlert();
		if (Action.equalsIgnoreCase("Accept")) {
			Alert alert = driver.switchTo().alert();
			String Text = alert.getText();
			System.out.println(Text);
			alert.accept();
		} else if (Action.equalsIgnoreCase("Dismiss")) {
			Alert alert = driver.switchTo().alert();
			String Text = alert.getText();
			System.out.println(Text);
			alert.dismiss();
		} else {
			System.out.println("please type 'Accept' for AlertAcept Or 'Dismiss' for AlertDismiss");
		}
	}

	/**
	 * This Method performs Alert Action with Text to be Entered In TextBox to
	 * Accept or Dismiss the Alert.
	 * 
	 * @param Action
	 * @param TextBoxMessage
	 */
	public static void doAlertWithMessage(String Action, String TextBoxMessage) {
		waitForAlert();
		if (Action.equalsIgnoreCase("Accept")) {
			Alert alert = driver.switchTo().alert();
			String Text = alert.getText();
			System.out.println(Text);
			alert.sendKeys(TextBoxMessage);
			alert.accept();
		} else if (Action.equalsIgnoreCase("Dismiss")) {
			Alert alert = driver.switchTo().alert();
			String Text = alert.getText();
			System.out.println(Text);
			alert.sendKeys(TextBoxMessage);
			alert.dismiss();
		} else {
			System.out.println(
					"please type 'Accept' for AlertAcept Or 'Dismiss' for AlertDismiss And Enter Data In  'TextBoxMessage'  To Enter Data In TextBox");
		}
	}

//	****************************************************************************************************************************************************************

//	********************************************************** EXPLICIT_WAITS ************************************************************************************

	/**
	 * This Method is to wait for Alert is Present/Not
	 */
	public static void waitForAlert() {
		try {
			wait.until(ExpectedConditions.alertIsPresent());
		} catch (Exception e) {
			System.out.println("Alert was not present");
			System.out.print(e);
		}
	}

	/**
	 * This Method is to wait for PresenceOfElement
	 * 
	 * @param selector
	 */
	public static void waitForPresenceOfElement(By selector) {

		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(selector));
		} catch (Exception e) {
			System.out.println("Element is Not Present In DOM");
			System.out.print(e);
		}
	}

	/**
	 * This Method is to wait for ElementToBeClickable
	 * 
	 * @param selector
	 */
	public static void waitForElemetClickable(By selector) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(selector));
		} catch (Exception e) {
			System.out.println("Element is Notvisible Or Enabled ");
			System.out.println(e);
		}
	}

	/**
	 * This Method is to wait for visibilityOfElement
	 * 
	 * @param selector
	 */
	public static void waitForVisibilityOfElement(By selector) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
		} catch (Exception e) {
			System.out.println("Element is Not Visible");
			System.out.println(e);
		}
	}

	/**
	 * This Method is to wait for VisibilityOfAllElements.
	 * 
	 * @param selector
	 */
	public static void waitForVisibilityOfAllElements(By selector) {
		try {
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(selector));
		} catch (Exception e) {
			System.out.println("Elements is Not Visible");
			System.out.println(e);
		}
	}

	/**
	 * This Method is to wait for presenceOfAllElements.
	 * 
	 * @param selector
	 */
	public static void waitForPresenceOfAllElements(By selector) {
		try {
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(selector));
		} catch (Exception e) {
			System.out.println("PresenceOfAllElements Not Visible");
			System.out.println(e);
		}
	}

	/**
	 * This Method is to wait for frameToBeAvailableAndSwitchToIt.
	 * 
	 * @param selector
	 */
	public static void waitForFrameToBeAvailableAndSwitchToIt(By selector) {
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(selector));
		} catch (Exception e) {
			System.out.println(" The given frame is Notavailable to switch to.");
			System.out.println(e);
		}
	}

	/**
	 * This Method is to wait for frameToBeAvailableAndSwitchToIt with Index.
	 * 
	 * @param index
	 */
	public static void waitForFrameToBeAvailableAndSwitchToIt(int index) {
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
		} catch (Exception e) {
			System.out.println(" The given frame is Notavailable to switch to.");
			System.out.println(e);
		}
	}

	/**
	 * This Method is to wait for frameToBeAvailableAndSwitchToIt With FrameName.
	 * 
	 * @param FrameName
	 */
	public static void waitForFrameToBeAvailableAndSwitchToIt(String FrameName) {
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(FrameName));
		} catch (Exception e) {
			System.out.println(" The given frame is Notavailable to switch to.");
			System.out.println(e);
		}
	}

	/**
	 * This Method is to wait for elementToBeSelected.
	 * 
	 * @param selector
	 */
	public static void waitForElementToBeSelected(By selector) {
		try {
			wait.until(ExpectedConditions.elementToBeSelected(selector));
		} catch (Exception e) {
			System.out.println("The Element n=is Not to Be Selected");
			System.out.println(e);
		}
	}

	/**
	 * This Method is to wait for textMatches.
	 * 
	 * @param selector
	 * @param pattern
	 */
	public static void waitForElementTextMatches(By selector, Pattern pattern) {
		try {
			wait.until(ExpectedConditions.textMatches(selector, pattern));
		} catch (Exception e) {
			System.out.println("The Element n=is Not to Be Selected");
			System.out.println(e);
		}
	}

	/**
	 * This Method is to wait for titleIs.
	 * 
	 * @param Title
	 */
	public static void waitForTitleIs(String Title) {
		try {
			wait.until(ExpectedConditions.titleIs(Title));
		} catch (Exception e) {
			System.out.println("Title Not Matched");
			System.out.println(e);
		}
	}

	/**
	 * This Method is to wait for titleContains.
	 * 
	 * @param Title
	 */
	public static void waitForTitleContains(String Title) {
		try {
			wait.until(ExpectedConditions.titleContains(Title));
		} catch (Exception e) {
			System.out.println("Title Does'nt match");
			System.out.println(e);
		}
	}

	/**
	 * This Method is to wait for urlToBe.
	 * 
	 * @param Url
	 */
	public static void waitForUrlToBe(String Url) {
		try {
			wait.until(ExpectedConditions.urlToBe(Url));
		} catch (Exception e) {
			System.out.println("Url Does'nt match");
			System.out.println(e);
		}
	}

	/**
	 * This Method is to wait for urlContains.
	 * 
	 * @param Url
	 */
	public static void waitForUrlContains(String Url) {
		try {
			wait.until(ExpectedConditions.urlContains(Url));
		} catch (Exception e) {
			System.out.println("Url Does'nt match");
			System.out.println(e);
		}
	}

	/**
	 * This Method is to wait for urlMatche.
	 * 
	 * @param Url
	 */
	public static void waitForUrlMathces(String Url) {
		try {
			wait.until(ExpectedConditions.urlMatches(Url));
		} catch (Exception e) {
			System.out.println("Url Does'nt match");
			System.out.println(e);
		}
	}

	/**
	 * This Method is to wait for numberOfWindowsToBe.
	 * 
	 * @param windowSize
	 */
	public static void waitForNumberOfWindowsToBe(int windowSize) {
		try {
			wait.until(ExpectedConditions.numberOfWindowsToBe(windowSize));
		} catch (Exception e) {
			System.out.println("No Windows Available");
			System.out.println(e);
		}
	}

	/**
	 * This Method is to wait for textToBe.
	 * 
	 * @param selector
	 * @param Text
	 */
	public static void waitForTextToBe(By selector, String Text) {
		try {
			wait.until(ExpectedConditions.textToBe(selector, Text));
		} catch (Exception e) {
			System.out.println("Text Didn't Matched");
			System.out.println(e);
		}
	}

	/**
	 * This Method is to wait for TextToBePresentInElement.
	 * 
	 * @param selector
	 * @param Text
	 */
	public static void waitForTextToBePresentInElement(By selector, String Text) {
		try {
			wait.until(ExpectedConditions.textToBePresentInElementLocated(selector, Text));
		} catch (Exception e) {
			System.out.println("Text Didn't Matched");
			System.out.println(e);
		}
	}

	/**
	 * This Method is to wait for invisibilityOfElementLocated.
	 * 
	 * @param selector
	 */
	public static void waitForInvisibilityOfElement(By selector) {
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(selector));
			System.out.println("Condition matched for invisibilityOfElement ");
		} catch (Exception e) {
			System.out.println(" Didn't Matched invisibilityOfElement");
			System.out.println(e);
		}
	}

	/**
	 * This Method is to wait for invisibilityOfElementWithText.
	 * 
	 * @param selector
	 * @param Text
	 */
	public static void waitForInvisibilityOfElementWithText(By selector, String Text) {
		try {
			wait.until(ExpectedConditions.invisibilityOfElementWithText(selector, Text));
			System.out.println("Condition matched for invisibilityOfElement with text ");
		} catch (Exception e) {
			System.out.println(" Didn't Matched invisibilityOfElement with text");
			System.out.println(e);
		}
	}

	/**
	 * This Method is to wait for numberOfElementsToBe.
	 * 
	 * @param selector
	 * @param Number
	 */
	public static void waitForNumberOfElementsToBe(By selector, int Number) {
		try {
			wait.until(ExpectedConditions.numberOfElementsToBe(selector, Number));
		} catch (Exception e) {
			System.out.println(" Didn't Matched numberOfElementsToBe");
			System.out.println(e);
		}
	}

	/**
	 * This Method is to wait for numberOfElementsToBeLessThan.
	 * 
	 * @param selector
	 * @param Number
	 */
	public static void waitForNumberOfElementsToBeLessThan(By selector, int Number) {
		try {
			wait.until(ExpectedConditions.numberOfElementsToBeLessThan(selector, Number));
		} catch (Exception e) {
			System.out.println(" Didn't Matched numberOfElementsToBeLessThan");
			System.out.println(e);
		}
	}

	/**
	 * This Method is to wait for numberOfElementsToBeMoreThan.
	 * 
	 * @param selector
	 * @param Number
	 */
	public static void waitForNumberOfElementsToBeMoreThan(By selector, int Number) {
		try {
			wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(selector, Number));
		} catch (Exception e) {
			System.out.println(" Didn't Matched numberOfElementsToBeMoreThan");
			System.out.println(e);
		}
	}

	/**
	 * This Method is to wait for attributeContains.
	 * 
	 * @param selector
	 * @param attribute
	 * @param Value
	 */
	public static void waitForAttributeContains(By selector, String attribute, String Value) {
		try {

			wait.until(ExpectedConditions.attributeContains(selector, attribute, Value));
		} catch (Exception e) {
			System.out.println(" Didn't Matched attributeContains");
			System.out.println(e);
		}
	}

	/**
	 * This Method is to wait for attributeToBe.
	 * 
	 * @param selector
	 * @param attribute
	 * @param Value
	 */
	public static void waitForAttributeToBe(By selector, String attribute, String Value) {
		try {
			wait.until(ExpectedConditions.attributeToBe(selector, attribute, Value));
		} catch (Exception e) {
			System.out.println(" Didn't Matched attributeToBe");
			System.out.println(e);
		}
	}

	/**
	 * This Method is to wait for elementSelectionStateToBe.
	 * 
	 * @param selector
	 * @param attribute
	 * @param flag
	 */
	public static void waitForElementSelectionStateToBe(By selector, String attribute, boolean flag) {
		try {
			wait.until(ExpectedConditions.elementSelectionStateToBe(selector, flag));
		} catch (Exception e) {
			System.out.println(" Didn't Matched lementSelectionStateToBe");
			System.out.println(e);
		}
	}

	/**
	 * This Method is to wait for javaScriptThrowsNoExceptions.
	 * 
	 * @param javaScript
	 */
	public static void waitForJavaScriptThrowsNoExceptions(String javaScript) {
		try {
			wait.until(ExpectedConditions.javaScriptThrowsNoExceptions(javaScript));
		} catch (Exception e) {
			System.out.println(" Didn't Matched javaScript");
			System.out.println(e);
		}
	}

	/**
	 * This Method is to wait for jsReturnsValue
	 * 
	 * @param javaScript
	 */
	public static void waitForJsReturnsValue(String javaScript) {
		try {
			wait.until(ExpectedConditions.jsReturnsValue(javaScript));
		} catch (Exception e) {
			System.out.println(" An expectation for String value from javascript");
			System.out.println(e);
		}
	}

	/**
	 * This Method is to wait for A StaleElementReferenceException is thrown when
	 * the second part of the condition is checked.
	 * 
	 * @param condition
	 */
	public static void waitForRefreshed(ExpectedCondition<Object> condition) {
		try {
			wait.until(ExpectedConditions.refreshed(condition));
		} catch (Exception e) {
			System.out.println(
					"  A StaleElementReferenceException is thrown when the second part of the condition is checked.");
			System.out.println(e);
		}
	}

	/**
	 * This Method And is to wait for a list of alternative conditions.
	 * 
	 * @param conditions
	 */
	public static void waitForAnd(ExpectedCondition<?> conditions) {
		try {
			wait.until(ExpectedConditions.and(conditions));
		} catch (Exception e) {
			System.out.println("   ExpectedCondition is Not a list of alternative conditions.");
			System.out.println(e);
		}
	}

	/**
	 * This Method OR is to wait for a list of alternative conditions.
	 * 
	 * @param conditions
	 */
	public static void waitForOr(ExpectedCondition<?> conditions) {
		try {
			wait.until(ExpectedConditions.or(conditions));
		} catch (Exception e) {
			System.out.println("   ExpectedCondition is Not a list of alternative conditions.");
			System.out.println(e);
		}
	}

//	*************************************************************** END **************************************************************************************************

//	**********************************************************************************************************************************************************************
}
