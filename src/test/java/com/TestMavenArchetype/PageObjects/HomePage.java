package com.TestMavenArchetype.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	
	@FindBy(xpath="//a[text()='Mobile']")
	private WebElement MobileLink;
	
	@FindBy(xpath="//select[@title='Sort By']")
	private WebElement Dropdown_SortBy;
	
	//Getting Elements
	public WebElement getMobileLink(){
		return MobileLink;
	}
	
	public WebElement getSortByDropdown(){
		return Dropdown_SortBy;
	}
	
	public void SortBy_DropDown(String data) {		
	      Select drop = new Select(Dropdown_SortBy);
	      drop.selectByVisibleText(data); 	      
	}
}
