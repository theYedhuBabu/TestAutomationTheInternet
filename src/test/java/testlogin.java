import Assignment6Login.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testlogin {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/home/qbuser/Documents/Selenium/Assignment_1/chromedriver");
        driver = new ChromeDriver();
    }

    @DataProvider(name = "testData")
    public Object[][] createTestData(){
        return new Object[][]{
                {"tomsmith", "SuperSecretPassword!"},
                {"Yedhu", "Babu"},
        };

        }
    @Test(dataProvider = "testData")
    public void TestLogin (String username, String password) throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/login");
        Login login = new Login(driver);
//       login.loginStat();
        String result = login.loginStat(username, password);
        if(username.equals("tomsmith")&&password.equals("SuperSecretPassword!")){
            Assert.assertEquals(result, "Secure Area", "Test Failed");
        }else {
            Assert.assertEquals(result, "Your username is invalid!\n" +
                    "×", "Test Failed");
        }
        }
    @AfterClass
    public void cleanUp() {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
