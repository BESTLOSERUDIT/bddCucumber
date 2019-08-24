package com.myorg.qa.bddAssessment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
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

public class TransferFundsPage {	
		
		 WebDriver driver;			 
		 public TransferFundsPage(WebDriver driver) {
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
			 }

	@FindBy(xpath="//a[contains(text(),'Transfer Funds')]")
	WebElement transferFundLink;
	@FindBy(xpath="//h1[contains(text(), 'Transfer Funds')]")
	WebElement transferFundHeader;
	@FindBy(xpath="//strong[contains(text(), 'From Account')]")
	WebElement frmAccText;
	@FindBy(xpath="//strong[contains(text(), 'To Account')]")
	WebElement toAccText;
	@FindBy(xpath="//*[@id='fromAccount']")
	WebElement frmAccDd;
	@FindBy(xpath="//*[@id='toAccount']")
	WebElement toAccDd;
	@FindBy(xpath="//*[@id='transferAmount']")
	WebElement amountToTransfer;
	@FindBy(xpath="//*[@id='transfer']")
	WebElement transferBtn;
	@FindBy(xpath="//span[contains(text(),'was successfully transferred from Account')]")
	WebElement succTrnMsg;
	 
	 
    public void clickOnTransferFunds() {
    	
    transferFundLink.click();
    }
    
    public void verifyTransferFundsPage() {
    	
    	Assert.assertTrue("Transfer Page Not displayed", transferFundHeader.isDisplayed());
    }
	 
    public void selectFromAccount(String fromAcc)
    {	
    	try{
    		 Select selectfromAccount= new Select (frmAccDd);
    	     selectfromAccount.selectByVisibleText(fromAcc);;
    	}
    		
    	catch (Exception e) {
           
            System.out.println("***Exception Occured.!!.Account NOT Selected***");
         }
    }
    
    public void selectToAccount(String toAcc)
    {	
    	try{
    		 Select selecttoAccount= new Select (toAccDd);
    	     selecttoAccount.selectByVisibleText(toAcc);;
    	}
    		
    	catch (Exception e) {
           
            System.out.println("***Exception Occured.!!.Account NOT Selected***");
         }
    }
	 
    public void enterTranferAmount(String transferAmt)
    {	
    	amountToTransfer.sendKeys(transferAmt);   
    	
    }
    
    public void clickTranfer()
    {	    	
    	transferBtn.click();    	
    }
	 
    public void verifyAmtTransferMessage()
    {	
    	System.out.println(succTrnMsg.getText());
    	
    }
	 
	 
	 
	
	
	 
}