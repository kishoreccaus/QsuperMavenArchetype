package com.TestMavenArchetype.SecondModule;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.TestMavenArchetype.PageObjects.ClientMobilePage;
import com.TestMavenArchetype.PageObjects.HomePage;
import com.TestMavenArchetype.lib.Archetype_SuperTestng;

public class Day3 extends Archetype_SuperTestng {
	String sheetName = this.getClass().getSimpleName();
	@Test(testName="Day3-Test")
	public void Day3Test() throws InterruptedException{
	//All Page Object Declarations
		HomePage CHP = PageFactory.initElements(driver, HomePage.class);
		ClientMobilePage CMP = PageFactory.initElements(driver, ClientMobilePage.class);
		
		CHP.getMobileLink().click();		
		CHP.SortBy_DropDown("Name");
		CMP.getXperiaAddtoCartButton().click();
		CMP.getquantityInputBox().clear();
		CMP.getquantityInputBox().sendKeys("1000");
		CMP.getquantityUpdateButton().click();
		Thread.sleep(2000);
		
		String Error_Message = CMP.getshippingCartErrorMsg().getText();
		
		try {
			Assert.assertEquals(Error_Message,"Some of the products cannot be ordered in requested quantity.");
			Archetype_SuperTestng.KG1.captureSS(driver, "Product_Quanity_Err");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CMP.getemptyCartButton().click();		
		String emptyCartMsg = CMP.getshoppingCartEmptyMsg().getText();
		
		try {
			Assert.assertEquals(emptyCartMsg, "SHOPPING CART IS EMPTY");
			Reporter.log("SHOPPING CART IS EMPTY");
			Archetype_SuperTestng.KG1.captureSS(driver, "Shopping_Cart_Empty_Msg");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
