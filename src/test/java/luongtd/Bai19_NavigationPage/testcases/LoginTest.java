package luongtd.Bai19_NavigationPage.testcases;

import luongtd.Bai19_NavigationPage.pages.LoginPage;
import luongtd.common.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    //Khai bao doi tuong class LoginPage toan cuc
    LoginPage loginPage;

    @Test
    public void testLoginCRM_Success(){
        //Khoi tao doi tuong class LoginPage de truyen gia tri driver tu BaseTest
        //De class LoginPage nhan duoc gia tri driver thi moi thuc thi cac ham trong class page duoc
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
    }


    @Test
    public void testLoginCRM_EmailInvalid(){
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin123@example.com", "123456");
        loginPage.verifyLoginFail();
    }

    @Test
    public void testLoginCRM_PasswordInvalid(){
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com", "1234456");
        loginPage.verifyLoginFail();
    }
}
