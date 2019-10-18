package main.java.PO;

import main.java.Utils.PropertyLoader;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    public Logger logger = LogManager.getLogger(this.getClass());

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public HomePage isShown() {
        logger.trace("Trace log");
        logger.debug("Debug log sefssdfasdfsdf sdffsda fsdafasdfsd \n fsdfasfasdfasdfasdfa\n sdfgasdfdasfsdf\n ffasdfsd\nfafsdf");
        logger.info("Info log");
        logger.warn("Warn log");
        logger.error("Error log");
        logger.fatal("Fatal log");

        driver.get(PropertyLoader.loadProperty("url"));
        this.waitSpinner();
        logger.info("The page is shown");
        return this;
    }

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
}
