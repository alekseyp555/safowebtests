package stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.concurrent.TimeUnit;

@Description("Проверка модуля ОПКМ")
@Test(retryAnalyzer = MyRetry.class)
public class OPKMTests  extends TestBase{
    private WebDriver driver = app.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 60);
    Actions act = new Actions(driver);

    public OPKMTests () throws Throwable {
        super();
        app.login();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
        app.waitForPageLoadComplete(driver);
        app.selectPusk(); //клик пуск
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        app.selectOperaciy(); //выбрать операции
    }

    @Given ("^Выбрать модуль ОПКМ$")
    public void selectOPKM () throws InterruptedException {
        driver.findElement(By.id("ext-comp-1050")).click(); //Клик на ОПКМ
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
    }

    @When ("^Выбрать событие$")
    public void selectEvent () throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector
                ("#opkm_events_grid > div > div > div > div > div > div > div > div > div:nth-child(2) > table > tbody > tr > td:nth-child(2) > div")))); //ожидание 30c
        act.doubleClick(driver.findElement(By.cssSelector
                ("#opkm_events_grid > div > div > div > div > div > div > div > div > div:nth-child(2) > table > tbody > tr > td:nth-child(2) > div"))).build().perform(); //дабл клик на событии
        //act.moveToElement(driver.findElement(By.cssSelector
        //      ("#opkm_events_grid > div > div > div > div > div > div > div > div > div:nth-child(2) > table > tbody > tr > td:nth-child(2) > div"))).doubleClick().build().perform();
    }


    @Then ("^События загрузились$")
    public void loadedEvent () {

        //wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector
        //("div> table > tbody > tr > td.x-grid3-col.x-grid3-cell.x-grid3-td-0.x-grid3-cell-first.x-grid3-check-col-td.x-grid3-dirty-cell > div > div")))); //ждем загрузку информации
        //driver.findElement(By.cssSelector("div> table > tbody > tr > td.x-grid3-col.x-grid3-cell.x-grid3-td-0.x-grid3-cell-first.x-grid3-check-col-td.x-grid3-dirty-cell > div > div")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
           //driver.findElement(By.cssSelector("div.x-window-bbar > div > table > tbody > tr > td.x-toolbar-right > table.x-toolbar-right-ct")).click(); //закрыть информацию о событиеи
        driver.findElement(By.xpath
                    ("//div[33]/div[2]/div/div/div/div[2]/div/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/em/button")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
    }

    @Then ("^Выбрать контрагенты$")
    public void selectContragent() throws InterruptedException {
        driver.findElement(By.cssSelector("span.x-tab-strip-text.contractor-man-icon")).click(); //выбрать контрагенты
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("tbody:nth-child(2) > tr.x-tree-node-el.x-tree-node-collapsed > td:nth-child(1) > a > span > font")));
        driver.findElement(By.cssSelector("tbody:nth-child(2) > tr.x-tree-node-el.x-tree-node-collapsed > td:nth-child(1) > a > span > font")).click(); //клик 1элемент в списке
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div.x-panel.x-border-panel > div > div > div > div:nth-child(2) > div > div > div.x-panel-bwrap > form > div > div > div > div > input")));
        WebElement contragentInfo = driver.findElements(
                By.cssSelector("div.x-panel.x-border-panel > div > div > div > div:nth-child(2) > div > div > div.x-panel-bwrap > form > div > div > div > div > input")).get(0);
        contragentInfo.getText();
        contragentInfo.click();
    }

    @Then ("^Выбрать отчеты ОПКМ$")
    public void selectReportOKM () throws InterruptedException {
        driver.findElement(By.cssSelector("span.x-tab-strip-text.reports-icon")).click(); //клик отчеты
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        act.doubleClick(driver.findElement(By.cssSelector
                ("#opkm3_report > div > div > div > div > div > div > div > div > div > div:nth-child(5)"))).build().perform(); //дабл клик на событии
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        driver.findElement(By.cssSelector("div.x-panel-bwrap > div.x-panel-bbar.x-panel-bbar-noborder > " +
                "div.x-toolbar.x-small-editor.x-statusbar.x-toolbar-layout-ct > table > tbody > tr > td.x-toolbar-right > table > tbody > tr > td > table > tbody > tr > td:nth-child(2)")).click();  //клик открыть
        Thread.sleep(3000);
    }

    @Then ("^Выбрать настройки ОПКМ$")
    public void selectSettingsOPKM () {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        driver.findElement(By.cssSelector("li:nth-of-type(4) > a:nth-of-type(2) > em > span > span")).click(); //Клик Настройки ОПКМ
        driver.findElement(By.cssSelector("div> div.x-grid3-row.x-grid3-row-first > table > tbody > tr > td > div.x-grid3-col-1")).isDisplayed(); //отобразились настройки

    }
    @Then ("^Выбрать Автоверификация$")
    public void selectAutoVerify () {
        driver.findElement(By.cssSelector("span.x-tab-strip-text.document-check-icon")).click(); //клик автоверификация
        driver.findElement(By.cssSelector("[name='CMB_LIST_BUYERSs']")).isDisplayed(); //проверка полей
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
    }
}
