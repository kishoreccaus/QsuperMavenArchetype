package com.TestMavenArchetype.lib;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITest;
import org.testng.ITestMethodFinder;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.TestMavenArchetype.PageObjects.HomePage;


public class Archetype_SuperTestng {
	public static Archetype_Generic KG1 = new Archetype_Generic();
	public static WebDriver driver = null;
	String Browser_Name = Archetype_Generic.getPropertyValue("Browser");
	static String filepath= Archetype_Generic.getPropertyValue("TestData");
	public static Xls_Reader xlsReader = new Xls_Reader(filepath);
	
	
	@BeforeMethod
	public void lauchWebDriver(){
		//Step1:- Read the webdriver parameter from the Properties file
		//Step2:- Launch the Webdriver
		if(Browser_Name.equalsIgnoreCase("Firefox")){
			//driver = new FirefoxDriver();
			FirefoxProfile fp = new FirefoxProfile();
			fp.setAcceptUntrustedCertificates(true);
			driver = new FirefoxDriver(fp);
		}	
		else if(Browser_Name.equalsIgnoreCase("Chrome  ")){
			System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(Archetype_Generic.getPropertyValue("TestURL"));
		//driver.get("http://live.guru99.com");
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void afterMethod(ITestResult it) throws IOException 
	  { 
		 System.out.println("getMethod"+it.getMethod().getMethodName());
		 String TestName = it.getMethod().getMethodName();
		  if(!it.isSuccess())
		 {
		  EventFiringWebDriver e1=new EventFiringWebDriver(driver);
		  File f1=e1.getScreenshotAs(OutputType.FILE);
		  String Class_Name = this.getClass().getName();
		  String date= new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		  String directoryName =".\\screenshots\\"+date;
		  File theDir = new File(directoryName);

		   // if the directory does not exist, create it
		   if (!theDir.exists())
		   {
			   theDir.mkdir();
		   }

		  File f2=new File(directoryName +"\\"+ TestName+".png");
		  /*String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		  File f2=new File(".\\screenshot\\"+Class_Name+timeStamp+".png");*/
		  FileUtils.copyFile(f1, f2);
		 }
		  driver.quit();
	  }	
}
