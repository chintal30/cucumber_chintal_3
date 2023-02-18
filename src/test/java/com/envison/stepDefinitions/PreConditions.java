package com.envison.stepDefinitions;

import com.envison.utility.BrowserFactory;
import io.cucumber.java.en.Given;

public class PreConditions {
    @Given("user launches the url {string}")
    public void user_launches_the_url(String string) {
        BrowserFactory.LaunchWebsitewithURLinput(string);
    }
}
