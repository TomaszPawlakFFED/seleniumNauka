import com.travlers.testsTestng.BaseSeleniumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WaitTest  extends BaseSeleniumTest {

    @Test
    public void waitTest() throws InterruptedException {
        driver.get("file:///Users/tomaszpawlak/Downloads/Waits.html");
        driver.findElement(By.tagName("button")).click();
        Thread.sleep(4000);
        WebElement paragraph = driver.findElement(By.tagName("p"));
        System.out.println(paragraph.getText());
        Assert.assertEquals(paragraph.getText(), "Dopiero się pojawiłem");

    }
}
