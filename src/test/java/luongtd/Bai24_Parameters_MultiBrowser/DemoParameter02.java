package luongtd.Bai24_Parameters_MultiBrowser;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoParameter02 {
    @Test
    @Parameters({"number1", "number2", "number3"})
    public void tinhTong3So(int a, int b, int c) {
        System.out.println("Tổng 3 số: " + (a + b + c));
    }


}
