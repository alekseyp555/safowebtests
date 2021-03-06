package stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

@Description("Проверка модуля бизнес продукты")
@Feature("Справочники")
@Test(retryAnalyzer = MyRetry.class)

public class BusinessProdTests extends TestBase {

    //private ChromeDriver driver;
        private WebDriver driver = app.getDriver();

        public BusinessProdTests () throws Throwable {
        super();
        waitStandart();
        app.login();
        sleep(5000);
        app.waitForPageLoadComplete(driver);
        app.selectPusk(); //клик пуск
        app.selectSpravochnik(); //выбор справочники
    }

    @Given("Выбрать Бизнес-продукты")
    public void selectBusinessProduct() throws InterruptedException {
        waitStandart();
        click(By.id("ext-comp-1061")); //Клик на БП
        //driver.findElement(By.xpath("//div[12]/ul/li/a/span")).click(); //Xpath клик на бизнес продукты
        sleep(5000);
    }

    @When("Выбрать Агентский факторинг без права регресса")
    public void selectAgentFactoringNoRegression() throws InterruptedException {
        waitStandart();
        //driver.findElement(By.xpath("//div[3]/div[2]/div/div/div/div/div/div/div[2]/div/div/div/div/div[2]")).click(); //клик по бизнес продукту
        click(By.cssSelector("div[class*=x-grid3-row]:nth-child(2)")); //выбираем второй элемент в списке БП
        //driver.findElement(By.cssSelector("div[class*=x-grid3-row]:first-child")).click(); //выбираем первый элемент в списке БП
        //driver.findElement(By.cssSelector("div[class*=x-grid3-row]:last-child")).click(); //выбираем последний элемент в списке БП
        sleep(5000);
    }

    @Then("загрузились информация: описание продукта, схема обслуживания, сроки, тарифный план, лимитная политика, верификация")
    public void informationLoad() throws InterruptedException {
        // клики по вкладкам бизнес продуктам
        //driver.findElement(By.xpath("//span/span")).click();
        waitStandart();
        click(By.xpath("//li[2]/a[2]/em/span/span"));
        app.waitForPageLoadComplete(driver);
        click(By.xpath("//li[3]/a[2]/em/span/span"));
        app.waitForPageLoadComplete(driver);
        click(By.xpath("//li[4]/a[2]"));
        app.waitForPageLoadComplete(driver);
        click(By.xpath("//li[5]/a[2]/em"));

        click(By.xpath("//li[6]/a[2]/em"));
        String tab6 = driver.findElement(By.xpath("//li[6]/a[2]/em")).getText();
        System.out.println("Вкладка " + tab6);
        assertEquals("Верификация", tab6); //проверяем вкладка Верификация
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        sleep(5000);

        click(By.xpath("//div[6]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td/div")); //клик по элементу
        /*driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Описание продукта'])[1]/following::span[2]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Схема обслуживания'])[1]/following::span[2]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Сроки'])[1]/following::span[2]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Тарифный план'])[1]/following::span[2]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Лимитная политика'])[1]/following::span[2]")).click();
        */
    }
}
