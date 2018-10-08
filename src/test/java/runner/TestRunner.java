package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import framework.base.Browser;
import framework.base.BrowserType;
import framework.config.ConfigReader;
import framework.utilities.LogUtil;
import net.lightbody.bmp.core.har.Har;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;


@CucumberOptions(features = "Features", glue = {"steps"}, format = {"json:target/cucumber.json", "html:target/site/cucumber-pretty", "rerun:target/rerun.txt"}
        , tags = {"~@ignore"})
public class TestRunner extends AbstractTestNGCucumberTests {


    @Parameters({"browser"})
    @BeforeClass
    public void beforeSetup(String browser) throws Exception {

        ConfigReader.populateProperties();
        LogUtil.setLogger();
        LogUtil.info("Setting the properties");

        LogUtil.info("Set the browser");
        Browser.setBrowser(browser);

    }


    @AfterClass
    public void shutDown()  {

     LogUtil.info("Shut the browser");
        Browser.shutBrowser();

    }

}
