package com.myorg.qa.bddAssessment.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {	
	
	 WebDriver driver;
		 
	 public LoginPage(WebDriver driver) {
	 this.driver = driver;
	 PageFactory.initElements(driver, this);
		 }
	
	 @FindBy(xpath="//*[@id='HyperLink1']/img")
	 WebElement altoroLogo;
	 @FindBy(xpath="//*[@id='AccountLink']")
	 WebElement onlBankLink;
	 @FindBy(xpath="//*[@id='LinkHeader2']")
	 WebElement personalLink;
	 @FindBy(xpath="//*[@id='LinkHeader3']")
	 WebElement smlBussLink;
	 @FindBy(xpath="//*[@id='LinkHeader4']")
	 WebElement inAltoroMutual;
	 @FindBy(xpath="//input[@id='uid']")
	 WebElement username;
	 @FindBy(xpath="//input[@id='passw']")
	 WebElement password;
	 @FindBy(xpath="//input[@name='btnSubmit']")
	 WebElement lgnBtn;
	 @FindBy(xpath="//span[contains(text(),'but this username or password was not found in our system. Please try again.')]")
	 WebElement lgnFailureMsg;
	 @FindBy(xpath="//*[@id='AccountLink'][contains(text(),'MY ACCOUNT')]")
	 WebElement myAccountLink;
	 @FindBy(xpath="//a[@id='LoginLink']")
	 WebElement logoutLink;
	
public void validateHome_Login_Page()
{	
	try{
		Assert.assertTrue("Not on Online Banking Page", altoroLogo.isDisplayed());
	    Assert.assertTrue("Logo is Not Displayed", altoroLogo.isDisplayed());
	    Assert.assertTrue("Online Banking Header tab is not displayed", onlBankLink.isDisplayed());
	    Assert.assertTrue("Personal Banking Header tab is not displayed", personalLink.isDisplayed());
	    Assert.assertTrue("Small Business Header tab is not displayed", smlBussLink.isDisplayed());
	    Assert.assertTrue("INSIDE ALTORO MUTUAL Header tab is not displayed", inAltoroMutual.isDisplayed());}
	catch (Exception e) {
       
        System.out.println("***Exception occurred..!!!.Please Investigate**");
     }
}

public void invalidLogin(String userid,String pwd) {
	username.sendKeys(userid);
	password.sendKeys(pwd);		
}

public void validLogin(String userid,String pwd) {
	username.sendKeys(userid);
	password.sendKeys(pwd);
}
public void clickOnLogin() {
	lgnBtn.click();		
}

public String getErrorMessage() {
	Assert.assertTrue("Login Failed as UserName and Password do not match.", lgnFailureMsg.isDisplayed());
	return lgnFailureMsg.getText();
	
}
public String loginSuccessful() {
	
	Assert.assertTrue("Login Failed.", myAccountLink.isDisplayed());
	return "Login Successful";
}

public void clickonSignOff() {
	
	logoutLink.click();
}

public void verifySignedOff() {
	
	Assert.assertTrue(logoutLink.getText().contains("Sign Off"));
}
}