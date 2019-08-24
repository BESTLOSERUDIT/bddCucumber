package com.myorq.qa.bddAssessment.runners;
import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
 features = "src/test/resources",
// tags= "@Signout"
 glue={"com.myorg.qa.bddAssessment.tests"}
 ,//plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
 plugin = {"pretty", "junit:target/cucumber/junit.xml"
	        , "json:target/cucumber/result.json", "html:target/cucumber"}
 )
 
public class TestRunner {
 
}
