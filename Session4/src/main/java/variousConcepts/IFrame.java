package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class IFrame {
WebDriver driver;
	
	@Test
	public void init() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://docs.oracle.com/javase/8/docs/api/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.switchTo().frame("packageListFrame");
		driver.findElement(By.linkText("java.awt")).click();
		
		driver.switchTo().parentFrame();
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.linkText("Adjustable")).click();
		
		
		
	}
}
