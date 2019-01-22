package stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

@Description("Проверка модуля BPM")
@Epic("Epic")
@Feature("Feature")
@Story("Story")
@Test(retryAnalyzer = MyRetry.class)
public class BPMTests extends TestBase {

    private WebDriver driver = app.getDriver();

    public BPMTests () throws Throwable {
        super();
        waitStandart();
        app.login();
        sleep(5000);
        app.waitForPageLoadComplete(driver);
        app.selectPusk(); //клик пуск
        app.selectOperaciy(); //выбрать операции
        //app.getOperationsHelper().selectOperaciy();
    }

    @Given("^Выбрать модуль BPM$")
    public void selectBPM() throws InterruptedException {
        waitStandart();
        click(By.id("ext-comp-1045")); //Клик на BPM
        sleep(5000);
    }

    @When("^Выбрать все заявки$")
    public void selectAllQueries() throws InterruptedException {
        waitStandart();
        app.zayavki_all();
        //String element = driver.findElement(By.cssSelector("div#ext-comp-2597> div > div > div > div > div > div > div > div:nth-child(5)")).getText();// css имя 5й компании в списке заявок
        //String element = driver.findElement(By.xpath("//div[@id='ext-comp-6017']/div/div/div/div/div/div/div[5]")).getText();//xpath имя 5й компании в списке заявок
        //System.out.println(element); //выведем имя 5й строки в списке
        //driver.findElement(By.cssSelector("div#ext-comp-6017 > div > div > div > div > div > div > div:nth-child(5)")).click(); //css клик на 5 заявку
        //driver.findElement(By.xpath("//div[@id='ext-comp-6017']/div/div/div/div/div/div/div[5]")).click(); //xpath клик на 5 заявку
        //mainBPM(); //возврат на стартовую BPM
        //driver.findElement(By.xpath("//span/span")).click();
        sleep(5000);
        app.startPageOperations(); //возврат на стартовую BPM
        app.zayavki_change();
        app.startPageOperations(); //возврат на стартовую BPM
        app.zayavki_active();
        app.waitForPageLoadComplete(driver);
    }

    @Then("^Загрузились все заявки$")
    public void loadAllQueries() throws InterruptedException {
        sleep(5000);
    }
}
