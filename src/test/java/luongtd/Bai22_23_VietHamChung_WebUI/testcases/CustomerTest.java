package luongtd.Bai22_23_VietHamChung_WebUI.testcases;

import luongtd.Bai22_23_VietHamChung_WebUI.pages.CustomerPage;
import luongtd.Bai22_23_VietHamChung_WebUI.pages.DashboardPage;
import luongtd.Bai22_23_VietHamChung_WebUI.pages.LoginPage;
import luongtd.common.BaseTest;
import luongtd.constant.ConfigurationLogin;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;


    @Test
    public void addNewCuscomerSucces(){
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM(ConfigurationLogin.email, ConfigurationLogin.password);
        loginPage.verifyLoginSuccess();
        customerPage= dashboardPage.clickMenuCustomers();
        customerPage.verifyRedirectCustomerPageSuccess();
        customerPage.clickButtonAddNewCustomer();
        customerPage.inputDateCustomer("LTD");

    }
    @Test
    public void searchAndClickCompanyName(){
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM(ConfigurationLogin.email, ConfigurationLogin.password);
        loginPage.verifyLoginSuccess();
        customerPage= dashboardPage.clickMenuCustomers();
        customerPage.searchInfoCompany("LTD");
    }
}
