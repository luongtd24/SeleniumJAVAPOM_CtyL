package luongtd.Bai19_NavigationPage.testcases;

import luongtd.Bai19_NavigationPage.pages.CustomerPage;
import luongtd.Bai19_NavigationPage.pages.DashboardPage;
import luongtd.Bai19_NavigationPage.pages.LoginPage;
import luongtd.WebUI;
import luongtd.common.BaseTest;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;

    @Test
    private void openCustomerPage(){
        loginPage = new LoginPage(driver);
        dashboardPage =  loginPage.loginCRM("admin@example.com","123456");
        loginPage.verifyLoginSuccess();

       // dashboardPage = new DashboardPage(driver);

       customerPage = dashboardPage.clickMenuCustomers();

    }

    @Test
    private void logOut(){
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM("admin@example.com","123456");
        loginPage.verifyLoginSuccess();

        dashboardPage.logOut();
    }


}
