package stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Epic;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

@Description("Проверка модуля Начисления и тарифные документы")
@Epic(value = "Справочники")
@Test

public class NachisleniyaTarifnieDokTests extends TestBase{

    //private ChromeDriver driver;
    private WebDriver driver = app.getDriver();
    Actions act = new Actions(driver);
    JavascriptExecutor jse = (JavascriptExecutor) driver;

    public NachisleniyaTarifnieDokTests () throws Throwable {
        super();
        waitStandart();
        app.login();
        sleep(5000);
        app.waitForPageLoadComplete(driver);
        app.selectPusk(); //клик пуск
        app.selectSpravochnik(); //выбор справочники
    }

    @Given("Выбрать Начисления и тарифные документы")
    public void selectNachisleniya() throws Throwable {
        waitStandart();
        click(By.id("ext-comp-1066")); //Клик на Начисления и тарифные документы
        sleep(5000);
    }

    @When("Выбрали дату {localdate}")
        public void selectDate(LocalDate localdate) throws InterruptedException {
        //driver.findElement(By.name("ch_dt1")).sendKeys("localdate"); //css locators
        click(By.cssSelector("div:nth-of-type(3) > input")); //css locators
        driver.findElement(By.cssSelector("div:nth-of-type(3) > input")).clear();
        //driver.findElement(By.cssSelector("div:nth-of-type(3) > input")).sendKeys(localdate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))); //дата 01.09.2018 смотреть фичу

        app.selectCalendarDate();
        //driver.findElement(By.cssSelector("div:nth-of-type(3) > input")).sendKeys("localdate"); //дата 01.09.2018 смотреть фичу
        //driver.findElement(By.cssSelector("div:nth-of-type(3) > input")).sendKeys("localdate");
        //driver.findElement(By.xpath("//div[3]/input")).click(); //xpath locators
        //driver.findElement(By.xpath("//div[3]/input")).clear();
        //driver.findElement(By.xpath("//div[3]/input")).sendKeys(localdate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))); //дата 01.09.2018
        waitStandart();
        System.out.println(localdate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))); //форматируем дату

        act.sendKeys(Keys.TAB).build().perform(); //tab переход в поле дата ДО
        Thread.sleep(2000);

        WebElement dateTo = driver.findElement(By.name("ch2_dt2")); //дата ОТ
        dateTo.clear();
        jse.executeScript("arguments[0].value='" + "15.10.2018" + "';", dateTo); //передаем дату в поле ОТ
    }

    @When("Клик Применить начисления")
    public void selectAcceptNachislenia() throws Throwable {
        //driver.findElement(By.xpath("//div[3]/div/div/div/div/div/div/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[2]/em/button")).click(); //клик по "Применить"
        click(By.id("ext-comp-1276")); //№2 Клик по кнопке Применить
        waitStandart();
        sleep(2000);
        app.waitForPageLoadComplete(driver);
    }

    @Then("Список документов загрузился")
    public void loadedDocList() throws Throwable{
        sleep(2000);
    }

    @Then("Выбрать счет")
    public void selectAccount() throws Throwable {
        click(By.cssSelector("div[class*=x-grid3-row]:nth-of-type(5)")); //выбираем 5 элемент в списке документов счетов
        waitStandart();
        sleep(2000);
        app.waitForPageLoadComplete(driver);
    }

    @Then("Загрузились комиссии за обработку документов")
    public void loadedCommisionsDoc() {
        app.waitForPageLoadComplete(driver);
    }

    @Then("Клик Излишне начисленные комиссии")
    public void selectNewCommisions() throws Throwable {
        click(By.cssSelector("li:nth-of-type(2) > a:nth-of-type(2) > em > span > span")); //css клик на Излишне начисленные комиссии
        //driver.findElement(By.xpath("//li[2]/a[2]/em/span/span")).click(); // xpath клик на Излишне начисленные комиссии
        waitStandart();
        sleep(5000);
        //waitForPageLoadComplete(driver); //Ждем загрузку комиссии
    }

    @Then("Выбрать компанию")
    public void selectCompany() throws Throwable {
        //driver.findElement(By.cssSelector("div[class*=x-grid3-row]:nth-of-type(5)")).click(); //выбираем 5й элемент в списке документов счетов
        //driver.findElement(By.cssSelector("div[class*=x-grid3-row]:nth-child(2)")).click(); //выбираем 2й элемент в списке документов счетов
       // WebElement baseTable = driver.findElement(By.xpath("//div[5]/table/tbody/tr/td/div"));
       // List<WebElement> rows = baseTable.findElements(By.cssSelector("div[class*=x-grid3-row]"));
        //driver.findElement(By.xpath("//div[5]/table/tbody/tr/td/div")).click(); //xpath выбираем 5 элемент в таблице
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)=concat('ООО ', '\"', 'ЛУДИНГ', '\"', '')])[1]/following::div[3]"));
        waitStandart();
        Thread.sleep(5000);
        app.waitForPageLoadComplete(driver); //Ждем загрузку компании
    }

    @Then("Детализация загрузилась")
    public void infoLoaded() {
        app.waitForPageLoadComplete(driver); //Ждем загрузку связок BPM/CRM
    }

    @Then("Клик на Начисления")
    public void selectIncome() throws Throwable {
        click(By.cssSelector("li:nth-of-type(3) > a:nth-of-type(2) > em > span > span")); //css клик на связки BPM/CRM
        //driver.findElement(By.xpath("//li[2]/a[2]/em/span/span")).click(); // xpath клик на контрагенты
        waitStandart();
        app.waitForPageLoadComplete(driver); //Ждем загрузку связок BPM/CRM
        sleep(5000);
    }
}