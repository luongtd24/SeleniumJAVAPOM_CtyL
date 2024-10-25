package luongtd.Bai17_PageObkectModel.pages;

import luongtd.locator.LocatorCRM;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {

    private String url = "https://crm.anhtester.com/admin/authentication";

    //Khai bao driver cuc bo trong chinh class nay
    private WebDriver driver;
    private WebDriverWait wait;

    //Ham xay dung de truyen Driver tu ben ngoai (co the tu BaseTest)
    public LoginPage (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Khai bao tat ca object (element) tren page nay
    // Thuoc kieu doi tuong By (thuoc selenium )

    By headerLoginPage = By.xpath("//h1[normalize-space()='Login']");
    By inputEmail = By.xpath("//input[@id='email']");
    By inputPassword = By.xpath("//input[@id='password']");
    By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    By errorMessage = By.xpath("//div[@class='text-center alert alert-danger']");

    //Xay dung cac ham xu ly tren chinh Page nay
    private void setInputEmail(String email){
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputEmail));
        driver.findElement(inputEmail).sendKeys(email);
    }

    private void setInputPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputPassword));
        driver.findElement(inputPassword).sendKeys(password);
    }
    private void clickButtonLogin(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonLogin));
        driver.findElement(buttonLogin).click();
    }

    public void loginCRM(String email, String password){
        driver.get(url);
        setInputEmail(email);
        setInputPassword(password);
        clickButtonLogin();
    }

    public void verifyLoginSuccess(){
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.menuDashboard)).isDisplayed(), "Menu Dashboard not Displayed");
    }

    public void verifyLoginFail(){
        Assert.assertTrue(driver.findElement(errorMessage).isDisplayed(),"Error Message not Displayed");
        Assert.assertEquals(driver.findElement(errorMessage).getText(),"Invalid email or password", "Error Message not Displayed");
    }

}
