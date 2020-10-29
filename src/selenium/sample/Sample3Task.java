package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class Sample3Task {
    WebDriver driver;

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.get("https://kristinek.github.io/site/examples/locators");
    }

    @After
    public void endingTests() throws Exception {
        this.driver.quit();
    }

    @Test
    public void assertEqualsTask() throws Exception {
        long expected = 5L;
        long actual = (long)this.driver.findElements(By.className("test")).size();
        Assert.assertEquals(expected, actual);

        String expected1 = "This is also a button";
        String actual1 = this.driver.findElement(By.name("randomButton2")).getAttribute("value");
        Assert.assertEquals(expected1, actual1);
    }

    @Test
    public void assertTrueTask() throws Exception {
        String exp1 = this.driver.findElement(By.name("randomButton2")).getAttribute("value");
        Assert.assertTrue(exp1.equals("This is also a button"));
        Assert.assertTrue(exp1.equalsIgnoreCase("this is Also a Button"));
        Assert.assertTrue(true);
    }

    @Test
    public void assertFalseExample() throws Exception {
        String exp = this.driver.findElement(By.name("randomButton2")).getAttribute("value");
        Assert.assertFalse(exp.equals("This is a button"));
        Assert.assertFalse(exp.equals("wrong text"));
        Assert.assertFalse(exp.contains("wrong text"));
        Assert.assertFalse(false);
    }

    @Test
    public void failTask() throws Exception {
        List<WebElement> elements = this.driver.findElements(By.className("test"));
        for(WebElement elementWithClass : elements) {
            Assert.assertFalse(elementWithClass.getText().contains("190"));
        }

    }
}
