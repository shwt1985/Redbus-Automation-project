package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.browser;
import base.utility;
import pages.searchFunctionality;
import pages.sortbyPrice;

public class sortbyFare extends browser {
	searchFunctionality page1;
	sortbyPrice page2;

	@BeforeTest
	public void initialization() throws Throwable {
		setup();
		page1 = new searchFunctionality();
		page2 = new sortbyPrice();
	}

	@Test(priority = 1)
	public void searchBusFunctionality() throws InterruptedException, IOException {
		page1.selectFromCity();
		page1.selectToCity();
		page1.calender();
		page1.searchBus();
		utility.takeScreenShot(driver, "searchBus");
	}

	@Test(priority = 2)
	public void sortByFareType() throws InterruptedException, IOException {
		page2.scroll();
		page2.fareAscending();
		page2.scrollup();
	}

	@Test(priority = 3)
	public void farebutton() {
		page2.fareButton();
		page2.scrollDown();
		page2.fareSorted();
		page2.compareArray();
	}

	@Test(priority = 3)
	public void quitBrowser() {
		quit();
	}
}
