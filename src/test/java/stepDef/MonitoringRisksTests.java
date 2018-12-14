package stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.concurrent.TimeUnit;

@Description("Проверка модуля Мониторинг рисков")
@Test(retryAnalyzer = MyRetry.class)
public class MonitoringRisksTests extends TestBase {
    private WebDriver driver = app.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 30);

    public MonitoringRisksTests() throws Throwable {
        super();
        app.login();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
        app.waitForPageLoadComplete(driver);
        app.selectPusk(); //клик пуск
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        app.selectOperaciy(); //выбрать операции
    }

    @Given("^Выбрать модуль Мониторинг Риски$")
    public void selectMonitoringRisks() throws InterruptedException {
        driver.findElement(By.id("ext-comp-1049")).click(); //Клик на Мониторинг Рисков
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
    }

    @When("^Выбрать в работе$")
    public void selectActiveTaskInWork() {
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("div:nth-of-type(5) > table > tbody > tr > td:nth-of-type(2) > div")))); //ожидание 10c
        driver.findElement(By.cssSelector("span.x-tab-strip-text.action-RiskWork")).click(); //клик в работе
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
       // driver.findElement(By.xpath("//div[2]/div/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div[6]/table/tbody/tr/td[2]/div")).click(); //клик 5 элемент в списке
    }

    @Then("^Задачи в работе загрузились$")
    public void loadActiveTaskInWork() throws InterruptedException {
        driver.findElement(By.cssSelector("#bpmrisk1_events_action_work > div > div > div > div > div:nth-child(2) > div > div > div > div > div > div:nth-child(2) > div:nth-child(5)")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
    }

    @Then ("^Выбрать исполнено$")
    public void selectdoneTask () {
        driver.findElement(By.cssSelector("span.x-tab-strip-text.action-RiskArhivTask")).click(); //клик Исполнено
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
    }

    @Then ("^Выбрать реестр$")
    public void selectReestr () throws InterruptedException {
        driver.findElement(By.cssSelector("span.x-tab-strip-text.contractor-man-icon")).click(); //клик Реестры

        wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("tbody:nth-of-type(6) > tr > td > img")))); //ожидание 30с
        driver.findElement(By.cssSelector("tbody:nth-of-type(6) > tr > td > img")).click(); //развернуть реестр
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("font")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea"))); //ждем загрузки комментария и выводим его
        System.out.println(driver.findElement(By.cssSelector("textarea")).getText()); //выведем имя комментария
        driver.findElement(By.cssSelector("textarea")).click(); //клик в поле комментарий
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
    }

    @Then ("^Выбрать мониторинг ПА$")
    public void selectMonitoring () throws InterruptedException {
        driver.findElement(By.cssSelector("span.x-tab-strip-text.monitor-man-icon")).click(); //клик Мониторинг ПА
        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("#bpmrisk_monitor_grid > div > div > div > div > div:nth-child(2) > div > div:nth-child(5)")))); //ожидание 30с
        System.out.println(driver.findElement(By.cssSelector("#bpmrisk_monitor_grid > div > div > div > div > div:nth-child(2) > div > div:nth-child(5)")).getText()); //имя элемента
        driver.findElement(By.cssSelector("#bpmrisk_monitor_grid > div > div > div > div > div:nth-child(2) > div > div:nth-child(5)")).click();
    }
}
