/**
 *
 */
package utility;

import appmanager.ApplicationManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import stepDef.MyTestListener;

import java.io.IOException;

@Listeners(MyTestListener.class)
public class Hook {

    private final ApplicationManager app = new ApplicationManager();
    //protected static final ApplicationManager app = new ApplicationManager();

    @BeforeSuite
    public void setUp (ITestContext context)    {
        context.setAttribute("app", app);
    }

    @Before
	public void setUp(Scenario scenario) throws IOException {
        
        app.init(scenario);

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
	    app.stop(scenario);
    }

    public ApplicationManager getApp() {
        return app;
    }

}
