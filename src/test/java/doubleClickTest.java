import com.travlers.testsTestng.BaseSeleniumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class doubleClickTest extends BaseSeleniumTest {

    @Test
    public void doubleClickTest() throws IOException {
        SeleniumHelper helper = new SeleniumHelper(driver);
        driver.get("file:///Users/tomaszpawlak/Downloads/DoubleClick.html");
        WebElement button = driver.findElement(By.id("bottom"));
        Actions actions = new Actions(driver);
        actions.moveToElement(button).doubleClick().perform();
        helper.takeScreenShot();
        Assert.assertTrue(driver.getWindowHandles().size()>1);


    }

}
