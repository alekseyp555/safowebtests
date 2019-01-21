package stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Description;

@Description("Проверка модуля Консолидированные группы")
public class InvividualPersonTests extends TestBase {

    private WebDriver driver = app.getDriver();

    public InvividualPersonTests() throws Throwable {
        super();
        waitStandart();
        app.login();
        sleep(5000);
        app.waitForPageLoadComplete(driver);
        app.selectPusk(); //клик пуск
        app.selectSpravochnik(); //выбрать справочники
    }

    @Given ("^Выбрать модуль Физические лица$")
    public void selectIndididualPerson () throws InterruptedException {
        waitStandart();
        click(By.id("ext-comp-1073")); //Клик на Физические лица
        sleep(5000);
      }


    @When("^Выбрать физическое лицо$")
    public void selectIndividualPersonList () {
        click(By.cssSelector(".x-btn-text.ico_m_filtr"));
        click(By.cssSelector(".x-panel-bwrap > div.x-panel-body.x-panel-body-noheader.x-panel-body-noborder > .x-grid3 > div > div > div.x-grid3-body > div:nth-child(5)"));
    }

    @Then("^Загрузились список лиц. общее. контрагент$")
    public void loadedInidividualPersonList () {
        if(driver.findElement(By.name("LASTNAME")).isDisplayed()) {
        click(By.cssSelector("#tabPanelPrivatePerson > div > div > div > ul > li:nth-child(2)"));
        }
    }

}
