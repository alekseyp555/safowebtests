package stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class SmokeHierarchyLimitTests extends TestBase {

    public SmokeHierarchyLimitTests () throws Throwable {
        super();
        login();
        waitForPageLoadComplete(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
        //waitForPageLoadComplete(driver, 30);
        selectPusk(); //клик пуск
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        selectSpravochnik(); //выбор справочники лимиты
    }

    @Given("Выбрать Иерархия лимитов")
    public void выбрать_Иерархия_лимитов() throws Throwable {
        driver.findElement(By.id("ext-gen150")).click(); //Клик на иерархия лимитов
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
    }

    @When("выбрали лимит")
    public void выбрали_лимит() {
        waitForPageLoadComplete(driver);
    }

    @Then("загрузились свойства лимитов: Общие, дополнительно")
    public void загрузились_свойства_лимитов_Общие_дополнительно() throws Throwable {
        driver.findElement(By.xpath("//tbody[6]/tr/td/a/span")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
    }

}
