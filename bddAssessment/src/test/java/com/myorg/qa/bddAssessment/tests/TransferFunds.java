package com.myorg.qa.bddAssessment.tests;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.myorg.qa.bddAssessment.pages.TransferFundsPage;
import ContextSharing.ScenarioContext;
		
public class TransferFunds {
			
			private final ScenarioContext scenarioContext;
			private WebDriver d;
			TransferFundsPage transferPage;
			public TransferFunds(ScenarioContext context) {
			
			        scenarioContext = context;
			        transferPage=scenarioContext.getTransferFundsPage();
			        d = context.getDriver();
			    }

	@Given("^I am on Transfer Funds Page$")
	public void i_am_on_Transfer_Funds_Page() {		
		transferPage.clickOnTransferFunds();
		transferPage.verifyTransferFundsPage();
		
	}

	@When("^I select from account \"([^\"]*)\"$")
	public void i_select_from_account(String fromAcc){
		transferPage.selectFromAccount(fromAcc);
	}

	@When("^I select to account \"([^\"]*)\"$")
	public void i_select_to_account(String toAcc) {
		transferPage.selectToAccount(toAcc);
	}

	@When("^I enter Amount to transfer \"([^\"]*)\"$")
	public void i_enter_Amount_to_transfer(String transferAmt) {
		transferPage.enterTranferAmount(transferAmt);
	}

	@When("^I click on Transfer Money$")
	public void i_click_on_Transfer_Money() {
		
		transferPage.clickTranfer();
	}

	@Then("^a message is displayed with correct amount and from/to account details$")
	public void a_message_is_displayed_with_correct_amount_and_from_to_account_details() {
		
		transferPage.verifyAmtTransferMessage();
	}

	 @After("@Transfer")
		public void closeBrowser() {
			
			d.quit();
		}
}
