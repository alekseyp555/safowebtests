package appmanager;

import cucumber.api.Result;
import cucumber.api.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import stepDef.MyTestListener;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@Listeners(MyTestListener.class)
public class ApplicationManager {

    public static ChromeDriver driver;
    //ChromeDriver driver;

    public ApplicationManager()  {
        this.driver = ApplicationManager.getDriver();
        properties = new Properties();
    }

    private SpravochnikHelper spravochnikHelper;
    private OperationsHelper operationsHelper;

    public SpravochnikHelper getSpravochnikHelper() {
        return spravochnikHelper;
    }
    public OperationsHelper getOperationsHelper() { return operationsHelper; }

    private final Properties properties;

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    public static ChromeDriver getDriver () {
	    return driver;
    }

    public void logTestStart (Scenario scenario) {
        logger.info("Start test " +  scenario.getName());
    }
    public void logTestStop(Scenario scenario) {
        logger.info("Stop test " +  scenario.getName());
    }

    public byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public void init(Scenario scenario) {
        //public void init() {
        //указываем папку для драйвера
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
        ChromeOptions options = new ChromeOptions(); ////браузер разворачиваем чтобы все элементы поместились
        options.addArguments("--start-maximized"); //браузер разворачиваем чтобы все элементы поместились
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //logger.info("Start test " +  scenario.getName());
        //spravochnikHelper = new SpravochnikHelper(driver);
        operationsHelper = new OperationsHelper(driver);
        System.out.println("----------------------------------------------");
        System.out.println("Starting - " + scenario.getName());
        System.out.println("----------------------------------------------");
    }
        public void stop(Scenario scenario) {
        //logger.info("Stop test " +  scenario.getName() + " - " + scenario.getStatus());
        if (scenario.getStatus() == Result.Type.FAILED) {
            //System.out.println(scenario.getName() + " status - " + scenario.getStatus());
            logger.info("Scenario " + scenario.getName() + " status " + scenario.getStatus());
            //} else logger.info("Scenario " +  scenario.getName() + " status " + scenario.getStatus());
            //System.err.println(scenario.getName() + " status - " + scenario.getStatus());
            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                String testName = scenario.getName();
                scenario.embed(screenshot, "image/png");
                scenario.write(testName);
            } catch (WebDriverException wde) {
                System.err.println(wde.getMessage());
            } catch (ClassCastException cce) {
                cce.printStackTrace();}
        }
        System.out.println("------------------------------------------------------------------");
        System.out.println("Stop - " + scenario.getName() + " status - " +scenario.getStatus());
        System.out.println("------------------------------------------------------------------");
        driver.quit();
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
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("user")))); //ожидание 10c
        type("user", properties.getProperty("web.login"));
        //wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("pass")))); //ожидание 10c
        type("pass", properties.getProperty("web.password"));
        driver.findElement(By.xpath("//button")).click();
    }

    private void type(String user, String locator) {
        driver.findElement(By.id(user)).click();
        driver.findElement(By.id(user)).clear();
        driver.findElement(By.id(user)).sendKeys(locator);
    }

    public void selectPusk() {
        //driver.findElement(By.xpath("//button[@id='ext-gen14']")).click();
        driver.findElement(By.cssSelector("#ext-comp-1003")).click(); //valid id
    }

    public void setDatepicker(WebDriver driver, String cssSelector, String date) {
        new WebDriverWait(driver, 30000).until(
                (WebDriver d) -> d.findElement(By.cssSelector(cssSelector)).isDisplayed());
        JavascriptExecutor.class.cast(driver).executeScript(
                String.format("$('%s').datepicker('setDate', '%s')", cssSelector, date));
    }
    public void selectSpravochnik() {
        driver.findElement(By.cssSelector("#ext-comp-1059")).click(); //valid id
        //driver.findElement(By.id("ext-gen110")).click(); //not good xpath locator
        //driver.findElement(By.cssSelector("[class*=x-menu-list-item]:nth-of-type(6)")); //выбрать справочники
    }
    public void selectCalendarDate() throws InterruptedException {
        driver.findElement(By.xpath("//div[3]/img")).click(); //клик календарь
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ждем
        for (int i = 0; i < 3; i++) {
            driver.findElement(By.cssSelector("td.x-date-left")).click(); //click 3 times
            Thread.sleep(2000);
        }
        //Actions action = new Actions(driver);
        //WebElement back = driver.findElement(By.cssSelector("td.x-date-left"));
        //action.doubleClick(back).perform(); //клик 2р назад
        //action.moveToElement(back).doubleClick().perform();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ждем
        //WebElement kalendar = driver.findElement(By.cssSelector("#ext-comp-1860")); //локатор для таблицы
        //WebElement kalendar = driver.findElement(By.id("ext-comp-1862")); //не работает
        WebElement kalendar = driver.findElement(By.xpath("//*[@id='ext-comp-1860']/ul/li/div/table/tbody")); //валидный xpath для календаря раньше был ext 1862!!!
        List<WebElement> rows = kalendar.findElements(By.tagName("tr")); //поиск строк
        List <WebElement> columns = kalendar.findElements(By.tagName("td")); //поиск столбцов
        for (WebElement cell: columns){
            //Выбираем 11 число
            if (cell.getText().equals("11")){
                cell.findElement(By.linkText("11")).click();
                break;
            }
        }
    }

    public void gotoCrmSettings () {
        driver.findElement(By.xpath("//li[2]/a[2]/em/span/span")).click();//возврат в настройки
    }

    public void selectOperaciy() {
       driver.findElement(By.cssSelector("#ext-comp-1043")).click(); //выбрать операции в пуске
    }

    public void startPageOperations() {
        driver.findElement(By.xpath("//span/span")).click();
    }
    public void zayavki_change() throws InterruptedException {
        driver.findElement(By.cssSelector("#cloneRequestList")).click(); //клик заявки доступные к изменениям
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
        //driver.findElement(By.xpath("//div[3]/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[6]/table/tbody/tr/td[5]/div")).click(); //выбрать 5й элемент в списке

        //driver.findElement(By.cssSelector("#srm_bpm-cloneRequestList > div > div > div > div > div > div > div > div > div > div > div > div:nth-child(5)")); //заявки доступные к изменениям

        //driver.findElement(By.xpath("//div[5]/table/tbody/tr/td[2]/div")).click(); //клик на 5 элемент
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        //Thread.sleep(5000);
        //driver.findElement(By.xpath("//div[3]/div/div/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td/div")).click(); //выбрать первую строку
    }

    public void zayavki_active() throws InterruptedException {
        driver.findElement(By.cssSelector("#activeRequestList")).click(); //клик заявки доступные к изменениям
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
        //driver.findElement(By.xpath("//div[4]/div/div/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td/div")).click();
        //driver.findElement(By.cssSelector("#srm_bpm-activeRequestList > div > div > div > div > div > div > div > div > div > div > div > div:nth-child(5)")); //выбор 5 элемента
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        //Thread.sleep(5000);
        //driver.findElement(By.xpath("//div[4]/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[6]/table/tbody/tr/td[2]/div")).click();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
    }

    public void zayavki_all() throws InterruptedException {
        String all = driver.findElement(By.cssSelector("#allRequestList")).getText();
        Assert.assertEquals(all, "Все заявки"); //проверка "Все заявки"
        System.out.println(all); //проверяем "все заявки"
        driver.findElement(By.cssSelector("#allRequestList")).click(); //клик все запросы
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
        //driver.findElement(By.cssSelector("div#ext-comp-2597> div > div > div > div > div > div > div > div:nth-child(5)")); //клик на 5ю строку в таблице
        //driver.findElement(By.xpath("//div[2]/div/div/div/div/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[6]/table/tbody/tr/td[5]/div")).click(); // запрос
        driver.findElement(By.xpath("//div[4]/table/tbody/tr/td[2]/div")).click(); //клик на 5 элемент
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        WebElement element = driver.findElement(By.xpath("//div[2]/div/div/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[3]/div"));
        Thread.sleep(5000);
        waitForPageLoadComplete(driver);
        System.out.println(element.getText()); // имя в таблице
        element.click(); //клик на 2элемент в таблице
    }


    public void setDateOperations() throws InterruptedException {
        for (int i = 0; i < 3 ; i++) {
            driver.findElement(By.cssSelector("td.x-date-left")).click(); //click 3 times
            Thread.sleep(2000);
        }

        WebElement kalendarOperations = driver.findElement(By.cssSelector("li > div > table > tbody > tr:nth-child(2) > td > table > tbody")); //валидный xpath для календаря раньше был ext 1862!!!
        //List<WebElement> rows = kalendarOperations.findElements(By.tagName("tr")); //поиск строк
        List<WebElement> columns = kalendarOperations.findElements(By.tagName("td")); //поиск столбцов
        for (WebElement cell: columns){
            //Выбираем 11 число
            if (cell.getText().equals("11")){
                cell.findElement(By.linkText("11")).click();
                break;
            }
        }
    }

    public boolean isElementPresent(By locatorKey) {
        try {
            driver.findElement(locatorKey);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementVisible(String cssLocator){
        return driver.findElement(By.cssSelector(cssLocator)).isDisplayed();
    }

}
