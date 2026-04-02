package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.SecurePage;

public class LoginTest extends BaseTest{

    @Test
    public void testSuccessfulLogin(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("tomsmith","SuperSecretPassword!");

        SecurePage securePage = new SecurePage(driver);
        String message = securePage.getSuccessMessage();

        Assert.assertTrue(message.contains("You logged into a secure area!"));
    }
}
