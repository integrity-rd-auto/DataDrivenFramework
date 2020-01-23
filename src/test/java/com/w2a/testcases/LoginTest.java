package com.w2a.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class LoginTest extends TestBase {

	@Test
	public void loginAsBankManager() throws InterruptedException {

		log.debug("Inside main page");
		btn = driver.findElement(By.xpath("//button[contains(text(),'Bank Manager Login')]"));
		btn.click();
		log.debug("Test Case 1 Passed");
		Thread.sleep(3000);
		Assert.assertTrue(isElementPreasent(By.xpath("//button[contains(text(),'Add Customer')]")));
		log.debug("Test Case Ends!!!!");
	}

}
