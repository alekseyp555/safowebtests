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

@Description("Проверка модуля Регресс")
@Test(retryAnalyzer = MyRetry.class)
public class RegressTests extends TestBase {
    private WebDriver driver = app.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 30);
    Actions act = new Actions(driver);
    JavascriptExecutor jse = (JavascriptExecutor)driver;

    public RegressTests() throws Throwable {
        super();
        app.login();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
        app.waitForPageLoadComplete(driver);
        app.selectPusk(); //клик пуск
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        app.selectOperaciy(); //выбрать операции
    }

    @Given("^Выбрать модуль Регресс$")
    public void selectRegress () throws InterruptedException {
        driver.findElement(By.id("ext-comp-1053")).click(); //Выбрать Регресс
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);;
    }

    @When("^Выбрать фильтр и дату$")
    public void selectFilter () throws InterruptedException {
        WebElement dateFrom = driver.findElement(By.name("pDateS"));
        dateFrom.click();
        dateFrom.clear();
        dateFrom.sendKeys("18122018");

        act.sendKeys(Keys.TAB).build().perform(); //tab переход в поле дата ДО
        Thread.sleep(2000);

        WebElement dateTo = driver.findElement(By.name("pDateE"));
        dateTo.sendKeys("19122018");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//div[2]/div/div/div/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/em/button")).click(); //клик применить
        Thread.sleep(3000);
    }

    @Then ("^Поставки отображаются$")
    public void selectRegressPostavki () {

    }

    @Then("^Выбрать регрессные требования$")
    public void selectRegressRequirement() {

    }

}
