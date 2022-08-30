
package PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
public class pageFactory {protected WebDriver driver;

    public pageFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}