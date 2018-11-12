package stepDef;

import appmanager.ApplicationManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Listeners;

@Listeners(MyTestListener.class)
public class TestBase {

    protected final ApplicationManager app;

    public TestBase() {
        app = new ApplicationManager();
    }

    public byte[] takeScreenshot() {
        return ((TakesScreenshot) ApplicationManager.driver).getScreenshotAs(OutputType.BYTES);
    }

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
}
