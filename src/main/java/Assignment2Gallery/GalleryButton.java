package Assignment2Gallery;

import PageObject.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;


public class GalleryButton extends pageFactory {


    @FindAll(@FindBy(how = How.TAG_NAME, using = "li"))
    List<WebElement> allElements;

    public GalleryButton(WebDriver driver) {
        super(driver);
    }

    public int gallery() throws InterruptedException {
        GalleryButton obj = new GalleryButton(driver);
        int count=obj.allElements.size();
        Thread.sleep(2000);
//        String la="Button Not Found";
//        while(true){
//            if(count==5){
//                la="Button Found";
//                System.out.println(la);
//                break;
//            }
//            else{
//                driver.get("https://the-internet.herokuapp.com/disappearing_elements");
//                System.out.println("Button not Found"+"\n"+"Reloading");
//                count=obj.allElements.size();
//            }
//        }
        Thread.sleep(2000);
        return count;
    }


}
