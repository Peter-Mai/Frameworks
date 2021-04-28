package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.junit.Assert;

public class MouseHover {
WebDriver driver;
	
	@Before
	public void init() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://www.dell.com/en-us");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	@Test
	public void loginTest() {
		
		WebElement PRODUCT_BUTTON_ELEMENT = driver.findElement(By.xpath("/html/body/main/header/div[3]/nav/ul/li[1]/button"));
		WebElement MONITOR_BUTTON_ELEMENT = driver.findElement(By.xpath("//span[text()=' Monitors']"));
		WebElement ALL_MONITORS_BUTTON_ELEMENT = driver.findElement(By.xpath("//span[text()='View all Monitors for Home']"));
		WebElement MONITORS_ACCESSORIES_BUTTON_ELEMENT = driver.findElement(By.xpath("/html/body/main/div[3]/section[1]/section/div/div/div[2]/h1"));
		
		Actions action = new Actions(driver);
		action.moveToElement(PRODUCT_BUTTON_ELEMENT).build().perform();
		action.moveToElement(MONITOR_BUTTON_ELEMENT).build().perform();
		
		ALL_MONITORS_BUTTON_ELEMENT.click();
		
		Assert.assertEquals("Wrong page!!", "Monitors & Monitor Accessories", MONITORS_ACCESSORIES_BUTTON_ELEMENT);
		

	}
}
