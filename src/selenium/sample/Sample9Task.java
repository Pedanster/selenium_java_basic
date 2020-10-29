package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class Sample9Task {
    WebDriver driver;

    private static WebDriverWait wait;
    static long startTime;

    @Before
    public void openPage() {
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/loading_color");
    }


        @After
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void loadGreenSleep() throws Exception {
//         TODO:

        // 1) click on start loading green button
        WebElement greenButton = driver.findElement(By.id("start_green"));
        greenButton.click();

        String loading= driver.findElement(By.id("loading_green")).getText();

        Thread.sleep(10000);
//         * 2) check that button does not appear,
//         * but loading text is seen instead   "Loading green..."
        assertFalse(greenButton.isDisplayed());
        assertEquals("Loading green...", loading);
        assertEquals("Green Loaded", driver.findElement(By.id("finish_green")).getText());

    }

    @Test
    public void loadGreenImplicit() throws Exception {
        //* 1) click on start loading green button
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement greenButton = driver.findElement(By.id("start_green"));
        greenButton.click();

        String loading= driver.findElement(By.id("loading_green")).getText();
        assertFalse(greenButton.isDisplayed());
        assertEquals("Loading green...", loading);
        assertEquals("Green Loaded", driver.findElement(By.id("finish_green")).getText());
//         TODO:
//
//         * 2) check that button does not appear,
//         * but loading text is seen instead   "Loading green..."

//         * 3) check that both button
//         * and loading text is not seen,
//         * success is seen instead "Green Loaded"
    }


    //@Test
    /* Natalja Babchenko - this test is not completed!!


    public void loadGreenExplicitWait() throws Exception {
//         TODO:
//         * 1) click on start loading green button

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("start_green")));

        WebElement greenButton = driver.findElement(By.id("start_green"));
        greenButton.click();
//         * 2) check that button does not appear,
        //assertFalse(greenButton.isDisplayed());
//         * but loading text is seen instead   "Loading green..."
        //String loading= driver.findElement(By.id("loading_green")).getText();

//         * 3) check that both button
        //assertEquals("Loading green...", loading);

        assertEquals("Green Loaded", driver.findElement(By.id("finish_green")).getText());
//         * and loading text is not seen,
//         * success is seen instead "Green Loaded"
    */

    @Test
    public void loadGreenAndBlueBonus() {
        /* TODO:
         * 0) wait until button to load green and blue appears
         * 1) click on start loading green and blue button
         * 2) check that button does not appear, but loading text is seen instead for green
         * 3) check that button does not appear, but loading text is seen instead for green and blue
         * 4) check that button and loading green does not appear,
         * 		but loading text is seen instead for blue and success for green is seen
         * 5) check that both button and loading text is not seen, success is seen instead
         */
    }

}