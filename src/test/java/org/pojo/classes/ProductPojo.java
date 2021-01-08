package org.pojo.classes;

import org.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPojo extends Base {
	
	public ProductPojo() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Samsung Galaxy M51 (Electric Blue, 6GB RAM, 128GB Storage)']")
	private WebElement samsung;
	
	@FindBy(id="add-to-cart-button")
	private WebElement addToCart;
	
	@FindBy(xpath="(//input[@class='a-button-input'])[8]")
	private WebElement checkOut;

	@FindBy(xpath="//span[@id='attach-sidesheet-view-cart-button-announce']")
	private WebElement cart;

	public WebElement getCart() {
		return cart;
	}

	public WebElement getCheckOut() {
		return checkOut;
	}

	public WebElement getSamsung() {
		return samsung;
	}

	public WebElement getAddToCart() {
		return addToCart;
	}

}
