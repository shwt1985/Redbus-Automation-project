package Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class redbus {

	public static void main(String[] args) {
		//Set system properties so that the code should know the location of chrome driver
		System.setProperty("webdriver.chrome.driver", "D:\\Dashrath\\Test_data\\chrome_driver\\chromedriver.exe");
		//Create object of chrome driver
		WebDriver driver = new ChromeDriver();       
		//launch the URL
		driver.get("https://www.redbus.in/");
		//Maximize the window
		driver.manage().window().maximize();
		
		//FROM text box
		common_pkg.autosuggestion_text_box.dropdown(driver, 
				By.xpath("//div[@class=\"fl search-box clearfix\"]/div/input"), "PUNE", 
				By.xpath("//ul[@class=\"autoFill homeSearch\"]/li[contains(@select-id,\"results\")]"),
				By.xpath("//ul[@class=\"autoFill homeSearch\"]/li/i"),"Shivaji Nagar");
		
		//TO text box
		common_pkg.autosuggestion_text_box.dropdown(driver,
				By.xpath("//div[@class=\"fl search-box\"]/div/input"), "MUMBAI", 
				By.xpath("//ul[@class=\"autoFill homeSearch\"]/li"),
				By.xpath("//ul[@class=\"autoFill homeSearch\"]/li/i"), "Dadar");
		
		//Select month from calender
		common_pkg.calender.select_month(driver,
				By.xpath("//label[text()=\"Date\"]"),
				By.xpath("//div[@class=\"rb-calendar\"]/table/tbody/tr/td[2]"),
				"Mar 2023",
				By.xpath("//div[@class=\"rb-calendar\"]/table/tbody/tr/td[3]"));
		
		//Select the Date
		common_pkg.calender.select_date(driver,
				By.xpath("//td[@class=\"current day\" or @class=\"wd day\" or @class=\"we day\"]"),
				By.xpath("//td[@class=\"current day\" or @class=\"wd day\" or @class=\"we day\"]"),
				"12");
		
		//Click on search button
		common_pkg.wait.clickable(driver,By.xpath("//div[@id=\"search_div\"]/section/div/button"));	
	}
}