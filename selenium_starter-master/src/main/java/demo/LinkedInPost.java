package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LinkedInPost {
    ChromeDriver driver;

    public LinkedInPost()
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

        driver.get("https://in.linkedin.com/");
        WebElement emailPhone =driver.findElement(By.id("session_key"));
        emailPhone.sendKeys("valid user name");
        WebElement password = driver.findElement(By.id("session_password"));
        password.sendKeys("valid password");
        driver.findElement(By.xpath(" //button[contains(text(),'Sign in')]")).click();
        WebElement images = driver.findElement(By.xpath("//label[@Text()='Select images to share']"));
        images.sendKeys("C:\\Users\\Hema\\Desktop\\crio_git_work");
        driver.findElement(By.id("ember339"));

    }

}
