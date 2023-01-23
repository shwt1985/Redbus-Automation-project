package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;



public class Utility {
	
	public static String readExcelData(int rownum,int colnum) throws EncryptedDocumentException, IOException {
		FileInputStream fobj = new FileInputStream("C:\\Users\\ACER\\eclipse-workspace\\RedbusFramwork1\\TestData\\testData.xlsx");
		Sheet data = WorkbookFactory.create(fobj).getSheet("Sheet1");
		return data.getRow(rownum).getCell(colnum).getStringCellValue();
		
		} 
	
	public static void takeScreenShot(WebDriver driver,String name) throws IOException {
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\ACER\\eclipse-workspace\\RedbusFramwork1\\Screenshot\\"+ name+".png");
		FileUtils.copyFile(source, dest);
	}
	public static void full_screenshot(WebDriver driver,String screenshotName) throws IOException {
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		String path = "C:\\Users\\ACER\\eclipse-workspace\\RedbusFramwork1\\Screenshot\\";
		ImageIO.write(screenshot.getImage(),"PNG",new File(path+screenshotName+".png"));
	}	
	

}
