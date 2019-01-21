package stepDef;

import appmanager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;

import java.util.concurrent.TimeUnit;

@Listeners(MyTestListener.class)
public class TestBase {

    private WebDriver driver = app.getDriver();

    protected static final ApplicationManager app = new ApplicationManager();
    public ApplicationManager getApp() {
        return app;
    }

    /*private static void addJQuery (JavascriptExecutor js) {

        String script = "";

        boolean needInjection = (Boolean)(js.executeScript("return this.$ === undefined;"));
        if(needInjection) {
            URL u = Resources.getResource("jquery.js");
            try {
                script = Resources.toString(u, Charsets.UTF_8);
            } catch(IOException e) {
                e.printStackTrace();
            }
            js.executeScript(script);
        }
    }*/

    public void waitStandart() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }
}
