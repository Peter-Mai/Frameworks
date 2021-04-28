package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardEvent {
WebDriver driver;
	
	@Before
	public void init() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		

		
		
		
	}
	
	@Test
	public void loginTest() {
		
		WebElement USERNAME_FIELD_ELEMENT = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		WebElement PASSWORD_FIELD_ELEMENT = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		
		USERNAME_FIELD_ELEMENT.sendKeys("demo@techfios.com");
		PASSWORD_FIELD_ELEMENT.sendKeys("abc123");
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		
	}
}

