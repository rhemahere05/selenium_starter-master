package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutomateImageUrls {

    ChromeDriver driver;

    public AutomateImageUrls() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("headless");
//        driver = new ChromeDriver(options);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01() {
//    navigate to url  https://in.bookmyshow.com/explore/home/chennai
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
//    store all the webelement of links in a list  Using Locator "XPath" //h2[text()='Recommended Movies']/parent::div/parent::div/parent::div/following-sibling::div/div/div/div//img
        List<WebElement> links = driver.findElements(By.xpath("//h2[text()='Recommended Movies']/parent::div/parent::div/parent::div/following-sibling::div/div/div/div//img"));
//    iterate through the list of elements
        Iterator<WebElement> iterate = links.iterator();

//    using getAttribute() get and print the image links
        while(iterate.hasNext()){
            System.out.println("image links" + iterate.next().getAttribute("src"));
        }
        // scroll downro view premier list
         JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)","");
     //Actions action = new Actions(driver);
      //  action.sendKeys(Keys.PAGE_DOWN).build().perform();
     //   action.sendKeys(Keys.PAGE_DOWN).build().perform();
      //  WebDriverWait wait = new WebDriverWait(driver, 30);
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Brand new releases every Friday']/parent::div/following-sibling::div/div/div/div[2]/a/div/div[3]/div/div")));

//    locate the elements for name and language and store it in a list Using Locator "XPath" //div[text()='Brand new releases every Friday']/parent::div/following-sibling::div/div/div/div[2]/a/div/div[3]/div/div
     List<WebElement>details= driver.findElements(By.xpath("//div[text()='Brand new releases every Friday']/parent::div/following-sibling::div/div/div/div[2]/a/div/div[3]/div/div"));
    // js.executeScript("arguments[0].scrollIntoView(); ",details);
       // ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", details);
     //    iterate through the list of elements

        Iterator<WebElement> iterateDetails = details.iterator();
            while(iterateDetails.hasNext()){
                //    using getText() print the name and language of the 2nd item
                System.out.println("moviedetails:"+iterateDetails.next().getText());

            }


    }
}
