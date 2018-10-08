package framework.base;

import net.lightbody.bmp.BrowserMobProxyServer;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.logging.Level;


public class BrowserType {

    public static BrowserMobProxyServer server;


    static WebDriver create(String browser) {
        try {

            server = new BrowserMobProxyServer();

            WebDriver driver;
            switch (browser) {
                case "Firefox":
                    FirefoxOptions options = new FirefoxOptions().setLogLevel(Level.OFF);
                    System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/resources/Drivers/geckodriver");
                    driver = new FirefoxDriver(options);
                    break;

                case "Chrome":

                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--kiosk");
                    System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "/resources/Drivers/chromedriver");

                    driver = new ChromeDriver(chromeOptions);


                    break;

                default:
                    throw new IllegalAccessException();

            }

            return driver;
        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;

    }
}
