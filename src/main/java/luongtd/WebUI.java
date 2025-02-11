package luongtd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.xml.xpath.XPath;
import java.time.Duration;
import java.util.List;

public class WebUI {

    //khai bao
    private static WebDriverWait wait;
    private static WebDriver driver;

    private static int TIME_OUT = 10;
    private static double STEP_TIME = 0.5;
    private static int PAGE_LOAD_TIMEOUT = 20;

    //Ham xay dung de truyen driver tu ben ngoai vao class nay
    public WebUI(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static void sleep(double second) {
        try {
            Thread.sleep((long) (1000 * second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void openURL(String url) {
        driver.get(url);
        sleep(STEP_TIME);
        logConsole("" + url);
    }

    private static void logConsole(Object message) {
        System.out.println(message);

    }

    public static WebElement getWebElement(By by) {
        return driver.findElement(by);
    }

    public static Boolean checkElementExist(By by) {
        sleep(2);
        List<WebElement> listElement = driver.findElements(by);

        if (listElement.size() > 0) {
            System.out.println("checkElementExist: " + true + " --- " + by);
            return true;
        } else {
            System.out.println("checkElementExist: " + false + " --- " + by);
            return false;
        }
    }

    public static void clickElement(String by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(by)));
        driver.findElement(By.xpath(by)).click();
    }

    public static void clickElement(By by, int timeout) {
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));    //TIME OUT: thoi gian linh dong theo tung ham
        //wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        waitForElementVisible(by,timeout);
        sleep(STEP_TIME);
        driver.findElement(by).click();
        logConsole("click element" + by);

    }

    public static void clickElement(By by) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT));  //TIME OUT: thoi gian duoc fix cung
//        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        waitForElementVisible(by);
        sleep(STEP_TIME);
        driver.findElement(by).click();
        logConsole("click element" + by);
    }

//    public static void setText(String xpath, String value) {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
//        driver.findElement(By.xpath(xpath)).sendKeys(value);
//    }

    public static void setText(String by, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(by)));
        sleep(STEP_TIME);
        driver.findElement(By.xpath(by)).sendKeys(value);
        logConsole("Set Text" + value + "on element" + by);
    }

    public static void setText(By by, String value) {
        waitForElementVisible(by);
        sleep(STEP_TIME);
        driver.findElement(by).sendKeys(value);
        logConsole("Set Text" + value + "on element" + by);
    }

    public static String getElementText(By by) {
        waitForElementVisible(by);
        sleep(STEP_TIME);
        logConsole("Get text of element " + by);
        String text = getWebElement(by).getText();
        logConsole("==> TEXT: " + text);
        return text; //Trả về một giá trị kiểu String
    }

    public static void waitForElementVisible(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT), Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Throwable error) {
            logConsole("Timeout waiting for the element Visible. " + by.toString());
            Assert.fail("Timeout waiting for the element Visible. " + by.toString());
        }
    }

    public static void waitForElementVisible(By by, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Throwable error) {
            logConsole("Timeout waiting for the element Visible. " + by.toString());
            Assert.fail("Timeout waiting for the element Visible. " + by.toString());
        }
    }

}
