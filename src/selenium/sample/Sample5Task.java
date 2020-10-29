package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class Sample5Task {
    WebDriver driver;

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/alerts_popups");
    }

    @After
    public void endingTests() throws Exception {
        driver.quit();
    }

    @Test
    public void goToAlertedPageViaButton() throws Exception {
        driver.findElement(By.className("w3-blue")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Want to see an alerted page?!", alert.getText());
        alert.accept();
        Alert alert1 = driver.switchTo().alert();
        Assert.assertEquals("Booooooooo!", alert1.getText());
        alert1.accept();
        Assert.assertEquals("This page is alerted", driver.findElement(By.id("heading")).getText());
    }

    @Test
    public void doNotGoToAlertedPageViaButton() throws Exception {
        driver.findElement(By.className("w3-blue")).click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        Assert.assertEquals("So you desided to say? Good!", driver.findElement(By.id("textForAlerts")).getText());
    }
}
