import com.travlers.testsTestng.BaseSeleniumTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.File;

public class FileUploadTest extends BaseSeleniumTest {


    @Test
    public void uploadFileTest(){
        driver.get("file:///Users/tomaszpawlak/Downloads/FileUpload.html");
        String path = new File("src/main/resources/text.txt").getAbsolutePath();
        driver.findElement(By.id("myFile")).sendKeys(path);
    }
}