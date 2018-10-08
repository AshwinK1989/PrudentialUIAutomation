package steps;

import contexts.TestContext;
import framework.base.Browser;
import cucumber.api.java.en.*;
import framework.utilities.LogUtil;
import org.testng.Assert;
import pages.DashboardPage;

import java.util.List;

public class DashboardStepDefinition  extends Browser{


    DashboardPage dashboardPage;
    TestContext testContext;

    public DashboardStepDefinition(TestContext context) {
        testContext = context;
        dashboardPage = testContext.getPageObjectManager().getDashboardPage();
    }

    @Given("^You Navigate to Dashboard Page$")
    public void you_Navigate_to_Dashboard_Page()  {

        LogUtil.info("Navigating to Dashboard Page");
        dashboardPage.navigateToDashboardPage();
    }

    @And("^You enter the city \"([^\"]*)\"$")
    public void enter_invalid_city(String city)  {

        LogUtil.info("Enter Invalid City");
        dashboardPage.enterInvalidCity(city);
    }

    @And("^Click on Search Button$")
    public void clickOnSearchButton()  {

        LogUtil.info("Click on Search Button");
        dashboardPage.clickOnSearchButton();
    }

    @Then("^Check whether validation message \"([^\"]*)\" is displayed$")
    public void verifyValidationMessage(String msg)  {

        LogUtil.info("Verify Correct Validation message is displayed");
        Assert.assertEquals(msg, dashboardPage.getValidationMessage());
    }

    @Then("^Verify weather details are displayed$")
    public void verifyValidationMessage()  {

        LogUtil.info("Verify Weather details are displayed");
        Assert.assertEquals(dashboardPage.getCity(),"Mumbai, IN");
        Assert.assertNotNull(dashboardPage.getSkyStatus());
        Assert.assertNotNull(dashboardPage.getCityTemperature());
        Assert.assertNotNull(dashboardPage.getCityTemperatureDetails());
        Assert.assertNotNull(dashboardPage.getCityCoordinates());

    }

    @Then("^Verify whether all links are working$")
    public void verifyLinksAreWorking()  {

        LogUtil.info("Verify Weather all links are working");
        dashboardPage.checkAllLinksWorking();


    }

    @Then("^Verify whether following Options are displayed on Navigation Bar$")
    public void verifyOptionsNavigationBar(List<String> values)  {

        LogUtil.info("Verify Weather Options displayed on Navigation Bar");

        List<String> navValues = dashboardPage.returnNavElements();

        System.out.println("The values are "+values);
        System.out.println("The nav values are "+navValues);


        Assert.assertTrue(values.containsAll(navValues));


    }

    @Then("^Verify whether the chart is present$")
    public void verifyChartPresent()  {

        LogUtil.info("Verify Weather chart is present");

        Assert.assertTrue(dashboardPage.chartPresent(),"Chart is not present");

    }


    @Then("^Verify temperature is displayed in Faraheneit$")
    public void verifyTempDisplayedFaraheneit()  {

        LogUtil.info("Click on Faraheneit toggle button");
        dashboardPage.clickOnFarheneit();
        Assert.assertTrue(dashboardPage.returnTempInFaraheneit().contains("°F"),"Temp is not displayed in Faraheneit");

    }

    @Then("^Verify values in widget items are not null$")
    public void verifyValuesAreNotNull()  {

        LogUtil.info("Verify Widget Values are not null");

        for(String widgetValue:dashboardPage.getWidgetValues()) {

            Assert.assertNotNull(widgetValue,"The widget value is null");
        }


    }

    @And("^Click on Sign In button$")
    public void clickOnSignInButton()  {

        LogUtil.info("Click on SignIn Button");
        dashboardPage.clickOnSignIn();
    }

}
