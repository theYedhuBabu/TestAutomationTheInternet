import Assignment4Slider.slider;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class testSlider {
    WebDriver driver;
    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/home/qbuser/Documents/Selenium/Assignment_1/chromedriver");
        driver=new ChromeDriver();
    }
    @Test
    public void TestSlider() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/horizontal_slider");
        slider Slider = new slider(driver);
        float range=Slider.sliderStat();
        Assert.assertEquals(range,2.5,"Test Failed");
    }
    @AfterClass
    public void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
