import Assignment2Gallery.GalleryButton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class testGallery {
    WebDriver driver;


    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "/home/qbuser/Documents/Selenium/Assignment_1/chromedriver");
        driver=new ChromeDriver();
    }
    @Test(testName = "Gallery Button")
    public void galleryTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/disappearing_elements");
        GalleryButton galleryButton = new GalleryButton(driver);
        int count=galleryButton.gallery();
//        Assert.assertEquals(la,"Button Found","Test failed");
        while (true) {
            if(count==5){
                Assert.assertEquals(count,5,"Test Failed");
                break;

            }else{
                driver.get("https://the-internet.herokuapp.com/disappearing_elements");
                count=galleryButton.gallery();
            }
        }

    }
    @AfterClass
    public void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
