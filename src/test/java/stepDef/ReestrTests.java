package stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Description("Проверка модуля Реестры")
@Test(retryAnalyzer = MyRetry.class)
public class ReestrTests extends TestBase {
    private WebDriver driver = app.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 30);
    Actions act = new Actions(driver);
    JavascriptExecutor jse = (JavascriptExecutor) driver;

    public ReestrTests() throws Throwable {
        super();
        app.login();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
        app.waitForPageLoadComplete(driver);
        app.selectPusk(); //клик пуск
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        app.selectOperaciy(); //выбрать операции
    }

    @Given("^Выбрать модуль Реестры$")
    public void selectRegress() throws InterruptedException {
        driver.findElement(By.id("ext-comp-1054")).click(); //Выбрать Регресс
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
        ;
    }

    @When("^Выбрать дату реестра$")
    public void filterReest() throws InterruptedException {
        driver.findElement(By.xpath("//div[3]/div/div/div/div/input")).click();

        act.sendKeys(Keys.TAB).build().perform(); //tab переход в поле дата ОТ
        Thread.sleep(2000);

        WebElement dateFrom = driver.findElement(By.cssSelector("[name=ch2_dt1]"));
        dateFrom.sendKeys("18112018");

        act.sendKeys(Keys.TAB).build().perform(); //tab переход в поле дата ДО
        Thread.sleep(2000);

        WebElement dateTo = driver.findElement(By.cssSelector("[name=ch2_dt2]"));
        dateTo.sendKeys("19112018");
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("#rr_p2 > div > div.x-tab-panel-bbar.x-tab-panel-bbar-noborder > div > table > tbody > tr > td> table > tbody > tr > td:nth-child(3)")).click(); //клик применить
        Thread.sleep(3000);
    }

    @Then("^Реестры отображаются$")
    public void loadedReestr () throws InterruptedException {
        List<WebElement> elements = driver.findElements(By.cssSelector("div > div > table > tbody > tr > td.x-grid3-col.x-grid3-cell.x-grid3-td-1 > div.x-grid3-cell-inner.x-grid3-col-1.x-unselectable"));
        if (elements.get(0).isDisplayed()) {
            System.out.println(elements.get(0).getText());
            elements.get(0).click(); //выбрать первый элемент из списка
        }
        Thread.sleep(3000);
    }

    @Then ("^Выбрать реестры ПП$")
    public void selectReestrPP () throws InterruptedException {
        driver.findElement(By.cssSelector("li.x-tab-with-icon:nth-child(2)")).click(); //клик на реестры ПП
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы

        List<WebElement> elements = driver.findElements(By.xpath("//div[2]/div/div/div/div[2]/div/div/div/form/div[3]/div/div/div/div/input"));
        if (elements.get(0).isDisplayed()) {
            elements.get(0).click(); //выбрать первый элемент из списка
        }
        //driver.findElement(By.xpath("//div[2]/div/div/div/div[2]/div/div/div/form/div[3]/div/div/div/div/input")).click();
        act.sendKeys(Keys.TAB).build().perform(); //tab переход в поле дата ОТ
        Thread.sleep(2000);

        WebElement dateFrom = elements.get(1);
        dateFrom.sendKeys("01122018");

        act.sendKeys(Keys.TAB).build().perform(); //tab переход в поле дата ДО
        Thread.sleep(2000);

        WebElement dateTo = elements.get(2);
        dateTo.sendKeys("10122018");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[2]/div/div/div/div[2]/div[2]/div/table/tbody/tr/td/table/tbody/tr/td[3]/table/tbody/tr[2]/td[2]/em/button")).click(); //клик применить
        Thread.sleep(2000);

        List<WebElement> elementsPP = driver.findElements
                (By.cssSelector("div > div > table > tbody > tr > td.x-grid3-col.x-grid3-cell.x-grid3-td-0.x-grid3-cell-first > div.x-grid3-cell-inner.x-grid3-col-0.x-unselectable"));
        if (elementsPP.get(0).isDisplayed()) {
            System.out.println(elementsPP.get(0).getText());
            elementsPP.get(0).click(); //выбрать первый элемент из списка
        }
        Thread.sleep(2000);
    }

    @Then ("^Выбрать заявки$")
    public void selectQuery () throws InterruptedException {
        driver.findElement(By.cssSelector("li.x-tab-with-icon:nth-child(3)")).click(); //клик на заявки
        Thread.sleep(3000);

        WebElement dateFrom = driver.findElement(By.xpath("//div[3]/div/div/div/div/div/div/div/form/div[2]/div/div/div/div[2]/input"));
        jse.executeScript("arguments[0].value='" + "01.12.2018" + "';", dateFrom); //передаем дату в поле ОТ
        //dateFrom.sendKeys("01122018");

        act.sendKeys(Keys.TAB).build().perform(); //tab переход в поле дата ДО
        Thread.sleep(2000);

        WebElement dateTo = driver.findElement(By.xpath("//div[3]/div/div/div/div/div/div/div/form/div[2]/div/div/div/div[3]/input"));
        //dateTo.sendKeys("10122018");
        jse.executeScript("arguments[0].value='" + "10.12.2018" + "';", dateTo); //передаем дату в поле ОТ
        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[3]/div/div/div/div/div[2]/div/table/tbody/tr/td/table/tbody/tr/td[3]/table/tbody/tr[2]/td[2]/em/button")).click(); //клик применить
        Thread.sleep(2000);

        driver.findElement (By.cssSelector("div > div.x-grid3-row.x-grid3-row-first.x-grid3-row-selected > table > tbody > tr > td.x-grid3-col.x-grid3-cell.x-grid3-td-3 > div"));
        System.out.println(driver.findElement
                (By.cssSelector("div > div.x-grid3-row.x-grid3-row-first.x-grid3-row-selected > table > tbody > tr > td.x-grid3-col.x-grid3-cell.x-grid3-td-3 > div")).getText());
    }

    @Then ("^Выбрать Исключенные заявки$")
    public void selectExcludedQuery () throws InterruptedException {
        List<WebElement> elements = driver.findElements(By.xpath("//li[4]/a[2]/em/span/span")); //клик исключенные заявки
        if (elements.get(0).isDisplayed()) {
            System.out.println(elements.get(0).getText());
            elements.get(0).click(); //выбрать первый элемент из списка
        } Thread.sleep(3000);
    }
}