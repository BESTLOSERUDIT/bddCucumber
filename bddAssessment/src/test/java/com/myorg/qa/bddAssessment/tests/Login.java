package com.myorg.qa.bddAssessment.tests;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.myorg.qa.bddAssessment.pages.LoginPage;


import ContextSharing.ScenarioContext;
	
	public class Login {
		
		private final ScenarioContext scenarioContext;
		private WebDriver d;
		LoginPage loginPage;
		public Login(ScenarioContext context) {
		
		        scenarioContext = context;
		        loginPage=scenarioContext.getLoginPage();
		        d = context.getDriver();
		    }
		
	
		@Given("^I am on AttoroMutual Home Page$")
		public void i_am_on_AttoroMutual_Home_Page() {
		
			d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    d.get("http://demo.testfire.net/bank/login.aspx");
					   
		}
		
		@When("^I enter invalid \"([^\"]*)\" and \"([^\"]*)\"$")
		public void i_enter_invalid_and(String userName, String passWord) {
		 loginPage.invalidLogin(userName,passWord);
		    }
		
		@When("^I click on login$")
		public void i_click_on_login()  {
		    loginPage.clickOnLogin();    
		}

		@Then("^the error message is displayed$")
		public void the_error_message_is_displayed()  {
		 System.out.println(loginPage.getErrorMessage());
		}
				

		@When("^I enter valid \"([^\"]*)\" and \"([^\"]*)\"$")
		public void i_enter_valid_and(String userName, String passWord) {
			loginPage.validLogin(userName,passWord);
		}

		@Then("^Online Banking Home page is displayed$")
		public void online_Banking_Home_page_is_displayed()  {
			loginPage.loginSuccessful();			
		}

		@Given("^AtoroMutual Logo and Online Banking,Personal Banking,Small Business,INSIDE ALTORO MUTUAL link is displayed$")
		public void atoromutual_Logo_and_Online_Banking_Personal_Banking_Small_Business_INSIDE_ALTORO_MUTUAL_link_is_displayed() throws Throwable {
		         
			loginPage.validateHome_Login_Page();
		}
		  @After("@login")
		public void closeBrowser() {
			
			d.quit();
		}
		  	 
		  @When("^I click on Sign Off$")
		  public void i_click_on_Sign_Off() {
			  loginPage.clickonSignOff();
		  }

		  @Then("^User is logged out$")
		  public void user_is_logged_out() {
			  
		  }


	}
