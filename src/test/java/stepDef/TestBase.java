package stepDef;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.Hook;

import java.io.IOException;
import java.net.URL;

public class TestBase {

    protected WebDriver driver;

    public TestBase() {
        this.driver = Hook.getDriver();
    }

    protected void waitForPageLoadComplete(WebDriver driver) {
        new WebDriverWait(driver,30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) driver).executeScript("return document.readyState")
                .equals("complete"));
    }

    protected void login() throws Throwable{
        this.driver = Hook.getDriver();
        driver.get("http://bugs-kz/login.html");
        driver.findElement(By.id("user")).click();
        driver.findElement(By.id("user")).clear();
        driver.findElement(By.id("user")).sendKeys("ABPak@sbfc.ru");
        driver.findElement(By.id("pass")).click();
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys("Makaka123");
        driver.findElement(By.xpath("//button")).click();
    }

    protected void selectSpravochnik() {
        driver.findElement(By.cssSelector("#ext-comp-1059")).click(); //valid id
        //driver.findElement(By.id("ext-gen110")).click(); //not good xpath locator
        //driver.findElement(By.cssSelector("[class*=x-menu-list-item]:nth-of-type(6)")); //выбрать справочники
    }

    protected void selectPusk() {
        //driver.findElement(By.xpath("//button[@id='ext-gen14']")).click();
        driver.findElement(By.cssSelector("#ext-comp-1003")).click(); //valid id
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
