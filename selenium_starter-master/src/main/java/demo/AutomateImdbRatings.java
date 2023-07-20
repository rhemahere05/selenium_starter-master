package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.apache.commons.lang3.ArrayUtils.addAll;

public class AutomateImdbRatings {
    ChromeDriver driver;

    public AutomateImdbRatings() {
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


        driver.get("https://www.imdb.com/chart/top");

        List<WebElement> listOfMovies = driver.findElements(By.xpath("//div[@data-testid='chart-layout-main-column']/ul/li"));
        List<WebElement> movieRating = driver.findElements(By.xpath("//div[@data-testid='chart-layout-main-column']/ul/li"));

            WebElement selector = driver.findElement(By.id("sort-by-selector"));
            Select select = new Select(selector);
            select.selectByVisibleText("Ranking");
            WebElement ranking = driver.findElement(By.xpath("//div[@data-testid='chart-layout-main-column']/ul/li/div[2]/div/div/div/a/h3"));
            System.out.println("highest rated movie name :"+ranking.getText());
            System.out.println("Total no of movies in the table :"+listOfMovies.size());

            select.selectByVisibleText("Release date");
            List<WebElement> yearBasedList = driver.findElements(By.xpath("//div[@data-testid='chart-layout-main-column']/ul/li/div[2]/div/div/div/a/h3"));
            ArrayList<WebElement> yearList = new ArrayList<>();
            yearList.addAll(yearBasedList);
            System.out.println("Oldest movie of the list is:"+(yearList.get(yearList.size()-1)).getText());
            System.out.println("Recent movie of the list is:"+(yearList.get(0)).getText());

            select.selectByVisibleText("Number of ratings");
            WebElement highestRated = driver.findElement(By.xpath("//div[@data-testid='chart-layout-main-column']/ul/li/div[2]/div/div/div/a/h3"));
            System.out.println("highest user rated movie name :"+highestRated.getText());



    }
}
