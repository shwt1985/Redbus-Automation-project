package CommonMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class action {
        
	public static Actions object(WebDriver Driver) {
		//Create Object Of Action Class
		Actions act = new Actions(Driver);
		return act;
	}
	
	public static void mouse_over(WebDriver Driver, By locator) {
		//mouse over
		CommonMethod.action.object(Driver).moveToElement(wait.visible(Driver, locator)).build().perform();
	}
	
	public static void upper_case(WebDriver Driver,By locator, String text) {
		//Upper Case
		CommonMethod.action.object(Driver).moveToElement(wait.move_clickable(Driver, locator)).click().keyDown(Keys.SHIFT).sendKeys(text).build().perform();
	}
	
	public static void double_click(WebDriver Driver, By locator) {
		//Double Click
		CommonMethod.action.object(Driver).moveToElement(wait.move_clickable(Driver, locator)).doubleClick().build().perform();
	}
	
	public static void right_click(WebDriver Driver, By locator) {
		//Right Click
		CommonMethod.action.object(Driver).contextClick(wait.move_clickable(Driver, locator)).build().perform();
	}
}
