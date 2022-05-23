package com.bigbasket.login.cucumberscript;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bigbasket.callmethods.GetExcelData;
import com.bigbasket.callmethods.ViewBasket;
import com.resuseMethods.UtilsResusable;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BigbasketAddProductCucumberScript extends UtilsResusable {

	@BeforeClass

	@Given("I have opened a browser")

	public void i_have_opened_a_browser() throws IOException {

		// Write code here that turns the phrase above into concrete actions

		launchURL();

	}

	@Test(priority = 1, groups = "bbasket")

	@When("I add the product")

	public void i_add_the_product() throws IOException, InterruptedException {

		// Write code here that turns the phrase above into concrete actions

		XSSFWorkbook wBook = readExcel(driver);

		GetExcelData.getexcelDataMethod(wBook);

	}

	@Test(priority = 2, groups = "bbasket", dependsOnMethods = "i_add_the_product")

	@Then("navigate to the basket")

	public void navigate_to_the_basket() throws InterruptedException, AWTException, IOException {

		// Write code here that turns the phrase above into concrete actions

		ViewBasket.viewAndEmptyBasket();

	}

	@AfterClass

	@Then("close the browser")

	public void close_the_browser() {

		// Write code here that turns the phrase above into concrete actions

		driver.quit();

	}

}
