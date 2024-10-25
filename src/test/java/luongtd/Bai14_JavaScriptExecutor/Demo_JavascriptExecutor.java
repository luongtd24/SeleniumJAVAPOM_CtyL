package luongtd.Bai14_JavaScriptExecutor;

import luongtd.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Demo_JavascriptExecutor extends BaseTest {

    @Test
    public void testJavascriptExecutor01(){
        driver.get("https://cms.anhtester.com/");
        sleep(2);
        //tat dialog
//        driver.findElement(By.xpath("//i[@class='la la-close fs-20']")).click();
//        sleep(1);
//        driver.findElement(By.xpath("//i[@class='la la-close fs-20'][1]")).click();
        WebElement buttonaddToCart = driver.findElement(By.xpath("//div[normalize-space()='Book']"));


        //dung javascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", buttonaddToCart);
        sleep(2);
    }

    @Test
    public void testJavascriptExecutorSearch(){
        driver.get("https://cms.anhtester.com/");
        sleep(2);
        //tat dialog
        driver.findElement(By.xpath("//i[@class='la la-close fs-20']")).click();
//        sleep(1);
//        driver.findElement(By.xpath("//i[@class='la la-close fs-20'][1]")).click();
        WebElement inputSearch = driver.findElement(By.xpath("//input[@id='search']"));


        //dung javascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','Gio qua Tet hquHA');", inputSearch);
        sleep(4);
    }

}
