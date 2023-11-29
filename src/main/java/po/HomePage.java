package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    private String modalWindowNoKongsLocator = "//div[@class = 'title text-center']";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public String getNoKongsText() {
        WebElement element = driver.findElement(By.xpath(modalWindowNoKongsLocator));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return element.getText();
    }
}
