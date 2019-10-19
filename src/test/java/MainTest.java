package test.java;

import io.qameta.allure.*;
import main.java.PO.CoursesPage;
import main.java.PO.HomePage;
import main.java.Utils.RetryAnalyzer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

@Epic("Create cart")
@Feature("Add product to cart")
public class MainTest extends TestSetUp {
    HomePage homePage;
    CoursesPage coursesPage;

    @BeforeMethod
    public void setUp() {
        homePage = new HomePage(driver);
        coursesPage = new CoursesPage(driver);
    }

    @Link("https://example.com")
    @Issues({
            @Issue("AAA-1"),
            @Issue("AAA-2")
    })
    @Story("Positive test")
    @Description("This is a very first test of mine")
    @Test(dataProvider = "provider")
    public void mainTest(String lang) throws InterruptedException {
        homePage.isShown()
                .selectLanguage(lang);
        //fail();
    }

    @Issues({
            @Issue("AAA-3"),
            @Issue("AAA-4")
    })
    @Story("Negative test")
    @Description("This is a second test of mine")
    @Test
    public void checkLanguages() {
        homePage.isShown();
        List<String> expected = new ArrayList<String>();
        expected.add("RU");
        expected.add("UA");
        expected.add("EN");

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

    @DataProvider
    public Object[][] provider() {
        return new Object[][]{
                {"ru-RU"},
                {"en-GB"},
                {"uk"}
        };
    }
}
