package com.bigbasket.callmethods;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bigbasket.pomdetails.POMbigbasket;
import com.resuseMethods.UtilsResusable;

public class GetExcelData extends UtilsResusable {

	public static void getexcelDataMethod(XSSFWorkbook wBook) throws IOException, InterruptedException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		String sheetName = UtilsResusable.loadConfig("sheetName");

		XSSFSheet xSheet = wBook.getSheet(sheetName);

		int total_rows = xSheet.getLastRowNum();

		System.out.println("Total num rows: " + (total_rows + 1));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		for (int i = 1; i <= total_rows; i++) {

			XSSFRow currentRow = xSheet.getRow(i);

			boolean requiredVal = currentRow.getCell(0).getBooleanCellValue();

			String prod_name = "curd";

			int quantity = 1;

			if (requiredVal == true) {

				for (int j = 2; j == 2; j++) {

					prod_name = currentRow.getCell(j).getStringCellValue();

					System.out.println("Product Name: " + prod_name);

					quantity = (int) currentRow.getCell(j + 1).getNumericCellValue();

					System.out.println("Quantity: " + quantity);

					UtilsResusable.openPagePOM(); // opening the POM defined in UtilsResusable

					System.out.println(prod_name);

					POMbigbasket.search.sendKeys(prod_name);

					POMbigbasket.search.sendKeys(Keys.ENTER);

					String productString = currentRow.getCell(1).getStringCellValue();

					String productStringFinal = POMbigbasket.quantityElement(productString);

					WebElement numProd = driver.findElement(By.xpath(productStringFinal));

					wait.until(ExpectedConditions.elementToBeClickable(numProd));

					numProd.clear();

					numProd.sendKeys(String.valueOf(quantity));

					String addproductFinal = POMbigbasket.addElement(productString);

					WebElement addProd = driver.findElement(By.xpath(addproductFinal));

					System.out.println(addProd);

					wait.until(ExpectedConditions.elementToBeClickable(addProd));

					addProd.click();

				}

			}

		}

		wBook.close();

	}

}
