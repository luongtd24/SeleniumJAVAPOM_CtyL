package luongtd.common;

import luongtd.WebUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    public  WebDriver driver;
    public  void sleep(double second){
        try {
            Thread.sleep((long) (1000*second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeMethod
    @Parameters({"browser"})
    public  void createBrowser(){
        setBrowser("chrome");
        new WebUI(driver);
    }

    public  void setBrowser(String browserName){

        if (browserName.trim().toLowerCase().equals("chrome")){
            driver = new ChromeDriver();
        }
        if (browserName.trim().toLowerCase().equals("firefox")){
            driver = new FirefoxDriver();
        }
        if (browserName.trim().toLowerCase().equals("edge")){
            driver = new EdgeDriver();
        }

        //2 ham cho doi
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Ham cho tim kiem element trong 10s
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        // 2 ham de maximize/minimine trinh duyet
        driver.manage().window().maximize();
    }
    @AfterMethod
    public  void closeBrowser() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();

    }
    }
