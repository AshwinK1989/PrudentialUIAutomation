package pages;

import framework.config.Settings;
import framework.controls.GenericBrowserActionMethods;
import framework.controls.GenericNavigationMethods;
import framework.helper.Helper;
import framework.utilities.LogUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DashboardPage {

    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }


    public void navigateToDashboardPage ()  {

        LogUtil.info("Navigating to page "+ Settings.openWeatherMapUrl);
        GenericNavigationMethods.navigateToUrl(driver, Settings.openWeatherMapUrl);
    }

    public void enterInvalidCity (String city) {

        LogUtil.info("Enter Invalid City");
        GenericBrowserActionMethods.input(driver, txtCity, city);
    }

    public void clickOnSearchButton ()  {

        LogUtil.info("Click on Search Button");
        GenericBrowserActionMethods.click(driver,btnSubmit);
    }

    public String getValidationMessage ()  {

        LogUtil.info("Return the validation message for invalid city");
        return GenericBrowserActionMethods.getElementText(driver,msgInvalidCity).substring(1).trim();
    }

    public String getCity () {

        LogUtil.info("Return the City and Country Name");

        return GenericBrowserActionMethods.getElementText(driver,strCityCountry);
    }

    public String getSkyStatus () {

        LogUtil.info("Return the Sky Status");

        return GenericBrowserActionMethods.getElementText(driver,strSkyStatus);
    }

    public String getCityTemperature() {

        LogUtil.info("Return the City Temperature");
        return GenericBrowserActionMethods.getElementText(driver,strCityTemp);
    }

    public String getCityTemperatureDetails() {

        LogUtil.info("Return the City Temperature");
        return GenericBrowserActionMethods.getElementText(driver,strCityTempDetails);
    }

    public String getCityCoordinates() {

        LogUtil.info("Return the City Coordinates");
        return GenericBrowserActionMethods.getElementText(driver,strCityCoordinates);
    }

    public void checkAllLinksWorking ()  {

        LogUtil.info("Verify all links are working");
        Helper.checkBrokenLinks(driver,lnkAll);

    }

    public List<String> returnNavElements () {

        List<String> navElementsText = new ArrayList<>();

        for(WebElement navElement:Helper.getElements(driver,lnkNav))  {

            navElementsText.add(navElement.getText());
        }

        return navElementsText;


    }

    public boolean chartPresent () {

      LogUtil.info("Return whether chart is present");
      return GenericBrowserActionMethods
              .checkElementIsDisplayed(driver,divChart);

    }

    public void clickOnFarheneit () {

        LogUtil.info("Clicking on Farheneit");
        GenericBrowserActionMethods.click(driver,toggleFarheneit);
    }

    public String returnTempInFaraheneit () {

        return GenericBrowserActionMethods.getElementText(driver,strWeatherTemp);
    }

    public List<String> getWidgetValues () {

        List <String> widgetValues = new ArrayList<>();


        for(WebElement widgetText : Helper.getElements(driver,widValues))  {

            widgetValues.add(widgetText.getText());

        }

        return  widgetValues;

    }

    public void clickOnSignIn () {

        LogUtil.info("Click on Sign in");
        GenericBrowserActionMethods.click(driver,btnSignIn);

    }


    public String txtCity = "//input[@placeholder='Your city name']";
    public String btnSubmit = "//button[@type='submit' and @class='btn btn-orange']";
    public String msgInvalidCity = "//div[@class='alert alert-warning']";
    public String strCityCountry ="//a[@href='/city/1275339']";
    public String strSkyStatus = "//div[@id='forecast_list_ul']//b/i";
    public String strCityTemp = "//div[@id='forecast_list_ul']//p/span";
    public String strCityTempDetails = "//div[@id='forecast_list_ul']//p[1]";
    public String strCityCoordinates = "//div[@id='forecast_list_ul']//p[2]/a";
    public String lnkAll = "//a";
    public String lnkNav = "//li[contains(@class,'nav__item')]";
    public String divChart = "//div[contains(@id,'highcharts-')]";
    public String toggleFarheneit = "//span[@id='imperial']";
    public String strWeatherTemp = "//h3[@class='weather-widget__temperature']";
    public String widValues = "//tr[@class='weather-widget__item']/td";
    public String btnSignIn = "(//a[contains(@href,'sign_in')])[1]";


}