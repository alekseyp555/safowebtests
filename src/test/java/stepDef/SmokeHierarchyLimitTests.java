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
        selectPusk(); //клик пуск
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        selectSpravochnik(); //выбор справочники
    }

    @Given("Выбрать Иерархия лимитов")
    public void выбрать_Иерархия_лимитов() throws Throwable {
        driver.findElement(By.id("ext-comp-1062")).click(); //Клик на иерархия лимитов
        //driver.findElement(By.cssSelector("[class*=x-menu-list-item]:nth-of-type(2)")); //Клик на иерархия лимитов из пуска
        //driver.findElement(By.xpath("//div[11]/ul/li[2]/a/span")).click(); //Клик на иерархия лимитов из пуска
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
    }

    @When("выбрали лимит")
    public void выбрали_лимит() {
        waitForPageLoadComplete(driver);
    }

    @Then("загрузились свойства лимитов: Общие, дополнительно")
    public void загрузились_свойства_лимитов_Общие_дополнительно() throws Throwable {
        //driver.findElement(By.xpath("//tbody[6]/tr/td/a/span")).click(); //клик xpath на 6й элемент в таблице "ГСЗ Роснефть"
        driver.findElement(By.cssSelector("tbody[class*=x-tree-node]:nth-of-type(6)")); //клик CSS на 6й элемент "ГСЗ Роснефть"
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
    }
}
