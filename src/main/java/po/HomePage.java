package po;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    private String modalWindowNoKongsLocator = "//div[@class = 'title text-center'][text() = 'This wallet has no Kongs!']";
    private String modalBoxLocator = "//div[@id = 'modal-4']/div[@class = 'modal-box']";
    private String titleBuyLocator = "//div[@class = 'buy-box']/div[@class = 'title'][text() = 'To purchase an Alpha Kong:']";
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public String getNoKongsText() {
        WebElement element = driver.findElement(By.xpath(modalWindowNoKongsLocator));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return element.getText();
    }
    public String getBuyText() {
        WebElement element = driver.findElement(By.xpath(titleBuyLocator));
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(By.xpath("//div[@class = 'modal-box']")));
        return element.getText();
    }

    public String getModalBoxText() {
        WebElement element = driver.findElement(By.xpath(modalBoxLocator));
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(By.xpath("//div[@class = 'modal-box']")));
        return element.getText();
    }
    public String getTextJS() {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        return (String) js.executeScript("document.getElementsByClassName('title text-center')[0].textContent");
    }
}
