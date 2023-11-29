import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import po.ConnectPage;
import po.HomePage;
import po.MetamaskPage;

import java.time.Duration;

public class OenMMTest extends BaseTest {

    @DisplayName("test")
    @Test
    public void openMM() throws InterruptedException {
        startDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        ConnectPage connectPage = new ConnectPage(driver);
        connectPage.clickConnectBtn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        connectPage.markCheckBox();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        connectPage.selectMetamaskConnector();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String mainWindowHandle = driver.getWindowHandle();
        MetamaskPage metamaskPage = new MetamaskPage(driver);

        switchToMetaMaskWindow(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.out.println(driver.getTitle());
        metamaskPage.inputPassword();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        metamaskPage.submitPassword();

        driver.switchTo().window(mainWindowHandle);
        Thread.sleep(5);
        HomePage homePage = new HomePage(driver);
        String actualText = homePage.getNoKongsText();

        System.out.println(actualText);
        Thread.sleep(5);
        Assertions.assertEquals("This wallet has no Kongs!", actualText, "Error! Something went wrong");
    }
}


