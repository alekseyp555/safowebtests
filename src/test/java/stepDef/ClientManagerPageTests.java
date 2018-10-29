package stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;

public class ClientManagerPageTests extends TestBase {

    public ClientManagerPageTests () throws Throwable {
        super();
        login();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
        waitForPageLoadComplete(driver);
        selectPusk(); //клик пуск
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        selectSpravochnik(); //выбор справочники
    }

    @Given("Выбрать клиентский менеджер")
    public void выбрать_клиентский_менеджер() throws Throwable {
        driver.findElement(By.id("ext-comp-1063")).click(); //Клик на клиентский менеджер
        //driver.findElement(By.cssSelector("[class*=x-menu-list-item]:nth-of-type(3)")); //Клик на клиентский менеджер
        //driver.findElement(By.xpath("//div[11]/ul/li[3]/a/span")).click(); //клик на менеджера
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
    }

    @When("выбрать менеджера")
    public void выбрать_менеджера() throws Throwable {
        driver.findElement(By.cssSelector("div[class*=x-grid3-row]:nth-child(2)")).click(); //выбираем второй элемент в списке КМ
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
    }

    @Then("загрузились связки из сафо")
    public void загрузились_связки_из_сафо() {
        waitForPageLoadComplete(driver); //Ждем загрузку связок сафо
    }

    @Then("клик на связки в BPM\\/CRM")
    public void клик_на_связки_в_BPM_CRM() throws Throwable {

        driver.findElement(By.cssSelector("li:nth-of-type(2) > a:nth-of-type(2) > em > span > span")).click(); //css клик на связки BPM/CRM
        //driver.findElement(By.xpath("//li[2]/a[2]/em/span/span")).click(); // xpath клик на связки BPM/CRM
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        waitForPageLoadComplete(driver); //Ждем загрузку связок сафо
        Thread.sleep(5000);
    }

    @Then("загрузились связки из BPM\\/CRM")
    public void загрузились_связки_из_BPM_CRM() throws Throwable {
        //driver.findElement(By.cssSelector("div[class*=x-grid3-row]:nth-child(2)")).click(); //выбираем второй элемент в списке КМ
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        waitForPageLoadComplete(driver); //Ждем загрузку связок BPM/CRM
    }

    @Then("клик на контрагенты")
    public void клик_на_контрагенты() throws Throwable {
        driver.findElement(By.cssSelector("li:nth-of-type(3) > a:nth-of-type(2) > em > span > span")).click(); //css клик на связки BPM/CRM
        //driver.findElement(By.xpath("//li[2]/a[2]/em/span/span")).click(); // xpath клик на контрагенты
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        waitForPageLoadComplete(driver); //Ждем загрузку связок BPM/CRM
        Thread.sleep(5000);
    }

    @Then("загрузились контрагенты")
    public void загрузились_контрагенты() {
      //  driver.findElement(By.cssSelector("div[class*=x-grid3-row]:nth-child(2)")).click(); //выбираем второй элемент в списке КМ
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        waitForPageLoadComplete(driver); //Ждем загрузку связок контрагенты
    }
}