package stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.concurrent.TimeUnit;


@Description("Проверка модуля Документы для 1С-Бухгалтерии")
@Test(retryAnalyzer = MyRetry.class)
public class Dok1CTests extends TestBase {
    private WebDriver driver = app.getDriver();

    public Dok1CTests () throws Throwable {
        super();
        app.login();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
        app.waitForPageLoadComplete(driver);
        app.selectPusk(); //клик пуск
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        app.selectOperaciy(); //выбрать операции
    }

    @Given("^Выбрать модуль Документы для 1С-Бухгалтерии$")
    public void selectDok1C() throws InterruptedException {
        driver.findElement(By.id("ext-comp-1047")).click(); //Клик на документы для 1с-бухгалтерии
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
    }

    @When("^Выбрать Операционные переводы$")
    public void selectOperacionPerevody() throws InterruptedException {
        driver.findElement(By.cssSelector("li:nth-of-type(2) > a:nth-of-type(2) > em > span > span")).click(); //выбрать операционные переводы
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
    }

    @Then("^Загрузились статусы$")
    public void lodedStatus() throws InterruptedException {
        driver.findElement(By.cssSelector
        ("#docs1c_stage > div > div > div > div > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2)")).click();//клик на 2й месяц
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
    }
}
