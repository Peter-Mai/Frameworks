package variousLocators;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	@Test
	public void launchBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://objectspy.space/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("firstname")).sendKeys("Selenium");
		driver.findElement(By.id("sex-1")).click();
		
//		driver.findElement(By.className("input-file")).click();
		
//		driver.findElement(By.linkText("OS-API Product FrontEnd")).click();
//		
//		driver.findElement(By.partialLinkText("TF-API Product")).click();
		
//		driver.findElement(By.partialLinkText("New Page")).click();
		
		driver.findElement(By.cssSelector("input#exp-3")).click();
		
		driver.findElement(By.cssSelector("input[value = 'Automation Tester']")).click();
		
		driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("slfdajs");
		driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("slfdajs");
		
		driver.findElement(By.xpath("//input[@name='tool' and @value='Selenium Webdriver']")).click();
		
		driver.findElement(By.xpath("//strong[text()='Link Test : New Page']")).click();
		driver.findElement(By.xpath("//strong[contains(text(), 'Link Test : Page Change')]")).click();
	}
}
