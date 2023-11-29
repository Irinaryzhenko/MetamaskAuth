package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConnectPage {
    private WebDriver driver;
    private String connectButtonLocator = "//*[@id='root']/div[2]/div[2]/div[2]/div[3]/a";
    private String termsCheckBoxTrueLocator = "//div[@class = 'checkbox-input']";
    private String metamaskConnectButtonLocator = "//div[@class = 'link']/a[@class = 'btn-1']";

    public ConnectPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickConnectBtn() {
        driver.findElement(By.xpath(connectButtonLocator)).click();
    }
    public void markCheckBox() {
        driver.findElement(By.xpath(termsCheckBoxTrueLocator)).click();
    }
    public void selectMetamaskConnector() {
        driver.findElement(By.xpath(metamaskConnectButtonLocator)).click();
    }

}
