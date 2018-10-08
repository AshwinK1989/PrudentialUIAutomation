package steps;

import contexts.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import framework.utilities.LogUtil;
import org.testng.Assert;
import pages.SignInPage;

public class SignPageStepDefinition {

    SignInPage signInPage;
    TestContext testContext;

    public SignPageStepDefinition(TestContext context) {
        testContext = context;
        signInPage = testContext.getPageObjectManager().getSignInPage();
    }

    @And("^Enter username and password$")
    public void enterCredentials()  {

        LogUtil.info("Enter the Credentials");
        signInPage.enterCredentials();
    }

    @And("^Click on Submit button$")
    public void clickOnSubmitButton()  {

        LogUtil.info("Click on Submit Button");
        signInPage.clickOnSubmitButton();
    }

    @Then("^Verify Login is Successful$")
    public void verifyLoginSuccessful()  {

        LogUtil.info("Verify Login is Successful");
        Assert.assertEquals(signInPage.getLoginMessage(),"Signed in successfully.");

    }
}
