package CommonMethod;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.google.common.io.Files;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class screenshot {

	public static void scr(String screenshotName,WebDriver Driver) throws IOException {
		//Creating object of TakesScreenshot
		TakesScreenshot ts = (TakesScreenshot)Driver;
				
		//Capture a Screenshot
		File src = ts.getScreenshotAs(OutputType.FILE);
				
		//Creating object of File class
		String path = "C:\\Drivers\\Selenium_Screenshots\\";
		File filename = new File(path+screenshotName+".png");
				
		if(filename.exists())
		{
	    System.out.println("file "+screenshotName+" already exists ,hence deleting");
	    filename.delete();
		System.out.println("Old file : "+filename+" is deleted");
		Files.copy(src, filename);
		System.out.println("file "+screenshotName+" copied in directory having path - "+path);
		}
		else
		{
		System.out.println("file "+screenshotName+" does not exists, hence copying");
		Files.copy(src, filename);
	    System.out.println("file "+screenshotName+" copied in directory having path - "+path);
		}
	}
		
	public static void full_screenshot(String screenshotName,WebDriver Driver) throws IOException {
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(Driver);
		String path = "C:\\Drivers\\Selenium_Screenshots\\";
		ImageIO.write(screenshot.getImage(),"PNG",new File(path+screenshotName+".png"));
	}
}

