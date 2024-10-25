package luongtd.Bai12_ActionClass_RobotClass;

import luongtd.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Demo_RobotClass extends BaseTest {
    @Test
    public void inputText()  {

        driver.get("https://anhtester.com/");

        sleep(1);
        WebElement inputCourseElement = driver.findElement(By.name("key"));

        inputCourseElement.click();

        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        // Nhập từ khóa selenium
        robot.keyPress(KeyEvent.VK_S);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_L);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_N);
        robot.keyPress(KeyEvent.VK_I);
        robot.keyPress(KeyEvent.VK_U);
        robot.keyPress(KeyEvent.VK_M);

//        robot.keyRelease(KeyEvent.VK_S);
//        robot.keyRelease(KeyEvent.VK_E);
//        robot.keyRelease(KeyEvent.VK_L);
//        robot.keyRelease(KeyEvent.VK_E);
//        robot.keyRelease(KeyEvent.VK_N);
//        robot.keyRelease(KeyEvent.VK_I);
//        robot.keyRelease(KeyEvent.VK_U);
//        robot.keyRelease(KeyEvent.VK_M);

        sleep(1);
        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease((KeyEvent.VK_ENTER));

        sleep(2);
    }

    @Test
    public void mousePress() {

        driver.get("https://anhtester.com/");
        sleep(1);

        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        //Di chuyển trỏ chuột đến vị trí x,y
        robot.mouseMove(1550, 240);
        //Dalay giống sleep
        robot.delay(1000);
        //Click chuột trái
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        //Thả chuột trái ra
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        sleep(2);
    }
}
