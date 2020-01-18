package test.java.layout;

import main.java.PO.CoursesPage;
import main.java.PO.HomePage;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import test.java.TestSetUp;

public class MainPageTest extends TestSetUp {
    HomePage homePage;
    CoursesPage coursesPage;

    @BeforeMethod
    public void setUpTest(ITestContext context) {
        homePage = new HomePage(this.driver);
        coursesPage = new CoursesPage(this.driver);
    }
}
