import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    public WebDriver driver;
    public void startDriver() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("user-data-dir=C:\\Users\\User\\AppData\\Local\\Google\\Chrome\\User Data\\TestUser");
        driver = new ChromeDriver(options);
        driver.get("https://deepintothejungle.esas.by/en/");
      Thread.sleep(5000);
        driver.navigate().refresh();
    }
    public  void switchToMetaMaskWindow(WebDriver driver) {
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);

            if (driver.getTitle().contains("MetaMask notification")) {
                break;
            }
        }
    }

    @AfterEach
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
