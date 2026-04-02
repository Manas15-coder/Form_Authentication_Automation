package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @Before
    public void setUp() {

        // Setup ChromeDriver automatically
        WebDriverManager.chromedriver().setup();

        // Headless mode for GitHub Actions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // important for latest Chrome
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://the-internet.herokuapp.com/login");
    }

    @After
    public void tearDown() throws IOException {

        takeScreenshot("screenshot");

        if (driver != null) {
            driver.quit();
        }
    }

    // Reusable Screenshot Method
    public void takeScreenshot(String fileName) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        File dest = new File("screenshots/" + fileName + ".png");

        // Create folder if not exists
        dest.getParentFile().mkdirs();

        FileUtils.copyFile(src, dest);
    }
}