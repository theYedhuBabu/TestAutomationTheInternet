package Assignment3iFrame;


import PageObject.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.FindBy;


public class iFrame extends pageFactory {
    final static String inputText = "Hello World";
    @FindBy(id="tinymce")
    WebElement iframeField;
    public iFrame(WebDriver driver) {
        super(driver);
    }
    public void iFramestat() throws InterruptedException {
        driver.switchTo().frame("mce_0_ifr");
        iFrame obj = new iFrame(driver);
        obj.iframeField.click();
        Thread.sleep(5000);
        obj.iframeField.clear();
        Thread.sleep(2000);
        obj.iframeField.sendKeys(inputText);
        Thread.sleep(5000);
    }
}
