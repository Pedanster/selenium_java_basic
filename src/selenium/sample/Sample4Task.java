package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class Sample4Task {
    WebDriver driver;
    String base_url = "https://kristinek.github.io/site/examples/actions";

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.get(this.base_url);
    }

    @After
    public void endingTests() throws Exception {
        this.driver.quit();
    }

    @Test
    public void enterNumber() throws Exception {
        WebElement numberInput = this.driver.findElement(By.id("number"));
        numberInput.sendKeys(new CharSequence[]{"4"});
        WebElement clickButton = this.driver.findElement(By.id("clear_result_button_number"));
        Assert.assertFalse(clickButton.isEnabled());
        WebElement textDip = this.driver.findElement(By.id("result_number"));
        Assert.assertFalse(textDip.isDisplayed());
        WebElement resultButton = this.driver.findElement(By.id("result_button_number"));
        resultButton.click();
        Assert.assertTrue(textDip.isEnabled());
        Assert.assertEquals("You entered number: \"45\"", textDip.getText());
        Assert.assertTrue(clickButton.isEnabled());
        clickButton.click();
        Assert.assertEquals("", textDip.getText());
        Assert.assertFalse(textDip.isDisplayed());
    }

    @Test
    public void clickOnLink() throws Exception {
        Assert.assertEquals(this.base_url, this.driver.getCurrentUrl());
        WebElement button = this.driver.findElement(By.id("homepage_link"));
        button.click();
        Assert.assertFalse(this.driver.getCurrentUrl().equals(this.base_url));
        Assert.assertEquals("https://kristinek.github.io/site/", this.driver.getCurrentUrl());
    }
}
