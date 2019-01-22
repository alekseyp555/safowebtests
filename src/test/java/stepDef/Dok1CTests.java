package stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Feature;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

@Description("Проверка модуля Документы для 1С-Бухгалтерии")
@Feature("Операции")
@Test(retryAnalyzer = MyRetry.class)
public class Dok1CTests extends TestBase {
    private WebDriver driver = app.getDriver();
    Actions act = new Actions(driver);
    JavascriptExecutor jse = (JavascriptExecutor) driver;

    public Dok1CTests () throws Throwable {
        super();
        waitStandart();
        app.login();
        sleep(5000);
        app.waitForPageLoadComplete(driver);
        app.selectPusk(); //клик пуск
        app.selectOperaciy(); //выбрать операции
    }

    @Given("^Выбрать модуль Документы для 1С-Бухгалтерии$")
    public void selectDok1C() throws InterruptedException {
        waitStandart();
        click(By.id("ext-comp-1047")); //Клик на документы для 1с-бухгалтерии
        sleep(5000);
    }

    @When("^Создать выписку с 10 декабря по 20 декабря$")
    public void requestDocs () throws InterruptedException {
        click(By.cssSelector("td:nth-of-type(4) > table > tbody > tr:nth-of-type(2) > td:nth-of-type(2) > em > button.x-btn-text.ico_m_filtr")); //клик на кнопку фильтр
        sleep(2000);

        WebElement dateFrom = driver.findElement(By.name("ch1_dt1")); //дата ОТ
        dateFrom.click();
        dateFrom.clear();
        jse.executeScript("arguments[0].value='" + "10.12.2018" + "';", dateFrom); //передаем дату в поле ОТ
        //dateFrom.sendKeys("10122018");

        act.sendKeys(Keys.TAB).build().perform(); //tab переход в поле дата ДО
        Thread.sleep(2000);

        WebElement dateTo = driver.findElement(By.name("ch1_dt2"));
        dateTo.sendKeys("20.12.2018");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[2]/div/div/div/div/div[2]/div/div/div/div/div/div/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/em/button")).click();
        Thread.sleep(2000);

    }


    @Then ("^Документы отобразились$")
    public void loadedDocs() {
        WebDriverWait wait = new WebDriverWait(driver, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[5]/table/tbody/tr/td[2]/div")))); //ожидание 60с появления документов, 1с долго грузятся.
        click(By.xpath("//div[5]/table/tbody/tr/td[2]/div"));
        app.waitForPageLoadComplete(driver);
    }

    @Then("^Выбрать Операционные переводы$")
    public void selectOperacionPerevody() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li:nth-of-type(2) > a:nth-of-type(2) > em > span > span")));
        click(By.cssSelector("li:nth-of-type(2) > a:nth-of-type(2) > em > span > span")); //выбрать операционные переводы
    }

    @Then("^Загрузились статусы$")
    public void lodedStatus() throws InterruptedException {
        waitStandart();
        click(By.cssSelector("#docs1c_stage > div > div > div > div > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2)"));//клик на 2й месяц
        sleep(3000);
    }
}
