package org.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.qa.utilities.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static WebDriverManager wd;
	public static Properties prop;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\org\\qa\\properties\\config.properties");
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void init() {
		String Browsername = prop.getProperty("browser");
		if(Browsername.equalsIgnoreCase("chrome")) {
			wd.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(Browsername.equalsIgnoreCase("firefox")) {
			wd.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(Browsername.equalsIgnoreCase("edge")) {
			wd.edgedriver().setup();
			driver = new EdgeDriver();
		}else if(Browsername.equalsIgnoreCase("opera")) {
			wd.operadriver();
			driver = new OperaDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(Constants.Implicit_wait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Constants.Pageload_timeout,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("URL"));
	}
}
