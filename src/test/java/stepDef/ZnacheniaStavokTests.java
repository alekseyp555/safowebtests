package stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.concurrent.TimeUnit;

@Description("Проверка модуля Значения ставок")
@Test
public class ZnacheniaStavokTests extends TestBase {
    //private ChromeDriver driver;
    private WebDriver driver = app.getDriver();

    public ZnacheniaStavokTests () throws Throwable {
        super();
        app.login();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
        app.waitForPageLoadComplete(driver);
        app.selectPusk(); //клик пуск
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        app.selectSpravochnik(); //выбор справочники
    }

    @Given("Выбрать Значения ставок")
    public void выбрать_Значения_ставок() throws InterruptedException {
        driver.findElement(By.id("ext-comp-1069")).click(); //Клик на ставки
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
    }

    @When("Клик на прогнозные курсы валют для лимитов")
    public void клик_на_прогнозные_курсы_валют_для_лимитов() throws InterruptedException {
        driver.findElement(By.cssSelector("div[class*=x-grid3-row]:nth-child(10)")).click(); //выбираем 10 элемент в списке БП
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
    }

    @Then("Загрузилась информация про ставки")
    public void загрузилась_информация_про_ставки() {
        driver.findElement(By.xpath("//div[2]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td/div")).click(); //переделать локатор
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
    }
}
