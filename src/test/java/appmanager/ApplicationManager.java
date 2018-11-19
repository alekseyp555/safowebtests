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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private final Properties properties;
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    public static WebDriver driver;

    public ApplicationManager()  {
        this.driver = ApplicationManager.getDriver();
        properties = new Properties();
    }

    public static WebDriver getDriver () {
	    return driver;
    }

    public void logTestStart (Scenario scenario) {
        logger.info("Start test " +  scenario.getName());
    }
    public void logTestStop(Scenario scenario) {
        logger.info("Stop test " +  scenario.getName());
    }


    public void init(Scenario scenario) throws IOException {
        //public void init() {
        //указываем папку для драйвера
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
        ChromeOptions options = new ChromeOptions(); //
        options.addArguments("--start-maximized"); //браузер разворачиваем чтобы все элементы поместились
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //logger.info("Start test " +  scenario.getName());
        System.out.println("----------------------------------------------------");
        System.out.println("Starting - " + scenario.getName());
        System.out.println("----------------------------------------------------");
    }

    public void stop(Scenario scenario) {
        driver.quit();
        //logger.info("Stop test " +  scenario.getName() + " - " + scenario.getStatus());
        System.out.println("--------------------------------------------------");
        if (scenario.getStatus() != Result.Type.PASSED) {
            //System.out.println(scenario.getName() + " status - " + scenario.getStatus());
            logger.info("Scenario " + scenario.getName() + " status " + scenario.getStatus());
            //} else logger.info("Scenario " +  scenario.getName() + " status " + scenario.getStatus());
            //System.err.println(scenario.getName() + " status - " + scenario.getStatus());
            System.out.println("--------------------------------------------------");
        }
    }

    public void waitForPageLoadComplete(WebDriver driver) {
        new WebDriverWait(driver,30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) driver).executeScript("return document.readyState")
                .equals("complete"));
    }

    public void login() throws Throwable{
        //чтение данных из файла
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
        driver.get(properties.getProperty("web.baseUrl"));
        //driver.get("http://bugs-kz/login.html");
        driver.findElement(By.id("user")).click();
        driver.findElement(By.id("user")).clear();
        driver.findElement(By.id("user")).sendKeys(properties.getProperty("web.login"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(5000);
        driver.findElement(By.id("pass")).click();
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys( properties.getProperty("web.password"));
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
        WebElement kalendar = driver.findElement(By.xpath("//*[@id='ext-comp-1860']/ul/li/div/table/tbody")); //валидный xpath для календаря раньше был ext 1862!!!
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

    public void setDatepicker(WebDriver driver, String cssSelector, String date) {
        new WebDriverWait(driver, 30000).until(
                (WebDriver d) -> d.findElement(By.cssSelector(cssSelector)).isDisplayed());
        JavascriptExecutor.class.cast(driver).executeScript(
                String.format("$('%s').datepicker('setDate', '%s')", cssSelector, date));
    }

}
