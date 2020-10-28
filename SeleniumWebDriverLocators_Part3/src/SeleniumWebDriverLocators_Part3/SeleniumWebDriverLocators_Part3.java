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
	String driverPath = "D:\\Eclipse-Project-IDE\\ChromeDriver\\chromedriver.exe";
	public WebDriver driver;
	
	// Access to Flickr Webiste
	@Test
  	public void HomePageFlickr() throws InterruptedException {
		//1.Navigate to Flickr Website (at http://www.flickr.com)
		System.out.println("launching chrome browser"); 
	  	System.setProperty("webdriver.chrome.driver", driverPath);
	  	System.out.println("Openning chrome browsers");
	  	driver = new ChromeDriver();
	  	driver.manage().window().maximize();
	  	driver.get(baseUrl);
	  	String expectedTitle = "Find your inspiration. | Flickr";
	  	String actualTitle = driver.getTitle();
	  	
	  	//2.Click on 'Log In' button
	  	driver.findElement(By.cssSelector(".gn-signin")).click();
	  	WebDriverWait wait = new WebDriverWait(driver, 30);
	  	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-email")));
	  	//3.Send 'Username' value to the field
		driver.findElement(By.id("login-email")).sendKeys("sakurakinomoto185@gmail.com");
		driver.findElement(By.cssSelector("form > button")).click();		
		//4.Click on 'Next'
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-password")));		
		//5.Send 'Password' value to the field
		driver.findElement(By.id("login-password")).sendKeys("Sakuraandusagi*123");		
		//6.Click 'Log in' button
		driver.findElement(By.cssSelector("form > button")).click();		
		//7.Click the avatar icon
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".c-account-menu")));	
		WebElement Avatar = driver.findElement(By.cssSelector(".c-account-menu"));
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
				.moveToElement(Avatar)
				//.moveToElement(titleAlbum)
				.click()
				.build();
		seriesOfActions.perform();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(".Settings")));	
		WebElement Settings = driver.findElement(By.linkText(".Settings"));
		Actions builder2 = new Actions(driver);
		Action seriesOfActions2 = builder2
				.moveToElement(Settings)
				.click()
				.build();
		seriesOfActions2.perform();
			
		//8.Click "Settings"
		//Actions builder = new Actions(driver);
	}
	
	// Update Account Information
	@Test
	public void UpdateAccountInformation() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".change-real-name")));
		
		WebElement ChangeRealName = driver.findElement(By.cssSelector(".change-real-name"));
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
			.moveToElement(ChangeRealName)	
			.click()
			.build();
		seriesOfActions.perform();
		
	}
	
	@Test
	public void CloseBrowser() throws InterruptedException {
		driver.close();
	}
} 
		
	/* @Test
	public void YouTool() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".moola-container.feed-ba.upsell-fallback")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".filter-menu-text")));
		WebElement titleYou = driver.findElement(By.cssSelector(".filter-menu-text"));
		//WebElement titleAlbum = driver.findElement(By.cssSelector("Album"));
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
				.moveToElement(titleYou)
				//.moveToElement(titleAlbum)
				.click()
				.build();
		seriesOfActions.perform();
		
	
	} */

		
