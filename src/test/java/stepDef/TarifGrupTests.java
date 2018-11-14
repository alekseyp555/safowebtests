package stepDef;

import appmanager.ApplicationManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

@Description("Проверка модуля тарифные группы")
@Test
public class TarifGrupTests extends TestBase {

    public TarifGrupTests () throws Throwable {
        super();
        app.login("ABPak@sbfc.ru", "Makaka123");
        app.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
        app.waitForPageLoadComplete(ApplicationManager.driver);
        app.selectPusk(); //клик пуск
        app.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        app.selectSpravochnik(); //выбор справочники
    }

    @Given("Выбрать Тарифные группы")
    public void выбрать_Тарифные_группы() throws InterruptedException {
        app.driver.findElement(By.id("ext-comp-1070")).click(); //Клик на тарифные группы
        app.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
    }

    @When("Клик на тарифную группы")
    public void клик_на_тарифную_группы() throws InterruptedException {
        app.driver.findElement(By.cssSelector("div[class*=x-grid3-row]:nth-child(2)")).click(); //выбираем 2 элемент в списке БП
        app.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
    }

    @Then("Тарифные группы отобразились")
    public void тарифные_группы_отобразились() {
        String text = app.driver.findElement(By.xpath("//div[2]/table/tbody/tr/td[2]/div")).getText();
        System.out.println("Имя 2го элемента " + text);
        assertEquals("Комиссия за факторинговое обслуживание", text);
    }
}
