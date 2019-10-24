package test.java;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import main.java.PO.CoursesPage;
import main.java.PO.HomePage;
import main.java.Utils.RetryAnalyzer;
import main.java.Utils.Screenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Epic("Cart menu")
@Feature("Add product")
public class MainTest {
    static WebDriver driver;
    static WebDriverWait wait;
    static WebElement preloader;
    static HomePage homePage;
    static CoursesPage coursesPage;

    @BeforeMethod
    public static void setUp(ITestContext context) {
        System.setProperty("webdriver.chrome.driver",
                "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        context.setAttribute("webDriver", driver);
        homePage = new HomePage(driver);
        coursesPage = new CoursesPage(driver);
    }

    @Story("Poisitive test")
    @Test()
    public static void mainTest() throws InterruptedException {
        String[] str = {"ru-RU", "uk", "en-GB"};
        int rand = (int) (Math.random() * (str.length + 1) );
        homePage.isShown()
                .selectLanguage(str[rand]);
    }

    @Test
    public static void checkLanguages() {
        homePage.isShown();
        String arr[] = {"a", "b"};
        List<String> list = new ArrayList<String>(Arrays.asList(arr));


        List<String> expected = new ArrayList<String>();
        expected.add("RU");
        expected.add("UA");
        //expected.add("EN");

        boolean isPresent = true;
        List<WebElement> elements = driver.findElements(By.xpath("(//ul[@class='lang'])[1]/li/a"));
        for (WebElement el : elements) {
            String text = el.getText();
            if (!expected.contains(text)) {
                isPresent = false;
            }
        }
        assertTrue(isPresent);
    }

    @AfterMethod
    public static void tearDown(ITestResult result) {
        Screenshot screenshot = new Screenshot(driver);
        screenshot.saveScreenshot(result);
        driver.quit();
    }

    @DataProvider
    public Object[][] provider() {
        return new Object[][]{
                {"ru-RU"}/*,
                {"en-GB"},
                {"uk"}*/
        };
    }
}
