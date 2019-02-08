package google;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.GoogleHomePage;
import pages.ResultsPage;

import java.net.MalformedURLException;
import java.net.URL;

public class GoogleTest {

    private WebDriver driver;
    private GoogleHomePage google;
    private ResultsPage resultsPage;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);
        google = new GoogleHomePage(driver);
        resultsPage = new ResultsPage(driver);
    }

    @Test
    public void searchingCards() {
        google.goTo();
        google.searchingCards("Nissan Rogue", "Cars & Vehicles", "Greater Montréal");
        Assert.assertTrue(google.getSearchReults().size() >= 1);
    }

    @Test
    public void sortByNewestFirst(){
        resultsPage.sortBy("newest first");
    }


    @After
    public void tearDown() {
        driver.quit();
    }

}



