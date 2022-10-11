package tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.IMDBPage;
import pages.WikiPage;

public class Validation extends BasePage{

	@Test

	public void validationOfDateAndCountry() throws ParseException {
		driver.get("https://en.wikipedia.org/wiki/Pushpa:_The_Rise");
		WikiPage wp = new WikiPage(driver);
		String wikiCountry = wp.getWikiCountry();
		String wikiDate = wp.getWikiDate();

		driver.get("https://www.imdb.com/title/tt9389998/");
		IMDBPage ip = new IMDBPage(driver);		
		String imdbCountry = ip.getImdbCountry();
		String imdbDate = ip.getImdbDate();

		Assert.assertEquals(wikiCountry, imdbCountry);	
		Assert.assertEquals(wikiDate, imdbDate);




	}
}
