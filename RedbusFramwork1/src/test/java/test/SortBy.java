package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Utility;
import base.browser;
import pages.search;
import pages.SortByFare;

public class SortBy extends browser{
	
	search page1;
	Utility utils;
	SortByFare page2;
	
	@BeforeTest
	public void setupTest() throws Throwable {
		setup();	
		impWait();
		page1=new search();
		page2=new SortByFare();
		utils=new Utility();
	}
	
	@Test(priority=-1)
	public void FirstPage() throws InterruptedException, IOException {
		page1.fromCity();
		page1.toCity();
		page1.calendar();
		page1.availableBus();
		utils.full_screenshot(driver, "BeforeSort");
		
	}
	
	@Test(priority=2)
	public void SortFare() throws InterruptedException, IOException {
		page2.fareButton();
		utils.full_screenshot(driver, "AfterSort");
		page2.scroll();		
		page2.fareAscending();
		
		
	}
	
	@Test(priority=3)
	public void closeWindow() {
		close();
	}
	
	

}
