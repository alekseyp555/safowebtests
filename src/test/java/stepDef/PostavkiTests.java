package stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.concurrent.TimeUnit;

@Description("Проверка модуля Поставки")
@Test(retryAnalyzer = MyRetry.class)
public class PostavkiTests extends TestBase {
    private WebDriver driver = app.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 30);
    Actions act = new Actions(driver);
    JavascriptExecutor jse = (JavascriptExecutor)driver;

    public PostavkiTests() throws Throwable {
        super();
        app.login();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
        app.waitForPageLoadComplete(driver);
        app.selectPusk(); //клик пуск
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        app.selectOperaciy(); //выбрать операции
    }

    @Given("^Выбрать модуль Поставки$")
    public void selectPostavki () throws InterruptedException {
        driver.findElement(By.id("ext-comp-1052")).click(); //выбрать поставки
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
    }

    @When ("^Выбрать фильтр$")
    public void selectFiltr () {
        driver.findElement(By.xpath("//div[2]/div/div/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[2]/em/button")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
    }

    @Then ("^Выбрать поставки за текущую неделю$")
    public void selectCurrWeek () {
        driver.findElement(By.cssSelector("#qfltr3")).click(); //клик на поставку за текущую неделю
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
    }

    @Then ("^Выбрать поставку$")
    public void selectCurrPostavki () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div > div:nth-child(4) > table > tbody > tr > td.x-grid3-col.x-grid3-cell.x-grid3-td-0.x-grid3-cell-first > div")));
        if (app.isElementVisible("div > div:nth-child(4) > table > tbody > tr > td.x-grid3-col.x-grid3-cell.x-grid3-td-0.x-grid3-cell-first > div"))
            driver.findElement(By.cssSelector("div > div:nth-child(4) > table > tbody > tr > td.x-grid3-col.x-grid3-cell.x-grid3-td-0.x-grid3-cell-first > div")).click();
        System.out.println(driver.findElement(By.cssSelector("div > div:nth-child(4) > table > tbody > tr > td.x-grid3-col.x-grid3-cell.x-grid3-td-0.x-grid3-cell-first > div")).getText());
    }
}
