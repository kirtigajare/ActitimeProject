package com.Actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Actitime.pom.LoginPage;

public class BaseClass {
	public static WebDriver driver;
	FileLibrary f= new FileLibrary();
	@BeforeSuite
	public void databaseconnected(){
		Reporter.log("database connected",true);
		
	}
	@AfterSuite
	public void databasedisconnected() {
		Reporter.log("database disconnected",true);
	}
	@BeforeClass
	public void launchBrowser() throws IOException  {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remot-allow-origins=*");
		 driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String FG = f.readDataFromProperty("url");
		driver.get(FG);
		Reporter.log("browser launched",true);
		
	}
	@AfterClass
		public void closeBrowser() {
			driver.close();
			
			Reporter.log("browser closed",true);
		}

		@BeforeMethod
		public void login() throws IOException {
			String U = f.readDataFromProperty("username");
			 String PW = f.readDataFromProperty("password");
			 LoginPage lp=new LoginPage(driver);
			 lp.getUntbx().sendKeys(U);
			 lp.getPwtbx().sendKeys(PW);
			 lp.getLgbtn().click();
			//driver.findElement(By.id("username")).sendKeys(U);
			//driver.findElement(By.name("pwd")).sendKeys(PW);
			//driver.findElement(By.xpath("//div[.='Login ']")).click();
			
			Reporter.log("logged in succesfully",true);
		}
		@AfterMethod
		public void logout() {
			driver.findElement(By.id("logoutLink")).click();
			Reporter.log("logged out",true);
		}
	}

