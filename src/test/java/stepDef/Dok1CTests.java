package stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static javafx.scene.input.KeyCode.N;

@Description("Проверка модуля Документы для 1С-Бухгалтерии")
@Test(retryAnalyzer = MyRetry.class)
public class Dok1CTests extends TestBase {
    private WebDriver driver = app.getDriver();

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

    @When("^Создать выписку с 19 сентября$")
    public void requestDocs () throws InterruptedException {

        driver.findElement(By.cssSelector("td:nth-of-type(5) > table > tbody > tr:nth-of-type(2) > td:nth-of-type(2) > em > button")).click(); //клик на Создать
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        driver.findElement(By.xpath("//div[2]/div/div/div/div/div/div/form/div/div/div/div/div[2]/img")).click(); //клик на календарь
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы

        for (int i = 0; i < 3 ; i++) {
            driver.findElement(By.cssSelector("td.x-date-left")).click(); //click 3 times
            Thread.sleep(2000);
        }

        WebElement kalendarOperations = driver.findElement(By.cssSelector("li > div > table > tbody > tr:nth-child(2) > td > table > tbody")); //валидный xpath для календаря раньше был ext 1862!!!
        //List<WebElement> rows = kalendarOperations.findElements(By.tagName("tr")); //поиск строк
        List <WebElement> columns = kalendarOperations.findElements(By.tagName("td")); //поиск столбцов
        for (WebElement cell: columns){
            //Выбираем 11 число
            if (cell.getText().equals("11")){
                cell.findElement(By.linkText("11")).click();
                break;
            }
        }
        Actions act = new Actions(driver);
        for (int i = 0; i < 3; i++) {
            act.sendKeys(Keys.TAB).build().perform();
        }

        act.sendKeys(Keys.RETURN).build().perform();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);

        act.sendKeys(Keys.RETURN).build().perform();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        //driver.findElement(By.xpath("//div[2]/div/div/div/div/div/div/form/div/div/div/div/div[2]/input")).clear();
        //driver.findElement(By.xpath("//div[2]/div/div/div/div/div/div/form/div/div/div/div/div[2]/input")).click();
       // driver.findElement(By.xpath("//div[2]/div/div/div/div/div/div/form/div/div/div/div/div[2]/input")).sendKeys("11.09.2018");
        Thread.sleep(5000);
        //driver.findElement(By.cssSelector("*[class^='x-window x-resizable-pinned']")).click();
        //driver.findElement(By.xpath("//div[34]/div[2]/div/div/div/div[2]/div/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[2]/em/button")).click(); //клик сформировать
        //driver.findElement(By.xpath("//div[2]/div/div/div/div/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[2]/em/button")).click();
        //driver.findElement(By.xpath("//div[2]/div/div/div/div/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[2]")).click(); //клик да
        app.waitForPageLoadComplete(driver);
    }

    @Then ("^Документы отобразились$")
    public void loadedDocs() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[5]/table/tbody/tr/td[2]/div"))));
        driver.findElement(By.xpath("//div[5]/table/tbody/tr/td[2]/div")).click();
        app.waitForPageLoadComplete(driver);
    }

    @Then("^Выбрать Операционные переводы$")
    public void selectOperacionPerevody() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li:nth-of-type(2) > a:nth-of-type(2) > em > span > span")));
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
