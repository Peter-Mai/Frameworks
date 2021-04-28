package homework;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {
	
	WebDriver driver;
	
	@Before
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void login() {
		
		//Signing in and navigating to bank and new account
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demo@techfios.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("abc123");
		driver.findElement(By.xpath("//button[@name='login']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Bank & Cash')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'New Account')]")).click();
		
		//Adding Account
		driver.findElement(By.xpath("//input[@id='account']")).sendKeys("Peter Mai");
		driver.findElement(By.xpath("//input[@id='description']")).sendKeys("Vacation");
		driver.findElement(By.xpath("//input[@id='balance']")).sendKeys("1.00");
		driver.findElement(By.xpath("//input[@id='account_number']")).sendKeys("123456789");
		driver.findElement(By.xpath("//input[@id='contact_person']")).sendKeys("Peter");
		driver.findElement(By.xpath("//input[@id='contact_phone']")).sendKeys("123-456-7890");
		driver.findElement(By.xpath("//input[@id='ib_url']")).sendKeys("wellsfargo.com");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		
		
	}
	
}
