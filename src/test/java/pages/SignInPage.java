package pages;


import framework.controls.GenericBrowserActionMethods;
import framework.utilities.LogUtil;
import org.openqa.selenium.WebDriver;

public class SignInPage {

    WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }


    public void enterCredentials()  {

        LogUtil.info("Enter the Credentials");
        GenericBrowserActionMethods.input(driver,txtEmail,"ashu271989@gmail.com");
        GenericBrowserActionMethods.input(driver,txtPassword,"test@123");

    }

    public void clickOnSubmitButton()  {

        LogUtil.info("Click on Submit Button");
        GenericBrowserActionMethods.submit(driver,btnSubmit);
    }

    public String getLoginMessage()  {

        LogUtil.info("Return Login Successful message");
        return GenericBrowserActionMethods.getElementText(driver,msgSignIn);

    }

    public String txtEmail = "(//input[@placeholder='Enter email'])[1]";
    public String txtPassword = "(//input[@placeholder='Password'])[1]";
    public String btnSubmit = "//input[@value='Submit']";
    public String msgSignIn = "//div[@class='panel-body']";
}
