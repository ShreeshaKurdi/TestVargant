package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiPage extends BasePage{

	@FindBy (xpath = "//div[text()='Release date']/..//following-sibling::td//child::li")
	WebElement wikiDate;

	@FindBy (xpath = "//th[text()='Country']//following-sibling::td")
	WebElement wikiCountry;

	public WikiPage(WebDriver driver) {   
		PageFactory.initElements(driver, this); 
	}

	public void scrollingPage() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int x = wikiDate.getLocation().getY();
		js.executeScript("window.scrollTo(0, "+x+")");
	}

	public String getWikiDate() {
		String date =wikiDate.getText();
		System.out.println(date);
		return date;
	}

	public String getWikiCountry() {
		String country = wikiCountry.getText();
		System.out.println(country);
		return country;
	}

}
