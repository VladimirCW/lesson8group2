package test.java;

import main.java.PO.CoursesPage;
import main.java.PO.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
                .openCourses("C++");
        coursesPage.clickPay();
        assertTrue(coursesPage.checkIfLocationIsSelected("ВДНХ"));
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
        for(WebElement el: elements) {
            String text = el.getText();
            if(!expected.contains(text)) {
                isPresent = false;
            }
        }
        assertTrue(isPresent);
    }

    @AfterMethod
    public static void tearDown() {
        driver.quit();
    }
}
