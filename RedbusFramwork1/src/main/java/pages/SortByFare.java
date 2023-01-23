package pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.browser;

public class SortByFare extends browser {

	int[] intExtratedSortedArray;
	int[] intExtractedArray;

	public SortByFare() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class=\"w-15 fl f-12 d-color\"]//a[text()=\"Fare\"]")
	WebElement fare;
	@FindBy(xpath = "//span[@class=\"f-19 f-bold\" or @class=\"f-bold f-19\"]")
	List<WebElement> priceText;

	JavascriptExecutor js = (JavascriptExecutor) driver;

	public void scroll() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int i = 0;
		while (i < 5) {
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			i++;
		}
	}

	public void getByDefaultFare() {         //Get Fare before sorting
		waitForWebElementsToAppear(priceText);
		int count = priceText.size();
	//	System.out.println(count);
		String[] priceArray = new String[count];

		for (int i = 0; i < count; i++) {
			priceArray[i] = priceText.get(i).getText();
		}

		// Extracting the array outside the loop
		String[] extractedArray = priceArray;

		int[] intArray = new int[count];
		for (int i = 0; i < count; i++) {
			intArray[i] = (int) Double.parseDouble(extractedArray[i].trim());
		//	System.out.println(intArray[i]);
		}

		intExtractedArray = intArray;

		// Sorting the extracted array using the built-in sort method
		Arrays.sort(intExtractedArray);

		// Printing the sorted array
		for (int i : intExtractedArray) {
	//		System.out.print(i);
		}

	}

	public void scrollup() {
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
	}

	public void fareButton() {
		waitForWebElementToAppear(fare);
		fare.click();
	}

	public void scrollDown() {
		int k = 0;
		while (k < 5) {
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			k++;
		}
	}

	public void fareSorted() {

		List<WebElement> sorted_price_text = priceText;// driver.findElements(By.xp
		int sorted_count = sorted_price_text.size();
	//	System.out.println(sorted_count);

		String[] sorted_price_array = new String[sorted_count];

		for (int i = 0; i < sorted_count; i++) {
			sorted_price_array[i] = sorted_price_text.get(i).getText();
		}

		// Extracting the array outside the loop
		String[] sortedExtractedArray = sorted_price_array;

		int[] intSortedArray = new int[sorted_count];
		for (int i = 0; i < sorted_count; i++) {
			intSortedArray[i] = (int) Double.parseDouble(sortedExtractedArray[i].trim());
			System.out.println(intSortedArray[i]);
		}
		intExtratedSortedArray = intSortedArray;
	}

	public void compareArray() {
		Arrays.equals(intExtractedArray, intExtratedSortedArray);
		System.out.println("Both arrays are equal");
	}
}
