package com.bigbasket.login.cucumberrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "Feature/com/bigbasket/login/cucumberfeature/bigbasket.feature", glue = "com.bigbasket.login.cucumberscript")
public class BigbasketAddProductCucumberRun extends AbstractTestNGCucumberTests {

}
