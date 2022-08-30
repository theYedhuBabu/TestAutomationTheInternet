package Assignment6Login;

import PageObject.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.FindBy;


public class InvalidLogin extends pageFactory {

    final static String userName = "tomsmith";
    final static String password = "WrongPassword!";
    @FindBy(id = "username")
    WebElement user_name;
    @FindBy(id = "password")
    WebElement pass_word;
    @FindBy(xpath = "//*[@id=\"login\"]/button/i")
    WebElement login_button;
    @FindBy(xpath = "//*[@id=\"flash\"]")
    WebElement alertFail;
    public InvalidLogin(WebDriver driver) {
        super(driver);
    }

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/home/qbuser/Documents/Selenium/Assignment_1/chromedriver");
        WebDriver driver = new ChromeDriver();
        InvalidLogin obj = new InvalidLogin(driver);
        driver.get("http://the-internet.herokuapp.com/login");
        Thread.sleep(5000);
        obj.user_name.sendKeys(userName);
        obj.pass_word.sendKeys(password);
        obj.login_button.click();
        Thread.sleep(2000);
        String title=obj.alertFail.getText();
//        System.out.println(title);
        if(title.equals("Your password is invalid!\n" +
                "×")){
            System.out.println("Invalid Credentials");
        }

        driver.quit();
    }


}
