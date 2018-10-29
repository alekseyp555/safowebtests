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
    }

    @Given("клик на кнопку Пуск")
    public void клик_на_кнопку_Пуск() throws Throwable {
        //driver.findElement(By.xpath("//[@id='ext-gen14']")).click();
        selectPusk();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //Thread.sleep(5000);
    }

    @Given("выбрать справочники")
    public void выбрать_справочники() {
        selectSpravochnik();
    }

    @When("выбрать Бизнес-продукты")
    public void выбрать_Бизнес_продукты()throws Throwable {
        driver.findElement(By.id("ext-comp-1061")).click(); //Клик на бизес продукты
        //driver.findElement(By.xpath("//div[12]/ul/li/a/span")).click(); //Xpath клик на бизнес продукты
        Thread.sleep(5000);
    }

    @Then("страницы с бизнес продуктами загрузилась")
    public void страницы_с_бизнес_продуктами_загрузилась() {
        waitForPageLoadComplete(driver); //Ждем загрузку бизнес продуктов и элементов js
    }

    @Then("выбрать Агентский факторинг без права регресса")
    public void выбрать() throws Throwable {

        //driver.findElement(By.xpath("//div[3]/div[2]/div/div/div/div/div/div/div[2]/div/div/div/div/div[2]")).click(); //клик по бизнес продукту
        driver.findElement(By.cssSelector("div[class*=x-grid3-row]:nth-child(2)")).click(); //выбираем второй элемент в списке БП
        //driver.findElement(By.cssSelector("div[class*=x-grid3-row]:first-child")).click(); //выбираем первый элемент в списке БП
        //driver.findElement(By.cssSelector("div[class*=x-grid3-row]:last-child")).click(); //выбираем последний элемент в списке БП
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
    }

    @Then("загрузились страницы: описание продукта, схема обслуживания, сроки, тарифный план, лимитная политика, верификация")
    public void загрузились_страницы_описание_продукта_схема_обслуживания_сроки_тарифный_план_лимитная_политика_верификация() {
        // клики по вкладкам бизнес продуктам

        driver.findElement(By.xpath("//span/span")).click();
        driver.findElement(By.xpath("//li[2]/a[2]/em/span/span")).click();
        driver.findElement(By.xpath("//li[3]/a[2]/em/span/span")).click();
        driver.findElement(By.xpath("//li[4]/a[2]")).click();
        driver.findElement(By.xpath("//li[5]/a[2]/em")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        /*driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Описание продукта'])[1]/following::span[2]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Схема обслуживания'])[1]/following::span[2]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Сроки'])[1]/following::span[2]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Тарифный план'])[1]/following::span[2]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Лимитная политика'])[1]/following::span[2]")).click();
        */
    }

}
