package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Base {
	public static WebDriver driver;
	public Properties prop;
	public FileInputStream fis;

	public WebDriver initializeDriver() throws IOException {

		String browserName = readProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\Executables\\chromedriver.exe");
			driver = new ChromeDriver();
			// execute in chrome driver
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					(System.getProperty("user.dir") + "\\src\\main\\java\\Executables\\geckodriver.exe"));
			driver = new FirefoxDriver();
			// firefox code
		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver",
					(System.getProperty("user.dir") + "\\src\\main\\java\\Executables\\IEDriverServer.exe"));
			driver = new InternetExplorerDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public String readProperty(String value) throws IOException {
		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\config.properties");
		prop = new Properties();
		prop.load(fis);
		return prop.getProperty(value);
	}
	public String getScreenshot(ITestResult result) throws IOException
	{
		 Date d=new Date();
		 SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
			String timeStamp =formatter.format(d);
		//String timeStamp = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss"). format(Calendar. getInstance(). getTime());
		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots"+"\\"+result.getName()+timeStamp+"screenshot.png";
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(screenshotPath));
		return screenshotPath;
	}
}
