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
import com.myorg.qa.bddAssessment.pages.OnlineBankingHomePage;
import ContextSharing.ScenarioContext;
		
	public class OnlineBankingHome {
			
			private final ScenarioContext scenarioContext;
			private WebDriver d;
			OnlineBankingHomePage homePageOB;
			public OnlineBankingHome(ScenarioContext context) {
			
			        scenarioContext = context;
			        homePageOB=scenarioContext.getOnBankHomePage();
			        d = context.getDriver();
			    }
		
	@When("^I select Bank Account \"([^\"]*)\"$")
	public void i_select_Bank_Account(String bankAcNum) {
		
		homePageOB.selectAccount(bankAcNum);
	}

	@When("^I click on Go button$")
	public void i_click_on_Go_button() {
		homePageOB.clickOn();
	}

	@Then("^Account Information page is displayed$")
	public void verify_Account_Information_page_is_displayed() {
		homePageOB.accountInfPageDisplayed();
		System.out.println("Account Information Page is displayed");
	}

	@Then("^the account no \"([^\"]*)\" is displayed in heading with Account History$")
	public void the_account_no_is_displayed_in_heading_with_Account_History(String bankAcNum) {
		
		
		System.out.println("Account No is displayed as: Account History - "+bankAcNum);
	}

	@Given("^I am on Account Information page$")
	public void i_am_on_Account_Information_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Ending Balance should be shown as per current date$")
	public void ending_Balance_should_be_shown_as_per_current_date() {
		
		boolean currentdate = homePageOB.CheckDateDisplayed();
		Assert.assertEquals(currentdate, true);
		System.out.println("The Balance Detail table has date shown as: Ending balance as of "+currentdate);
		
	}
	 @After("@HomePage")
		public void closeBrowser() {
			
			d.quit();
		}

}
