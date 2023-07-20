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
//        navigate to Url  https://the-internet.herokuapp.com/nested_frames
        driver.get("https://the-internet.herokuapp.com/nested_frames");
//        locate the top frame Using Locator "Name" frame-top
//        switchTo() frame
        driver.switchTo().frame("frame-top");
//        locate the left frame Using Locator "Name" frame-left
//        switchTo() frame
        driver.switchTo().frame("frame-left");
//        get the text using Using Locator "Tag Name" body
        System.out.println("Left frame text :"+driver.findElement(By.tagName("body")).getText());
//        switchTo().parentFrame()
        driver.switchTo().parentFrame();
//        locate the middle frame Using Locator "Name" frame-middle
//        switchTo() fame
        driver.switchTo().frame("frame-middle");
//        use driver.getText() Using Locator "Tag Name" body
        System.out.println("Middle frame text :"+driver.findElement(By.tagName("body")).getText());
//        switchTo().parentContent()
        driver.switchTo().parentFrame();
//        locate the right frame Using Locator "Name" frame-right
//        switchTo() fame
        driver.switchTo().frame("frame-right");
//        use driver.getText() Using Locator "Tag Name" body
        System.out.println("Right frame text :"+driver.findElement(By.tagName("body")).getText());
//        switchTo().parentContent()
        driver.switchTo().parentFrame();
//        switchTo().parentContent()
        driver.switchTo().parentFrame();
//        locate the bottom frame Using Locator "Name" frame-bottom
//        switchTo().frame
        driver.switchTo().frame("frame-bottom");
//        get the text  Using Locator "Tag Name" body
        System.out.println("Bottom frame text :"+driver.findElement(By.tagName("body")).getText());
//        switchTo().defaultContent()
        driver.switchTo().defaultContent();
    }
}
