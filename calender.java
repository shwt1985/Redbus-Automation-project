package CommonMethod;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class calender {

	public static void select_month(WebDriver Driver, By cal_select_locator, By month_year_locator, String m_year ,By next_Button_locator) {
		//Click on calender
		wait.clickable(Driver,cal_select_locator);
		//Select month and year from calender
		while (true) {
		String month_year =	wait.visible(Driver, month_year_locator).getText();
			if (month_year.equalsIgnoreCase(m_year))
			{
			   break;
			}
			else
			{
				System.out.println("Desired value of month&year is not found ,hence clicking on next Button");
				wait.clickable(Driver, next_Button_locator);
			}
		}
	}
	
	public static void select_date(WebDriver Driver ,By cal_text_locator ,By cal_click_locator, String date) {						
		//Select date from calender
		//Create web element variables for text and click
		List<WebElement> webelements_text = wait.visible_all(Driver, cal_text_locator);
		List<WebElement> webelements_click = wait.visible_all(Driver, cal_click_locator);
				
		//fetch the count of constituents of list
		int count = webelements_text.size();
		System.out.println(count);
				
		//Iterate through the entire list and select value depending on comparison
		for (int i=0;i<count;i++)
		{
			String list_values = webelements_text.get(i).getText();
			System.out.println(list_values);
					
			if(list_values.equals(date))
			{
				webelements_click.get(i).click();
				break;
			}
			else
			{
				System.out.println("Desired value is not found in iteration "+i+" ,hence retrying");
			}
		}
	}
}

