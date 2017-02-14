package com.TestMavenArchetype.FirstModule;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

//import com.TestMavenArchetype.PageObjects.HomePage;
import com.TestMavenArchetype.lib.*;
import com.TestMavenArchetype.PageObjects.HomePage;



public class Day1 extends Archetype_SuperTestng{
	String Class_Name = this.getClass().getName();
	@Test(testName="FirstTest")
	public void Day1Test() throws InterruptedException, IOException{
		//Declaring the Page Objects
		HomePage CHP = PageFactory.initElements(driver, HomePage.class);
		
		List<String> Displayed_Names = new ArrayList<String>();
		List<String> Sorted_Names = new ArrayList<String>();
		
		System.out.println("Launched the driver");
		Assert.assertEquals(driver.getTitle(), "Home page");
		//System.out.println("Verified the Assert");
		CHP.getMobileLink().click();
		Assert.assertEquals(driver.getTitle(), "Mobile");
		//CHP.getSortByDropdown().sendKeys("Name");
		CHP.SortBy_DropDown("Name");
		Thread.sleep(2000);
		List<WebElement> Actual_List =driver.findElements(By.xpath("//h2[@class='product-name']/a"));
		
		for(int i =0;i<Actual_List.size();i++){
			//Displayed_Names.add(i, Actual_List.get(i).getText()); 
			Displayed_Names.add(Actual_List.get(i).getText());
			Sorted_Names.add(Actual_List.get(i).getText());
		}
		
		Collections.sort(Sorted_Names);
		Assert.assertEquals(Displayed_Names,Sorted_Names);
		
		if (Displayed_Names.equals(Sorted_Names))
		{
			final String failedMsg ="Customer Names are in sorted order.";
			System.out.println(failedMsg);
			Archetype_SuperTestng.KG1.captureSS(driver, Class_Name+" - SortedScreenshot");
		}
		KG1.enterLog("Completed the Day-1 Script");
	}

}
