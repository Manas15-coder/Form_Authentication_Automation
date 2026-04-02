package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class SecurePage extends BasePage {

    private By successMsg = By.id("flash");
    private By logoutBtn = By.cssSelector("a.button.secondary.radius");

    public SecurePage(WebDriver driver) {
        super(driver);
    }

    public String getSuccessMessage() {
        return getText(successMsg);
    }

    public LoginPage clickLogout() {
        click(logoutBtn);
        return new LoginPage(driver);
    }
}
