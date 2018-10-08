package steps;

import framework.base.Browser;
import framework.utilities.CaptureScreenShotUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;

public class Hooks extends Browser {


    @After
    public void shutDown(Scenario scenario) {

        if(scenario.isFailed()) {

            CaptureScreenShotUtil.captureScreen(scenario.getName());

        }

    }
}
