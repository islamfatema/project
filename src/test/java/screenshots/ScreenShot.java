package screenshots;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ScreenShot {
	private static final String URL="http://www.facebook.com/";
	private static WebDriver driver = null;
   
	
	
 @Test
 public void captureScreenShot() throws Exception{
	 System.setProperty("webdriver.chrome.driver","/Users/fatemaislam/Downloads/chromedriver");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
	
	 driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("learn automation");
	 
	TakesScreenshot sc=(TakesScreenshot)driver;
	File source=sc.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(source, new File("./screenShot/facebook.png"));
	System.out.println("screenshot taken");
	driver.quit();
	 
    
 }
}
