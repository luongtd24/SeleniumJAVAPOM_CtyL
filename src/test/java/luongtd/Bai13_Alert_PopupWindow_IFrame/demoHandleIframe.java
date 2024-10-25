package luongtd.Bai13_Alert_PopupWindow_IFrame;

import luongtd.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class demoHandleIframe extends BaseTest {

    @Test
    public void testIFrame01_Checkbox() throws InterruptedException {

        driver.navigate().to("https://anhtester.com/contact");
        sleep(10);
        System.out.println("iframe total: " + driver.findElements(By.tagName("iframe")).size());
        //----Switch to content of Messenger--------
        driver.switchTo().frame( 0); //Thẻ iframe thứ nhất
        System.out.println(driver.findElement(By.tagName("strong")).getText());

        //----Switch to icon of Messenger---------

        //1. Switch to Parent WindowHandle
        driver.switchTo().parentFrame(); //Chuyển về nội dung chính không thuộc iframe nào

        //2. Switch to iframe icon of Messenger
        driver.switchTo().frame(1); //Thẻ iframe thứ hai
        driver.findElement(By.tagName("svg")).click(); //Nhấn icon để ẩn messenger chat đi

        sleep(2);
    }
 
}
