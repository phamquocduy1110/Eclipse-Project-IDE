package SeleniumWebDriverLocators_Part3;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumWebDriverLocators_Part3 {
	public String baseUrl = "https://flickr.com/";
	String driverPath = "D:\\Eclipse Project IDE\\ChromeDriver\\chromedriver.exe";
	public WebDriver driver;
	
	@Test
  	public void Flickr() throws InterruptedException {
	  	System.out.println("launching chrome browser"); 
	  	System.setProperty("webdriver.chrome.driver", driverPath);
	  	System.out.println("Openning chrome browsers");
	  	driver = new ChromeDriver();
	  	driver.get(baseUrl);
	  	String expectedTitle = "Find your inspiration. | Flickr";
	  	String actualTitle = driver.getTitle();
	  	driver.findElement(By.cssSelector(".gn-signin")).click();
	  	WebDriverWait wait = new WebDriverWait(driver, 30);
	  	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-email")));
		driver.findElement(By.id("login-email")).sendKeys("sakurakinomoto185@gmail.com");
		driver.findElement(By.cssSelector("form > button")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-password")));
		driver.findElement(By.id("login-password")).sendKeys("Sakuraandusagi*123");
		driver.findElement(By.cssSelector("form > button")).click();
		//Thread.sleep(3000);
		//WebDriverWait waiter2 = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".moola-container.feed-ba.upsell-fallback")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".filter-menu-text")));
		WebElement titleAllActivity = driver.findElement(By.cssSelector(".filter-menu-text"));
		//WebElement titleAlbum = driver.findElement(By.cssSelector("Album"));
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
				.moveToElement(titleAllActivity)
				//.moveToElement(titleAlbum)
				.click()
				.build();
		seriesOfActions.perform();
		//driver.findElement(By.linkText("You")).click();
		
		
		//waiter2.until(condition);
	  	//driver.findElement(By.linkText("Hướng dẫn sử dụng trang Học trực tuyến")).click();
	  	//Select single_select5f89923f22a521 = new Select(driver.findElement(By.name("categoryid")));
	  	// single_select5f89923f22a521.selectByVisibleText("Hướng dẫn sử dụng trang Học trực tuyến / Training 10 / 2019");
	  	//single_select5f89923f22a521.selectByIndex(2);
	  	//Assert.assertEquals(actualTitle, expectedTitle);
  	}
}

/* String baseUrl = "https://www.flickr.com/";

	WebDriver driver;
	
	@Test
	public void verifyHomePageTitle() throws InterruptedException {
		String path = System.getProperty("user.dir");
		String edgeDriverPath = path + "/res/edge_driver/msedgedriver.exe";
	//	ExpectedCondition<Boolean> condition = new ExpectedCondition<Boolean>() {
	//		
	//		@Override
	//		public Boolean apply(WebDriver driver) {
	//			// TODO Auto-generated method stub
	//			return driver.getCurrentUrl().equals("https://www.flickr.com");
	//		}
	//	};
		
		System.setProperty("webdriver.edge.driver", edgeDriverPath);
		
		System.out.println("Opening edge browser");
		driver = new EdgeDriver();
		driver.get(baseUrl);
	
		driver.findElement(By.cssSelector(".gn-tools .gn-signin .gn-title")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-email")));
		driver.findElement(By.id("login-email")).sendKeys("ax4409h@gmail.com");
		driver.findElement(By.cssSelector("form > button")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-password")));
		driver.findElement(By.id("login-password")).sendKeys("123456789thy");
		driver.findElement(By.cssSelector("form > button")).click();
	//	Thread.sleep(3000);
	//	WebDriverWait waiter2 = new WebDriverWait(driver, 3);
	//	waiter2.until(condition); */
