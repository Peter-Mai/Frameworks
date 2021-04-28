package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ScrollUpAndDown {

	WebDriver driver;
	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://www.techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void loginTest() {
	
		WebElement USERNAME_FIELD_ELEMENT = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		WebElement PASSWORD_FIELD_ELEMENT = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement SIGNIN_BUTTON_FIELD_ELEMENT = driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button"));

		
		USERNAME_FIELD_ELEMENT.sendKeys("demo@techfios.com");
		PASSWORD_FIELD_ELEMENT.sendKeys("abc123");
		SIGNIN_BUTTON_FIELD_ELEMENT.click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("Scroll(0,1500)");
		
	}
}
