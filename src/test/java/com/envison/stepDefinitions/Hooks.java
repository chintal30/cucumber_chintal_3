package com.envison.stepDefinitions;

import com.envison.utility.BrowserFactory;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    @Before
    public static void openBrowserAsPerPropertyFile(){
        BrowserFactory.openBrowserAsPerPropertiesFileBrowser();
    }
    @AfterAll
    public static void closeAllWindows(){
        BrowserFactory.closeAllWindows();
    }
}
