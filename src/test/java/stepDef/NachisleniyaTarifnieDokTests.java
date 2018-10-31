package stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class NachisleniyaTarifnieDokTests extends TestBase{

    public NachisleniyaTarifnieDokTests () throws Throwable {
        super();
        login();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
        waitForPageLoadComplete(driver);
        selectPusk(); //клик пуск
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        selectSpravochnik(); //выбор справочники
    }

    @Given("Выбрать Начисления и тарифные документы")
    public void выбрать_Начисления_и_тарифные_документы() throws Throwable {
        driver.findElement(By.id("ext-comp-1065")).click(); //Клик на Начисления и тарифные документы
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
    }

    @When("Выбрали дату с {localdate}")
    public void выбрали_дату_с(LocalDate localdate) {
        System.out.println(localdate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }

    @Then("Список документов загрузился")
    public void список_документов_загрузился() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("Выбрать счет")
    public void выбрать_счет() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("Загрузились комиссии за обработку документов")
    public void загрузились_комиссии_за_обработку_документов() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("Клик Излишне начисленные комиссии")
    public void клик_Излишне_начисленные_комиссии() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("Выбрать компанию")
    public void выбрать_компанию() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("Детализация загрузилась")
    public void детализация_загрузилась() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("Клик на Начисления")
    public void клик_на_Начисления() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }
}