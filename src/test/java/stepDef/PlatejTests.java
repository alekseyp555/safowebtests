package stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.concurrent.TimeUnit;

@Description("Проверка модуля Платежи")
@Test(retryAnalyzer = MyRetry.class)
public class PlatejTests extends TestBase {
    private WebDriver driver = app.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 30);
    Actions act = new Actions(driver);
    JavascriptExecutor jse = (JavascriptExecutor)driver;

    public PlatejTests () throws Throwable {
        super();
        app.login();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
        app.waitForPageLoadComplete(driver);
        app.selectPusk(); //клик пуск
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        app.selectOperaciy(); //выбрать операции
    }

    @Given("^Выбрать модуль Платежи$")
    public void selectPlateji () throws InterruptedException {
        driver.findElement(By.id("ext-comp-1051")).click(); //Клик на ОПКМ
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
    }

    @When("^Выбрать платеж$")
    public void selectPlatej () throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div > div.x-grid3-row.x-grid3-row:nth-child(5)"))); //ожидание
        driver.findElement(By.cssSelector("div > div.x-grid3-row.x-grid3-row:nth-child(5)")).click();
        Thread.sleep(5000);
    }

    @Then ("^История отобразилась$")
    public void historyPlatejLoaded() {

    }

    @Then ("^Выбрать поставки$")
    public void selectPostavki () throws InterruptedException {
        driver.findElement(By.cssSelector("span.x-tab-strip-text.supplies-icon")).click(); //Клик поставки
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        driver.findElement(By.xpath
                ("//div[2]/div/div/div/div/div/div[2]/div/div/div/div/div/div/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[2]/em/button")).click();

        //WebElement dateFrom = driver.findElement(By.cssSelector("[name='pd1']")); //поиск даты ОТ
        WebElement dateFrom = driver.findElement(By.xpath("//div[2]/div/div/div[2]/div/div/div/div/form/div[2]/div/div/div/div[2]/input")); //поиск даты ОТ
        dateFrom.clear();
        dateFrom.sendKeys("01122018");
       // jse.executeScript("arguments[0].value='" + "01122018" + "';", dateFrom); //передаем дату в поле ОТ

        act.sendKeys(Keys.TAB).build().perform(); //tab переход в поле дата ДО
        Thread.sleep(2000);

        //WebElement dateTo = driver.findElement(By.cssSelector("[name='pd2']"));        //dateFrom.clear();
        WebElement dateTo = driver.findElement(By.xpath("//div[2]/div/div/div[2]/div/div/div/div/form/div[2]/div/div/div/div[3]/input")); //поиск даты ОТ
        //dateTo.clear();
        dateTo.sendKeys("10122018");
        Thread.sleep(3000);

        //jse.executeScript("arguments[0].value='" + "01122018" + "';", dateTo); //передаем дату в поле ДО
        driver.findElement(By.xpath
                ("//div[2]/div/div/div[2]/div/div/div/div/div/div/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/em/button")).click(); //клик применить

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div> div:nth-child(5) > table > tbody > tr > td.x-grid3-col.x-grid3-cell.x-grid3-td-0.x-grid3-cell-first.x-grid3-check-col-td")));

                //By.cssSelector("div > div:nth-child(5) > table > tbody > tr > td.x-grid3-col.x-grid3-cell.x-grid3-td-0.x-grid3-cell-first.x-grid3-check-col-td > div > div")));
        //By.cssSelector("div > div:nth-child(2) > table > tbody > tr > td.x-grid3-col.x-grid3-cell.x-grid3-td-0.x-grid3-cell-first.x-grid3-check-col-td > div > div")));

        //driver.findElement(By.cssSelector("div > div:nth-child(2) > table > tbody > tr > td.x-grid3-col.x-grid3-cell.x-grid3-td-0.x-grid3-cell-first.x-grid3-check-col-td > div > div")).click();
        driver.findElement(By.cssSelector("div> div:nth-child(5) > table > tbody > tr > td.x-grid3-col.x-grid3-cell.x-grid3-td-0.x-grid3-cell-first.x-grid3-check-col-td")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div> div.x-grid3-row.x-grid3-row-first > table > tbody > tr > td.x-grid3-col.x-grid3-cell.x-grid3-td-1 > div")));
        driver.findElement(By.cssSelector("div> div.x-grid3-row.x-grid3-row-first > table > tbody > tr > td.x-grid3-col.x-grid3-cell.x-grid3-td-1 > div")).isDisplayed(); //отображается список
    }

    @Then ("^Выбрать Документы$")
    public void selectDocs() {

    }

    @Then ("^Выбрать Регрессные требования$")
    public void selectRegresn() {


    }

}
