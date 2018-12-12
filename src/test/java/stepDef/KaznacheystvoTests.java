package stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

@Description("Проверка модуля Документы для 1С-Бухгалтерии")
@Test(retryAnalyzer = MyRetry.class)
public class KaznacheystvoTests extends TestBase {
    private WebDriver driver = app.getDriver();
    JavascriptExecutor jse = (JavascriptExecutor)driver;
    Actions act = new Actions(driver);

    public KaznacheystvoTests () throws Throwable {
        super();
        app.login();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
        app.waitForPageLoadComplete(driver);
        app.selectPusk(); //клик пуск
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        app.selectOperaciy(); //выбрать операции
    }

    @Given("^Выбрать модуль Казначейство$")
    public void selectKaznacheystvo() throws InterruptedException {
        driver.findElement(By.id("ext-comp-1048")).click(); //Клик на казначейство
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
    }

    @When("^Выбрать источник$")
    public void selectIstochnik() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("div:nth-of-type(4) > table > tbody > tr > td:nth-of-type(2) > div")))); //ожидание 10c
        driver.findElement(By.cssSelector("div:nth-of-type(4) > table > tbody > tr > td:nth-of-type(2) > div")).click();
    }

    @Then("^Транши отобразились$")
    public void loadedTransh() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //ожидание загрузки страницы
        System.out.println(driver.findElement(By.cssSelector("div:nth-of-type(4) > table > tbody > tr > td:nth-of-type(2) > div")).getText());
    }

    @Then("Выбрать транши по заявкам")
    public void selectTranshRequest() throws InterruptedException {
        driver.findElement(By.cssSelector("li:nth-of-type(2) > a:nth-of-type(2) > em > span > span")).click(); //клик транши по заявкам
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //ожидание загрузки страницы

        //driver.findElement(By.name("ch1_dt1")).clear();
        //driver.findElement(By.name("ch1_dt1")).sendKeys("11092018");
        driver.findElement(By.xpath("//div[2]/img")).click(); //клик календарь
        app.setDateOperations();
        Thread.sleep(2000);

        //driver.findElement(By.xpath("//div[3]/img")).click();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //ожидание загрузки страницы
        //Thread.sleep(2000);
        //app.setDateOperations();
        act.sendKeys(Keys.TAB).build().perform(); //tab переходит в поле дата ДО
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(2000);

        jse.executeScript("document.getElementsByName('ch2_dt1')[0].value='11092018'"); //передаем дату в поле

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(2000);
    }

    @Then("Транш по заявкам загрулись")
    public void loadedTranshRequest() throws InterruptedException {
        driver.findElement(By.xpath("//div[3]/div/div/div/div[2]/img")).click(); //клик статус транша
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //ожидание загрузки страницы

        Thread.sleep(2000);
        //driver.findElement(By.xpath("//div[64]/div/div[4]")).click(); //xpath
        driver.findElement(By.cssSelector("div.x-combo-list-item:nth-child(4)")).click(); //Клик действующий статус
        //driver.findElement(By.cssSelector("div:nth-of-type(64) > div > div:nth-child(4)")).click(); //css

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //ожидание загрузки страницы
        //driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Применить'])[2]/preceding::td[5]")).click();
        driver.findElement(By.xpath("//div[2]/div/div/div/div/div/div/div/div/div/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/em/button")).click();
        //driver.findElement(By.xpath("//div[2]/div/div/div/div/div/div/div/div/div/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td[2]")).click();

        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[2]/div")))); //ожидание 10c
        driver.findElement(By.xpath("//div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[2]/div")).click();
    }

    /*
    @Then("Выбрать транши к погашению")
    public void выбрать_транши_к_погашению() throws InterruptedException {
        driver.findElement(By.cssSelector("li:nth-of-type(3) > a:nth-of-type(2) > em > span > span")).click(); //клик на транши к пошагению
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //ожидание загрузки страницы

        jse.executeScript("document.getElementsByName('dt1')[0].value='01092018'"); //передаем дату в поле ОТ
        Thread.sleep(2000);
        jse.executeScript("document.getElementsByName('dt2')[0].value='03092018'"); //передаем дату в поле ДО
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[3]/div/div/div[2]/div/div/div/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/em/button")).click(); //Клик применить

        //WebDriverWait wait = new WebDriverWait(driver, 30);
        //wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[3]/div/div/div/div/div/div/div/div[2]/div/div/div[2]")))); //ожидание 30c
        //app.waitForPageLoadComplete(driver);
        Thread.sleep(5000);
    }
    */

    @Then("^Выбрать платежи$")
    public void selectPayment() throws InterruptedException, ParseException {
        driver.findElement(By.xpath("//li[4]/a[2]/em/span/span")).click(); //клик платежи
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //ожидание загрузки страницы
        driver.findElement(By.xpath("//div[4]/div/div/div[2]/div/form/div[2]/div/div/div/div/input")).click(); //клик чекбокс диапазон дат
        Thread.sleep(2000);

        act.sendKeys(Keys.TAB).build().perform(); //tab переход в поле дата ОТ
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //ожидание загрузки страницы
        WebElement dateFrom = driver.findElement(By.xpath("//div[4]/div/div/div[2]/div/form/div[2]/div/div/div/div[2]/input"));
        dateFrom.clear();
        //dateFrom.sendKeys("01012018");
        jse.executeScript("arguments[0].value='" + "01012018" + "';", dateFrom); //передаем дату в поле JN
        //dateFrom.sendKeys(date());
        Thread.sleep(2000);

        act.sendKeys(Keys.TAB).build().perform(); //tab переход в поле дата ДО
        Thread.sleep(2000);

        WebElement dateTo = driver.findElement(By.xpath("//div[4]/div/div/div[2]/div/form/div[2]/div/div/div/div[3]/input"));
        dateTo.clear();
        jse.executeScript("arguments[0].value='" + "10.01.2018" + "';", dateTo); //передаем дату в поле ДО
        //act.sendKeys(Keys.TAB).build().perform(); //tab перезодит в поле дата ДО
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //ожидание загрузки страницы
        //driver.findElement(By.xpath("//div[4]/div/div/div[2]/div/form/div[2]/div/div/div/div[3]/input")).sendKeys("10012018"); //дата ДО
        //driver.findElement(By.name("dt2")).clear();
        //act.sendKeys("10012018"); //ввод дата ДО
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы

        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Применить'])[4]/preceding::td[3]")).click();
        Thread.sleep(5000);
        //driver.findElement(By.xpath
        //        ("//div[4]/div/div/div[2]/div/div/div/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/em/button")).click(); //Клик применить
    }

    @Then("Платежи отобразились")
    public void loadPayment() {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
                ("#fndrv_pay_card1 > div > div > div > div > div > div > div > div:nth-child(2) > div > div:nth-child(4)")))); //ожидание загрузки списка платежей
        //wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[4]/div/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[2]/table/tbody/tr/td[3]/div")))); //ожидание 30c
        driver.findElement(By.cssSelector("#fndrv_pay_card1 > div > div > div > div > div > div > div > div:nth-child(2) > div > div:nth-child(4)")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[4]/div/div/div/div/div/div[2]/div/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[2]/div"))); //клик информация платежи
        System.out.println(driver.findElement(By.xpath(("//div[4]/div/div/div/div/div/div[2]/div/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[2]/div"))).getText());
    }

    @Then("Выбрать маржа")
    public void selectMarja() {
        driver.findElement(By.xpath("//li[5]/a[2]/em/span/span")).click(); //выбрать маржу
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        driver.findElement(By.xpath("//div/table/tbody/tr[2]/td[2]/em/button")).click(); //клик применить
    }

    @Then("Маржа отобразилась")
    public void loadMarja() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(("#fndr2_tab2_1 > div > div > div:nth-child(2) > div > div:nth-child(2) > div > div > div > div > div:nth-child(5)")))); //клик информация маржа
        System.out.println(driver.findElement(By.cssSelector(("#fndr2_tab2_1 > div > div > div:nth-child(2) > div > div:nth-child(2) > div > div > div > div > div:nth-child(5)"))).getText()); //имя маржа
        driver.findElement(By.cssSelector(("#fndr2_tab2_1 > div > div > div:nth-child(2) > div > div:nth-child(2) > div > div > div > div > div:nth-child(5)"))).click(); //клик
        Thread.sleep(2000);
    }

    @Then("Выбрать платежный календарь")
    public void selectPaymentCalendar() {
        driver.findElement(By.xpath("//li[6]/a[2]/em/span/span")).click(); //выбрать платежный календарь
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        driver.findElement(By.cssSelector("#fnd_calndar_panel-month-evt-55-1")).click(); //клик на платежный календарь
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(("div:nth-of-type(2) > div > div:nth-of-type(2) > div > div:nth-of-type(2) > div > div > div:nth-of-type(2) > div > div:nth-of-type(5)")))); //клик платеж
        driver.findElement(By.cssSelector(("div:nth-of-type(2) > div > div:nth-of-type(2) > div > div:nth-of-type(2) > div > div > div:nth-of-type(2) > div > div:nth-of-type(5)"))).click(); //клик на платеж
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
    }

    @Then("Выбрать справочник банков")
    public void selectSprBank() {
        driver.findElement(By.xpath("//li[7]/a[2]/em/span/span")).click(); //выбрать платежный календарь
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement bank = driver.findElement(By.cssSelector("#fndr_tab5 > div > div > div > div > div > div > div:nth-child(5)"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#fndr_tab5 > div > div > div > div > div > div > div:nth-child(5)")));
        System.out.println(bank.getText()); //имя банка
        bank.click(); //клик 5й банк в списке
    }
}
