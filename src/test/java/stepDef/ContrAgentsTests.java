package stepDef;

import appmanager.ApplicationManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import java.util.concurrent.TimeUnit;

@Description("Проверка модуля контрагенты")
@Test
public class ContrAgentsTests extends TestBase{
    //private ChromeDriver driver;
    private WebDriver driver = app.getDriver();

    public ContrAgentsTests () throws  Throwable{
        super();
        app.login();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
        app.waitForPageLoadComplete(driver);
        app.selectPusk(); //клик пуск
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        app.selectSpravochnik(); //выбор справочники
    }

    @Given("Выбрать Контрагенты")
    public void выбрать_Контрагенты() throws Throwable {
        driver.findElement(By.id("ext-comp-1064")).click(); //Клик на контрагенты
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
    }

    @When("Клик Применить")
    public void клик_Применить() throws Throwable{
        //driver.findElement(By.id("ext-comp-8760")).click(); //Применить не работает
        driver.findElement(By.xpath("//td[3]/table/tbody/tr[3]/td[2]")).click(); // №2 Клик "Применить"
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
    }

    @Then("Список контрагентов появился")
    public void список_контрагентов_появился() {
        app.waitForPageLoadComplete(driver);
    }

    @Then("Выбрать контрагента")
    public void выбрать_контрагента() throws Throwable {
        driver.findElement(By.cssSelector("div[class*=x-grid3-row]:nth-child(2)")).click(); //выбираем второй элемент в списке КМ
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
    }

    @Then("Загрузились свойства контрагента")
    public void загрузились_свойства_контрагента() {
        app.waitForPageLoadComplete(driver);
    }

    @Then("Клик Общие сведения, Дополнительно, Лимиты, Договора, Банковские реквизиты контрагента")
    public void клик_Общие_сведения_Дополнительно_Лимиты_Договора_Банковские_реквизиты_контрагента() {
        driver.findElement(By.xpath("//li[2]/a[2]/em/span/span")).click(); //Клик на Дополнительно
        driver.findElement(By.xpath("//li[4]/a[2]")).click(); // Клик на Лимиты
        driver.findElement(By.xpath("//li[5]/a[2]/em")).click(); // Клик на Договора
        driver.findElement(By.xpath("//li[6]/a[2]/em")).click(); //Клик на Банковские реквизиты контрагента
        //driver.findElement(By.xpath("//li[7]/a[2]/em")).click(); // Клик на представители контрагента не помещается в экране
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
}