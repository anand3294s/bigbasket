package com.resuseMethods;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.bigbasket.pomdetails.POMbigbasket;

public class UtilsResusable {

	public static WebDriver driver;

	public static String loadConfig(String findProperty) throws IOException {

		FileInputStream configFile = new FileInputStream("bigbasket.properties");

		Properties pFile = new Properties();

		pFile.load(configFile);

		String foundDetail = pFile.getProperty(findProperty);

		System.out.println("from loadConfig: " + foundDetail);

		return foundDetail;

	}

	public static WebDriver launchBrowser(String browserOption) throws IOException {

		if (browserOption.equalsIgnoreCase("Chrome")) {

			ChromeOptions Chrome_Profile = OpenExistingProfileChrome();

			System.out.println("Opening Chrome");

			driver = new ChromeDriver(Chrome_Profile);

		} else if (browserOption.equalsIgnoreCase("Firefox")) {

			System.out.println("Opening Firefox");

			driver = new FirefoxDriver();

		} else if (browserOption.equalsIgnoreCase("edge")) {

			EdgeOptions Edge_Profile = OpenExistingProfileEdge();

			driver = new EdgeDriver(Edge_Profile);

			// driver = new EdgeDriver();

		}

		return driver;

	}

	public static ChromeOptions OpenExistingProfileChrome() throws IOException {

		String Chrome_Profile_Path = loadConfig("chromeProfile");

		ChromeOptions Chrome_Profile = new ChromeOptions();

		Chrome_Profile.addArguments("user-data-dir=" + Chrome_Profile_Path);

		return Chrome_Profile;

	}

	public static EdgeOptions OpenExistingProfileEdge() throws IOException {

		String Edge_Profile_Path = loadConfig("edgeProfile");

		EdgeOptions Edge_Profile = new EdgeOptions();

		Edge_Profile.addArguments("user-data-dir=" + Edge_Profile_Path);

		return Edge_Profile;

	}

	public void launchURL() throws IOException {

		String broswerOption = loadConfig("browser");

		System.out.println(broswerOption);

		launchBrowser(broswerOption);

		driver.manage().window().maximize();

		String url = loadConfig("URL");

		driver.get(url);

	}

	public static XSSFWorkbook readExcel(WebDriver driver) throws IOException {

		String excelFilePath = loadConfig("excelFile");

		FileInputStream refFile = new FileInputStream(excelFilePath);

		XSSFWorkbook wBook = new XSSFWorkbook(refFile);

		return wBook;

	}

	public static void openPagePOM() {

		PageFactory.initElements(driver, POMbigbasket.class);

	}

	public static void takeScreenshot() throws AWTException, IOException {

		DateFormat dateFormatFolder = new SimpleDateFormat("dd-MMM-YYYY");

		DateFormat dateFormatFile = new SimpleDateFormat("dd-MM-YYYY hh-mm-ss");

		Date date = new Date();

		Robot robot = new Robot();

		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();

		Rectangle rectangle = new Rectangle(screenDimension);

		BufferedImage sourceImage = robot.createScreenCapture(rectangle);

		File dest = new File("C:\\Users\\Surendra Anand R\\eclipse-workspace\\CaseStudy\\Output\\" + "Screesnhot-"
				+ dateFormatFile.format(date) + ".jpeg");

		ImageIO.write(sourceImage, "jpeg", dest);

	}

}
