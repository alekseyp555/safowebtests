package stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class NachisleniyaTarifnieDokTests extends TestBase{

    public NachisleniyaTarifnieDokTests () throws Throwable {
        super();
        login();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
        waitForPageLoadComplete(driver);
        selectPusk(); //клик пуск
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        selectSpravochnik(); //выбор справочники
    }

    @Given("Выбрать Начисления и тарифные документы")
    public void выбрать_Начисления_и_тарифные_документы() throws Throwable {
        driver.findElement(By.id("ext-comp-1065")).click(); //Клик на Начисления и тарифные документы
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
    }

    @When("Выбрали дату с {localdate}")
    public void выбрали_дату_с(LocalDate localdate) {
        //driver.findElement(By.name("ch_dt1")).sendKeys("localdate"); //css locators
        driver.findElement(By.cssSelector("div:nth-of-type(3) > input")).click();
        driver.findElement(By.cssSelector("div:nth-of-type(3) > input")).clear();
        driver.findElement(By.cssSelector("div:nth-of-type(3) > input")).sendKeys(localdate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))); //дата 01.09.2018 смотреть фичу
        //driver.findElement(By.xpath("//div[3]/input")).click(); //xpath locators
        //driver.findElement(By.xpath("//div[3]/input")).clear();
        //driver.findElement(By.xpath("//div[3]/input")).sendKeys(localdate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))); //дата 01.09.2018
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println(localdate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
    }

    @When("Клик Применить начисления")
    public void клик_Применить_начисления() throws Throwable {
        //driver.findElement(By.xpath("//div[3]/div/div/div/div/div/div/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[2]/em/button")).click(); //клик по "Применить"
        driver.findElement(By.id("ext-comp-1274")).click(); //№2 Клик по кнопке Применить
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
    }

    @Then("Список документов загрузился")
    public void список_документов_загрузился() {
        waitForPageLoadComplete(driver);
    }

    @Then("Выбрать счет")
    public void выбрать_счет() throws Throwable {
        //driver.findElement(By.cssSelector("div[class*=x-grid3-row]:nth-child(2)")).click(); //выбираем второй элемент в списке документов счетов
        //driver.findElement(By.cssSelector("div[class*=x-grid3-row]:nth-of-type(5)")).click(); //выбираем второй элемент в списке документов счетов
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
    }

    @Then("Загрузились комиссии за обработку документов")
    public void загрузились_комиссии_за_обработку_документов() {
        waitForPageLoadComplete(driver);
    }

    @Then("Клик Излишне начисленные комиссии")
    public void клик_Излишне_начисленные_комиссии() throws Throwable {
        driver.findElement(By.cssSelector("li:nth-of-type(2) > a:nth-of-type(2) > em > span > span")).click(); //css клик на связки BPM/CRM
        //driver.findElement(By.xpath("//li[2]/a[2]/em/span/span")).click(); // xpath клик на связки BPM/CRM
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        waitForPageLoadComplete(driver); //Ждем загрузку связок сафо
        Thread.sleep(5000);
    }

    @Then("Выбрать компанию")
    public void выбрать_компанию() throws Throwable {
        driver.findElement(By.cssSelector("div[class*=x-grid3-row]:nth-of-type(5)")).click(); //выбираем 5й элемент в списке документов счетов
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
    }

    @Then("Детализация загрузилась")
    public void детализация_загрузилась() {
        waitForPageLoadComplete(driver); //Ждем загрузку связок BPM/CRM
    }

    @Then("Клик на Начисления")
    public void клик_на_Начисления() throws Throwable {
        driver.findElement(By.cssSelector("li:nth-of-type(3) > a:nth-of-type(2) > em > span > span")).click(); //css клик на связки BPM/CRM
        //driver.findElement(By.xpath("//li[2]/a[2]/em/span/span")).click(); // xpath клик на контрагенты
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        waitForPageLoadComplete(driver); //Ждем загрузку связок BPM/CRM
        Thread.sleep(5000);
    }
}