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

@Description("Проверка модуля рабочий календарь")
@Feature(value = "Справочники")
@Test
public class RabCalendarTests extends TestBase {

    //private ChromeDriver driver;
    private WebDriver driver = app.getDriver();

    public RabCalendarTests () throws Throwable {
        super();
        app.login();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
        app.waitForPageLoadComplete(driver);
        app.selectPusk(); //клик пуск
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        app.selectSpravochnik(); //выбор справочники
    }

    @Given("Выбрать Рабочий календарь")
    public void выбрать_Рабочий_календарь() throws InterruptedException {
        driver.findElement(By.id("ext-comp-1069")).click(); //Клик на контрагенты
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
    }

    @When("Клик на год календаря")
    public void клик_на_год_календаря() {
        driver.findElement(By.xpath("//img")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @When("^Выбрать 2016 год$")
    public void selectYear() throws InterruptedException {
        driver.findElement(By.xpath("//div[15]/div/div[6]")).click(); //выбрать 2016 год
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
    }

    @Then("Отобразился 2016 год$")
    public void loadedYear() {
        app.waitForPageLoadComplete(driver);
    }
}
