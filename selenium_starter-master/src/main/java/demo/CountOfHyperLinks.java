package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CountOfHyperLinks {

    ChromeDriver driver;

    public CountOfHyperLinks()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }



    public  void testCase01() {
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        List<WebElement> hyperLinks = driver.findElements(By.tagName("a"));
        System.out.println("Count of hyperLinks"+ hyperLinks.size());

    }
}
