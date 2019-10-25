package test.java;

import io.qameta.allure.*;
import main.java.PO.CoursesPage;
import main.java.PO.HomePage;
import main.java.Utils.RetryAnalyzer;
import main.java.Utils.Screenshot;
import org.openqa.selenium.*;
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
     WebDriver driver;
     HomePage homePage;
     CoursesPage coursesPage;

    @BeforeMethod
    public void setUp(ITestContext context) {
        System.setProperty("webdriver.chrome.driver",
                "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        context.setAttribute("webDriver", driver);
        homePage = new HomePage(driver);
        coursesPage = new CoursesPage(driver);
    }

    @Link("https://google.com")
    @TmsLink("AAA-1")
    @Issues({
            @Issue("B-1"),
            @Issue("B-2")
    })
    @Story("Poisitive test")
    @Test()
    public void mainTest() throws InterruptedException {
        String[] str = {"ru-RU", "uk", "en-GB"};
        int rand = (int) (Math.random() * (str.length + 1) );
        homePage.isShown()
                .selectLanguage(str[rand]);
    }

    @Test
    public void checkLanguages() {
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
    public void tearDown(ITestResult result) {
        saveScreenshot();
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

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
