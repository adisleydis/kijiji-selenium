package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class GoogleHomePage {
    private final WebDriver driver;

    @FindBy(id = "SearchKeyword")
    private WebElement search;

    @FindBy(id = "SearchCategory")
    private WebElement searchCategory;

    @FindBy(id = "SearchLocationPicker")
    private WebElement searchLocation;

    @FindBy(name = "SearchSubmit")
    private WebElement searchSubmit;

    @FindBy(className = "info-container")
    private List<WebElement> searchResults;

    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public GoogleHomePage goTo() {
        this.driver.get("https://www.kijiji.ca/");
        return this;
    }

    public void searchingCards(String cardType, String category, String location) {
        this.search.sendKeys(cardType);
        this.searchCategory.sendKeys (category);
        this.searchLocation.sendKeys(location);
        this.searchSubmit.click();
    }

    public List<WebElement> getSearchReults() {
        return this.searchResults;
    }

}