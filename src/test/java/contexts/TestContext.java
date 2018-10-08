package contexts;

import framework.base.Browser;
import managers.*;

public class TestContext extends Browser  {

    private PageObjectManager pageObjectManager;

    public TestContext()  {

        pageObjectManager = new PageObjectManager(getDriver());
         }

    public PageObjectManager getPageObjectManager() {

        return pageObjectManager;
    }

}