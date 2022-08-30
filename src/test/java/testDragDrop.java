import Assignment1DragDrop.DragDrop;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;


public class testDragDrop {
    WebDriver driver;
    @BeforeClass
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "/home/qbuser/Documents/Selenium/Assignment_1/chromedriver");
        driver=new ChromeDriver();
    }
    @Test(testName = "Drag and Drop")
    public void dragDropTest(){
        driver.get("http://the-internet.herokuapp.com/drag_and_drop");
        DragDrop dragDrop2 =new DragDrop(driver);
        List<String> arr2=dragDrop2.dragDrop();
        Assert.assertTrue((arr2.get(0).equals("B"))&&(arr2.get(1).equals("A")));
    }
    @AfterClass
    public void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
