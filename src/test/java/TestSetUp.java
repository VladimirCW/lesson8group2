package test.java;

import io.qameta.allure.Attachment;
import main.java.PO.CoursesPage;
import main.java.PO.HomePage;
import main.java.Utils.PropertyLoader;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class TestSetUp {
    WebDriver driver;

    @BeforeMethod
    public void setUp(ITestContext context) throws MalformedURLException {
        /*DesiredCapabilities desiredCapabilities = DesiredCapabilities.
                chrome();
        desiredCapabilities.setBrowserName("chrome");
        ChromeOptions options = new ChromeOptions();

        options.addArguments("disable-session-crashed-bubble");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        desiredCapabilities.setCapability(
                ChromeOptions.CAPABILITY, options);
        desiredCapabilities.setCapability("enableVNC", true);
        driver = new RemoteWebDriver(
                new URL(PropertyLoader.loadProperty("gridhub")),
                desiredCapabilities);*/

        System.setProperty("webdriver.chrome.driver",
                "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        context.setAttribute("webDriver", driver);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        saveScreenshot();
        driver.quit();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}
