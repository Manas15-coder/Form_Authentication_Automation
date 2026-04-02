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

        // Setup driver
        WebDriverManager.chromedriver().setup();

        // Headless for GitHub Actions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/login");
    }

    @After
    public void tearDown() {

        try {
            takeScreenshot();
        } catch (Exception e) {
            System.out.println("Screenshot failed: " + e.getMessage());
        }

        if (driver != null) {
            driver.quit();
        }
    }

    // Simple Screenshot Method (Auto name)
    public void takeScreenshot() throws IOException {

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Unique name using time
        String fileName = "screenshot_" + System.currentTimeMillis() + ".png";

        File dest = new File("screenshots/" + fileName);

        dest.getParentFile().mkdirs(); // create folder

        FileUtils.copyFile(src, dest);
    }
}