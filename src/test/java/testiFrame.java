import Assignment3iFrame.iFrame;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class testiFrame {
    WebDriver driver;


    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/home/qbuser/Documents/Selenium/Assignment_1/chromedriver");
        driver=new ChromeDriver();
    }
    @Test
    public void TestiFrame() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/iframe");
        iFrame iframe =new iFrame(driver) ;
        iframe.iFramestat();
    }
    @AfterClass
    public void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
