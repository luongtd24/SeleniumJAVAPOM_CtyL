package luongtd.Bai13_Alert_PopupWindow_IFrame;

import luongtd.common.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandleAlert extends BaseTest {
    @Test
    public void demoHandleAlertAccept() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        sleep(2);

        //Mở Alert Message, click vào nút "Click me!" thứ nhất
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
        sleep(1);

        //Khởi tạo class Alert thứ nhất
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();


        sleep(1);
    }
    @Test
    public void demoHandleAlertDismiss() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        sleep(2);

        //Mở Alert Dismiss, click vào nút "Click me!" thứ 2
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
        sleep(1);

        //Khởi tạo class Alert
        Alert alert2 = driver.switchTo().alert();
        Assert.assertEquals(alert2.getText(),"I am a JS Confirm");
        alert2.dismiss();

        Assert.assertTrue(driver.findElement(By.xpath("//p[@id='result']")).isDisplayed(),"chua nhan duoc nut cancel");
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(),"You clicked: Cancel");
        sleep(1);
    }

    @Test
    public void demoHandleAlertInputText() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        sleep(2);

        //Mở Alert Input text, click nút thứ 3
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
        sleep(1);

        //Khởi tạo class Alert
        Alert alert3 = driver.switchTo().alert();
        sleep(2);
        alert3.sendKeys("Anh Tester Demo Alert");
        sleep(2);
        alert3.accept();

        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(),
                "You entered: Anh Tester Demo Alert",
                "Chưa điền được text");

        sleep(1);
    }
}
