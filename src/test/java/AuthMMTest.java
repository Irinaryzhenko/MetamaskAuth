import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import po.ConnectPage;
import po.HomePage;
import po.MetamaskPage;
import java.time.Duration;

public class AuthMMTest extends BaseTest {

    @DisplayName("test")
    @Test
    public void openMM() throws InterruptedException {
        startDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        ConnectPage connectPage = new ConnectPage(driver);
        connectPage.clickConnectBtn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        connectPage.markCheckBox();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        connectPage.selectMetamaskConnector();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String mainWindowHandle = driver.getWindowHandle();
        MetamaskPage metamaskPage = new MetamaskPage(driver);

        switchToMetaMaskWindow(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.out.println(driver.getTitle());

        metamaskPage.inputPassword();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        metamaskPage.submitPassword();
        Thread.sleep(10);
        driver.switchTo().window(mainWindowHandle);

        HomePage homePage = new HomePage(driver);

//        System.out.println(homePage.getTextJS());
//        String actualText = homePage.getNoKongsText();

        String actualText = homePage.getBuyText();
        System.out.println(actualText);
        Assertions.assertEquals("To purchase an Alpha Kong:", actualText, "Error! Something went wrong");
    }
}
