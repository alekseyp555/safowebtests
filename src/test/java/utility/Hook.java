/**
 * 
 */
package utility;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hook {

	private static WebDriver driver;

    @Before
	public void setUp(Scenario scenario)
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println("--------------------------------------------------");
		System.out.println("Starting - " + scenario.getName());
        System.out.println("--------------------------------------------------");
	}

	/*
	@Before("@appium")
	public void setUpAppium() throws MalformedURLException
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 9");
		cap.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+"//App//ApiDemos.apk");
		driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	*/
	
	@After
	public void tearDown(Scenario scenario)
	{
	    driver.quit();
        System.out.println("--------------------------------------------------");
        System.out.println(scenario.getName() + " Status - " + scenario.getStatus());
        System.out.println("--------------------------------------------------");
	}

	public static WebDriver getDriver () {
	    return driver;
    }

}
