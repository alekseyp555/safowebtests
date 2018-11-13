package stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Description("Проверка модуля Проверочные массивы финансового мониторинга")
@Test
public class PMFMTests extends TestBase {

    public PMFMTests() throws Throwable {
        super();
        app.login("ABPak@sbfc.ru", "Makaka123");
        app.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
        app.waitForPageLoadComplete(app.driver);
        app.selectPusk(); //клик пуск
        app.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        app.selectSpravochnik(); //выбор справочники
    }

    @Given("Выбрать ПМФМ")
    public void выбрать_ПМФМ() throws InterruptedException {
        app.driver.findElement(By.id("ext-comp-1066")).click(); //Клик на ПМФМ в пуске
        app.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
    }

    @When("Клик ФИО")
    public void клик_ФИО() throws InterruptedException {
        app.driver.findElement(By.cssSelector("div[class*=x-grid3-row]:nth-child(2)")).click(); //выбираем второй элемент в списке
        app.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
    }

    @Then("Выбрать Территория террористической активности")
    public void выбрать_Территория_террористической_активности() {
        app.driver.findElement(By.cssSelector("li:nth-of-type(2) > a:nth-of-type(2) > em > span > span")).click(); //Клик Территория терр активности
        app.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        app.waitForPageLoadComplete(app.driver);
    }

    @Then("Клик Турция")
    public void клик_Турция() throws InterruptedException {
        //WebElement baseTable = driver.findElement(By.cssSelector("#ext-comp-1659"));
        //WebElement baseTable = app.driver.findElement(By.xpath("//*[@id='ext-comp-1659']/div/div/div[2]/div/div/div/div/div[2]/div/div"));
        //List<WebElement> tableRows = baseTable.findElements(By.cssSelector("table.x-grid3-row-table"));
        //System.out.println("Text is " + tableRows.get(2).getText());
        //app.driver.findElement(By.cssSelector("div[class*=x-grid3-row]:nth-child(2)")).click(); //выбираем второй элемент в списке
        app.driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Россия / Российская Федерация'])[1]/preceding::div[21]")).click();        //app.driver.findElement(By.xpath("//div[2]/div/div[2]/div/div/div[2]/div/div[2]/table/tbody/tr/td[2]/div")).click();
        app.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
    }

    @Then("Клик ФАТФ")
    public void клик_ФАТФ() {
        app.driver.findElement(By.cssSelector("li:nth-of-type(3) > a:nth-of-type(2) > em > span > span")).click(); //Клик ФАТФ
        app.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
    }

    @Then("Клик Корея, КНДР")
    public void клик_Корея_КНДР() throws InterruptedException {
        app.driver.findElement(By.xpath("//div[3]/div/div[2]/div/div/div[2]/div/div[2]/table/tbody/tr/td[2]/div")).click(); //клик 2 элемент
         //app.driver.findElement(By.cssSelector("div[class*=x-grid3-row]:nth-child(2)")).click(); //выбираем второй элемент в списке
        app.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
    }

    @Then("Клик Оффшорные зоны")
    public void клик_Оффшорные_зоны() {
        app.driver.findElement(By.cssSelector("li:nth-of-type(4) > a:nth-of-type(2) > em > span > span")).click(); //Клик Оффшорные зоны
        app.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
    }

    @Then("Клик Белиз")
    public void клик_Белиз() throws InterruptedException {
        app.driver.findElement(By.xpath("//div[4]/div/div[2]/div/div/div[2]/div/div[9]/table/tbody/tr/td[2]/div")).click(); // 10 элемент
        app.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
    }

    @Then("Клик Виды деятельности")
    public void клик_Виды_деятельности() {
        app.driver.findElement(By.cssSelector("li:nth-of-type(5) > a:nth-of-type(2) > em > span > span")).click(); //Клик Виды деятельности
        app.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
    }

    @Then("Клик Деятельность, связанная со скупкой")
    public void клик_Деятельность_связанная_со_скупкой() throws InterruptedException {
        app.driver.findElement(By.xpath("//div[5]/div/div[2]/div/div/div[2]/div/div[2]/table/tbody/tr/td[2]/div")).click(); //клик 2 элемент
        app.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
    }

    @Then("Клик Банковские счета")
    public void клик_Банковские_счета() {
        app.driver.findElement(By.cssSelector("li:nth-of-type(6) > a:nth-of-type(2) > em > span > span")).click(); //Клик Счета
        app.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
    }

    @Then("Клик счет")
    public void клик_счет() throws InterruptedException {
        app.driver.findElement(By.xpath("//div[6]/div/div[2]/div/div/div[2]/div/div[2]/table/tbody/tr/td[2]/div")).click();
        app.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
    }
}
