package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

public class LuxoftPage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public LuxoftPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 5);
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public void isPageInitialized() {
        JavascriptExecutor input = (JavascriptExecutor) driver;
        assertThat(input.executeScript("return document.readyState").equals("complete")).isEqualTo(true);
    }

    public void openMenuPoint() {
        driver.findElement(By.xpath("//div[@class='header__box _main']/.//*[text()='Каталог']")).click();
    }

    public void loadCatalog() {
        WebElement element = driver.findElement(By.xpath("//*[@href='/files/luxoft_training_catalog.pdf']"));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).click().perform();
    }
}