package stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import java.util.concurrent.TimeUnit;

@Description("Проверка модуля Реестры")
@Test(retryAnalyzer = MyRetry.class)
public class ReestrTests extends TestBase {
    private WebDriver driver = app.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 30);
    Actions act = new Actions(driver);
    JavascriptExecutor jse = (JavascriptExecutor) driver;

    public ReestrTests() throws Throwable {
        super();
        app.login();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
        app.waitForPageLoadComplete(driver);
        app.selectPusk(); //клик пуск
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        app.selectOperaciy(); //выбрать операции
    }

    @Given("^Выбрать модуль Реестры$")
    public void selectRegress() throws InterruptedException {
        driver.findElement(By.id("ext-comp-1054")).click(); //Выбрать Регресс
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
        ;
    }

    @When("^Выбрать дату реестра$")
    public void filterReest() throws InterruptedException {
        driver.findElement(By.xpath("//div[3]/div/div/div/div/input")).click();

        act.sendKeys(Keys.TAB).build().perform(); //tab переход в поле дата ДО
        Thread.sleep(2000);

        WebElement dateFrom = driver.findElement(By.name("ch2_dt1"));
        dateFrom.sendKeys("18112018");

        act.sendKeys(Keys.TAB).build().perform(); //tab переход в поле дата ДО
        Thread.sleep(2000);

        WebElement dateTo = driver.findElement(By.name("ch2_dt2"));
        dateTo.sendKeys("19112018");
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("#rr_p2 > div > div.x-tab-panel-bbar.x-tab-panel-bbar-noborder > div > table > tbody > tr > td> table > tbody > tr > td:nth-child(3)")).click(); //клик применить
        Thread.sleep(3000);
    }

    @Then("^Реестры отображаются$")
    public void loadedReestr () {

    }

    @Then ("^Выбрать реестры ПП$")
    public void selectReestrPP () {

    }

    @Then ("^Выбрать заявки$")
    public void selectQuery () {

    }

    @Then ("^Выбрать Исключенные заявки$")
    public void selectExcludedQuery () {

    }

}