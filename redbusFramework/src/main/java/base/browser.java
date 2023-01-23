package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class browser {
	public static WebDriver driver;

	public void setup() throws Throwable {

		String browser = readPropertyFile("browser");

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
			System.out.println(browser + " is incorrect, Please select correct browser name");
			break;
		}

		driver.get(readPropertyFile("url"));

		driver.manage().window().maximize();

	}

	public void impWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public String readPropertyFile(String value) throws Throwable {
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\vishal\\eclipse-workspace\\redbusFramework\\properties");
		prop.load(file);
		return prop.getProperty(value);
	}

	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void waitForWebElementElementsToAppear(List<WebElement> findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(findBy));
	}

	public void waitForWebElementToAppear(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}

	public void closePage() {
		driver.close();
		System.out.println("Run Finished");
	}

	public void quit() {
		driver.quit();
	}
}