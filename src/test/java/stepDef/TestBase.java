package stepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.Hook;

public class TestBase {

    private WebDriver driver;

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
}
