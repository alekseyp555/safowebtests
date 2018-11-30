package stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

@Description("Проверка модуля CRM")
@Test(retryAnalyzer = MyRetry.class)
public class CRMTests extends TestBase {

    private WebDriver driver = app.getDriver();

    public CRMTests () throws Throwable {
        super();
        app.login();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
        app.waitForPageLoadComplete(driver);
        app.selectPusk(); //клик пуск
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        app.selectOperaciy(); //выбрать операции
        //app.getOperationsHelper().selectOperaciy();
    }

    @Given("^Выбрать модуль CRM$")
    public void selectCRM() throws InterruptedException {
        driver.findElement(By.id("ext-comp-1046")).click(); //Клик на CRM
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
    }

    @When("^Выбрать ввод заявок, ручной ввод$")
    public void inputQuery() throws InterruptedException {
        WebElement inputRequest = driver.findElement(By.cssSelector("#addRequest"));
        assertEquals(inputRequest.getText(), "Ввод заявок");
        System.out.println(inputRequest.getText());
        inputRequest.click(); //клик на ввод заявок
        //driver.findElement(By.cssSelector("#addRequest")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
    }

    @Then("^Отобразились поля для ввода$")
    public void mainQueryForm() throws InterruptedException {
        WebElement actions = driver.findElement(By.cssSelector("#crm2-addRequest > div > div > div > table > tbody > tr > td > table > tbody > tr > td"));
        //driver.findElement(By.xpath("//div[2]/div/div/div/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/em/button")).click(); //клик действия
        System.out.println(actions.getText()); //имя кнопки
        actions.isDisplayed();
        actions.click(); //клик валидный локатор для кнопки "Действия"
        Thread.sleep(5000);
        //List<WebElement> li = driver.findElements(By.cssSelector("#ext-comp-7698 > ul > li > a > span"));
        //List<WebElement> li = driver.findElements(By.xpath("//div[19]/ul/li/a/span"));
        //li.get(1).click();//If there are only two such element, here 1 is index of 2nd element in list returned.
        //driver.findElement(By.xpath("//input[2]")).click(); //клик второе поля ввода
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        //Thread.sleep(5000);
    }

    @Then("^Выбрать рабочий список, выбрать 5й элемент$")
    public void selectWorkQuery() throws InterruptedException {
        app.startPageOperations(); //возврат на стартовую
        Thread.sleep(5000);
        WebElement workRequest = driver.findElement(By.cssSelector("#workList")); //Клик на рабочий список (ххх)
        System.out.println(workRequest.getText());
        workRequest.click(); //клик на ввод заявок
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
        //driver.findElement(By.xpath("//div[6]/table/tbody/tr/td[3]/div")).click(); //выбрать 6 элемент в списке
    }

    @Then("^Загрузилась информация по заявке$")
    public void loadedQueryInfo() throws InterruptedException {
        driver.findElement(By.cssSelector("#crm2-workList-main > div > div > div > div > div > div > div > div:nth-child(5)")).click(); //клик на 5й элемент в таблице
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[2]/div/div/div/div/ul/li/a[2]/em/span/span")).click();
        driver.findElement(By.xpath("//div[2]/div/div/div/div/ul/li[2]/a[2]/em/span/span")).click();
        driver.findElement(By.xpath("//li[4]/a[2]/em/span/span")).click();
        driver.findElement(By.xpath("//li[5]/a[2]/em/span/span")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
    }

    @Then("^Выбрать заявки в работе, выбрать 5й элемент$")
    public void selectActiveQueries() throws InterruptedException {
        app.startPageOperations(); //возврат на стартовую
        WebElement inProgressRequest = driver.findElement(By.cssSelector("#requestList")); //Клик на рабочий список (ххх)
        System.out.println(inProgressRequest.getText());
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        inProgressRequest.click(); //клик на ввод заявок
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("#crm2-requestList-main > div > div > div > div > div > div > div > div > div:nth-child(5)")).click(); //клик на 5й элемет в таблице
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
    }

    @Then("^Выбрать настройки$")
    public void selectSettings()   {
        app.startPageOperations(); //возврат на стартовую
        driver.findElement(By.cssSelector("#settings")).click(); //клик настройки
    }

    @Then("^Выбрать пользователи$")
    public void selectUser() throws InterruptedException {
        driver.findElement(By.cssSelector("#settingsUsers")).click(); //клик Пользователи
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
        WebElement element = driver.findElement(By.cssSelector("#crm2-settingsUsers > div > div > div > div > div > div > div:nth-child(5)"));//локатор 5го пользователя
        System.out.println(element.getText()); //имя 5го пользователя
        element.click(); //клик на 5го пользователя
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
    }

    @Then("^Выбрать настройка обработка заявок по email$")
    public void selectSettingsQueryByEmail() throws InterruptedException {
        app.startPageOperations(); //возврат на стартовую
        driver.findElement(By.cssSelector("#settings")).click(); //клик настройки
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        driver.findElement(By.cssSelector("#settingsRqsMail")).click(); //клик обработка заявок по email
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
        driver.findElement(By.name("MAIL_HOST")).click();
    }

    @Then("^Выбрать справочники$")
    public void selectSpravochniki() {
        app.startPageOperations(); //возврат на стартовую
        driver.findElement(By.cssSelector("#settings")).click(); //клик настройки
        driver.findElement(By.cssSelector("#settingsDict")).click(); //клик справочники
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        driver.findElement(By.cssSelector("#crm2-settingsDict > div > div > div > div > div > div > div > div > div > div:nth-child(5)")).click(); //клик на 5й элемент
        driver.findElement(By.xpath("//div[2]/div/div[2]/div/div/div[2]/div/div[5]/table/tbody/tr/td/div")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
    }
    @Then("^Выбрать отчеты$")
    public void selectReports() throws InterruptedException {
        app.startPageOperations(); //возврат на стартовую
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("#reportPage")).click(); //клик отчеты
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
    }
    @Then("^Загрузились отчеты$")
    public void loadedQueries() throws InterruptedException {
        //driver.findElement(By.xpath("//td/table/tbody[2]/tr/td/a/span")).click();
        driver.findElement(By.cssSelector("td > table > tbody:nth-of-type(2) > tr > td > a > span")).click(); //клик на отчет
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
    }

    @Then("^Выбрать руководство пользователя$")
    public void selectUserManual() throws InterruptedException {
        app.startPageOperations(); //возврат на стартовую
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        driver.findElement(By.cssSelector("#faqPage")).click(); //клик отчеты
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        driver.findElement(By.cssSelector("#crm2-faqPage > div > div > div > div > div > ul > div > li:nth-child(2)")).click(); //клик на форма рабочий список
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
    }

}
