package test.java.makeScreenshots;

import main.java.PO.CoursesPage;
import main.java.PO.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.cropper.indent.IndentCropper;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import test.java.TestSetUp;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static ru.yandex.qatools.ashot.cropper.indent.IndentFilerFactory.blur;

public class MainPageScreens extends TestSetUp {
    private HomePage homePage;

    @BeforeMethod
    public void setUpTest() {
        homePage = new HomePage(this.driver);
    }

    @Test
    public void getHeader() throws IOException {
        homePage.isShown();
        WebElement myWebElement = driver.findElement(By.id("header"));
        Screenshot screenshot = new AShot()
                .addIgnoredElement(By.cssSelector("#logo"))
                .takeScreenshot(driver, myWebElement);
        ImageIO.write(screenshot.getImage(),"PNG",new File("Screenshots\\elementScreenshot.png"));
    }
}
