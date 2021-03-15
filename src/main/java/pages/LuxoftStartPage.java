package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

//TODO: добавить использование шаблона Chain of Responsibility

public class LuxoftStartPage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public LuxoftStartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 5);
    }

    public LuxoftStartPage openUrl(String url) {
        driver.get(url);
        return this;
    }

    public LuxoftCatalogPage openMenuPoint(String menuPoint) {
        driver.findElement(By.xpath("//div[@class='header__box _main']/.//*[text()='" + menuPoint + "']")).click();
        return new LuxoftCatalogPage(driver);
    }
}