package utilities;

public class ReusableMethods {
    public static void wait(int second) throws InterruptedException {
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
        }
    }
}
