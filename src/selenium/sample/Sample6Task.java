package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample6Task {
    WebDriver driver;

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        // declaration above:
        driver = new ChromeDriver();
        //open page:
        driver.get("https://kristinek.github.io/site/examples/locators");
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.quit();
    }

    @Test
    public void findElementByXPath() throws Exception {
//         TODO:
//        2 ways to find text: "Heading 2 text":
       System.out.println("to find text:" + driver.findElement(By.xpath("//*[@id = 'heading_2']")).getText());
       System.out.println("to find text:" + driver.findElement(By.cssSelector("#heading_2")).getText());

      //1-2 ways to find text: "Test Text 1"
        System.out.println("to find text:" + driver.findElement(By.xpath("//body/div[@id='test1']/p[1]")).getText());
       System.out.println("to find text:" + driver.findElement(By.cssSelector("#test1 > p.test")).getText());

      //1-2 ways to find text: "Test Text 2"
       System.out.println("to find text:" + driver.findElement(By.xpath("//body/div[@id='test1']/p[2]")).getText());
     System.out.println("to find text:" + driver.findElement(By.cssSelector("#test1 > p.twoTest")).getText());

     // 1-2 ways to find text: "Test Text 3"
       System.out.println("to find text:" + driver.findElement(By.xpath("//body/div[@id='test3']/p[1]")).getText());
       System.out.println("to find text:" + driver.findElement(By.cssSelector("#test3 > p:nth-child(1)")).getText());

      //1-2 ways to find text: "Test Text 4"
        System.out.println("to find text:" + driver.findElement(By.xpath("//body/div[@id='test3']/p[2]")).getText());
      System.out.println("to find text:" + driver.findElement(By.cssSelector("#test3 > p:nth-child(2)")).getText());

      // 1-2 ways to find text: "Test Text 5"
       System.out.println("to find text:" + driver.findElement(By.xpath("//body/div[@id='test2']/p[1]")).getText());
        System.out.println("to find text:" + driver.findElement(By.cssSelector("#test2 > p.Test")).getText());
     //   1-2 ways to find text: "This is also a button"
        System.out.println("to find text:" + driver.findElement(By.xpath("//input[@id='buttonId']")).getAttribute( "Value"));
        System.out.println("to find text:" + driver.findElement(By.cssSelector("#buttonId")).getAttribute( "Value"));
    }

    @Test
    public void findElementByCssName() throws Exception {
//         TODO:
//        1-2 ways to find text: "Heading 2 text" - there is no class for this element

//        1-2 ways to find text: "Test Text 1"
        System.out.println("to find text:" + driver.findElement(By.xpath("//*[@class = 'test']")).getText());
        System.out.println("to find text:" + driver.findElement(By.cssSelector(".test")).getText());
//        1-2 ways to find text: "Test Text 2"
        System.out.println("to find text:" + driver.findElement(By.xpath("//*[@ class= 'twoTest']")).getText());
        System.out.println("to find text:" + driver.findElement(By.cssSelector(".twoTest")).getText());
//        1-2 ways to find text: "Test Text 3"
       // System.out.println("to find text:" + driver.findElement(By.xpath("//*[contains(@class = 'test' and @id = 'test3')]")).getText());
       // System.out.println("to find text:" + driver.findElement(By.cssSelector("#test3.test")).getText());
//
//        1-2 ways to find text: "This is also a button" - there is no class for this element

    }
}//*[contains(@class,'test') and @id='test3']
