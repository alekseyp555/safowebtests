package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class OperationsHelper extends HelperBase {

    public OperationsHelper(ChromeDriver driver) {
        super(driver);
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
}
