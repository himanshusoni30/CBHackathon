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

	@Parameters({ "browser", "device", "version" })
	@BeforeTest
	public void openBrowser(String browser, String device, String version) {
		asrt = new SoftAssert();
		try {
			if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				if (device.equalsIgnoreCase("laptop")) {
					setWindowSize("laptop");
				} else if (device.equalsIgnoreCase("tablet")) {
					setWindowSize("tablet");
				}
			} else if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				if (device.equalsIgnoreCase("laptop")) {
					setWindowSize("laptop");
				} else if (device.equalsIgnoreCase("tablet")) {
					setWindowSize("tablet");
				} else if (device.equalsIgnoreCase("mobile")) {
					setWindowSize("mobile");
				} else {
					runner = new VisualGridRunner(10);
					eyes = new Eyes(runner);
					eyeSetUp();
				}

			} else if (browser.equalsIgnoreCase("edge")) {
				System.getProperty("webdriver.edge.driver");
				driver = new EdgeDriver();
				if (device.equalsIgnoreCase("laptop")) {
					setWindowSize("laptop");
				} else if (device.equalsIgnoreCase("tablet")) {
					setWindowSize("tablet");
				}
			}
			if(version.equals("1")) {
				driver.get(System.getProperty("site.url.v1"));
			}else if(version.equals("2")) {
				driver.get(System.getProperty("site.url.v2"));
			}
			
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}
	}

	@AfterTest
	public static void tearDown() {
		Reporter.log("********** Test Execution End ************", true);
		driver.close();
//		asrt.assertAll();
	}

	@AfterSuite()
	public static void afterSuite() {
		asrt.assertAll();
		if(driver!=null) {
			driver.quit();
		}
		if(eyes!=null) {
			eyes.abortIfNotClosed();
			TestResultsSummary allTestResults = runner.getAllTestResults(false);
			System.out.println(allTestResults);
		}
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

	private static void setWindowSize(String device) {
		driver.manage().window().setPosition(new Point(0, 0));
		if (device.equalsIgnoreCase("laptop")) {
			driver.manage().window().setSize(new Dimension(1200, 700));
		} else if (device.equalsIgnoreCase("tablet")) {
			driver.manage().window().setSize(new Dimension(900, 700));
		} else if (device.equalsIgnoreCase("mobile")) {
			driver.manage().window().setSize(new Dimension(500, 700));
		}
	}
	
	public static String viewPort(String device) {
		String viewport = null;
		if (device.equalsIgnoreCase("laptop")) {
			viewport = "1200 x 700";
		} else if (device.equalsIgnoreCase("tablet")) {
			viewport = "900 x 700";
		} else if (device.equalsIgnoreCase("mobile")) {
			viewport = "500 x 700";
		}
		return viewport;
	}

	public static boolean hackathonReporter(int task, String testName, String domId, boolean comparisonResult,
			String browser, String viewport, String device, String version) {
		String fileName=null;
		if(version.equals("1")) {
			fileName="Traditional-V1-TestResults.txt";
		}else if(version.equals("2")){
			fileName="Traditional-V2-TestResults.txt";
		}
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
			writer.write("Task: " + task + ", Test Name: " + testName + ", DOM Id: " + domId + ", Browser: " + browser
					+ ", Viewport: " + viewport + ", Device: " + device + ", Status: "
					+ (comparisonResult ? "Pass" : "Fail"));
			writer.newLine();
		} catch (Exception e) {
			System.out.println("Error writing to report file");
			e.printStackTrace();
		}
		// returns the result so that it can be used for further Assertions in the test
		// code.
		return comparisonResult;
	}
}
