package crmTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest_Junit {

	WebDriver driver;
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("===================" + "calling @Before Class");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("================ " + "calling @After Class");
	}
	
	@Before
	public void launchBrowser() {
//		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://techfios.com/billing/?ng=admin/\r\n");
		driver.manage().window().maximize();
	}
	
	@Test
	public void loginTest() throws InterruptedException {
		//identify username and pass value
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		
		//identify signin button and pass value
		driver.findElement(By.name("login")).click();
		
		//Stop code execution for 2 seconds
		Thread.sleep(2000);
	}
	
	@Test
	public void invalidLoginTest() throws InterruptedException {
		//identify username and pass value
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123456");
		
		//identify signin button and pass value
		driver.findElement(By.name("login")).click();
		
		//Stop code execution for 2 seconds
		Thread.sleep(2000);
	}
	
	@After
	public void tearDown() {
		//close the browser
		driver.close();
		driver.quit();
		
		
	}
}
