package Assignment5NewWindow;

import PageObject.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;


public class newWindow extends pageFactory {


    @FindBy(xpath = "//*[@id=\"content\"]/div/a")
    WebElement newWindowButton;

    public newWindow(WebDriver driver) {
        super(driver);
    }

    public String newWindowStat() throws InterruptedException {
        newWindow obj = new newWindow(driver);

        Thread.sleep(2000);
        obj.newWindowButton.click();
        List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
        Thread.sleep(2000);
        driver.switchTo().window(browserTabs .get(1));
        String title=driver.getTitle();
//        System.out.println(title);
        return title;
//        if(title.equals("New Window")){
//            System.out.println("Successful");
//        }
//        Thread.sleep(5000);

//        driver.quit();
    }


}
