package com.w2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.w2a.utilities.ExcelReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static FileInputStream fis;
	public static Properties config;
	public static Properties OR;
	public static WebElement btn;
	public static WebElement addCustomer;
	public static WebElement firstName;
	
	
	//public static Logger log = Logger.getLogger(TestBase.class);
	public static Logger log = Logger.getLogger("devpinoyLogger");
	
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx");

	@BeforeSuite
	public void setUp() {

		if (driver == null) {

			config = new Properties();
			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
			log.debug("Config file loaded !!!");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			try {
				config.load(fis);
			} catch (IOException e1) {

				e1.printStackTrace();
			}
			if (config.getProperty("browser").equalsIgnoreCase("firefox")) {

				WebDriverManager.firefoxdriver().setup();

				driver = new FirefoxDriver();

			} else if (config.getProperty("browser").equalsIgnoreCase("chrome")) {

				WebDriverManager.chromedriver().setup();

				driver = new ChromeDriver();

			}
            log.debug("url loaded!!!");
			driver.get(config.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);

		}

	}
	
	
	public boolean isElementPreasent(By by){
		
		try {
			driver.findElement(by);
			return true;
		}
		catch(NoSuchElementException  e ){
			
			
		
		return false;
		}
		
	}

	@AfterSuite
	public void tearDown() {

		if (driver != null) {
			driver.quit();
			log.debug("Test Execution Completed!!!");
		}
	}

}
