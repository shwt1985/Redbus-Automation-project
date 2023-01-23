package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.Utility;
import base.browser;
import pages.FilterByNonAC;
import pages.search;

public class FilterByTest extends browser{
	
	search act=new search();
	Utility util=new Utility();
	FilterByNonAC filter=new FilterByNonAC();
	
	@BeforeTest
	public void setupTest() throws Throwable {
		setup();
		impWait();	
		 act=new search();
		 util=new Utility();
		 filter=new FilterByNonAC();
		
	}
	@Test(priority=1)
	public void fromDropdown() throws InterruptedException, IOException{
		
		act.fromCity();
		act.toCity();
		act.calendar();		
		
	}
	@Test(priority=2)
	public void findBuses() throws InterruptedException, IOException {		
		act.availableBus();
		//util.full_screenshot(driver, "BusBeforeFilter");
		
	}
	@Test(priority=3)
	public void filterByNonACType() throws IOException {
		filter.selectNonAC();
		filter.busInfo();
		util.full_screenshot(driver, "BusAfterFilter");
		
	}	
	@Test(priority=4)
	public void closeWindow() {
		close();
	}
	
	
		

}
