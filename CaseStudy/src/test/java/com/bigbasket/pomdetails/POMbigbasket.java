package com.bigbasket.pomdetails;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class POMbigbasket {

	@FindBy(xpath = "//input[@qa='searchBar']")

	public static WebElement search;

	@FindBy(xpath = "//span[@title='Your Basket']/following-sibling::span")

	public static WebElement mybasket;

	@FindBy(xpath = "//button[@qa='viewBasketMB']")

	public static WebElement viewBasket;

	@FindBy(xpath = "//span[@id='finalTotal']")

	public static WebElement totalAmount;

	@FindBy(xpath = "//a[@onclick='empty_cart()']/p")

	public static WebElement emptyBasket;

	@FindBy(xpath = "//div[@id='empty_message']//h4")

	public static WebElement emptyTextMessage;

	public static String quantityElement(String productString) {

		String prodQuantityFirst = "//div[@qa='product_name']//a[text()='";

		String prodQuantityLast = "']/ancestor::div[1]/following-sibling::div[2]//div[contains(@class,'bskt-opt')]//input[@ng-model='vm.startQuantity']";

		String quantityxPath = prodQuantityFirst + productString + prodQuantityLast;

		return quantityxPath;

	}

	public static String addElement(String addProduct) {

		String prodQuantityFirst = "//div[@qa='product_name']//a[text()='";

		String prodQuantityLast = "']/ancestor::div[1]/following-sibling::div[2]//div[contains(@class,'bskt-opt')]//button[@qa='add']";

		String addxPath = prodQuantityFirst + addProduct + prodQuantityLast;

		return addxPath;

	}
}
