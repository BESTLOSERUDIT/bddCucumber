package ContextSharing;
import com.myorg.qa.bddAssessment.pages.LoginPage;
import com.myorg.qa.bddAssessment.pages.OnlineBankingHomePage;
import com.myorg.qa.bddAssessment.pages.TransferFundsPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class ScenarioContext {	
	
	
	private final ChromeDriver d;
	public LoginPage loginPage;
	public OnlineBankingHomePage homePageOB;
	public TransferFundsPage transferPage;
    public ScenarioContext() {
    	System.setProperty("webdriver.chrome.driver","src/test/drivers/chromedriver.exe");
        d = new ChromeDriver();
    	loginPage = new LoginPage(d);
    	homePageOB=new OnlineBankingHomePage(d);
    	transferPage=new TransferFundsPage(d);
    }
    public LoginPage getLoginPage() {
		return loginPage;
	}
    public WebDriver getDriver() {
        return d;
    }
    
    public OnlineBankingHomePage getOnBankHomePage() {
    	return homePageOB;
    }
    public TransferFundsPage getTransferFundsPage() {
    	return transferPage;
    }
}
