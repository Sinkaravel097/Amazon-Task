package org.pojo.classes;

import org.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePojo extends Base {
	
	public HomePojo() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement searchTxt;
	
	@FindBy(id="nav-search-submit-text")
	private WebElement searchBtn;

	public WebElement getSearchTxt() {
		return searchTxt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

}
