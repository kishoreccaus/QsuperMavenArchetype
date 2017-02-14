package com.TestMavenArchetype.FirstModule;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.TestMavenArchetype.PageObjects.HomePage;
import com.TestMavenArchetype.lib.Archetype_Generic;
import com.TestMavenArchetype.lib.Archetype_SuperTestng;

public class Day2 extends Archetype_SuperTestng{
	String sheetName = this.getClass().getSimpleName();
	@Test(testName="Day2-Test")
	public void Day2Test(){
		HomePage CHP = PageFactory.initElements(driver, HomePage.class);
		
		int Total_Rows = Archetype_Generic.getRowsandColumnsCount(sheetName);
		for(int rowNum =2;rowNum<=Total_Rows;rowNum++){
			CHP.getMobileLink().click();
			String Mobile_Name = xlsReader.getCellData(sheetName, "ProductName", rowNum);
			String Price_SonyXperia = driver.findElement(By.xpath("//*[@id='product-price-1']/span")).getText();
			
			driver.findElement(By.xpath("//a[text()='Sony Xperia']")).click();
			
			String MobilePrice_Product_Page = driver.findElement(By.xpath("//span[@id='product-price-1']/span")).getText();
			
			try {
				Assert.assertEquals(MobilePrice_Product_Page, Price_SonyXperia);
				Archetype_SuperTestng.KG1.captureSS(driver, "MobileDetailsPage");
			} catch (IOException e) {
				System.out.println("Product details are not matching");
			}
		}
	}

}
