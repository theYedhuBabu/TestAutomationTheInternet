package Assignment4Slider;

import PageObject.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class slider extends pageFactory {

    final static int xOffset = 5;
    final static int yOffset = 0;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/input")
    WebElement sliderField;
    @FindBy(id = "range")
    WebElement range;
    public slider(WebDriver driver) {
        super(driver);
    }

    public float sliderStat() throws InterruptedException {

        slider obj = new slider(driver);

        Thread.sleep(5000);
        Actions action =new Actions(driver);
        action.dragAndDropBy(obj.sliderField, xOffset,yOffset).perform();
        Thread.sleep(5000);
        float Range=Float.parseFloat(obj.range.getText());
//        System.out.println(Range);
        return Range;
        }

    }



