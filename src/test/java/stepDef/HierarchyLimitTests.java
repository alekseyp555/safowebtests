package stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.concurrent.TimeUnit;

@Description("Проверка модуля Иерархия лимитов")
@Feature("Справочники")
@Test
public class HierarchyLimitTests extends TestBase {
    //private ChromeDriver driver;
    private WebDriver driver = app.getDriver();

    public HierarchyLimitTests() throws Throwable {
        super();
        waitStandart();
        app.login();
        app.waitForPageLoadComplete(driver);
        sleep(5000);
        app.selectPusk(); //клик пуск
        app.selectSpravochnik(); //выбор справочники
    }

    @Given("Выбрать Иерархия лимитов")
    public void selectHierarhyLimit() throws Throwable {
        waitStandart();
        click(By.id("ext-comp-1062")); //Клик на иерархия лимитов
        //driver.findElement(By.cssSelector("[class*=x-menu-list-item]:nth-of-type(2)")); //Клик на иерархия лимитов из пуска
        //driver.findElement(By.xpath("//div[11]/ul/li[2]/a/span")).click(); //Клик на иерархия лимитов из пуска
        sleep(5000);
    }

    @When("выбрали лимит")
    public void selectHierarhyLimitList() {
        app.waitForPageLoadComplete(driver);
    }

    @Then("загрузились свойства лимитов: Общие, дополнительно")
    public void loadedHierarhyLimitInfo() throws Throwable {
        waitStandart();
        //driver.findElement(By.xpath("//tbody[6]/tr/td/a/span")).click(); //клик xpath на 6й элемент в таблице "ГСЗ Роснефть"
        click(By.cssSelector("tbody[class*=x-tree-node]:nth-of-type(6)")); //клик CSS на 6й элемент "ГСЗ Роснефть"
        sleep(5000);
    }
}
