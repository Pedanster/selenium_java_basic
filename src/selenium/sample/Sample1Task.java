//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package selenium.sample;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample1Task {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";

    public Sample1Task() {
    }

    @Test
    public void goToHomepage() throws Exception {

        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://kristinek.github.io/site/");

        //get title of page
        System.out.println(driver.getTitle());

        //get URL from current page
        System.out.println(driver.getCurrentUrl());

// close browser
        driver.quit();
    }
}
