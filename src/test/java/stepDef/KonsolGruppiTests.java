package stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Description;

@Description("Проверка модуля BPM")
public class KonsolGruppiTests extends TestBase {
    private WebDriver driver = app.getDriver();

    public KonsolGruppiTests() throws Throwable {
        super();
        waitStandart();
        app.login();
        Thread.sleep(5000);
        app.waitForPageLoadComplete(driver);
        app.selectPusk(); //клик пуск
        app.selectSpravochnik(); //выбрать операции
    }

    @Given("^Выбрать модуль Консолидированные группы$")
    public void selectKonsolGrupp() throws InterruptedException {
        waitStandart();
        click(By.id("ext-comp-1064")); //Клик на Консолидированные группы
        Thread.sleep(5000);
    }

    @When("^Выбрать консолидированную групу$")
    public void selectListKonsolGrupp() {
        if(driver.findElement(By.cssSelector(".x-grid3 > div > div > div.x-grid3-body")).isDisplayed()) {
            click(By.cssSelector(".x-grid3 > div > div > div.x-grid3-body > div.x-grid3-row:nth-child(4)"));
        }
    }

    @Then("^Загрузились общее, рейтинг, продуктовые лимиты$")
    public void loadedKonsolGrupp () {
        waitStandart();
        driver.findElement(By.name("NAME")).isDisplayed();
        click(By.xpath("//li[2]/a[2]/em/span/span"));
        driver.findElement(By.cssSelector("div.x-grid3-body > div.x-grid3-row.x-grid3-row-first.x-grid3-row-last")).isDisplayed();
        click(By.xpath("//li[3]/a[2]/em/span/span"));
        driver.findElement(By.cssSelector("div.x-grid3-body> div.x-grid3-row.x-grid3-row-first > table > tbody > tr > td:nth-child(3")).isDisplayed();
    }
}
