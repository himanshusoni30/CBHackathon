package com.applitools.hackathon.ufg.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.visualgrid.model.DeviceName;
import com.applitools.eyes.visualgrid.model.ScreenOrientation;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTests {
	protected static WebDriver driver;
	public static Eyes eyes;
	protected static SoftAssert asrt;
	protected static Configuration suiteConfig;
	protected static BatchInfo batch;
	protected static Properties props;
	public static VisualGridRunner runner;

	@BeforeSuite
	public static void intiate() throws IOException {
		props = System.getProperties();
		try {
			props.load(new FileInputStream(new File("src/test/resources/test.properties")));
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	@Parameters({ "browser", "width" })
	@BeforeMethod
	public void openBrowser(String browser, String width) {
		int w = Integer.parseInt(width);
		try {
			if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				setWindowSize(w);
			} else if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				if(w==0) {
					runner = new VisualGridRunner(1);
					eyes = new Eyes(runner);
					eyeSetUp();
				}else {
					setWindowSize(w);
				}
				
			} else if (browser.equalsIgnoreCase("edge")) {
//				WebDriverManager.edgedriver().setup();
//				System.out.println(WebDriverManager.edgedriver().getDownloadedVersion());
//				System.out.println(WebDriverManager.edgedriver().getDriverVersions());
//				System.out.println(WebDriverManager.edgedriver().getBinaryPath());
//				ChromeOptions chromeOptions = new ChromeOptions();
//				chromeOptions.setBinary("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
//				EdgeOptions edgeOptions = new EdgeOptions().merge(chromeOptions);
//				driver = new EdgeDriver(edgeOptions);
//				setWindowSize(w);
//				System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
				System.getProperty("webdriver.edge.driver");
				driver = new EdgeDriver();
				setWindowSize(w);
			}
			driver.get(System.getProperty("site.url"));
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}
	}

	@AfterMethod
	public static void tearDown() {
		Reporter.log("********** Test Execution End ************", true);
		driver.close();
	}

	@AfterSuite()
	public static void afterSuite() {
		driver.quit();		
		eyes.abortIfNotClosed();
		
		TestResultsSummary allTestResults = runner.getAllTestResults(false);
		System.out.println(allTestResults);
	}

	private static void eyeSetUp() {
		Configuration config = new Configuration();

		config.setApiKey(System.getProperty("applitools.api.key"));

		config.setBatch(new BatchInfo("Ultrafast Batch"));

		config.addBrowser(1200, 700, BrowserType.CHROME);
		config.addBrowser(1200, 700, BrowserType.FIREFOX);
		config.addBrowser(1200, 700, BrowserType.EDGE_CHROMIUM);
		config.addBrowser(768, 700, BrowserType.CHROME);
		config.addBrowser(768, 700, BrowserType.FIREFOX);
		config.addBrowser(768, 700, BrowserType.EDGE_CHROMIUM);
		config.addDeviceEmulation(DeviceName.iPhone_X, ScreenOrientation.PORTRAIT);

		eyes.setConfiguration(config);
	}

	protected static void setTheBatch(String batchName) {
		batch = new BatchInfo(batchName);
		eyes.setBatch(batch);
	}

	private static void setWindowSize(int width) {
		int height = 700;
		driver.manage().window().setPosition(new Point(0, 0));
		if (width == 1200) {
			driver.manage().window().setSize(new Dimension(width, height));
		} else if (width == 768) {
			driver.manage().window().setSize(new Dimension(width, height));
		} else if (width == 500) {
			driver.manage().window().setSize(new Dimension(width, height));
		}
	}
	

	public static boolean hackathonReporter(int task, String testName, String domId, boolean comparisonResult, String browser, String viewport, String device) {
	    try(BufferedWriter writer = new BufferedWriter(new FileWriter("Traditional-V1-TestResults.txt", true))){
	        writer.write("Task: " + task + ", Test Name: " + testName +", DOM Id: " + domId + ", Browser: " + browser 
	        		+ ", Viewport: " + viewport + ", Device: " + device + ", Status: " + (comparisonResult ? "Pass" : "Fail"));
	        writer.newLine();
	    }catch(Exception e){
	        System.out.println("Error writing to report file");
	        e.printStackTrace();
	    }
		//returns the result so that it can be used for further Assertions in the test code.
		return comparisonResult;
	}
}
