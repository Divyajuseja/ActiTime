package com.Actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.Actitime.pom.HomePage;
import com.Actitime.pom.LoginPage;

public class Baseclass {
	
	public static WebDriver driver;
	Filelib fis = new Filelib();
	
	
	@BeforeSuite
	public void DataBaseConnection() {
		Reporter.log("Databaseconnected",true);
		
	}
	@BeforeTest
	public void LaunchBrowser() throws IOException {
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		String url =fis.readDataFrompropertyFile("url");
		driver.get (url);
		Reporter.log("Brower is launched",true);
	}
	@BeforeMethod
	public void  login () throws IOException
	
	{
		String username =fis.readDataFrompropertyFile("username");
		LoginPage lp =new LoginPage(driver);
		lp.getUntbx().sendKeys(username);
		String password =fis.readDataFrompropertyFile("password");
		lp.getPwdbx().sendKeys("password");	
		lp.getLoginbt().click();
		Reporter.log("login successfully",true);
	}
	@AfterMethod
	public void logout () {
		HomePage hp = new HomePage(driver);
		hp.getLogoutlink().click();
		Reporter.log("logout successfully",true);
		
	}

	@AfterSuite
	public void DataBaseDisConnection() {
		Reporter.log("Databasedisconnected",true);
	}
}
		
		
		



