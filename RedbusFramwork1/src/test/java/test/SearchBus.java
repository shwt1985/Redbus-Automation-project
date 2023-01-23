package test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Utility;
import base.browser;
import junit.framework.Assert;
import pages.search;


public class SearchBus extends browser{
	search act;
	Utility util=new Utility();
	
	@BeforeTest(groups = {"Sanity","Regression"})
	public void setupTest() throws Throwable {
		setup();
	//	impWait();	
		act=new search();
		
	}

	
	@Test(priority=1,groups = {"Sanity","Regression"})
	public void fromDropdown() throws InterruptedException, IOException{
		
		act.fromCity();
		act.toCity();
		act.calendar();	
		util.takeScreenShot(driver, "LandingPageDetails");		
		
	}
	
	@Test(priority=2,groups = {"Sanity","Regression"})
	public void findBuses() throws InterruptedException, IOException {		
		act.availableBus();
		util.full_screenshot(driver, "AvailableBus");
		
	}
	
	
	@Test(priority=3,groups = {"Sanity","Regression"})
	public void closeWindow() {
		close();
	}

		

}


