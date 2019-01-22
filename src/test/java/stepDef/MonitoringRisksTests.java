package stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.concurrent.TimeUnit;

@Description("Проверка модуля Мониторинг рисков")
@Feature("Операции")
@Test(retryAnalyzer = MyRetry.class)
public class MonitoringRisksTests extends TestBase {
    private WebDriver driver = app.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 30);

    public MonitoringRisksTests() throws Throwable {
        super();
        waitStandart();
        app.login();
        sleep(5000);
        app.waitForPageLoadComplete(driver);
        app.selectPusk(); //клик пуск
        app.selectOperaciy(); //выбрать операции
    }

    @Given("^Выбрать модуль Мониторинг Риски$")
    public void selectMonitoringRisks() throws InterruptedException {
        waitStandart();
        click(By.id("ext-comp-1049")); //Клик на Мониторинг Рисков
        sleep(5000);
    }

    @When("^Выбрать в работе$")
    public void selectActiveTaskInWork() {
        //wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("div:nth-of-type(5) > table > tbody > tr > td:nth-of-type(2) > div")))); //ожидание 10c
        waitStandart();
        click(By.cssSelector("span.x-tab-strip-text.action-RiskWork")); //клик в работе
       // driver.findElement(By.xpath("//div[2]/div/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div[6]/table/tbody/tr/td[2]/div")).click(); //клик 5 элемент в списке
    }

    @Then("^Задачи в работе загрузились$")
    public void loadActiveTaskInWork()   {
        waitStandart();
        click(By.cssSelector("#bpmrisk1_events_action_work > div > div > div > div > div:nth-child(2) > div > div > div > div > div > div:nth-child(2) > div:nth-child(5)"));
    }

    @Then ("^Выбрать исполнено$")
    public void selectdoneTask () {
        waitStandart();
        click(By.cssSelector("span.x-tab-strip-text.action-RiskArhivTask")); //клик Исполнено
    }

    @Then ("^Выбрать реестр$")
    public void selectReestr () throws InterruptedException {
        click(By.cssSelector("span.x-tab-strip-text.contractor-man-icon")); //клик Реестры

        wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("tbody:nth-of-type(6) > tr > td > img")))); //ожидание 30с
        click(By.cssSelector("tbody:nth-of-type(6) > tr > td > img")); //развернуть реестр
        sleep(2000);
        //driver.findElement(By.cssSelector("font")).click();
        click(By.cssSelector
                ("#bpmrisk_contractor_grid > div > div > div > div.x-treegrid-root-node > table > tbody:nth-child(7) > tr.x-tree-node-ct > td > table > tbody")); //клик на реестр
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='NAME_CA_SID']"))); //ждем загрузки комментария и выводим его
        System.out.println(driver.findElement(By.cssSelector("[name='NAME_CA_SID']")).getText()); //выведем имя комментария
    }

    @Then ("^Выбрать мониторинг ПА$")
    public void selectMonitoring () throws InterruptedException {
        click(By.cssSelector("span.x-tab-strip-text.monitor-man-icon")); //клик Мониторинг ПА
        sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("#bpmrisk_monitor_grid > div > div > div > div > div:nth-child(2) > div > div:nth-child(5)")))); //ожидание 30с
        System.out.println(driver.findElement(By.cssSelector("#bpmrisk_monitor_grid > div > div > div > div > div:nth-child(2) > div > div:nth-child(5)")).getText()); //имя элемента
        click(By.cssSelector("#bpmrisk_monitor_grid > div > div > div > div > div:nth-child(2) > div > div:nth-child(5)"));
    }
}
