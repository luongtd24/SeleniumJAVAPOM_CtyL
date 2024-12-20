package luongtd.Bai19_NavigationPage.pages;

import luongtd.WebUI;
import org.openqa.selenium.WebDriver;

public class ProfileCustomerPage extends CustomerPage{
    private WebDriver driver;

    public ProfileCustomerPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        new WebUI(driver); //Khoi tao gia tri cho đối tượng webui
    }

    

}
