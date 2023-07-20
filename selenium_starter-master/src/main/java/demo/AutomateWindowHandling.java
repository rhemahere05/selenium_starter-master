package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class AutomateWindowHandling {
    ChromeDriver driver;

    public AutomateWindowHandling() {
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
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        driver.switchTo().frame("iframeResult");
        driver.findElement(By.xpath("//button[text()='Try it']")).click();
        driver.switchTo().defaultContent();
        Set<String> allWindow = driver.getWindowHandles();
        String parentWindow = driver.getWindowHandle();

        Iterator iterate = allWindow.iterator();
        while ((iterate.hasNext())) {
            String childWindow = (String) iterate.next();

            if (childWindow.equals(parentWindow)) {
                continue;
            } else {
                driver.switchTo().window(childWindow);
                TakesScreenshot screenshot = (TakesScreenshot) driver;
                try {
                    FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE), new File("C:\\Users\\Hema\\Desktop\\crio_git_work\\selenium_starter-master\\selenium_starter-master\\screenshot\\Screenshot.png"));
                } catch (Exception e) {
                    e.getMessage();
                }
            }

        }
        driver.close();
        driver.switchTo().window(parentWindow);
    }
}
