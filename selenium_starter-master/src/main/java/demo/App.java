/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package demo;
import java.net.MalformedURLException;


public class App {
    public void getGreeting() throws InterruptedException, MalformedURLException {
//        TestCases tests = new TestCases(); // Initialize your test class
//
//        //TODO: call your test case functions one after other here
//
//        tests.testCase01();

//        SearchAmazon searchAmazon = new SearchAmazon();
//        searchAmazon.testCase01();

//        CountOfHyperLinks countOfHyperLinks = new CountOfHyperLinks();
//        countOfHyperLinks.testCase01();

//        LinkedInPost linkedInPost = new LinkedInPost();
//        linkedInPost.testCase01();
//
//        AutomateImageUrls automateImageUrls = new AutomateImageUrls();
//        automateImageUrls.testCase01();

//        AutomtedNestedFrames automtedNestedFrames = new AutomtedNestedFrames();
//        automtedNestedFrames.testCase01();

//        AutomateImdbRatings automateImdbRatings = new AutomateImdbRatings();
//        automateImdbRatings.testCase01();

        AutomateWindowHandling automateWindowHandling = new AutomateWindowHandling();
        automateWindowHandling.testCase01();

        //END Tests


     //  searchAmazon.endTest(); // End your test by clearning connections and closing browser
    //    countOfHyperLinks.endTest();
        //linkedInPost.endTest();
     //   automateImageUrls.endTest();
  //      automtedNestedFrames.endTest();
    //    automateImdbRatings.endTest();
        automateWindowHandling.endTest();

    }

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        new App().getGreeting();



    }
}