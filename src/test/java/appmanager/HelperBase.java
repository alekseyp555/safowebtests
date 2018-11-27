package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelperBase {

    protected ChromeDriver driver;

    public HelperBase(ChromeDriver driver) {
        this.driver = driver;
    }

    public HelperBase(WebDriver driver) {
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

}
