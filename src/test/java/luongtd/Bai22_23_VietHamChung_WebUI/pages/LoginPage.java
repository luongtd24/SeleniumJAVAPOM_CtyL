package luongtd.Bai22_23_VietHamChung_WebUI.pages;

import luongtd.WebUI;
import luongtd.locator.LocatorCRM;
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
        new WebUI(driver);
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
        //driver.findElement(inputEmail).sendKeys(email);
        WebUI.setText(inputEmail,email);
    }

    private void setInputPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputPassword));
        //driver.findElement(inputPassword).sendKeys(password);
        WebUI.setText(inputPassword,password);
    }
    private void clickButtonLogin(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonLogin));
        //driver.findElement(buttonLogin).click();
        WebUI.clickElement(buttonLogin);
    }

    public DashboardPage loginCRM(String email, String password){
       // driver.get(url);
        WebUI.openURL(url);
        WebUI.waitForPageLoaded();
        setInputEmail(email);
        setInputPassword(password);
        clickButtonLogin();
        WebUI.waitForPageLoaded();
    return new DashboardPage(driver);
    }

    public void verifyLoginSuccess(){
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.menuDashboard)).isDisplayed(), "Menu Dashboard not Displayed");
    }

    public void verifyLoginFail(){
        Assert.assertTrue(driver.findElement(errorMessage).isDisplayed(),"Error Message not Displayed");
        Assert.assertEquals(driver.findElement(errorMessage).getText(),"Invalid email or password", "Error Message not Displayed");
    }

    public void verifyRedirectLoginPage(){
        System.out.println("Verify redirect to Login Page");
        Assert.assertTrue(driver.findElement(headerLoginPage).isDisplayed(),"Header of login page not Displayed");
        Assert.assertEquals(driver.findElement(headerLoginPage).getText(),"Login", "Content of header Login page not match");
    }

}
