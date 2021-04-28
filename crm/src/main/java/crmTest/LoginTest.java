package crmTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		launchBrowser();
		loginTest();
		tearDown();
		
		launchBrowser();
		invalidLoginTest();
		tearDown();
	}
	
	public static void launchBrowser() {
//		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://techfios.com/billing/?ng=admin/\r\n");
		driver.manage().window().maximize();
	}
	
	public static void loginTest() throws InterruptedException {
		//identify username and pass value
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		
		//identify signin button and pass value
		driver.findElement(By.name("login")).click();
		
		//Stop code execution for 2 seconds
		Thread.sleep(2000);
	}
	
	public static void invalidLoginTest() throws InterruptedException {
		//identify username and pass value
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123456");
		
		//identify signin button and pass value
		driver.findElement(By.name("login")).click();
		
		//Stop code execution for 2 seconds
		Thread.sleep(2000);
	}
	
	public static void tearDown() {
		//close the browser
		driver.close();
		driver.quit();
	}
	
	
}
