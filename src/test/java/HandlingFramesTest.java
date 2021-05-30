import com.travlers.testsTestng.BaseSeleniumTest;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.util.List;

public class HandlingFramesTest extends BaseSeleniumTest {

    @Test
    public void handlingFramesTest() {
        driver.get("file:///Users/tomaszpawlak/Downloads/iFrameTest.html");
        driver.switchTo().frame(0);
        WebElement clickOnMeButton = driver.findElement(By.id("clickOnMe"));
        clickOnMeButton.click();
        List<WebElement> headers = (List<WebElement>) driver.findElement(By.tagName("h1"));
        driver.switchTo().alert().accept();
        System.out.println(headers.size());
    }

}
