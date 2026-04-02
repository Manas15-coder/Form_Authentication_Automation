package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecurePage extends BasePage {

    private By sucessMsg = By.id("flash");

    public SecurePage(WebDriver driver){
        super(driver);
    }
    public String getSuccessMessage(){
        return getText(sucessMsg);
    }
}
