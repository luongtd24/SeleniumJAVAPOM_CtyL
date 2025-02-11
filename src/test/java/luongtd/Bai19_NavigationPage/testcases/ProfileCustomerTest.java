package luongtd.Bai19_NavigationPage.testcases;
import luongtd.Bai19_NavigationPage.pages.CustomerPage;
import luongtd.Bai19_NavigationPage.pages.DashboardPage;
import luongtd.Bai19_NavigationPage.pages.LoginPage;
import luongtd.Bai19_NavigationPage.pages.ProfileCustomerPage;
import luongtd.common.BaseTest;
import luongtd.constant.ConfigurationLogin;
import org.testng.annotations.Test;

public class ProfileCustomerTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;
    ProfileCustomerPage profileCustomerPage;

    @Test
    public void verifyContactCustomer(){
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM(ConfigurationLogin.email, ConfigurationLogin.password);
        loginPage.verifyLoginSuccess();
        customerPage = dashboardPage.clickMenuCustomers();
        profileCustomerPage = customerPage.searchInfoCompany("LTD");    //Đặt profileCustomerPage gán giá trị trả về để khởi tạo profileCustomerPage thay cho lệnh khởi tạo bên dưới
        //profileCustomerPage = new ProfileCustomerPage(driver); //Khởi tạo profileCustomerPage
        profileCustomerPage.verifyRedirectContactCustomerSuccess();
        profileCustomerPage.clickButtonContactsCustomer();
    }

    @Test
    public void addNewContactCustomer(){
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM(ConfigurationLogin.email, ConfigurationLogin.password);
        loginPage.verifyLoginSuccess();
        customerPage = dashboardPage.clickMenuCustomers();
        profileCustomerPage = customerPage.searchInfoCompany("LTD");
        profileCustomerPage.clickButtonContactsCustomer();
        profileCustomerPage.addNewContactCustomer();
    }

}
