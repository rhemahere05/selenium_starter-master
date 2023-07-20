package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class SearchAmazon {
    ChromeDriver driver;

    public SearchAmazon()
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
    public  void testCase01(){

        driver.get("https://www.google.com");
       WebElement searchBox= driver.findElement(By.xpath("//textarea[@aria-label='Search']"));
        searchBox.sendKeys("amazon");
        searchBox.sendKeys(Keys.ENTER);
        Boolean resultOne=driver.findElement(By.xpath("//*[contains(text(),'amazon.in')]")).isDisplayed();
        Boolean resultTwo=driver.findElement(By.xpath("//*[contains(text(),'amazon.com')]")).isDisplayed();
       if(resultOne && resultTwo)
        System.out.println("Amazon links are present");
       else
           System.out.println("amazon links are not present");

    }
}
