package stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.Hook;
import java.util.concurrent.TimeUnit;

public class SmokeModulBusinessProdTests extends TestBase {
    private WebDriver driver;
    public SmokeModulBusinessProdTests () throws Throwable {
        this.driver = Hook.getDriver();
        login();
        waitForPageLoadComplete(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
        //waitForPageLoadComplete(driver, 30);
    }

    @Given("клик на кнопку Пуск")
    public void клик_на_кнопку_Пуск() throws Throwable {
        //driver.findElement(By.xpath("//[@id='ext-gen14']")).click();
        driver.findElement(By.xpath("//button[@id='ext-gen14']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //Thread.sleep(5000);
    }

    @Given("выбрать справочники")
    public void выбрать_справочники() {
        driver.findElement(By.id("ext-gen143")).click();
    }

    @When("выбрать Бизнес-продукты")
    public void выбрать_Бизнес_продукты()throws Throwable {
        driver.findElement(By.id("ext-gen148")).click(); //Клик на бизес продукты
        Thread.sleep(5000);
    }

    @Then("страницы с бизнес продуктами загрузилась")
    public void страницы_с_бизнес_продуктами_загрузилась() {
        waitForPageLoadComplete(driver); //Ждем загрузку бизнес продуктов
    }

    @Then("выбрать Агентский факторинг без права регресса")
    public void выбрать() {
        driver.findElement(By.xpath("//div[3]/div[2]/div/div/div/div")).click(); //клик по бизнес продукту
       // driver.findElement(By.xpath("//*[starts-with(@id='ext-gen'}/div[1]/table/tbody/tr/td[1]/div")).click(); //клик по бизнес продукту
        waitForPageLoadComplete(driver);
    }

    @Then("загрузились страницы: описание продукта, схема обслуживания, сроки, тарифный план, лимитная политика, верификация")
    public void загрузились_страницы_описание_продукта_схема_обслуживания_сроки_тарифный_план_лимитная_политика_верификация() {
        // клики по вкладкам бизнес продукта
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Описание продукта'])[1]/following::span[2]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Схема обслуживания'])[1]/following::span[2]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Сроки'])[1]/following::span[2]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Тарифный план'])[1]/following::span[2]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Лимитная политика'])[1]/following::span[2]")).click();
    }

}
