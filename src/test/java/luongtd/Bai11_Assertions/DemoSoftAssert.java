package luongtd.Bai11_Assertions;

import luongtd.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DemoSoftAssert extends BaseTest {
    @Test
    public void testOpenProject(){
        driver.get("https://crm.anhtester.com/admin/authentication");
        SoftAssert softAssert = new SoftAssert();
        String url = driver.getCurrentUrl();
        //Assert.assertEquals(url, "https://crm.anhtester.com/admin/authentication");

        boolean checkUrl = url.contains("admin/authentication");
        softAssert.assertTrue(checkUrl);


        String headerLoginPage = driver.findElement(By.xpath("//h1[normalize-space()='Login']")).getText();
        softAssert.assertEquals(headerLoginPage,"Login123", "Header Login match" + headerLoginPage);

        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        String headerDashboard = driver.findElement(By.xpath("//span[normalize-space()='Dashboard']")).getText();

        softAssert.assertEquals(headerDashboard,"Dashboard");

        boolean checkMenuDashboard = driver.findElement(By.xpath("//span[normalize-space()='Dashboard']")).isDisplayed();
        softAssert.assertTrue(checkMenuDashboard,"checkmenuDashboard match");

        // mo project

        driver.findElement(By.xpath("//span[normalize-space()='Projects']")).click();
        softAssert.assertAll();

    }
}
