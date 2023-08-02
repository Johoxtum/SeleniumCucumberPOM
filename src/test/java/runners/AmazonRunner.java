package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "json:target/cucumber-reports.json"},
        features = {"src/test/resources/features"},
        glue = {"stepdefinitions"},
        tags = "@Amazon",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class AmazonRunner {
    @AfterClass
    public static void cleanBrowser(){
        BasePage.closeBrowser();
    }
}
