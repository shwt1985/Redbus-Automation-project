package Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class redbus {
		WebDriver driver;
		
		@Parameters("browser")
		@Test(priority=0)
		public void select_browser(String browser)
		{
			switch (browser) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
				driver = new ChromeDriver();
				break;
				
			case "firefox":
				System.setProperty("webdriver.firefox.driver", "C:\\Drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
				break;
				
			case "edge":
				System.setProperty("webdriver.edge.driver", "C:\\Drivers\\msedgedriver.exe");
				driver = new EdgeDriver();
				break;

			default:
				System.out.println(browser+" is incorrect, Please select correct browser name");
				break;
			}
		}		
		
		//public static void main(String[] args) {
		@Test (priority=1)//(groups= {"regression"})
		public void launchurl() {
		
			//launch the URL
			driver.get("https://www.redbus.in/");
			//Maximize the window
			driver.manage().window().maximize();
		}
			
		@Test (priority=3)//(groups= {"regression"})
		public void redBussearchBus() {

		//FROM text box
		CommonMethod.autosuggestion_text_box.dropdown(driver, 
				By.xpath("//div[@class=\"fl search-box clearfix\"]/div/input"), "PUNE",
				By.xpath("//ul[@class=\"autoFill homeSearch\"]/li[contains(@select-id,\"results\")]"),
				By.xpath("//ul[@class=\"autoFill homeSearch\"]/li/i"),"Shivaji Nagar");
		
		//TO text box
		CommonMethod.autosuggestion_text_box.dropdown(driver,
				By.xpath("//div[@class=\"fl search-box\"]/div/input"), "MUMBAI", 
				By.xpath("//ul[@class=\"autoFill homeSearch\"]/li"),
				By.xpath("//ul[@class=\"autoFill homeSearch\"]/li/i"), "Dadar");
		
		//Select month from calender
		CommonMethod.calender.select_month(driver,
				By.xpath("//label[text()=\"Date\"]"),
				By.xpath("//div[@class=\"rb-calendar\"]/table/tbody/tr/td[2]"),
				"Mar 2023",
				By.xpath("//div[@class=\"rb-calendar\"]/table/tbody/tr/td[3]"));
		
		//Select the Date
		CommonMethod.calender.select_date(driver,
				By.xpath("//td[@class=\"current day\" or @class=\"wd day\" or @class=\"we day\"]"),
				By.xpath("//td[@class=\"current day\" or @class=\"wd day\" or @class=\"we day\"]"),
				"12");
		
		//Click on search button
		CommonMethod.wait.clickable(driver,By.xpath("//div[@id=\"search_div\"]/section/div/button"));
		
		driver.quit();
	}
}