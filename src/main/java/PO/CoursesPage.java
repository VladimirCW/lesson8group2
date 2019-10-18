package main.java.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoursesPage extends BasePage {

    public CoursesPage(WebDriver driver) {
        super(driver);
    }

    public CoursesPage clickPay() {
        WebElement payBtn = driver.findElement(By.xpath("//button[@name='roadFull_payOnce']"));
        wait.until(ExpectedConditions.elementToBeClickable(payBtn));
        payBtn.click();
        this.waitSpinner();
        return this;
    }

    public boolean checkIfLocationIsSelected(String location) {
        By element = By.xpath("//input[@id=//div[contains(text(), '" + location + "')]/../@for]");
        WebElement webLocation = driver.findElement(element);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        return webLocation.isSelected();
    }
}
