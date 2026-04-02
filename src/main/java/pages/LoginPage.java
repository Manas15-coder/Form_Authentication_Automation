package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private By username = By.id("username");
    private By password = By.id("password");
    private By loginBtn = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver driver){
        super(driver);
    }
    public void login(String user, String pass){
        type(username,user);
        type(password,pass);
        click(loginBtn);
    }
}
