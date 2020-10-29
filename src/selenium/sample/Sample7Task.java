package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

public class Sample7Task {
    WebDriver driver;
    String base_url = "https://kristinek.github.io/site/examples/actions";

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        // declaration above:
        driver = new ChromeDriver();
        //open page:
        driver.get(base_url);
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.quit();
    }

    @Test
    public void selectCheckBox() throws Exception {
//         TODO:
//        check that none of the checkboxes are ticked
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector(".w3-check[type='checkbox']"));
        for (WebElement checkBox : checkBoxes) {
            assertFalse(checkBox.isSelected());
        }
//        tick  "Option 2"
        WebElement option2 = driver.findElement(By.cssSelector(".w3-check[value='Option 2'][type='checkbox']"));
        option2.click();

//    check that "Option 1" and "Option 3" are not ticked, but "Option 2" is ticked
      WebElement option1 = driver.findElement(By.cssSelector(".w3-check[value='Option 1'][type='checkbox']"));
        assertFalse(option1.isSelected());
        WebElement option3 = driver.findElement(By.cssSelector(".w3-check[value='Option 3'][type='checkbox']"));
       assertFalse(option3.isSelected());
        assertTrue(option2.isSelected());
//
//        tick  "Option 3"
        option3.click();

//        click result
        WebElement result = driver.findElement(By.id("result_button_checkbox"));
        result.click();


//        check that text 'You selected value(s): Option 2, Option 3' is being displayed
        WebElement textDisp = driver.findElement(By.id("result_checkbox"));
        assertTrue(textDisp.isDisplayed());
    }


    @Test
   public void selectRadioButton() throws Exception {
//         TODO:
       List<WebElement> radioButtons = driver.findElements(By.cssSelector(".w3-check[type='radio']"));
//
//        check that none of the radio are selected
       for(WebElement radioButton : radioButtons){
            assertFalse(radioButton.isSelected());
        }
//        select  "Option 3"
        WebElement option3 = driver.findElement(By.id("vfb-7-3"));
       option3.click();



//        check that "Option 1" and "Option 2' are not select, but "Option 3" is selected
        WebElement option1 = driver.findElement(By.id("vfb-7-1"));
        WebElement option2 = driver.findElement(By.id("vfb-7-2"));
        assertFalse(option1.isSelected());
       assertFalse(option2.isSelected());
        assertTrue(option3.isSelected());

//        select  "Option 1"
       option1.click();

//        check that "Option 2" and "Option 3' are not select, but "Option 1" is selected
        assertFalse(option2.isSelected());
        assertFalse(option3.isSelected());
        assertTrue(option1.isSelected());

//        click result
        WebElement result = driver.findElement(By.id("result_button_ratio"));
        result.click();

//        check that 'You selected option: Option 1' text is being displayed
       WebElement textDisp1 = driver.findElement(By.id("result_radio"));
        assertTrue(textDisp1.isDisplayed());

    }

    @Test
    public void selectOption() throws Exception {

//        select "Option 3" in Select
        Select dropdown = new Select(driver.findElement(By.id("vfb-12")));
       assertEquals("Choose your option", dropdown.getFirstSelectedOption().getText());
        dropdown.selectByVisibleText("Option 3");

//        check that selected option is "Option 3"
        assertEquals("Option 3", dropdown.getFirstSelectedOption().getText());

//        select "Option 2" in Select

      dropdown.selectByIndex(2);

//        check that selected option is "Option 2"
     assertEquals( "Option 2", dropdown.getFirstSelectedOption().getText());

//        click result

        WebElement result1 = driver.findElement(By.id("result_button_select"));
        result1.click();

//        check that 'You selected option: Option 2' text is being displayed
        WebElement textDisp2 = driver.findElement(By.xpath("//p[@id='result_select']"));
        assertTrue(textDisp2.isDisplayed());


    }

   /* @Test
    public void chooseDateViaCalendarBonus() throws Exception {
//         TODO:
        Calendar cal = Calendar.getInstance();

        String result = new SimpleDateFormat("07/04/2007").format(cal.getTime());

        WebElement dateWidget = driver.findElement(By.id("ui-datepicker-div"));
        for (int i = 0; i < 159; i++) {

            dateWidget.findElement(By.className("ui-datepicker-calendar")).click();
        }
        dateWidget.findElement(By.xpath("//a[text()='4']")).click();

        assertEquals(result, dateWidget.getAttribute("value"));


        //enter date '4 of July 2007' using calendar widget


//        check that correct date is added

    }

    @Test
    public void chooseDateViaTextBoxBonus() throws Exception {
//         TODO:
//        enter date '2 of May 1959' using text
//        check that correct date is added
        */
    }

