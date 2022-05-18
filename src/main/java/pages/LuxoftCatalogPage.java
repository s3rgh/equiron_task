package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LuxoftCatalogPage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public LuxoftCatalogPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 5);
    }

    public String loadCatalog(String buttonName) {
        return driver.findElement(By.xpath("//*[contains(text(), '" + buttonName + "')]")).getAttribute("href");
    }
}