package test.java;

import main.java.PO.CoursesPage;
import main.java.PO.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MainTest {
    static WebDriver driver;
    static WebDriverWait wait;
    static WebElement preloader;
    static HomePage homePage;
    static CoursesPage coursesPage;

    @BeforeMethod
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        coursesPage = new CoursesPage(driver);
    }

    @Test
    public static void mainTest() throws InterruptedException {
        homePage.isShown()
                .selectLanguage("ru-RU")
                .clickLogo()
                .openCoursesJava();
        coursesPage.clickPay();
        assertTrue(coursesPage.checkIfBeresteikaIsSelected());
    }

    @AfterMethod
    public static void tearDown() {
        driver.quit();
    }
}
