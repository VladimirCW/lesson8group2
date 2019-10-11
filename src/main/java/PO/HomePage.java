package main.java.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    public WebDriver driver;
    public WebDriverWait wait;
    public WebElement preloader;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
    }

    public HomePage isShown() {
        driver.get("http://iteaua-develop.demo.gns-it.com/");
        preloader = driver.findElement(By.id("preload-it"));
        wait.until(ExpectedConditions.visibilityOf(preloader));
        wait.until(ExpectedConditions.invisibilityOf(preloader));
        return this;
    }

    public HomePage selectLanguage(String lang) {
        WebElement ruLanguage = driver.findElement(By.xpath("(//a[@hreflang='" + lang + "'])[1]"));
        wait.until(ExpectedConditions.visibilityOf(ruLanguage));
        ruLanguage.click();
        System.out.println("Ru language button clicked");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("preload-it"))));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("preload-it"))));
        System.out.println("Spinner is loaded");
        return this;
    }

    public HomePage clickLogo() {
        WebElement logo = driver.findElement(By.xpath("//img[@alt='ITEA']"));
        wait.until(ExpectedConditions.visibilityOf(logo));
        logo.click();
        System.out.println("Logo clicked");
        preloader = driver.findElement(By.id("preload-it"));
        wait.until(ExpectedConditions.visibilityOf(preloader));
        wait.until(ExpectedConditions.invisibilityOf(preloader));
        return this;
    }

    public HomePage openCoursesJava() {
        WebElement javaCourses = driver.findElement(By.xpath("//h3[contains(text(), 'Java')]/../img"));
        wait.until(ExpectedConditions.elementToBeClickable(javaCourses));
        javaCourses.click();
        return this;
    }
}
