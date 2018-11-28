package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class OperationsHelper extends HelperBase {

    public OperationsHelper(ChromeDriver driver) {
        super(driver);
    }

    public void selectOperaciy() {
        driver.findElement(By.cssSelector("#ext-comp-1043")).click(); //выбрать операции в пуске
    }

    public void mainBPM() {
        driver.findElement(By.xpath("//span/span")).click();
    }
    public void zayavki_change() throws InterruptedException {
        driver.findElement(By.cssSelector("#cloneRequestList")).click(); //клик заявки доступные к изменениям
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
        //driver.findElement(By.xpath("//div[3]/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[6]/table/tbody/tr/td[5]/div")).click(); //выбрать 5й элемент в списке
        driver.findElement(By.cssSelector("#srm_bpm-cloneRequestList > div > div > div > div > div > div > div > div > div > div > div > div:nth-child(5)")); //заявки доступные к изменениям
        //driver.findElement(By.xpath("//div[5]/table/tbody/tr/td[2]/div")).click(); //клик на 5 элемент
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[3]/div/div/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td/div")).click(); //выбрать первую строку
    }

    public void zayavki_active() throws InterruptedException {
        driver.findElement(By.cssSelector("#activeRequestList")).click(); //клик заявки доступные к изменениям
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
        //driver.findElement(By.xpath("//div[4]/div/div/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td/div")).click();
        driver.findElement(By.cssSelector("#srm_bpm-activeRequestList > div > div > div > div > div > div > div > div > div > div > div > div:nth-child(5)")); //выбор 5 элемента
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[4]/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[6]/table/tbody/tr/td[2]/div")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
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
        driver.findElement(By.xpath("//div[5]/table/tbody/tr/td[2]/div")).click(); //клик на 5 элемент
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ожидание загрузки страницы
        WebElement element = driver.findElement(By.xpath("//div[2]/div/div/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[3]/div"));
        Thread.sleep(5000);
        //app.waitForPageLoadComplete(driver);
        System.out.println(element.getText()); // имя в таблице
        element.click(); //клик на 2элемент в таблице
    }
}
