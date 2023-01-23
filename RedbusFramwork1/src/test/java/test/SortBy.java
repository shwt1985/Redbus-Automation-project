package test;

import java.io.IOException;
import java.util.Arrays;

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
	//	impWait();
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
		
		page2.scroll();
		page2.getByDefaultFare();                 //Catch Default Fare
		page2.scrollup();
		page2.fareButton();                       //1st Click to arrenge Fare in Ascending order 
		utils.full_screenshot(driver, "AfterSort");//Screen Shot
	//	page2.scrollDown() ;
		page2.fareSorted();                       //Catch Sorted array
		page2.compareArray();                     //Assertion
			
	}	
	@Test(priority=3)
	public void closeWindow() {
		close();
	}
	
	

}
