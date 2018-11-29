package stepDef;

import appmanager.ApplicationManager;
import org.testng.annotations.Listeners;

@Listeners(MyTestListener.class)
public class TestBase {

    //private ChromeDriver driver;

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
}
