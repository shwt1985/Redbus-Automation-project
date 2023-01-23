package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Utility;
import base.browser;

public class FilterByNonAC extends browser{
	
	Utility data=new Utility();
	
	public FilterByNonAC(){
		PageFactory.initElements(driver,this);
	}	
	
	@FindBy(xpath="//label[@for=\"bt_NONAC\" and @class=\"custom-checkbox\"]") WebElement filterByCheckBox;
	@FindBy(xpath="//div[@class=\"bus-type f-12 m-top-16 l-color\"]") List<WebElement> busTypeText;
	@FindBy(xpath="//div[@id=\"single_seat_coachmark\"] //div[@class=\"gotIt\"]") WebElement p;
	
	public void selectNonAC() {

		waitForWebElementToAppear(filterByCheckBox);
		filterByCheckBox.click();
	}
	
	public void busInfo() {
		waitForWebElementsToAppear(busTypeText);
		int count=busTypeText.size();
		
		for(int i=0;i<count;i++)
		{
			String info1=busTypeText.get(i).getText();
			String[] info2=info1.split("S");
			String info=info2[0].trim();
			
			if(info.contains("NON A/C"))
			{
				System.out.println(i+"No. bus is type - "+info);
			}
			else {
				System.out.println("Filter not work Test fails");
			}
		}
		
	}
	
	

}
