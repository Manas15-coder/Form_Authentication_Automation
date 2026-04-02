package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.LoginPage;
import pages.SecurePage;

public class LogoutTest extends BaseTest {

    @Test
    public void testLogout() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("tomsmith", "SuperSecretPassword!");

        SecurePage securePage = new SecurePage(driver);
        LoginPage newLoginPage = securePage.clickLogout();

        String message = newLoginPage.getMessage();

        Assert.assertTrue(
                "URL is incorrect after logout",
                driver.getCurrentUrl().equals("https://the-internet.herokuapp.com/login")
        );

        Assert.assertTrue(
                "Logout message not displayed",
                message.contains("You logged out of the secure area!")
        );
    }
}
