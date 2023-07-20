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

//        navigate to Url  https://www.google.com
        driver.get("https://www.google.com");
//        locate search box Using Locator "XPath" //textarea[@aria-label='Search']
       WebElement searchBox= driver.findElement(By.xpath("//textarea[@aria-label='Search']"));
//        on the above element send value   amazon
        searchBox.sendKeys("amazon");
//        send keyboard action enter
        searchBox.sendKeys(Keys.ENTER);


//        get link text and store it in a list Using Locator "Link Text" https://www.amazon.in/ || https://www.amazon.com
      // List<WebElement> = driver.findElements(By.linkText("https://www.amazon.in/"));

//        check ifthe size of the list is > 0
        Boolean resultOne=driver.findElement(By.xpath("//*[contains(text(),'amazon.in')]")).isDisplayed();
        Boolean resultTwo=driver.findElement(By.xpath("//*[contains(text(),'amazon.com')]")).isDisplayed();
       if(resultOne && resultTwo)
        System.out.println("Amazon links are present");
       else
           System.out.println("amazon links are not present");

    }
}
