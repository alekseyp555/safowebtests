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

import java.util.List;
import java.util.concurrent.TimeUnit;

@Description("Проверка модуля Документы для 1С-Бухгалтерии")
@Test(retryAnalyzer = MyRetry.class)
public class Dok1CTests extends TestBase {
    private WebDriver driver = app.getDriver();
    Actions act = new Actions(driver);
    JavascriptExecutor jse = (JavascriptExecutor) driver;

    public Dok1CTests () throws Throwable {
        super();
        app.login();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
        app.waitForPageLoadComplete(driver);
        app.selectPusk(); //клик пуск
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        app.selectOperaciy(); //выбрать операции
    }

    @Given("^Выбрать модуль Документы для 1С-Бухгалтерии$")
    public void selectDok1C() throws InterruptedException {
        driver.findElement(By.id("ext-comp-1047")).click(); //Клик на документы для 1с-бухгалтерии
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
    }

    @When("^Создать выписку с 10 декабря по 20 декабря$")
    public void requestDocs () throws InterruptedException {

    driver.findElement(By.cssSelector("td:nth-of-type(4) > table > tbody > tr:nth-of-type(2) > td:nth-of-type(2) > em > button.x-btn-text.ico_m_filtr")).click(); //клик на кнопку фильтр
        Thread.sleep(2000);

        WebElement dateFrom = driver.findElement(By.name("ch1_dt1"));
        dateFrom.click();
        dateFrom.clear();
        dateFrom.sendKeys("10.12.2018");

        act.sendKeys(Keys.TAB).build().perform(); //tab переход в поле дата ДО
        Thread.sleep(2000);

        WebElement dateTo = driver.findElement(By.name("ch1_dt2"));
        dateTo.sendKeys("20.12.2018");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[2]/div/div/div/div/div[2]/div/div/div/div/div/div/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/em/button")).click();
        Thread.sleep(2000);
        /*

        driver.findElement(By.cssSelector("td:nth-of-type(5) > table > tbody > tr:nth-of-type(2) > td:nth-of-type(2) > em > button")).click(); //клик на Создать
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы

        driver.findElement(By.xpath("//div[2]/div/div/div/div/div/div/form/div/div/div/div/div[2]/img")).click(); //клик на календарь от
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        app.setDateOperations();

        Actions act = new Actions(driver);
        act.sendKeys(Keys.TAB).build().perform(); //tab перезодит в поле дата ДО
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы

        act.sendKeys("11092018"); //ввод дата ДО
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//div[2]/div/div/div/div/div/div/form/div/div/div/div/div[4]/img")).click(); //клик на календарь до
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы

        //Actions act = new Actions(driver);
        for (int i = 0; i < 2; i++) {
            act.sendKeys(Keys.TAB).build().perform(); //иммитация нажатия TAB 3 раза
        }

        act.sendKeys(Keys.RETURN).build().perform();  //иммитация нажатия ENTER - кнопка Сформировать
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы

        act.sendKeys(Keys.RETURN).build().perform();
        //driver.findElement(By.xpath("//div[2]/div/div/div/div/div/div/form/div/div/div/div/div[2]/input")).clear();
        //driver.findElement(By.xpath("//div[2]/div/div/div/div/div/div/form/div/div/div/div/div[2]/input")).click();
       // driver.findElement(By.xpath("//div[2]/div/div/div/div/div/div/form/div/div/div/div/div[2]/input")).sendKeys("11.09.2018");
        Thread.sleep(5000);
        //driver.findElement(By.cssSelector("*[class^='x-window x-resizable-pinned']")).click();
        //driver.findElement(By.xpath("//div[34]/div[2]/div/div/div/div[2]/div/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[2]/em/button")).click(); //клик сформировать
        //driver.findElement(By.xpath("//div[2]/div/div/div/div/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[2]/em/button")).click();
        //driver.findElement(By.xpath("//div[2]/div/div/div/div/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[2]")).click(); //клик да
        app.waitForPageLoadComplete(driver);
        */
    }


    @Then ("^Документы отобразились$")
    public void loadedDocs() {
        WebDriverWait wait = new WebDriverWait(driver, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[5]/table/tbody/tr/td[2]/div")))); //ожидание 60с появления документов, 1с долго грузятся.
        driver.findElement(By.xpath("//div[5]/table/tbody/tr/td[2]/div")).click();
        app.waitForPageLoadComplete(driver);
    }

    @Then("^Выбрать Операционные переводы$")
    public void selectOperacionPerevody() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li:nth-of-type(2) > a:nth-of-type(2) > em > span > span")));
        driver.findElement(By.cssSelector("li:nth-of-type(2) > a:nth-of-type(2) > em > span > span")).click(); //выбрать операционные переводы
    }

    @Then("^Загрузились статусы$")
    public void lodedStatus() throws InterruptedException {
        driver.findElement(By.cssSelector
        ("#docs1c_stage > div > div > div > div > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2)")).click();//клик на 2й месяц
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
    }
}
