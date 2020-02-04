package BaseClass;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

import Utility.utilities;



public class BaseClass {
	public static WebDriver driver;
	public File fl;	
	public FileInputStream fis;
	public String Ppath= "./config.properties";
	public Properties pr;
	public Logger logger;
	public String browser;


	
	@BeforeSuite
	public void BrowserSetup() throws Exception
	{
		fl=new File("C:/Users/ashishj/workspace/Keyword/config.properties");
		fis=new FileInputStream(fl);
		pr=new Properties();
		pr.load(fis);
		logger=Logger.getLogger(utilities.class);
		PropertyConfigurator.configure("log4j.properties");
		browser=pr.getProperty("browser");
		System.out.println(browser);
		if(browser.equals("chrome"))
		{
			System.setProperty("Webdriver.chrome.driver", "Driver\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		if(browser.equals("firefox"))
		{
			//System.setProperty("Webdriver.chrome.driver", "Driver\\geckodriver.exe");
			System.setProperty("webdriver.gecko.driver","Driver\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
	}

}