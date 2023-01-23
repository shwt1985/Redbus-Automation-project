package test;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.browser;
import pages.LinksPage;


public class LinkValidations extends browser {

	LinksPage linkPage;
	
	@BeforeTest(groups="Sanity")
	public void setupTest() throws Throwable {
		setup();
	//	impWait();	
		linkPage=new LinksPage();
		
	}
	@Test(priority=1,groups="Sanity")
	public void availableLinks() throws IOException {
		int expectedLink=120;
		int actualLinks=linkPage.totalLinks();
		Assert.assertEquals(expectedLink, actualLinks,"Expect as per actual");	
		
	}

	@Test(priority=2,groups="Sanity")
	public void availableFooterLinks() throws IOException {
		int expextedFooterLinks=28;
		int actualFooterLinks=linkPage.footerLinkCount();
		Assert.assertEquals(expextedFooterLinks, actualFooterLinks,"Expect footer link count is as per actual");
		
	}
	
	
	@Test(priority=3,groups="Sanity")
	public void firstColumnLinksInFooter() throws InterruptedException, IOException {
		linkPage.footerColumnLink();
		
	}
	
	@Test(priority=4,groups="Sanity")
	public void closeWindow() {
		close();
	}
	



}
