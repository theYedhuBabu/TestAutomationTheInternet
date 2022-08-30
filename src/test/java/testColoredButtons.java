import Assignment7ColouredButtons.coloredButtons;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class testColoredButtons {
    WebDriver driver;
    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/home/qbuser/Documents/Selenium/Assignment_1/chromedriver");
        driver=new ChromeDriver();
    }
    @Test
    public void TestColoredButtons() throws InterruptedException {
        String mainUrl="http://the-internet.herokuapp.com/challenging_dom";
        driver.get(mainUrl);
        coloredButtons ColoredButtons =new coloredButtons(driver);
        List<String> arr2=ColoredButtons.coloredButtonStat();
        Assert.assertFalse(arr2.get(0) == arr2.get(1));
        Assert.assertFalse(arr2.get(2)==mainUrl);
        Assert.assertFalse(arr2.get(3)==mainUrl);


    }
    @AfterClass
    public void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
