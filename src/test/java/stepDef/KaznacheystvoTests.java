package stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Feature;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Description("Проверка модуля Казначейство")
@Feature("Операции")
@Test(retryAnalyzer = MyRetry.class)
public class KaznacheystvoTests extends TestBase {
    private WebDriver driver = app.getDriver();
    JavascriptExecutor jse = (JavascriptExecutor)driver;
    Actions act = new Actions(driver);

    public KaznacheystvoTests () throws Throwable {
        super();
        waitStandart();
        app.login();
        sleep(5000);
        app.waitForPageLoadComplete(driver);
        app.selectPusk(); //клик пуск
        app.selectOperaciy(); //выбрать операции
    }

    @Given("^Выбрать модуль Казначейство$")
    public void selectKaznacheystvo() throws InterruptedException {
        waitStandart();
        click(By.id("ext-comp-1048")); //Клик на казначейство
        sleep(5000);
    }

    @When("^Выбрать источник$")
    public void selectIstochnik() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("div:nth-of-type(4) > table > tbody > tr > td:nth-of-type(2) > div")))); //ожидание 30c
        click(By.cssSelector("div:nth-of-type(4) > table > tbody > tr > td:nth-of-type(2) > div"));
    }

    @Then("^Транши отобразились$")
    public void loadedTransh() {
        waitStandart();
        System.out.println(driver.findElement(By.cssSelector("div:nth-of-type(4) > table > tbody > tr > td:nth-of-type(2) > div")).getText());
    }

    @Then("Выбрать транши по заявкам")
    public void selectTranshRequest() throws InterruptedException {
        click(By.cssSelector("li:nth-of-type(2) > a:nth-of-type(2) > em > span > span")); //клик транши по заявкам
        waitStandart();

        //driver.findElement(By.name("ch1_dt1")).clear();
        //driver.findElement(By.name("ch1_dt1")).sendKeys("11092018");
        click(By.xpath("//div[2]/img")); //клик календарь
        app.setDateOperations(); //дата ОТ
        sleep(2000);

        //driver.findElement(By.xpath("//div[3]/img")).click();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //ожидание загрузки страницы
        //Thread.sleep(2000);
        //app.setDateOperations();
        act.sendKeys(Keys.TAB).build().perform(); //tab переходит в поле дата ДО
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        sleep(2000);

        jse.executeScript("document.getElementsByName('ch2_dt1')[0].value='12.10.2018'"); //передаем дату в поле

        sleep(2000);
    }

    @Then("Транш по заявкам загрулись")
    public void loadedTranshRequest() throws InterruptedException {
        waitStandart();
        click(By.xpath("//div[3]/div/div/div/div[2]/img")); //клик статус транша

        sleep(2000);
        //driver.findElement(By.xpath("//div[64]/div/div[4]")).click(); //xpath
        click(By.cssSelector("div.x-combo-list-item:nth-child(4)")); //Клик действующий статус
        //driver.findElement(By.cssSelector("div:nth-of-type(64) > div > div:nth-child(4)")).click(); //css

        //driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Применить'])[2]/preceding::td[5]")).click();
        click(By.xpath("//div[2]/div/div/div/div/div/div/div/div/div/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/em/button"));
        //driver.findElement(By.xpath("//div[2]/div/div/div/div/div/div/div/div/div/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td[2]")).click();

        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[2]/div")))); //ожидание 10c
        click(By.xpath("//div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[2]/div"));
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

    @Then ("^Выбрать корзину Траншей$")
            public void selectKorzinaTransh () throws InterruptedException {
        click(By.xpath("//li[4]/a[2]/em/span/span")); //клик корзина траншей
        waitStandart();
        click(By.xpath
                ("//div[2]/div/div/div/div/div/div/div[2]/div/div/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[2]/em/button")); //клик на фильтр

        //WebElement dateFrom = driver.findElement(By.name("ch1_dt1"));
        List<WebElement> dateFrom = driver.findElements(By.xpath("//div[2]/div/div/div/div/div/div[2]/div/div[2]/div/div/form/div/div/div/div/div[2]/input"));
        dateFrom.get(0).click(); //выбрать первый элемент из списка
        //WebElement dateFrom = driver.findElement(By.cssSelector("[name=ch1_dt1]"));
        dateFrom.get(0).clear();

        jse.executeScript("arguments[0].value='" + "10.12.2018" + "';", dateFrom.get(0)); //передаем дату в поле ОТ
        //dateFrom.get(0).sendKeys("10122018");
        sleep(2000);

        act.sendKeys(Keys.TAB).build().perform(); //tab переход в поле дата ДО
        sleep(2000);

        //WebElement dateTo = driver.findElement(By.name("ch1_dt2"));
        List <WebElement> dateTo = driver.findElements(By.xpath("//div[2]/div/div/div/div/div/div[2]/div/div[2]/div/div/form/div/div/div/div/div[4]/input"));
        dateTo.get(0).sendKeys("11122018");
        sleep(2000);

        click(By.xpath
                ("//div[2]/div/div/div/div/div/div[2]/div/div/div/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[2]/em/button")); //клик применить
        sleep(2000);
    }

    @Then ("^Корзина траншей загрузилась$")
    public void loadedKorzinaTransh () {

    }

    @Then("^Выбрать платежи$")
    public void selectPayment() throws InterruptedException {
        click(By.xpath("//li[5]/a[2]/em/span/span")); //клик платежи
        waitStandart();
        click(By.xpath("//div[5]/div/div/div[2]/div/form/div[2]/div/div/div/div/input")); //клик чекбокс диапазон дат
        sleep(2000);

        act.sendKeys(Keys.TAB).build().perform(); //tab переход в поле дата ОТ
        WebElement dateFrom = driver.findElement(By.xpath("//div[5]/div/div/div[2]/div/form/div[2]/div/div/div/div[2]/input"));
        dateFrom.clear();
        //dateFrom.sendKeys("01012018");
        jse.executeScript("arguments[0].value='" + "01012018" + "';", dateFrom); //передаем дату в поле JN
        //dateFrom.sendKeys(date());
        sleep(2000);

        act.sendKeys(Keys.TAB).build().perform(); //tab переход в поле дата ДО
        sleep(2000);

        WebElement dateTo = driver.findElement(By.xpath("//div[5]/div/div/div[2]/div/form/div[2]/div/div/div/div[3]/input"));
        dateTo.clear();
        jse.executeScript("arguments[0].value='" + "10.01.2018" + "';", dateTo); //передаем дату в поле ДО
        //act.sendKeys(Keys.TAB).build().perform(); //tab перезодит в поле дата ДО
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //ожидание загрузки страницы
        //driver.findElement(By.xpath("//div[4]/div/div/div[2]/div/form/div[2]/div/div/div/div[3]/input")).sendKeys("10012018"); //дата ДО
        //driver.findElement(By.name("dt2")).clear();
        //act.sendKeys("10012018"); //ввод дата ДО
        sleep(2000);

        click(
                By.cssSelector("div:nth-of-type(5) > div > div > div:nth-of-type(2) > div > div > div > table > tbody > tr > td:nth-of-type(2) > table > tbody > tr > td > table > tbody > tr > td > table > tbody > tr:nth-of-type(2) > td:nth-of-type(2) > em > button.x-btn-text.ico_m_filtr"));
        sleep(3000);
        //driver.findElement(By.xpath
        //        ("//div[4]/div/div/div[2]/div/div/div/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/em/button")).click(); //Клик применить
    }

    @Then("Платежи отобразились")
    public void loadPayment() {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
                ("#fndrv_pay_card1 > div > div > div > div > div > div > div > div:nth-child(2) > div > div:nth-child(4)")))); //ожидание загрузки списка платежей
        //wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[4]/div/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[2]/table/tbody/tr/td[3]/div")))); //ожидание 30c
        click(By.cssSelector("#fndrv_pay_card1 > div > div > div > div > div > div > div > div:nth-child(2) > div > div:nth-child(4)"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[5]/div/div/div/div/div/div[2]/div/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[2]/div"))); //клик информация платежи
        System.out.println(driver.findElement(By.xpath(("//div[5]/div/div/div/div/div/div[2]/div/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[2]/div"))).getText());
    }

    @Then("Выбрать маржа")
    public void selectMarja() {
        waitStandart();
        click(By.xpath("//li[6]/a[2]/em/span/span")); //выбрать маржу
        click(By.xpath("//div/table/tbody/tr[2]/td[2]/em/button")); //клик применить
    }

    @Then("Маржа отобразилась")
    public void loadMarja() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(("#fndr2_tab2_1 > div > div > div:nth-child(2) > div > div:nth-child(2) > div > div > div > div > div:nth-child(5)")))); //клик информация маржа
        System.out.println(driver.findElement(By.cssSelector(("#fndr2_tab2_1 > div > div > div:nth-child(2) > div > div:nth-child(2) > div > div > div > div > div:nth-child(5)"))).getText()); //имя маржа
        click(By.cssSelector(("#fndr2_tab2_1 > div > div > div:nth-child(2) > div > div:nth-child(2) > div > div > div > div > div:nth-child(5)"))); //клик
        sleep(2000);
    }

    @Then("Выбрать платежный календарь")
    public void selectPaymentCalendar() {
        click(By.xpath("//li[7]/a[2]/em/span/span")); //выбрать платежный календарь
        waitStandart();
        //driver.findElement(By.cssSelector("#fnd_calndar_panel-month-wk-1 > table.ext-cal-bg-tbl > tbody > tr > td:nth-child(3)")).click(); //клик на платежный календарь
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("#fnd_calndar_panel-month-wk-1 > table.ext-cal-evt-tbl > tbody > tr:nth-child(3) > td:nth-child(3)"))); //клик платеж
        click(By.cssSelector(("#fnd_calndar_panel-month-wk-1 > table.ext-cal-evt-tbl > tbody > tr:nth-child(3) > td:nth-child(3)"))); //клик на платеж
    }

    @Then("Выбрать справочник банков")
    public void selectSprBank() {
        waitStandart();
        click(By.xpath("//li[8]/a[2]/em/span/span")); //выбрать платежный календарь
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement bank = driver.findElement(By.cssSelector("#fndr_tab5 > div > div > div > div > div > div > div:nth-child(5)"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#fndr_tab5 > div > div > div > div > div > div > div:nth-child(5)")));
        System.out.println(bank.getText()); //имя банка
        bank.click(); //клик 5й банк в списке
    }
}
