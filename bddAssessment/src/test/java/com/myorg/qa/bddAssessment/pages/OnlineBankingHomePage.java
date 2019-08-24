package com.myorg.qa.bddAssessment.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OnlineBankingHomePage {	
		
		 WebDriver driver;			 
		 public OnlineBankingHomePage(WebDriver driver) {
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
			 }

@FindBy(xpath="//*[@id='listAccounts']")
WebElement accountList;
@FindBy(xpath="//*[@id='btnGetAccount']")
WebElement getAccountBtn;
@FindBy(xpath="//h1[contains(text(),'Account History')]")
WebElement accNoHistory;
@FindBy(xpath="//td[contains(text(),'Ending balance as of')]")
WebElement dateEndingBal;

public void selectAccount(String bankAcNum)
{	
	try{
		 Select selectfromAccount= new Select (accountList);
	     selectfromAccount.selectByVisibleText(bankAcNum);;
	}
		
	catch (Exception e) {
       
        System.out.println("***Exception Occured.!!.Account NOT Selected***");
     }
}

public void clickOn()
{	
	getAccountBtn.click();	
	
}

public void accountInfPageDisplayed()
{	
	Assert.assertTrue("Account Information Page is NOT displayed", accNoHistory.isDisplayed());

}

public void verifyAccountNoDisplayed(String bankAcNo)
{	
    Assert.assertTrue(accNoHistory.getText().contains(bankAcNo));	
	
}
public boolean CheckDateDisplayed()
{
	DateFormat dateFormat = new SimpleDateFormat("M/dd/yy");
	Date date = new Date();
	String currentDate= dateFormat.format(date);
	return dateEndingBal.getText().contains(currentDate); 
	
} 
}
