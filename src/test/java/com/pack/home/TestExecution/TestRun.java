package com.pack.home.TestExecution;

import java.io.IOException;


import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;

import com.pack.home.Libraries.DriverLaunch;
import com.pack.home.Libraries.LibraryForGenericFunction;

public class TestRun {
	DriverLaunch Dlib = new DriverLaunch();
	public static WebDriver driver;	
	LibraryForGenericFunction lib = null;

	@BeforeTest
	public void executing() throws InterruptedException, IOException {
		driver = Dlib.openBrowser("phantomjs");
		lib = new LibraryForGenericFunction(driver);
		// Application link will be opened
		driver.get("http://10.244.30.178/YouthInc");
	}

	@Test(priority = 2, description="Navigate to forgot Password page")
	public void passwdlink() throws InterruptedException, IOException {
		lib.waitAndClickForID("passwdlink", "login", "class");
	}
	
	@Test(priority = 6, description="Enter mail address page ")
	public void emaillink() throws InterruptedException, IOException {
		lib.jsSendKeysForID("emaillink", "abcd123@gmail.com", "login", "ID");
		
		Assert.assertTrue(lib.waitAndClickForID("emaillink2", "login", "name"));
		Thread.sleep(2000);
						
	}

	@AfterTest()
	public void afterMethod() throws IOException {
		driver.quit();		
	}	
	
}
