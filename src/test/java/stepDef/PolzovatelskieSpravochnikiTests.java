package stepDef;

import appmanager.ApplicationManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.concurrent.TimeUnit;

@Description("Проверка модуля Пользовательские справочники")
@Test
public class PolzovatelskieSpravochnikiTests extends TestBase {

    public PolzovatelskieSpravochnikiTests() throws Throwable {
        super();
        app.login("ABPak@sbfc.ru", "Makaka123");
        app.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
        app.waitForPageLoadComplete(ApplicationManager.driver);
        app.selectPusk(); //клик пуск
        app.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        app.selectSpravochnik(); //выбор справочники
    }

    @Given("Выбрать Пользовательские справочники")
    public void выбрать_Пользовательские_справочники() throws InterruptedException {
        app.driver.findElement(By.id("ext-comp-1067")).click(); //Клик на контрагенты
        app.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
    }

    @When("Клик Справочник банков")
    public void клик_Справочник_банков() throws InterruptedException {
        app.driver.findElement(By.cssSelector("div[class*=x-grid3-row]:nth-child(14)")).click(); //клик на Справочник банков
        app.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
    }

    @Then("Загрузилась информация про банки")
    public void загрузилась_информация_про_банки() {
        app.driver.findElement(By.xpath("//div[2]/div/div[2]/div/div/div[2]/div/div/table/tbody/tr/td/div")).click(); //клик на Сбербанк информация
        app.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
}
