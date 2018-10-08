package framework.controls;

import framework.helper.Helper;
import framework.utilities.LogUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.ArrayList;

public class GenericBrowserActionMethods {


    public static void click(WebDriver driver, String sLocator) {

        try {

            LogUtil.info("Waiting for an element to be clickable");
            GenericWaitMethods.waitToClickMethod(driver, sLocator);

            LogUtil.info("Clicking on an element");
            Helper.getElement(driver,sLocator).click();

        }

        catch (Exception e) {

            LogUtil.error("Failed to Click | Class: GenericMethods | method: click "+e.getMessage());
            Assert.assertFalse(true,"e.getMessage()");


        }

    }

    public static void submit(WebDriver driver, String sLocator) {

        try {

            LogUtil.info("Waiting for an element to be present");
            //GenericWaitMethods.waitMethod(driver, sLocator);

            LogUtil.info("Clicking on button of type Submit");
            Helper.getElement(driver,sLocator).submit();

        }

        catch (Exception e) {

            LogUtil.error("Failed to Submit | Class: GenericMethods | method: submit "+e.getMessage());
            Assert.assertFalse(true,"e.getMessage()");


        }

    }

    public static void input(WebDriver driver, String sLocator, String inputValue) {

        try {

            LogUtil.info("Waiting for an element to be clickable");
            GenericWaitMethods.waitMethod(driver,sLocator);

            LogUtil.info("Entering value in an input field");
            Helper.getElement(driver,sLocator).sendKeys(inputValue);

        }
        catch (Exception e)  {

            LogUtil.error("Failed to input | Class: GenericMethods | method: input "+e.getMessage());
            Assert.assertFalse(true,"e.getMessage()");


        }
    }





    public static String getElementText(WebDriver driver, String sLocator) {

        try {

            LogUtil.info("Waiting for an element to be visible");
            GenericWaitMethods.waitMethod(driver, sLocator);

            LogUtil.info("Reading the text of an element");
            return Helper.getElement(driver,sLocator).getText();

        }
        catch (Exception e)  {

            LogUtil.error("Failed to get Element Text | Class: GenericMethods | method: getElementText "+e.getMessage());
            Assert.assertFalse(true,"e.getMessage()");


        }

        return null;
    }


    public static boolean isElementPresent(WebDriver driver, String sLocator) {

        try {

            LogUtil.info("Waiting for an element to be visible");
            GenericWaitMethods.waitMethod(driver, sLocator);

            LogUtil.info("Checking whether an element is present");
            return Helper.getElements(driver,sLocator).size()>0;

        }

        catch (Exception e)  {

            LogUtil.error("Failed to check whether element is present" +
                    " | Class: GenericMethods | method: isElementPresent "+e.getMessage());
            Assert.assertFalse(true,"e.getMessage()");


        }

        return false;
    }



    public static boolean checkElementIsDisplayed(WebDriver driver, String sLocator)  {

        try {

            LogUtil.info("Check whether element is displayed");
            GenericWaitMethods.waitMethod(driver,sLocator);
            return Helper.getElement(driver, sLocator).isDisplayed();

        }
        catch (Exception e)  {

            LogUtil.info("Failed to check whether element is displayed | Class: GenericMethods" +
                    " | method: checkElementIsDisplayed "+e.getMessage());
            Assert.assertFalse(true,"e.getMessage()");

        }

        return false;

    }

}
