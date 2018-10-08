package framework.helper;

import framework.utilities.LogUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import static io.restassured.RestAssured.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Helper {

    //A helper method to return the status code of the link
    public static int returnStatusCode(URL url) {

        try {
            return given().when().get(url).getStatusCode();
        } catch (Exception e) {

            LogUtil.info("Failed to return the status code | Class: Helper | Method:returnStatusCode " + e.getMessage());
        }

        return 0;
    }

    public static WebElement getElement(WebDriver driver, String sLocator) {

        try {

            if(sLocator.contains("//")) {

                return driver.findElement(By.xpath(sLocator));
            }
            else  {

                return driver.findElement(By.cssSelector(sLocator));

            }
        } catch (Exception e) {

            LogUtil.error("Failed to return the WebElement | Class: GenericMethods | method: getElement " + e.getMessage());

        }

        return null;
    }

    public static String getData(String fileName) {

        try {

            LogUtil.info("Returning the data from " + fileName );

            return Files.readAllLines(Paths.get(fileName)).get(0);

        } catch (Exception e) {

            LogUtil.error("Failed to return the data | Class:Helper | method:getData " + e.getMessage());

        }
        return null;

    }

    public static List<WebElement> getElements(WebDriver driver, String sLocator) {

        try {

            if(sLocator.contains("//")) {
                return driver.findElements(By.xpath(sLocator));
            }
            else {

                return driver.findElements(By.cssSelector(sLocator));
            }

        } catch (Exception e) {

            LogUtil.error("Failed to return the list of WebElements | Class: Helper | method: getElement " + e.getMessage());

        }

        return null;
    }



      public static boolean checkBrokenLinks(WebDriver driver, String sLocator)  {

        try {
            List<String> hrefs = new ArrayList<String>();
            List<WebElement> anchors = Helper.getElements(driver, sLocator);
            int brokenLinkFlag = 0;

            for (WebElement anchor : anchors) {

                if (anchor.getAttribute("href") != null && anchor.getAttribute("href").contains("http"))
                    hrefs.add(anchor.getAttribute("href"));

            }

            for (String href : hrefs) {

                try {

                    int responseCode = Helper.returnStatusCode(new URL(href));
                    if (responseCode != 200 && responseCode!= 999) {

                        LogUtil.info("The broken Link is " + href + " and the response code is " + responseCode);
                        Assert.assertTrue(false,"The broken link is "+href);
                        brokenLinkFlag = 1;

                    }

                } catch (Exception e) {
                    LogUtil.info("URL: " + href + " returned " + e.getMessage());

                }

            }

            if(brokenLinkFlag==1)  {

                return false;
            }
            else {
                return true;
            }
        }
        catch (Exception e)  {

            LogUtil.info("Failed to check Broken Links | Class: GenericMethods | method:checkBrokenLinks "+e.getMessage() );
            Assert.assertFalse(true,"e.getMessage()");

        }


        return false;

    }

}