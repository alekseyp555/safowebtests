package stepDef;

import appmanager.ApplicationManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;

@Description("Проверка модуля клиентский менеджер")
@Test
public class FaktorChems extends TestBase {

    private WebDriver driver = app.getDriver();

    public FaktorChems () throws Throwable {
        super();
        app.login("ABPak@sbfc.ru", "Makaka123");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
        app.waitForPageLoadComplete(ApplicationManager.driver);
        app.selectPusk(); //клик пуск
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        app.selectSpravochnik(); //выбор справочники
    }

    @Given("Выбрать факторинговые схемы")
    public void выбрать_факторинговые_схемы() throws InterruptedException {
        driver.findElement(By.id("ext-comp-1071")).click(); //Клик на фс
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
    }

    @When("Выбрать фс схему в списке")
    public void выбрать_фс_схему_в_списке() throws InterruptedException {
        driver.findElement(By.cssSelector("div[class*=x-grid3-row]:nth-child(5)")).click(); //выбираем 5 элемент в списке ФС
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
    }

    @Then("Свойства отобразились: Общие сведения, договоры, лимиты")
    public void свойства_отобразились_Общие_сведения_договоры_лимиты() throws InterruptedException {
        driver.findElement(By.xpath("//li[2]/a[2]/em/span/span")).click(); //Клик Договоры
        String tab2 = app.driver.findElement(By.xpath("//li[2]/a[2]/em/span/span")).getText();
        assertEquals("Договоры", tab2); //Проверяем вкладку Договоры
        System.out.println("Имя вкладки - " + tab2);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
        //app.driver.findElement(By.xpath("//div[2]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td/div")).click(); //клик номер договора
        //app.driver.findElement(By.xpath("//div[2]/div/div/div/div[2]/div[2]/div/div/div[2]/div")).click();
        //app.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        driver.findElement(By.xpath("//li[3]/a[2]/em/span/span")).click(); //Клик Лимиты
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
    }
}
