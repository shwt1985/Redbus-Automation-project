package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.Utility;
import base.browser;

public class search extends browser {
	
	String From="Jalna";
	String reqSource = "Jalna";
	
	String To="Amravati";
	String reqDest="Amravati";

	Utility data = new Utility();

	@FindBy(id = "src")
	WebElement searchBoxFrom;
	@FindBy(xpath = "//ul[@class='autoFill homeSearch']/li[contains(@select-id,'results')]")
	List<WebElement> fromCitiesText;
	@FindBy(xpath = "//ul[@class='autoFill homeSearch']/li/i")
	List<WebElement> fromCitiesclick;

	@FindBy(id = "dest")
	WebElement searchBoxTo;
	@FindBy(xpath = "//ul[@class=\"autoFill homeSearch\"]/li")
	List<WebElement> toCityText;
	@FindBy(xpath = "//ul[@class=\"autoFill homeSearch\"]/li/i")
	List<WebElement> toCityClick;
	@FindBy(xpath = "//td[@class='monthTitle']")
	WebElement monthTitle;
	@FindBy(xpath = "//td[@class='next']")
	WebElement nextButton;
	@FindBy(xpath = "//td[contains(@class,'day')]")
	List<WebElement> dates1;
	@FindBy(id = "search_btn")
	WebElement searchButton;

	By fromCitiesBy = By.xpath("//div[@class='ty-input-group isFocus']/div[1]/ul/li");

	public search() {
		PageFactory.initElements(driver, this);
	}

	public void fromCity() throws InterruptedException {
		waitForWebElementToAppear(searchBoxFrom);
		searchBoxFrom.sendKeys(From);
		waitForWebElementsToAppear(fromCitiesclick);
		int count = fromCitiesclick.size();
		System.out.println(count);
		Thread.sleep(2000);
		for (int i = 0; i < count; i++) {
			waitForWebElementsToAppear(fromCitiesText);
			String foundValue = fromCitiesText.get(i).getText();
			System.out.println(foundValue);
			if (foundValue.contains(reqSource)) {
				fromCitiesclick.get(i).click();
				System.out.println("Found in " + i + " no. iteration");
				break;
			} else {
				System.out.println("Desired value is not found in itteration " + i + ", hence retrying");
			}
		}
	}

	public void toCity() throws InterruptedException {
		waitForWebElementToAppear(searchBoxTo);		
		searchBoxTo.sendKeys(To);
		for (int i = 0; i < toCityText.size(); i++) {
			waitForWebElementsToAppear(toCityText);	
			String getValue = toCityText.get(i).getText();
			System.out.println(getValue);

			if (getValue.contains("Amravati")) {
				toCityClick.get(i).click();
				System.out.println("Found in " + i + " no. iteration");
				break;
			} else {
				System.out.println("Desired value is not found in itteration " + i + ", hence retrying");
			}
		}
	}

	public void calendar() {
		String date = "15";
		String month_yr = "Feb 2023";

		// Step10:Extract the required month & year by clicking on next button
		while (true) {
			waitForWebElementToAppear(monthTitle);
			String month_year = monthTitle.getText();

			if (month_year.equalsIgnoreCase(month_yr))
				break;
			else
				waitForWebElementToAppear(nextButton);
				nextButton.click();
		}
		// Step11: capture the list of date
		waitForWebElementsToAppear(dates1);
		int count = dates1.size();
		// Step12:validate the date & click/select
		for (int i = 0; i < count; i++) {
			String date_text = dates1.get(i).getText();
			if (date_text.equalsIgnoreCase(date)) {
				dates1.get(i).click();
				System.out.println("Ok done-You selected date-" + date + "," + month_yr);
				break;
			}
		}
	}

	public void availableBus() throws InterruptedException {
		// Step13:Serch the available bus
		waitForWebElementToAppear(searchButton);
		searchButton.click();
		// Verify that search results are displayed correctly
		String expectedTitle = "Book Bus Travels, AC Volvo Bus, rPool & Bus Hire - redBus India";
		String actualTitle = driver.getTitle();
		Thread.sleep(3000);
		System.out.println(actualTitle);		
		if (expectedTitle.equalsIgnoreCase(actualTitle)) {
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Failed");
		}
	}
}
