package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class MetamaskPage {
    private WebDriver driver;
    private String passwordFieldLocator = "//div[@id = 'app-content']";
    private String inputPasswordFieldLocator = "//*[@id = 'password']";
    private String submitPasswordLocator = "//button[@data-testid = 'unlock-submit']";
    private String forgotPasswordLocator = "//div[@class = 'unlock-page__links']/a[@class='button btn-link unlock-page__link']";
    public MetamaskPage(WebDriver driver) {
        this.driver = driver;
    }
    public void inputPassword() {
          driver.findElement(By.xpath(inputPasswordFieldLocator)).sendKeys("TestUser");
    }
    public void submitPassword() {
        driver.findElement(By.xpath(submitPasswordLocator)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
    }
}
