package Common_pkg;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class wait {
	public static void implicit(WebDriver Driver,int sec) {
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	
	public static WebDriverWait exp_obj(WebDriver Driver) {
		//Create the object of explicit wait
		WebDriverWait exp_wait = new WebDriverWait(Driver, Duration.ofSeconds(10));
		return exp_wait;
	}
	
	public static WebElement visible(WebDriver Driver ,By locator) {
	    WebElement visible = wait.exp_obj(Driver).until(ExpectedConditions.visibilityOfElementLocated(locator));
	    return visible;
	}
	
	public static void clickable(WebDriver Driver,By locator) {
	    wait.exp_obj(Driver).until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

	public static List<WebElement> visible_all(WebDriver Driver ,By locator) {
	    List<WebElement> visible_all = wait.exp_obj(Driver).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	    return visible_all;
	}
	
	public static WebElement move_clickable(WebDriver Driver,By locator) {
	    WebElement clickable = wait.exp_obj(Driver).until(ExpectedConditions.elementToBeClickable(locator));
	    return clickable;
	}
	
	public static void clickable_bus(WebDriver driver,By locator) {
		wait.exp_obj(driver).until(ExpectedConditions.elementToBeClickable(locator)).click();
		System.out.println("hello friends");
		
	}
	
	public static void view_seats(WebDriver driver,By locator,By popclose) {
	
		wait.exp_obj(driver).until(ExpectedConditions.elementToBeClickable(locator)).click();
		wait.exp_obj(driver).until(ExpectedConditions.elementToBeClickable(popclose)).click();
	}
}

