package com.w2a.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.w2a.base.TestBase;

public class LoginPage extends TestBase {
	
	WebElement btn = driver.findElement(By.xpath("//button[contains(text(),'Bank Manager Login')]"));
	
	public void loginAsBankManager() throws InterruptedException {

		btn.click();
		Thread.sleep(3000);

	}

}
