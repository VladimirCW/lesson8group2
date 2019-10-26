package test.java;

import io.qameta.allure.*;
import main.java.PO.CoursesPage;
import main.java.PO.HomePage;
import org.testng.ITestContext;
import org.testng.annotations.*;
import static org.testng.Assert.assertTrue;

@Epic("Cart menu")
@Feature("Add product")
public class MainTest extends TestSetUp{
    HomePage homePage;
    CoursesPage coursesPage;

    @BeforeMethod
    public void setUpTest(ITestContext context) {
        homePage = new HomePage(this.driver);
        coursesPage = new CoursesPage(this.driver);
    }

    @Link("https://google.com")
    @TmsLink("AAA-1")
    @Issues({
            @Issue("B-1"),
            @Issue("B-2")
    })
    @Story("Poisitive test")
    @Test
    public void checkLanguages() {
        homePage.isShown();
        assertTrue(homePage.languagesArePresent());
    }

    @Link("https://google.com")
    @TmsLink("AAA-1")
    @Issues({
            @Issue("B-1"),
            @Issue("B-2")
    })
    @Story("Negative test")
    @Test
    public void checkLanguagesNegative() {
        homePage.isShown();
        assertTrue(false);
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
