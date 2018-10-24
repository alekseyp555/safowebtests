package stepDef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utility.Hook;

import java.util.concurrent.TimeUnit;


public class LoginValidTests extends TestBase {

    private WebDriver driver;

    public LoginValidTests() {
        this.driver = Hook.getDriver();
    }

    @Given("navigate to SAFO web page")
    public void navigate_to_SAFO_web_page() {
        driver.get("http://bugs-kz/login.html");
    }

    @And("^I validate login field$")
    public void i_enter_login()  {
        Assert.assertTrue(driver.findElement(By.name("user")).isDisplayed());
    }

    @And("^I validate password field$")
    public void i_enter_password()  {
        Assert.assertTrue(driver.findElement(By.name("pass")).isDisplayed());
    }

    @When("user logged using username as \"([^\"]*)\" as password \"([^\"]*)\"")
    public void user_logged_using_username_as_as_password(String username, String password) throws Throwable {
        driver.findElement(By.id("user")).click();
        driver.findElement(By.id("user")).clear();
        driver.findElement(By.id("user")).sendKeys("ABPak@sbfc.ru");
        driver.findElement(By.id("pass")).click();
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys("Makaka123");
        driver.findElement(By.xpath("//button")).click();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
        waitForPageLoadComplete(driver);
    }

    @Then("^title SAFO modules page should be displayed$")
    public void title_SAFO_modules_page_should_be_displayed()  {
        System.out.println("Your page title is : " +driver.getTitle());
        Assert.assertEquals("SmartFactor v5.5.0.20170818 (Релизная среда тестирования)", driver.getTitle());
        //Assert.assertTrue(driver.findElement(By.id("ext-comp-")).isDisplayed());
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
}
