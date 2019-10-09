package test.java;

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

public class MainTest {
    static WebDriver driver;

    @BeforeMethod
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public static void mainTest() throws InterruptedException {
        driver.get("http://iteaua-develop.demo.gns-it.com/");
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement preloader = driver.findElement(By.id("preload-it"));
        wait.until(ExpectedConditions.visibilityOf(preloader));
        wait.until(ExpectedConditions.invisibilityOf(preloader));

        WebElement javaCourses = driver.findElement(By.xpath("//h3[contains(text(), 'Java')]/../img"));
        wait.until(ExpectedConditions.elementToBeClickable(javaCourses));
        javaCourses.click();

        WebElement payBtn = driver.findElement(By.xpath("//button[@name='roadFull_payOnce']"));
        wait.until(ExpectedConditions.elementToBeClickable(payBtn));
        payBtn.click();
        wait.until(ExpectedConditions.visibilityOf(preloader));
        wait.until(ExpectedConditions.invisibilityOf(preloader));
        //Thread.sleep(2000);
    }

    @AfterMethod
    public static void tearDown() {
        driver.quit();
    }
}
