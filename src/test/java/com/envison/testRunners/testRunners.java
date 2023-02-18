package com.envison.testRunners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/com/envison/features"},
        glue = {"com.envison.stepDefinitions"},
        tags = "@medium",
        plugin = {"html:actitime_reports/cucumber_reports/actitime_html_report.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class testRunners extends AbstractTestNGCucumberTests {

}
