package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SpravochnikHelper extends HelperBase {

    //private ChromeDriver driver;
    //private WebDriver driver = app.getDriver();

     //public SpravochnikHelper(ChromeDriver driver) {
       // this.driver = driver;
    //}

    public SpravochnikHelper(ChromeDriver driver) {
        super(driver);
        //this.driver = driver;
    }

    public void selectSpravochnik() {
        click(By.cssSelector("#ext-comp-1059")); //valid id
        //driver.findElement(By.id("ext-gen110")).click(); //not good xpath locator
        //driver.findElement(By.cssSelector("[class*=x-menu-list-item]:nth-of-type(6)")); //выбрать справочники
    }

    public void selectCalendarDate() {
        click(By.xpath("//div[3]/img")); //клик календарь
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
}
