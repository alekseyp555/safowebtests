package stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import java.util.concurrent.TimeUnit;

@Description("Проверка модуля контрагенты")
@Feature("Справочники")
@Test
public class ContrAgentsTests extends TestBase{
    //private ChromeDriver driver;
    private WebDriver driver = app.getDriver();

    public ContrAgentsTests () throws  Throwable{
        super();
        waitStandart();
        app.login();
        sleep(5000);
        app.waitForPageLoadComplete(driver);
        app.selectPusk(); //клик пуск
        app.selectSpravochnik(); //выбор справочники
    }

    @Given("Выбрать Контрагенты")
    public void selectContrAgents() throws Throwable {
        waitStandart();
        click(By.id("ext-comp-1065")); //Клик на контрагенты
        sleep(5000);
    }

    @When("Клик Применить")
    public void accept() throws Throwable{
        waitStandart();
        //driver.findElement(By.id("ext-comp-8760")).click(); //Применить не работает
        click(By.xpath("//td[3]/table/tbody/tr[3]/td[2]")); // №2 Клик "Применить"
        sleep(5000);
    }

    @Then("Список контрагентов появился")
    public void listContrAgents() {
        app.waitForPageLoadComplete(driver);
    }

    @Then("Выбрать контрагента")
    public void selectContraAgentName() throws Throwable {
        waitStandart();
        click(By.cssSelector("div[class*=x-grid3-row]:nth-child(2)")); //выбираем второй элемент в списке КМ
        sleep(5000);
    }

    @Then("Загрузились свойства контрагента")
    public void loadedInfoContrAgent() {
        app.waitForPageLoadComplete(driver);
    }

    @Then("Клик Общие сведения, Дополнительно, Лимиты, Договора, Банковские реквизиты контрагента")
    public void selectContrAgentsTab() {
        waitStandart();
        click(By.xpath("//li[2]/a[2]/em/span/span")); //Клик на Дополнительно
        click(By.xpath("//li[4]/a[2]")); // Клик на Лимиты
        click(By.xpath("//li[5]/a[2]/em")); // Клик на Договора
        click(By.xpath("//li[6]/a[2]/em")); //Клик на Банковские реквизиты контрагента
        //driver.findElement(By.xpath("//li[7]/a[2]/em")).click(); // Клик на представители контрагента не помещается в экране
    }
}