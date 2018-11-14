package stepDef;

import appmanager.ApplicationManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import java.util.concurrent.TimeUnit;

@Description("Проверка модуля клиентский менеджер")
@Test
public class ClientManagerPageTests extends TestBase {

    public ClientManagerPageTests () throws Throwable {
        super();
        app.login("ABPak@sbfc.ru", "Makaka123");
        app.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
        app.waitForPageLoadComplete(ApplicationManager.driver);
        app.selectPusk(); //клик пуск
        app.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        app.selectSpravochnik(); //выбор справочники
    }

    @Given("Выбрать клиентский менеджер")
    public void выбрать_клиентский_менеджер() throws Throwable {
        app.driver.findElement(By.id("ext-comp-1063")).click(); //Клик на клиентский менеджер
        //driver.findElement(By.cssSelector("[class*=x-menu-list-item]:nth-of-type(3)")); //Клик на клиентский менеджер
        //driver.findElement(By.xpath("//div[11]/ul/li[3]/a/span")).click(); //клик на менеджера
        app.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
    }

    @When("выбрать менеджера")
    public void выбрать_менеджера() throws Throwable {
        app.driver.findElement(By.cssSelector("div[class*=x-grid3-row]:nth-child(2)")).click(); //выбираем второй элемент в списке КМ
        app.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
    }

    @Then("загрузились связки из сафо")
    public void загрузились_связки_из_сафо() {
        app.waitForPageLoadComplete(app.driver); //Ждем загрузку связок сафо
    }

    @Then("клик на связки в BPM\\/CRM")
    public void клик_на_связки_в_BPM_CRM() throws Throwable {

        app.driver.findElement(By.cssSelector("li:nth-of-type(2) > a:nth-of-type(2) > em > span > span")).click(); //css клик на связки BPM/CRM
        //driver.findElement(By.xpath("//li[2]/a[2]/em/span/span")).click(); // xpath клик на связки BPM/CRM
        app.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        app.waitForPageLoadComplete(app.driver); //Ждем загрузку связок сафо
        Thread.sleep(5000);
    }

    @Then("загрузились связки из BPM\\/CRM")
    public void загрузились_связки_из_BPM_CRM() throws Throwable {
        //driver.findElement(By.cssSelector("div[class*=x-grid3-row]:nth-child(2)")).click(); //выбираем второй элемент в списке КМ
        app.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        app.waitForPageLoadComplete(app.driver); //Ждем загрузку связок BPM/CRM
    }

    @Then("клик на контрагенты")
    public void клик_на_контрагенты() throws Throwable {
        app.driver.findElement(By.cssSelector("li:nth-of-type(3) > a:nth-of-type(2) > em > span > span")).click(); //css клик на связки BPM/CRM
        //driver.findElement(By.xpath("//li[2]/a[2]/em/span/span")).click(); // xpath клик на контрагенты
        app.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        app.waitForPageLoadComplete(app.driver); //Ждем загрузку связок BPM/CRM
        Thread.sleep(5000);
    }

    @Then("загрузились контрагенты")
    public void загрузились_контрагенты() {
      //  driver.findElement(By.cssSelector("div[class*=x-grid3-row]:nth-child(2)")).click(); //выбираем второй элемент в списке КМ
        app.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        app.waitForPageLoadComplete(app.driver); //Ждем загрузку связок контрагенты
    }
}
