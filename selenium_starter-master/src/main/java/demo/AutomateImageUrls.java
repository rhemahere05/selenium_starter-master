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

        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        List<WebElement> links = driver.findElements(By.xpath("//h2[text()='Recommended Movies']/parent::div/parent::div/parent::div/following-sibling::div/div/div/div//img"));
        Iterator<WebElement> iterate = links.iterator();

        while(iterate.hasNext()){
            System.out.println("image links" + iterate.next().getAttribute("src"));
        }
         JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("window.scrollBy(0,800)","");
        List<WebElement>details= driver.findElements(By.xpath("//div[text()='Brand new releases every Friday']/parent::div/following-sibling::div/div/div/div[2]/a/div/div[3]/div/div"));
        Iterator<WebElement> iterateDetails = details.iterator();
            while(iterateDetails.hasNext()){
                System.out.println("moviedetails:"+iterateDetails.next().getText());
            }
    }
}
