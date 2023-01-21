import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Common_pkg.Calender;

import Common_pkg.autosuggestion_text_box;


public class driver_class {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Set system properties so that the code should know the location of chrome driver
				System.setProperty("WebDriver.chrome.driver", "E:\\chromedriver_win32.zip\\chromedriver.exe");
				//Create object of chrome driver
				WebDriver driver = new ChromeDriver();       
				//launch the URL
				driver.get("https://www.redbus.in/");
				//Maximize the window
				driver.manage().window().maximize();
				
				//FROM text box
			autosuggestion_text_box.dropdown(driver, 
						By.xpath("//div[@class=\"fl search-box clearfix\"]/div/input"), "PUNE", 
						By.xpath("//ul[@class=\"autoFill homeSearch\"]/li[contains(@select-id,\"results\")]"),
						By.xpath("//ul[@class=\"autoFill homeSearch\"]/li/i"),"Shivaji Nagar");
				
				//TO text box
				autosuggestion_text_box.dropdown(driver,
						By.xpath("//div[@class=\"fl search-box\"]/div/input"), "MUMBAI", 
						By.xpath("//ul[@class=\"autoFill homeSearch\"]/li"),
						By.xpath("//ul[@class=\"autoFill homeSearch\"]/li/i"), "Dadar");
				
				//Select month from calender
				Calender.select_month(driver,
						By.xpath("//label[text()=\"Date\"]"),
						By.xpath("//div[@class=\"rb-calendar\"]/table/tbody/tr/td[2]"),
						"Mar 2023",
						By.xpath("//div[@class=\"rb-calendar\"]/table/tbody/tr/td[3]"));
				
				//Select the Date
			Calender.select_date(driver,
						By.xpath("//td[@class=\"current day\" or @class=\"wd day\" or @class=\"we day\"]"),
						By.xpath("//td[@class=\"current day\" or @class=\"wd day\" or @class=\"we day\"]"),
						"12");
				
				//Click on search button
				Common_pkg.wait.clickable(driver,By.xpath("//div[@id=\"search_div\"]/section/div/button"));	
				
				//click om hide bus
				//mmon_pkg.wait.clickable_bus(driver, By.xpath("//div[@class=\"button\"]/i"));
				
				Common_pkg.wait.view_seats(driver, By.xpath("//ul[@class=\"bus-items\"]/div/li[@id=\"11406254\"]/div/div[2]//div[text()=\"View Seats\"]"), By.xpath("//div[@class=\"modalClose\"]"));
				//Common_pkg.wait.view_seats(driver, By.xpath("//div[@class=\"modalClose\"]"));
			}
		
	}



