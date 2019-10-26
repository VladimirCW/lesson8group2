package main.java.PO;

import io.qameta.allure.Step;
import main.java.Utils.PropertyLoader;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomePage extends BasePage {

    public Logger logger = LogManager.getLogger(this.getClass());

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Open home page")
    public HomePage isShown() {
        driver.get(PropertyLoader.loadProperty("url"));
        this.waitSpinner();
        logger.info("The page is shown");
        return this;
    }

    @Step("Select language {lang}")
    public HomePage selectLanguage(String lang) {
        logger.info("Select language '" + lang + "'");
        WebElement ruLanguage = driver.findElement(By.xpath("(//a[@hreflang='" + lang + "'])[1]"));
        wait.until(ExpectedConditions.visibilityOf(ruLanguage));
        ruLanguage.click();
        this.waitSpinner();
        return this;
    }

    public HomePage clickLogo() {
        WebElement logo = driver.findElement(By.xpath("//img[@alt='ITEA']"));
        wait.until(ExpectedConditions.visibilityOf(logo));
        logo.click();
        System.out.println("Logo clicked");
        this.waitSpinner();
        return this;
    }

    public HomePage openCourses(String courseName) {
        WebElement javaCourses = driver
                .findElement(By.xpath("//h3[contains(text(), '" + courseName + "')]/../img"));
        wait.until(ExpectedConditions.elementToBeClickable(javaCourses));
        javaCourses.click();
        return this;
    }

    public boolean languagesArePresent() {
        String arr[] = {"RU", "UA", "EN"};
        List<String> list = new ArrayList<String>(Arrays.asList(arr));
        boolean isPresent = true;
        List<WebElement> elements = driver.findElements(By.xpath("(//ul[@class='lang'])[1]/li/a"));
        for (WebElement el : elements) {
            String text = el.getText();
            if (!list.contains(text)) {
                isPresent = false;
            }
        }
        return isPresent;
    }
}
