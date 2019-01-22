package stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

@Description("Проверка модуля клиентский менеджер")
@Feature("Справочники")
@Test
public class FaktorChems extends TestBase {
    //private ChromeDriver driver;
    private WebDriver driver = app.getDriver();

    public FaktorChems () throws Throwable {
        super();
        waitStandart();
        app.login();
        sleep(5000);
        app.waitForPageLoadComplete(driver);
        app.selectPusk(); //клик пуск
        app.selectSpravochnik(); //выбор справочники
    }

    @Given("Выбрать факторинговые схемы")
    public void selectFS() throws InterruptedException {
        waitStandart();
        click(By.id("ext-comp-1072")); //Клик на фс
        sleep(3000);
    }

    @When("Выбрать фс схему в списке")
    public void selectFSList() throws InterruptedException {
        waitStandart();
        click(By.cssSelector("div[class*=x-grid3-row]:nth-child(5)")); //выбираем 5 элемент в списке ФС
        sleep(5000);
    }

    @Then("Свойства отобразились: Общие сведения, договоры, лимиты")
    public void loadedInfoFS() throws InterruptedException {
        click(By.xpath("//li[2]/a[2]/em/span/span")); //Клик Договоры
        String tab2 = driver.findElement(By.xpath("//li[2]/a[2]/em/span/span")).getText();
        assertEquals("Договоры", tab2); //Проверяем вкладку Договоры
        System.out.println("Имя вкладки - " + tab2);
        waitStandart();
        sleep(3000);
        //app.driver.findElement(By.xpath("//div[2]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td/div")).click(); //клик номер договора
        //app.driver.findElement(By.xpath("//div[2]/div/div/div/div[2]/div[2]/div/div/div[2]/div")).click();
        //app.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        click(By.xpath("//li[3]/a[2]/em/span/span")); //Клик Лимиты
    }
}
