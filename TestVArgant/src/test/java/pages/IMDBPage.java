package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IMDBPage extends BasePage{

	@FindBy (xpath = "//a[text()='Release date']/..//child::div//a")
	WebElement imdbDate;


	@FindBy (xpath = "//span[text()='Country of origin']//following-sibling::div//a")
	WebElement imdbCountry;

	public IMDBPage(WebDriver driver) {   
		PageFactory.initElements(driver, this); 
	}

	public void scrollingPage() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int x = imdbDate.getLocation().getY();
		js.executeScript("window.scrollTo(0, "+x+")");
	}
	
	public String getImdbDate () {
		String rawdate =imdbDate.getText();
		String[] date1 = rawdate.split(",");        
		String dateAndMonth = date1[0];
		String yearAndCountry = date1[1];       
		String[] date2 = dateAndMonth.split(" ");
		String month = date2[0];
		String date = date2[1];       
		String[] date3 = yearAndCountry.split(" ");
		String year = date3[1];       
		String releasedate = date+" "+month+" "+year;	
		System.out.println(releasedate);
		return releasedate;
	}

	public String getImdbCountry() {
		String country = imdbCountry.getText();

		System.out.println(country);
		return country;
	}



}
