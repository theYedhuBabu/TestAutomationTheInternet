package Assignment6Login;

import PageObject.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Login extends pageFactory {

//    final static String userName = "tomsmith";
//    final static String password = "SuperSecretPassword!";
    @FindBy(id = "username")
    WebElement user_name;
    @FindBy(id = "password")
    WebElement pass_word;
    @FindBy(xpath = "//*[@id=\"login\"]/button/i")
    WebElement login_button;
    @FindBy(xpath = "//*[@id=\"content\"]/div/h2")
    WebElement alertSuccess;
    @FindBy(xpath = "//*[@id=\"flash\"]")
    WebElement alertFail;
    public Login(WebDriver driver) {
        super(driver);
    }

    public String loginStat(String userName, String password) throws InterruptedException {
        Login obj = new Login(driver);

        Thread.sleep(5000);
        obj.user_name.sendKeys(userName);
        obj.pass_word.sendKeys(password);
        obj.login_button.click();
        Thread.sleep(2000);
        String title="";
        if(userName.equals("tomsmith")){
            title=obj.alertSuccess.getText();
        }else{
            title=obj.alertFail.getText();
            System.out.println(title);
        }

//        System.out.println(title);
//        if(title.equals("Secure Area")){
//            System.out.println("Successful");
//        }
        return title;
    }


}
