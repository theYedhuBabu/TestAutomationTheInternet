package Assignment1DragDrop;

import PageObject.pageFactory;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class DragDrop extends pageFactory {

    @FindBy(xpath = "//*[@id=\"column-a\"]")
    WebElement fromElement;
    @FindBy(id = "column-b")
    WebElement toElement;
    @FindBy(xpath = "//*[@id=\"column-a\"]/header")
    WebElement aHeader;
    @FindBy(xpath = "//*[@id=\"column-b\"]/header")
    WebElement bHeader;

    public DragDrop(WebDriver driver) {
        super(driver);
    }

    public List<String> dragDrop(){

//        System.setProperty("webdriver.chrome.driver", "/home/qbuser/Documents/Selenium/Assignment_1/chromedriver");
//        WebDriver driver = new ChromeDriver();
        DragDrop obj = new DragDrop(driver);
//        driver.get("http://the-internet.herokuapp.com/drag_and_drop");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
                + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
                + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
                + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
                + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
                + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
                + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
                + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
                + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
                + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
                + "var dropEvent = createEvent('drop');\n"
                + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
                + "var dragEndEvent = createEvent('dragend');\n"
                + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
                + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
                + "simulateHTML5DragAndDrop(source,destination);", obj.fromElement, obj.toElement);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<String> arr=new ArrayList<>();
        String aText=obj.aHeader.getText();
        arr.add(aText);
        String bText=obj.bHeader.getText();
        arr.add(bText);
//        if((aText.equals("B"))&&(bText.equals("A"))){
//            System.out.println("Drag and Drop Successful");

//        driver.quit();
        return arr;
    }


}
