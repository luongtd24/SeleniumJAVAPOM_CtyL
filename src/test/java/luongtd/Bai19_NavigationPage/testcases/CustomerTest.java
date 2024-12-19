package luongtd.Bai19_NavigationPage.testcases;

import luongtd.Bai19_NavigationPage.pages.CustomerPage;
import luongtd.Bai19_NavigationPage.pages.DashboardPage;
import luongtd.Bai19_NavigationPage.pages.LoginPage;
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

        customerPage.inputDateCustomer("Company A");
    }
}
