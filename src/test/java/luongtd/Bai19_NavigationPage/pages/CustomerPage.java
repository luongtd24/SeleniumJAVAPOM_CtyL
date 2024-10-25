package luongtd.Bai19_NavigationPage.pages;

import luongtd.WebUI;
import luongtd.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Base64;

public class CustomerPage extends BaseTest {

    private WebDriver driver;

    public CustomerPage(WebDriver driver){
        this.driver = driver;
        new WebUI(driver);
    }

    private By headerCustomer = By.xpath("//span[normalize-space()='Customers Summary']");
    private By addNewCustomer = By.xpath("//a[normalize-space()='New Customer']");
    private By searchCustomer = By.xpath("//div[@class='input-group']//input[@type='search']");
    //private By addNewCustomer = By.xpath("");


    public void moveCustomerSucces(){
        Assert.assertTrue(driver.findElement(headerCustomer).isDisplayed(),"Da vao dusng trang Customer");
    }


}
