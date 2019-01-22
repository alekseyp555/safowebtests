package stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

@Description("Проверка модуля клиентский менеджер")
@Feature("Справочники")
@Test
public class ClientManagerPageTests extends TestBase {
    //private ChromeDriver driver;
    private WebDriver driver = app.getDriver();

    public ClientManagerPageTests () throws Throwable {
        super();
        waitStandart();
        app.login();
        sleep(5000);
        app.waitForPageLoadComplete(driver);
        app.selectPusk(); //клик пуск
        app.selectSpravochnik(); //выбор справочники
    }

    @Given("Выбрать клиентский менеджер")
    public void selectClientManager() throws Throwable {
        waitStandart();
        click(By.id("ext-comp-1063")); //Клик на клиентский менеджер
        //driver.findElement(By.cssSelector("[class*=x-menu-list-item]:nth-of-type(3)")); //Клик на клиентский менеджер
        //driver.findElement(By.xpath("//div[11]/ul/li[3]/a/span")).click(); //клик на менеджера
        sleep(5000);
    }

    @When("выбрать менеджера")
    public void selectManager() throws Throwable {
        click(By.cssSelector("div[class*=x-grid3-row]:nth-child(2)")); //выбираем второй элемент в списке КМ
        sleep(5000);
    }

    @Then("загрузились связки из сафо")
    public void loadedInfo() {
        app.waitForPageLoadComplete(driver); //Ждем загрузку связок сафо
    }

    @Then("клик на связки в BPM\\/CRM")
    public void clickInfoBPMCRM() throws Throwable {
        waitStandart();
        click(By.cssSelector("li:nth-of-type(2) > a:nth-of-type(2) > em > span > span")); //css клик на связки BPM/CRM
        //driver.findElement(By.xpath("//li[2]/a[2]/em/span/span")).click(); // xpath клик на связки BPM/CRM
        app.waitForPageLoadComplete(driver); //Ждем загрузку связок сафо
        sleep(5000);
    }

    @Then("загрузились связки из BPM\\/CRM")
    public void loadedInfoBPMCRM() {
        waitStandart();
        //driver.findElement(By.cssSelector("div[class*=x-grid3-row]:nth-child(2)")).click(); //выбираем второй элемент в списке КМ
        app.waitForPageLoadComplete(driver); //Ждем загрузку связок BPM/CRM
    }

    @Then("клик на контрагенты")
    public void clickContrAgent() throws Throwable {
        waitStandart();
        click(By.cssSelector("li:nth-of-type(3) > a:nth-of-type(2) > em > span > span")); //css клик на связки BPM/CRM
        //driver.findElement(By.xpath("//li[2]/a[2]/em/span/span")).click(); // xpath клик на контрагенты
        app.waitForPageLoadComplete(driver); //Ждем загрузку связок BPM/CRM
        sleep(5000);
    }

    @Then("загрузились контрагенты")
    public void loadedContrAgent() {
      //  driver.findElement(By.cssSelector("div[class*=x-grid3-row]:nth-child(2)")).click(); //выбираем второй элемент в списке КМ
        waitStandart();
        app.waitForPageLoadComplete(driver); //Ждем загрузку связок контрагенты
    }
}
