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

//        navigate to Url  linkedin.com
        driver.get("https://in.linkedin.com/");
//       locate email/phone input textbox Using Locator "ID" session_key
        WebElement emailPhone =driver.findElement(By.id("session_key"));
//        send value through send keys
        emailPhone.sendKeys("valid user name");
//        locate password field Using Locator "ID" session_password
        WebElement password = driver.findElement(By.id("session_password"));
//        send password through sendkeys
        password.sendKeys("valid password");
//        click on sign  in button  Using Locator "XPath" //button[contains(text(),'Sign in')]
        driver.findElement(By.xpath(" //button[contains(text(),'Sign in')]")).click();
//        click on photo button Using Locator "XPath" //div[contains(@class,'share-box-feed-entry__tool-bar')]//button[@aria-label='Add a photo']
//
//        locate select images to share label Using Locator "XPath" //label[@Text()='Select images to share']
        WebElement images = driver.findElement(By.xpath("//label[@Text()='Select images to share']"));
//        send the file path using send keys for the above label  file path
        images.sendKeys("C:\\Users\\Hema\\Desktop\\crio_git_work");
//        click on Done button Using Locator "ID" ember339
        driver.findElement(By.id("ember339"));

    }

}
