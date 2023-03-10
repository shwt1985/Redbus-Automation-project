package Common_pkg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class autosuggestion_text_box {
	   public static void dropdown(WebDriver Driver, By text_box_locator, String to_insert, By dropdown_text_locator ,By dropdown_click_locator , String to_select) {
			//Autosuggestion dropdown of FROM text box
			wait.visible(Driver,text_box_locator).sendKeys(to_insert);
			
			//Create web element variables for text and click
			List<WebElement> text_webelement1 = wait.visible_all(Driver, dropdown_text_locator);
			List<WebElement> click_webelement1 = wait.visible_all(Driver, dropdown_click_locator);
		    
			//Fetch the count of constituents of list
			int count1 = text_webelement1.size();
			System.out.println(count1);
			
			//Iterate through the entire list and select value depending on comparison
			for (int i=0;i<count1;i++)
			{
				String list_value = text_webelement1.get(i).getText();
				if(list_value.contains(to_select))
				{
					click_webelement1.get(i).click();
					break;
				}
				else
				{
					System.out.println("Desired value is not found in iteration"+i+" ,hence retrying");
				}
			}	
	    }
	   
	   public static void viewbus(WebDriver driver,By click_viewbus) {
		   wait.visible(driver, click_viewbus);
		   System.out.println("view buses"+ wait.visible(driver, click_viewbus));
		   
	   }
	   public static void View_seats(WebDriver driver,By viewseat,By popclose) {
		   wait.visible(driver, viewseat);
		   System.out.println("view buses"+ wait.visible(driver, viewseat));
		   wait.visible(driver, popclose);
		   
	   }
	}

