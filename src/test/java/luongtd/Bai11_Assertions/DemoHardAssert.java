package luongtd.Bai11_Assertions;

import luongtd.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoHardAssert extends BaseTest {

    @Test
    public void testOpenProject(){
        driver.get("https://crm.anhtester.com/admin/authentication");
        String url = driver.getCurrentUrl();
        //Assert.assertEquals(url, "https://crm.anhtester.com/admin/authentication");

        boolean checkUrl = url.contains("admin/authentication");
        Assert.assertTrue(checkUrl);


        String headerLoginPage = driver.findElement(By.xpath("//h1[normalize-space()='Login']")).getText();
        Assert.assertEquals(headerLoginPage,"Login", "Header Login match" + headerLoginPage);

        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        String headerDashboard = driver.findElement(By.xpath("//span[normalize-space()='Dashboard']")).getText();

        Assert.assertEquals(headerDashboard,"Dashboard");

        boolean checkMenuDashboard = driver.findElement(By.xpath("//span[normalize-space()='Dashboard']")).isDisplayed();
        Assert.assertTrue(checkMenuDashboard,"checkmenuDashboard match");

     // mo project

        driver.findElement(By.xpath("//span[normalize-space()='Projects']")).click();

    }

}
