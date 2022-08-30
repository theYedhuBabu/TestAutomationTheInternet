import Assignment5NewWindow.newWindow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testNewWindow {
    WebDriver driver;
    @BeforeClass
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "/home/qbuser/Documents/Selenium/Assignment_1/chromedriver");
        driver=new ChromeDriver();
    }
    @Test
    public void TestNewWindow() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/windows");
        newWindow NewWindow = new newWindow(driver);
        String title=NewWindow.newWindowStat();
        Assert.assertEquals(title,"New Window","Test Failed");
    }
    @AfterClass
    public void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
