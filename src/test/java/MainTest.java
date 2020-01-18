package test.java;

import io.qameta.allure.*;
import main.java.PO.HomePage;
import org.testng.annotations.*;
import static org.testng.Assert.assertTrue;

@Epic("Cart menu")
@Feature("Add product")
public class MainTest extends TestSetUp{
    private HomePage homePage;

    @BeforeMethod
    public void setUpTest() {
        homePage = new HomePage(this.driver);
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

    @DataProvider
    public Object[][] provider() {
        return new Object[][]{
                {"ru-RU"},
                {"en-GB"},
                {"uk"}
        };
    }
}
