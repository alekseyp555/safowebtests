package stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
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

    @When("Выбрали дату {localdate}")
    public void выбрали_дату_с(LocalDate localdate) throws Throwable{

        //driver.findElement(By.name("ch_dt1")).sendKeys("localdate"); //css locators
        driver.findElement(By.cssSelector("div:nth-of-type(3) > input")).click(); //css locators
        driver.findElement(By.cssSelector("div:nth-of-type(3) > input")).clear();
        //driver.findElement(By.cssSelector("div:nth-of-type(3) > input")).sendKeys(localdate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))); //дата 01.09.2018 смотреть фичу
        driver.findElement(By.xpath("//div[3]/img")).click(); //клик календарь
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ждем
        driver.findElement(By.cssSelector("td.x-date-left")).click(); //css locator клик 1 месяц назад
        driver.findElement(By.cssSelector("td.x-date-left")).click(); //css locator клик 2 месяц назад
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ждем

        //WebElement kalendar = driver.findElement(By.cssSelector("#ext-comp-1860")); //локатор для таблицы
        //WebElement kalendar = driver.findElement(By.id("ext-comp-1862")); //не работает
        WebElement kalendar = driver.findElement(By.xpath("//*[@id='ext-comp-1862']/ul/li/div/table/tbody")); //валидный xpath для календаря
        List <WebElement> rows = kalendar.findElements(By.tagName("tr"));
        List <WebElement> columns = kalendar.findElements(By.tagName("td"));
        for (WebElement cell: columns){
            //Select 10th Date
            if (cell.getText().equals("10")){
                cell.findElement(By.linkText("10")).click();
                break;
            }
        }
        //driver.findElement(By.cssSelector("div:nth-of-type(3) > input")).sendKeys("localdate"); //дата 01.09.2018 смотреть фичу
        //driver.findElement(By.cssSelector("div:nth-of-type(3) > input")).sendKeys("localdate");
        //driver.findElement(By.xpath("//div[3]/input")).click(); //xpath locators
        //driver.findElement(By.xpath("//div[3]/input")).clear();
        //driver.findElement(By.xpath("//div[3]/input")).sendKeys(localdate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))); //дата 01.09.2018
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
        System.out.println(localdate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))); //форматируем дату
    }

    @When("Клик Применить начисления")
    public void клик_Применить_начисления() throws Throwable {
        //driver.findElement(By.xpath("//div[3]/div/div/div/div/div/div/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[2]/em/button")).click(); //клик по "Применить"
        driver.findElement(By.id("ext-comp-1274")).click(); //№2 Клик по кнопке Применить
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
        waitForPageLoadComplete(driver);
        System.out.println("Нажали кнопку Применить");
    }

    @Then("Список документов загрузился")
    public void список_документов_загрузился() throws Throwable{
        Thread.sleep(5000);
    }

    @Then("Выбрать счет")
    public void выбрать_счет() throws Throwable {
        //driver.findElement(By.cssSelector("div[class*=x-grid3-row]:nth-child(2)")).click(); //выбираем второй элемент в списке документов счетов
        driver.findElement(By.cssSelector("div[class*=x-grid3-row]:nth-of-type(5)")).click(); //выбираем второй элемент в списке документов счетов
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
        waitForPageLoadComplete(driver);
    }

    @Then("Загрузились комиссии за обработку документов")
    public void загрузились_комиссии_за_обработку_документов() {
        waitForPageLoadComplete(driver);
    }

    @Then("Клик Излишне начисленные комиссии")
    public void клик_Излишне_начисленные_комиссии() throws Throwable {
        driver.findElement(By.cssSelector("li:nth-of-type(2) > a:nth-of-type(2) > em > span > span")).click(); //css клик на Излишне начисленные комиссии
        //driver.findElement(By.xpath("//li[2]/a[2]/em/span/span")).click(); // xpath клик на Излишне начисленные комиссии
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
        //waitForPageLoadComplete(driver); //Ждем загрузку комиссии
    }

    @Then("Выбрать компанию")
    public void выбрать_компанию() throws Throwable {
        //driver.findElement(By.cssSelector("div[class*=x-grid3-row]:nth-of-type(5)")).click(); //выбираем 5й элемент в списке документов счетов
        //driver.findElement(By.cssSelector("div[class*=x-grid3-row]:nth-child(2)")).click(); //выбираем 2й элемент в списке документов счетов
       // WebElement baseTable = driver.findElement(By.xpath("//div[5]/table/tbody/tr/td/div"));
       // List<WebElement> rows = baseTable.findElements(By.cssSelector("div[class*=x-grid3-row]"));
        //driver.findElement(By.xpath("//div[5]/table/tbody/tr/td/div")).click(); //xpath выбираем 5 элемент в таблице
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)=concat('ООО ', '\"', 'ЛУДИНГ', '\"', '')])[1]/following::div[3]")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
        waitForPageLoadComplete(driver); //Ждем загрузку компании
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