package managers;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageObjectManager {

    WebDriver driver;
    DashboardPage dashboardPage;
    SignInPage signInPage;

    public PageObjectManager(WebDriver driver)  {

        this.driver=driver;
    }

     public DashboardPage getDashboardPage ()  {

        return ( dashboardPage == null) ? new DashboardPage(driver) : dashboardPage;
    }

    public SignInPage getSignInPage ()  {

        return ( signInPage == null) ? new SignInPage(driver) : signInPage;
    }

}
