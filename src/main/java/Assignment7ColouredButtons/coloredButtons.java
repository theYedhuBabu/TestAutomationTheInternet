package Assignment7ColouredButtons;

import PageObject.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;


public class coloredButtons extends pageFactory {
    @FindBy(className = "button")
    WebElement firstButton;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/div/div[2]/table/tbody/tr[1]/td[7]/a[1]")
    WebElement editButton;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/div/div[2]/table/tbody/tr[1]/td[7]/a[2]")
    WebElement deleteButton;
    public coloredButtons(WebDriver driver) {
        super(driver);
    }

    public List<String> coloredButtonStat() throws InterruptedException {
        List<String> arr=new ArrayList<>();
        coloredButtons obj = new coloredButtons(driver);
        Thread.sleep(5000);
        String textFirst=obj.firstButton.getText();
        arr.add(textFirst);
        obj.firstButton.click();
        String textSecond=obj.firstButton.getText();
        arr.add(textSecond);
        Thread.sleep(2000);
        obj.editButton.click();
        String currentUrl1= driver.getCurrentUrl();
        arr.add(currentUrl1);
        Thread.sleep(2000);
        obj.deleteButton.click();
        String currentUrl2= driver.getCurrentUrl();
        arr.add(currentUrl2);
        Thread.sleep(2000);
        return arr;
    }


}
