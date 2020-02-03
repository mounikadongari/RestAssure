package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver ldriver;
	// class construtor which will intiate the browser
	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
		
	}
		@FindBy(id="Email")
		@CacheLookup
		WebElement txtEmail;
		
		@FindBy(xpath="//input[@id='Password']")
		@CacheLookup
		WebElement txtPassword;
		
		@FindBy(xpath="//input[@class='button-1 login-button']")////input[@value='Log in']
		@CacheLookup
		WebElement btnLogin;
		
		@FindBy(xpath="//a[contains(text(),'Logout')]")
		@CacheLookup
		WebElement lnkLogout;
		
		public void setUserName(String uname) {
			
		txtEmail.clear();
		txtEmail.sendKeys(uname);
		}
		
		public void setPassword(String pwd)
		{ txtPassword.clear();
		txtPassword.sendKeys(pwd);
		}
		
		public void clickLogin() {
			btnLogin.click();
		}
		
		public void clickLogout() {
			lnkLogout.click();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
}
