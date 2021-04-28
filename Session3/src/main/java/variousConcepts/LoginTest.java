package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {
	
	WebDriver driver;
	
	@Before
	public void launchBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void logingTest() {
				
		//storing web element
		//element library
		WebElement USERNAME_FIELD_ELEMENT = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement PASSWORD_FIELD_ELEMENT = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement SINGIN_BUTTON_ELEMENT = driver.findElement(By.xpath("//button[@name='login']"));
		
		
		//storing web element using By Class
		By USERNAME_FIELD_LOCATOR = By.xpath("//input[@id='username']");
		By PASSWORD_FIELD_LOCATOR = By.xpath("//*[@id=\"password\"]");
		By SINGIN_BUTTON_LOCATOR = By.xpath("//button[@name='login']");
		By DASHBOAR_PAGE_TITLE_ELEMENT_LOCATOR = By.xpath("//h2[contains(text(),' Dashboard ')]");
		
		
		USERNAME_FIELD_ELEMENT.clear();
		USERNAME_FIELD_ELEMENT.sendKeys("demo@techfios.com");
		SINGIN_BUTTON_ELEMENT.sendKeys("abc1234");
		
		
		//SINGIN_BUTTON.click();
		driver.findElement(SINGIN_BUTTON_LOCATOR).click();
		
		boolean pageTitleDisplayStatus;
		try {
			
			WebElement DASHBOAR_PAGE_TITLE_ELEMENT = driver.findElement(By.xpath("//h2[contains(text(),' Dashboard ')]"));
			pageTitleDisplayStatus = true;		
			
		}catch(NoSuchElementException e) {
			
			pageTitleDisplayStatus = false;
			e.printStackTrace();
		}
		
		//Using Explicit Wait
		/*WebDriverWait wait =  new WebDriverWait(driver, 3);
		//wait.until(ExpectedConditions.visibilityOf(DASHBOAR_PAGE_TITLE_ELEMENT));
		wait.until(ExpectedConditions.visibilityOfElementLocated(DASHBOAR_PAGE_TITLE_ELEMENT_LOCATOR));*/
		
		//Validation
		Assert.assertTrue("Dashboard page not found!!", pageTitleDisplayStatus);
		
		
	}
	
	@After
	public void tearDown() {
		
		driver.close();
		driver.quit();
	}

}