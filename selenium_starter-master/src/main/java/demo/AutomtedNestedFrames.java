package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AutomtedNestedFrames {

    ChromeDriver driver;

    public AutomtedNestedFrames() {
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
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        System.out.println("Left frame text :"+driver.findElement(By.tagName("body")).getText());
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        System.out.println("Middle frame text :"+driver.findElement(By.tagName("body")).getText());
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        System.out.println("Right frame text :"+driver.findElement(By.tagName("body")).getText());
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-bottom");
        System.out.println("Bottom frame text :"+driver.findElement(By.tagName("body")).getText());
        driver.switchTo().defaultContent();
    }
}
