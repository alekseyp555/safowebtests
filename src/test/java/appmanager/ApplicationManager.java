package appmanager;

import cucumber.api.Result;
import cucumber.api.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    public static WebDriver driver;

    public ApplicationManager() {
        this.driver = ApplicationManager.getDriver();
    }

    public static WebDriver getDriver () {
	    return driver;
    }

    public void waitForPageLoadComplete(WebDriver driver) {
        new WebDriverWait(driver,30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) driver).executeScript("return document.readyState")
                .equals("complete"));
    }

    public void login(String username, String password) throws Throwable{
        driver.get("http://bugs-kz/login.html");
        driver.findElement(By.id("user")).click();
        driver.findElement(By.id("user")).clear();
        driver.findElement(By.id("user")).sendKeys(username);
        Thread.sleep(5000);
        driver.findElement(By.id("pass")).click();
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys(password);
        driver.findElement(By.xpath("//button")).click();
    }

    public void selectSpravochnik() {
        driver.findElement(By.cssSelector("#ext-comp-1059")).click(); //valid id
        //driver.findElement(By.id("ext-gen110")).click(); //not good xpath locator
        //driver.findElement(By.cssSelector("[class*=x-menu-list-item]:nth-of-type(6)")); //выбрать справочники
    }

    public void selectPusk() {
        //driver.findElement(By.xpath("//button[@id='ext-gen14']")).click();
        driver.findElement(By.cssSelector("#ext-comp-1003")).click(); //valid id
    }

    public void selectCalendarDate() {
        driver.findElement(By.xpath("//div[3]/img")).click(); //клик календарь
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ждем
        driver.findElement(By.cssSelector("td.x-date-left")).click(); //css locator клик 1 месяц назад - октябрь
        driver.findElement(By.cssSelector("td.x-date-left")).click(); //css locator клик 2 месяц назад - сентябрь
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ждем
        //WebElement kalendar = driver.findElement(By.cssSelector("#ext-comp-1860")); //локатор для таблицы
        //WebElement kalendar = driver.findElement(By.id("ext-comp-1862")); //не работает
        WebElement kalendar = driver.findElement(By.xpath("//*[@id='ext-comp-1862']/ul/li/div/table/tbody")); //валидный xpath для календаря
        List<WebElement> rows = kalendar.findElements(By.tagName("tr")); //поиск строк
        List <WebElement> columns = kalendar.findElements(By.tagName("td")); //поиск столбцов
        for (WebElement cell: columns){
            //Выбираем 10 число
            if (cell.getText().equals("10")){
                cell.findElement(By.linkText("10")).click();
                break;
            }
        }
    }
    public void init(Scenario scenario) {
    //public void init() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println("----------------------------------------------------");
        System.out.println("Starting - " + scenario.getName());
        System.out.println("----------------------------------------------------");
    }

    public void stop(Scenario scenario) {
        driver.quit();
        System.out.println("--------------------------------------------------");
        if (scenario.getStatus() == Result.Type.PASSED) {
          System.out.println(scenario.getName() + " Status - " + scenario.getStatus());
        } else System.err.println(scenario.getName() + " Status - " + scenario.getStatus());
        System.out.println("--------------------------------------------------");
    }
}
