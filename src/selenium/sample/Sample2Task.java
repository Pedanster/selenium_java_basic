package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;

public class Sample2Task {
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
    public void findElementByID() throws Exception {
        System.out.println(this.driver.findElement(By.id("heading_2")).getAttribute("id"));
    }

    @Test
    public void findElementByName() throws Exception {
        System.out.println(this.driver.findElement(By.name("randomButton2")).getAttribute("value"));
        System.out.println(this.driver.findElement(By.name("randomButton2")).getAttribute("id"));
    }

    @Test
    public void findElementByClassFirst() throws Exception {
        System.out.println(this.driver.findElement(By.className("test")).getText());
    }

    @Test
    public void findElementByClassAll() throws Exception {
        System.out.println(this.driver.findElements(By.className("test")).size());
        List<WebElement> allElementsWithClass = this.driver.findElements(By.className("test"));
        Iterator var2 = allElementsWithClass.iterator();

        while(var2.hasNext()) {
            WebElement elementWithClass = (WebElement)var2.next();
            System.out.println(((WebElement)this.driver.findElements(By.className("text")).get(0)).getText());
            System.out.println(((WebElement)this.driver.findElements(By.className("test")).get(3)).getText());
        }

    }
}
