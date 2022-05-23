package com.bigbasket.callmethods;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.bigbasket.pomdetails.POMbigbasket;
import com.resuseMethods.UtilsResusable;

public class ViewBasket {

	public static void viewAndEmptyBasket() throws InterruptedException, AWTException, IOException {

		WebDriver driver = UtilsResusable.driver;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		Actions action = new Actions(driver);

		wait.until(ExpectedConditions.elementToBeClickable(POMbigbasket.mybasket));

		action.moveToElement(POMbigbasket.mybasket).click().build().perform();

		POMbigbasket.mybasket.click();

		wait.until(ExpectedConditions.elementToBeClickable(POMbigbasket.viewBasket));

		POMbigbasket.viewBasket.click();

		String totalAmountVal = POMbigbasket.totalAmount.getText();

		System.out.println("Total Price for the order: " + totalAmountVal);

		UtilsResusable.takeScreenshot();

		POMbigbasket.emptyBasket.click();

		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@id='alert_ok']"))));

		WebElement emptyOK = driver.findElement(By.xpath("//a[@id='alert_ok']"));

		action.moveToElement(emptyOK).click().build().perform();

		wait.until(ExpectedConditions.textToBePresentInElement(POMbigbasket.emptyTextMessage,

				"There are no items in your basket."));

		UtilsResusable.takeScreenshot();

		String emptyStringVal = POMbigbasket.emptyTextMessage.getText();

		Assert.assertEquals("There are no items in your basket.", emptyStringVal);

		System.out.println("Empty String message: " + emptyStringVal);

	}

}