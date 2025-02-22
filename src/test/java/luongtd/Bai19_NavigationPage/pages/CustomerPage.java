package luongtd.Bai19_NavigationPage.pages;

import luongtd.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerPage {

    private WebDriver driver;

    public CustomerPage(WebDriver driver) {
        this.driver = driver;
        new WebUI(driver); //Khoi tao gia tri cho đối tượng webui
    }

    private By headerCustomer = By.xpath("//span[normalize-space()='Customers Summary']");
    private By addNewCustomer = By.xpath("//a[normalize-space()='New Customer']");
    private By searchCustomer = By.xpath("//div[@class='input-group']//input[@type='search']");

    //private By addNewCustomer = By.xpath("");
    //Trang Customers List
    private By buttonAddNewCustomer = By.xpath("//a[normalize-space()='New Customer']");
    private By buttonImportCustomer = By.xpath("//a[normalize-space()='Import Customers']");
    private By buttonContacts = By.xpath("//a[contains(@href, 'clients/all_contacts')]");
    //    private By inputSearchCustomers = By.xpath("//div[@id='DataTables_Table_0_filter']//input");
    private By firstItemCustomerOnTable = By.xpath("//td[@class='sorting_1']/a");

    //Add New Customer
    private By inputCompany = By.xpath("//input[@id='company']");
    private By inputVatNumber = By.xpath("//input[@id='vat']");
    private By inputPhone = By.xpath("//input[@id='phonenumber']");
    private By inputWebsite = By.xpath("//input[@id='website']");
    private By dropdownGroups = By.xpath("//button[@data-id='groups_in[]']");
    private By inputSearchGroups = By.xpath("//div[@app-field-wrapper='groups_in[]']//input[@type='search']");
    private By dropdownCurrency = By.xpath("//button[@data-id='default_currency']");
    private By inputSearchCurrency = By.xpath("//div[@app-field-wrapper='default_currency']//input");
    private By inputAddress = By.xpath("//textarea[@id='address']");
    private By inputCity = By.xpath("//input[@id='city']");
    private By inputState = By.xpath("//input[@id='state']");
    private By inputZipCode = By.xpath("//input[@id='zip']");
    private By dropdownCountry = By.xpath("//button[@data-id='country']");
    private By inputSearchCountry = By.xpath("//div[@app-field-wrapper='country']//input[@aria-label='Search']");
    private By buttonSaveAndCreateContact = By.xpath("//button[normalize-space()='Save and create contact']");
    private By buttonSaveCustomer = By.xpath("//div[@id='profile-save-section']//button[normalize-space()='Save']");

    public void clickButtonAddNewCustomer() {

        WebUI.clickElement(buttonAddNewCustomer);
    }

    public void verifyRedirectCustomerPageSuccess() {
        Assert.assertTrue(driver.findElement(headerCustomer).isDisplayed(), "Da vao dusng trang Customer");
        Assert.assertEquals(driver.findElement(headerCustomer).getText(), "Customers Summary", "Khong vao dung trang Customer");
    }

    public void inputDateCustomer(String companyName) {
        WebUI.setText(inputCompany, companyName);
        WebUI.setText(inputVatNumber, "1254");
        WebUI.setText(inputPhone, "123456789");
        WebUI.setText(inputWebsite, "http://lancsnet.com");
        WebUI.clickElement(dropdownGroups);
        WebUI.setText(inputSearchGroups, "Silver");
        WebUI.sleep(1);
        driver.findElement(inputSearchGroups).sendKeys(Keys.ENTER);
        WebUI.clickElement(dropdownGroups);
        WebUI.setText(inputAddress, "Me Linh");
        WebUI.setText(inputCity, "Ha Noi");
        WebUI.setText(inputState, "Manchester");
        WebUI.setText(inputZipCode, "254862");
        WebUI.clickElement(buttonSaveCustomer);
    }

    public ProfileCustomerPage searchInfoCompany(String companySummary) {
        WebUI.setText(searchCustomer, companySummary);
        driver.findElement(searchCustomer).sendKeys(Keys.ENTER);
        String nameCompanySearch = "//a[normalize-space()='" + companySummary + "'][1]";
        driver.findElement(By.xpath(nameCompanySearch)).click();
        //return new ProfileCustomerPage(driver);
        WebUI.sleep(2);
        Assert.assertTrue(driver.findElement(inputCompany).isDisplayed(), "Da vao dung trang Company can tim");
        Assert.assertEquals(driver.findElement(inputCompany).getText(), "", "Khong vao dung trang Company can tim");
        return new ProfileCustomerPage(driver);
    }
}
