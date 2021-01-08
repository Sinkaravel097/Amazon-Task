package org.pojo.classes;

import org.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPojo extends Base{
	
	public LoginPojo() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="ap_email")
	private WebElement email;
	
	@FindBy(id="continue")
	private WebElement conti;
	
	@FindBy(id="ap_password")
	private WebElement password;
	
	@FindBy(id="signInSubmit")
	private WebElement login;

	public WebElement getLogin() {
		return login;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getConti() {
		return conti;
	}
	

}
