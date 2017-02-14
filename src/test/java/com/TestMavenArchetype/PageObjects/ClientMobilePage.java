package com.TestMavenArchetype.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClientMobilePage {
	@FindBy(xpath="//li[3]/div/div[3]/button")
	private WebElement Button_XperiaAddtoCart;
	
	@FindBy(xpath="//input[@title='Qty']")
	private WebElement quantityInputBox;
	
	@FindBy(xpath="//li[@class='error-msg']/ul/li/span")
	private WebElement shippingCartErrorMsg;
	
	@FindBy(xpath="//button[@title='Update']")
	private WebElement quantityUpdateButton;
	
	@FindBy(xpath="//button[@id='empty_cart_button']")
	private WebElement emptyCartButton;
	
	@FindBy(xpath="//div[@class='page-title']/h1")
	private WebElement shoppingCartEmptyMsg;
	
	@FindBy(xpath="//li[1]/div/div[3]/ul/li[2]/a")
	private WebElement Iphone_AddtoCompare_Link;
	
	@FindBy(xpath="//li[3]/div/div[3]/ul/li[2]/a")
	private WebElement SonyXperia_AddtoCompare_Link;
	
	@FindBy(xpath="//button[@title='Compare']")
	private WebElement Compare_Link;
	
	public WebElement getXperiaAddtoCartButton() {
		return Button_XperiaAddtoCart;
	}
	
	public WebElement getquantityInputBox() {
		return quantityInputBox;
	}
	
	public WebElement getshippingCartErrorMsg() {
		return shippingCartErrorMsg;
	}
	
	public WebElement getquantityUpdateButton() {
		return quantityUpdateButton;
	}
	
	public WebElement getemptyCartButton() {
		return emptyCartButton;
	}
	
	public WebElement getshoppingCartEmptyMsg() {
		return shoppingCartEmptyMsg;
	}
	
	public WebElement getIphone_AddtoCompare_Link() {
		return Iphone_AddtoCompare_Link;
	}
	
	public WebElement getSonyXperia_AddtoCompare_Link() {
		return SonyXperia_AddtoCompare_Link;
	}
	
	public WebElement getCompare_Link() {
		return Compare_Link;
	}
}
