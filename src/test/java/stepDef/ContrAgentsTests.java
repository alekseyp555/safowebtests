package stepDef;

import appmanager.ApplicationManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.concurrent.TimeUnit;

@Description("Проверка модуля контрагенты")
@Test
public class ContrAgentsTests extends TestBase{

    public ContrAgentsTests () throws  Throwable{
        super();
        app.login("ABPak@sbfc.ru", "Makaka123");
        app.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
        app.waitForPageLoadComplete(app.driver);
        app.selectPusk(); //клик пуск
        app.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        app.selectSpravochnik(); //выбор справочники
    }

    @Given("Выбрать Контрагенты")
    public void выбрать_Контрагенты() throws Throwable {
        app.driver.findElement(By.id("ext-comp-1064")).click(); //Клик на контрагенты
        app.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
    }

    @When("Клик Применить")
    public void клик_Применить() throws Throwable{
        //driver.findElement(By.id("ext-comp-8760")).click(); //Применить не работает
        app.driver.findElement(By.xpath("//td[3]/table/tbody/tr[3]/td[2]")).click(); // №2 Клик "Применить"
        app.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
    }

    @Then("Список контрагентов появился")
    public void список_контрагентов_появился() {
        app.waitForPageLoadComplete(ApplicationManager.driver);
    }

    @Then("Выбрать контрагента")
    public void выбрать_контрагента() throws Throwable {
        app.driver.findElement(By.cssSelector("div[class*=x-grid3-row]:nth-child(2)")).click(); //выбираем второй элемент в списке КМ
        app.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
    }

    @Then("Загрузились свойства контрагента")
    public void загрузились_свойства_контрагента() {
        app.waitForPageLoadComplete(ApplicationManager.driver);
    }

    @Then("Клик Общие сведения, Дополнительно, Лимиты, Договора, Банковские реквизиты контрагента")
    public void клик_Общие_сведения_Дополнительно_Лимиты_Договора_Банковские_реквизиты_контрагента() {
        app.driver.findElement(By.xpath("//li[2]/a[2]/em/span/span")).click(); //Клик на Дополнительно
        app.driver.findElement(By.xpath("//li[4]/a[2]")).click(); // Клик на Лимиты
        app.driver.findElement(By.xpath("//li[5]/a[2]/em")).click(); // Клик на Договора
        app.driver.findElement(By.xpath("//li[6]/a[2]/em")).click(); //Клик на Банковские реквизиты контрагента
        //driver.findElement(By.xpath("//li[7]/a[2]/em")).click(); // Клик на представители контрагента не помещается в экране
        app.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
}
