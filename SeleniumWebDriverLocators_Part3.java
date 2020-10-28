package SeleniumWebDriverLocators_Part3;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumWebDriverLocators_Part3 {
	public String baseUrl = "https://flickr.com/";
	//String driverPath = "D:\\Local Disk D\\NGOC\\STUDY\\AutoTest\\Eclipse-Project-IDE\\ChromeDriver\\chromedriver.exe";
	String driverPath = "D:\\Local Disk D\\NGOC\\STUDY\\AutoTest\\Eclipse-Project-IDE\\FireFoxDriver\\FirefoxDriver.exe";
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
	
	//VIEW ACCONUT INFORMTION
	@Test
  	public void ViewInfoAcc() throws InterruptedException {
		//1.Navigate to Flickr Website (at http://www.flickr.com)
	  	System.out.println("launching firefox browser"); 
	  	System.setProperty("webdriver.gecko.driver", driverPath);
	  	System.out.println("Openning chrome browsers");
	  	driver = new FirefoxDriver();
	  	driver.get(baseUrl);
	  	//2.Click on 'Log In' button
	  	driver.findElement(By.cssSelector(".gn-signin")).click();
	  	WebDriverWait wait = new WebDriverWait(driver, 30);
	  	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-email")));
	  	//3.Send 'Username' value to the field
		driver.findElement(By.id("login-email")).sendKeys("sakurakinomoto185@gmail.com");
		//4.Click on 'Next'
		driver.findElement(By.cssSelector("form > button")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-password")));
		//5.Send 'Password' value to the field
		driver.findElement(By.id("login-password")).sendKeys("Sakuraandusagi*123");
		//6.Click 'Log in' button
		driver.findElement(By.cssSelector("form > button")).click();
		
		//7.Click the avatar icon
		driver.findElement(By.cssSelector("c-account-buddyicon")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("c-account-buddyicon")));
		//8.Click "Settings"
		Actions builder = new Actions(driver);
  	}
	
	//UPDATE ACCOUNT INFORMATION
	@Test
	public void UpdateAccSuccess() throws InterruptedException {
		//1.Navigate to Flickr Website (at http://www.flickr.com)
	  	System.out.println("launching chrome browser"); 
	  	System.setProperty("webdriver.chrome.driver", driverPath);
	  	System.out.println("Openning chrome browsers");
	  	driver = new ChromeDriver();
	  	driver.get(baseUrl);
	  	//2.Click on 'Log In' button
	  	driver.findElement(By.cssSelector(".gn-signin")).click();
	  	WebDriverWait wait = new WebDriverWait(driver, 30);
	  	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-email")));
	  	//3.Send 'Username' value to the field
		driver.findElement(By.id("login-email")).sendKeys("sakurakinomoto185@gmail.com");
		//4.Click on 'Next'
		driver.findElement(By.cssSelector("form > button")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-password")));
		//5.Send 'Password' value to the field
		driver.findElement(By.id("login-password")).sendKeys("Sakuraandusagi*123");
		//6.Click 'Log in' button
		driver.findElement(By.cssSelector("form > button")).click();
		Actions builder = new Actions(driver);
		//7.Click the avatar icon
		
		//8.Click "Settings" and observe the displayed result
		//9.Click "Change" in section "Your real name is"
		//10.Send value to the field want to update.("Your Timezone: +07:00 Bangkok, Hanoi, Jakarta, Gender: Female")
		//11.Click "Save It"
  	}
	
	@Test
	public void UpdateAccGoBack() throws InterruptedException {
		//1.Navigate to Flickr Website (at http://www.flickr.com)
	  	System.out.println("launching chrome browser"); 
	  	System.setProperty("webdriver.chrome.driver", driverPath);
	  	System.out.println("Openning chrome browsers");
	  	driver = new ChromeDriver();
	  	driver.get(baseUrl);
	  	//2.Click on 'Log In' button
	  	driver.findElement(By.cssSelector(".gn-signin")).click();
	  	WebDriverWait wait = new WebDriverWait(driver, 30);
	  	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-email")));
	  	//3.Send 'Username' value to the field
		driver.findElement(By.id("login-email")).sendKeys("sakurakinomoto185@gmail.com");
		//4.Click on 'Next'
		driver.findElement(By.cssSelector("form > button")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-password")));
		//5.Send 'Password' value to the field
		driver.findElement(By.id("login-password")).sendKeys("Sakuraandusagi*123");
		//6.Click 'Log in' button
		driver.findElement(By.cssSelector("form > button")).click();
		Actions builder = new Actions(driver);
		//7.Click the avatar icon
		
		//8.Click "Settings" and observe the displayed result
		//9.Click "Change" in section "Your real name is"
		//10.Click "go back to your account page"

  	}
	
	@Test
	public void UpdateAccCheckDropdown() throws InterruptedException {
		//1.Navigate to Flickr Website (at http://www.flickr.com)
	  	System.out.println("launching chrome browser"); 
	  	System.setProperty("webdriver.chrome.driver", driverPath);
	  	System.out.println("Openning chrome browsers");
	  	driver = new ChromeDriver();
	  	driver.get(baseUrl);
	  	//2.Click on 'Log In' button
	  	driver.findElement(By.cssSelector(".gn-signin")).click();
	  	WebDriverWait wait = new WebDriverWait(driver, 30);
	  	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-email")));
	  	//3.Send 'Username' value to the field
		driver.findElement(By.id("login-email")).sendKeys("sakurakinomoto185@gmail.com");
		//4.Click on 'Next'
		driver.findElement(By.cssSelector("form > button")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-password")));
		//5.Send 'Password' value to the field
		driver.findElement(By.id("login-password")).sendKeys("Sakuraandusagi*123");
		//6.Click 'Log in' button
		driver.findElement(By.cssSelector("form > button")).click();
		Actions builder = new Actions(driver);
		//7.Click the avatar icon
		
		//8.Click "Settings" and observe the displayed result
		//9.Click "Change" in section "Your real name is"
		//10.Click on "Your Timezone" drop down list and then press any key (Your Timezone: +07:00 Bangkok, Hanoi, Jakarta)
  	}
	
	@Test
	public void UpdateAccCheckRadioBtn() throws InterruptedException {
		//1.Navigate to Flickr Website (at http://www.flickr.com)
	  	System.out.println("launching chrome browser"); 
	  	System.setProperty("webdriver.chrome.driver", driverPath);
	  	System.out.println("Openning chrome browsers");
	  	driver = new ChromeDriver();
	  	driver.get(baseUrl);
	  	//2.Click on 'Log In' button
	  	driver.findElement(By.cssSelector(".gn-signin")).click();
	  	WebDriverWait wait = new WebDriverWait(driver, 30);
	  	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-email")));
	  	//3.Send 'Username' value to the field
		driver.findElement(By.id("login-email")).sendKeys("sakurakinomoto185@gmail.com");
		//4.Click on 'Next'
		driver.findElement(By.cssSelector("form > button")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-password")));
		//5.Send 'Password' value to the field
		driver.findElement(By.id("login-password")).sendKeys("Sakuraandusagi*123");
		//6.Click 'Log in' button
		driver.findElement(By.cssSelector("form > button")).click();
		Actions builder = new Actions(driver);
		//7.Click the avatar icon
		
		//8.Click "Settings" and observe the displayed result
		//9.Click "Change" in section "Your real name is"
		//10.Press any key in Gender and Singleness fields (Gender: Female)
  	}
	
	//CHANGE PASSWORD
	@Test
	public void ChangePassSuccessWith12Cha() throws InterruptedException {
		//1.Navigate to Flickr Website (at http://www.flickr.com)
	  	System.out.println("launching chrome browser"); 
	  	System.setProperty("webdriver.chrome.driver", driverPath);
	  	System.out.println("Openning chrome browsers");
	  	driver = new ChromeDriver();
	  	driver.get(baseUrl);
	  	//2.Click on 'Log In' button
	  	driver.findElement(By.cssSelector(".gn-signin")).click();
	  	WebDriverWait wait = new WebDriverWait(driver, 30);
	  	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-email")));
	  	//3.Send 'Username' value to the field
		driver.findElement(By.id("login-email")).sendKeys("sakurakinomoto185@gmail.com");
		//4.Click on 'Next'
		driver.findElement(By.cssSelector("form > button")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-password")));
		//5.Send 'Password' value to the field
		driver.findElement(By.id("login-password")).sendKeys("Sakuraandusagi*123");
		//6.Click 'Log in' button
		driver.findElement(By.cssSelector("form > button")).click();
		Actions builder = new Actions(driver);
		//7.Click the avatar icon
		
		//8.Click "Settings" and observe the displayed result
		//9.Click "Edit your password"
		//10.Send 'Current Password' value and 'New Password' (12 characters) value to the field" (Current Password:'ngoc.187pm06660', New Password: '012345678910')
		//11.Click "Change your Flickr password"

  	}
	
	@Test
	public void ChangePassSuccessWith13Cha() throws InterruptedException {
		//1.Navigate to Flickr Website (at http://www.flickr.com)
	  	System.out.println("launching chrome browser"); 
	  	System.setProperty("webdriver.chrome.driver", driverPath);
	  	System.out.println("Openning chrome browsers");
	  	driver = new ChromeDriver();
	  	driver.get(baseUrl);
	  	//2.Click on 'Log In' button
	  	driver.findElement(By.cssSelector(".gn-signin")).click();
	  	WebDriverWait wait = new WebDriverWait(driver, 30);
	  	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-email")));
	  	//3.Send 'Username' value to the field
		driver.findElement(By.id("login-email")).sendKeys("sakurakinomoto185@gmail.com");
		//4.Click on 'Next'
		driver.findElement(By.cssSelector("form > button")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-password")));
		//5.Send 'Password' value to the field
		driver.findElement(By.id("login-password")).sendKeys("Sakuraandusagi*123");
		//6.Click 'Log in' button
		driver.findElement(By.cssSelector("form > button")).click();
		Actions builder = new Actions(driver);
		//7.Click the avatar icon
		
		//8.Click "Settings" and observe the displayed result
		//9.Click "Edit your password"
		//10.Send 'Current Password' value and 'New Password' (13 characters) value to the field" (Current Password:'ngoc.187pm06660', New Password: '123456789ngoc')
		//11.Click "Change your Flickr password"

  	}
	
	@Test
	public void ChangePassWithBlank() throws InterruptedException {
		//1.Navigate to Flickr Website (at http://www.flickr.com)
	  	System.out.println("launching chrome browser"); 
	  	System.setProperty("webdriver.chrome.driver", driverPath);
	  	System.out.println("Openning chrome browsers");
	  	driver = new ChromeDriver();
	  	driver.get(baseUrl);
	  	//2.Click on 'Log In' button
	  	driver.findElement(By.cssSelector(".gn-signin")).click();
	  	WebDriverWait wait = new WebDriverWait(driver, 30);
	  	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-email")));
	  	//3.Send 'Username' value to the field
		driver.findElement(By.id("login-email")).sendKeys("sakurakinomoto185@gmail.com");
		//4.Click on 'Next'
		driver.findElement(By.cssSelector("form > button")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-password")));
		//5.Send 'Password' value to the field
		driver.findElement(By.id("login-password")).sendKeys("Sakuraandusagi*123");
		//6.Click 'Log in' button
		driver.findElement(By.cssSelector("form > button")).click();
		//7.Click the avatar icon
		driver.findElement(By.cssSelector("c-account-buddyicon")).click();
		//8.Click "Settings" and observe the displayed result
		//9.Click "Edit your password"
		//10.Click "Change your Flickr password"
		Actions builder = new Actions(driver);
  	}
	
	@Test
	public void ChangePassWithPnlySpace() throws InterruptedException {
		//1.Navigate to Flickr Website (at http://www.flickr.com)
	  	System.out.println("launching chrome browser"); 
	  	System.setProperty("webdriver.chrome.driver", driverPath);
	  	System.out.println("Openning chrome browsers");
	  	driver = new ChromeDriver();
	  	driver.get(baseUrl);
	  	//2.Click on 'Log In' button
	  	driver.findElement(By.cssSelector(".gn-signin")).click();
	  	WebDriverWait wait = new WebDriverWait(driver, 30);
	  	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-email")));
	  	//3.Send 'Username' value to the field
		driver.findElement(By.id("login-email")).sendKeys("sakurakinomoto185@gmail.com");
		//4.Click on 'Next'
		driver.findElement(By.cssSelector("form > button")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-password")));
		//5.Send 'Password' value to the field
		driver.findElement(By.id("login-password")).sendKeys("Sakuraandusagi*123");
		//6.Click 'Log in' button
		driver.findElement(By.cssSelector("form > button")).click();
		Actions builder = new Actions(driver);
		//7.Click the avatar icon
		
		//8.Click "Settings" and observe the displayed result
		//9.Click "Edit your password"
		//10.Send only spaces to fields 'Current Password' and 'New Password'
		//11.Click "Change your Flickr password"

  	}
	
	@Test
	public void ChangePassWithInvalidCurrentPass() throws InterruptedException {
		//1.Navigate to Flickr Website (at http://www.flickr.com)
	  	System.out.println("launching chrome browser"); 
	  	System.setProperty("webdriver.chrome.driver", driverPath);
	  	System.out.println("Openning chrome browsers");
	  	driver = new ChromeDriver();
	  	driver.get(baseUrl);
	  	//2.Click on 'Log In' button
	  	driver.findElement(By.cssSelector(".gn-signin")).click();
	  	WebDriverWait wait = new WebDriverWait(driver, 30);
	  	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-email")));
	  	//3.Send 'Username' value to the field
		driver.findElement(By.id("login-email")).sendKeys("sakurakinomoto185@gmail.com");
		//4.Click on 'Next'
		driver.findElement(By.cssSelector("form > button")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-password")));
		//5.Send 'Password' value to the field
		driver.findElement(By.id("login-password")).sendKeys("Sakuraandusagi*123");
		//6.Click 'Log in' button
		driver.findElement(By.cssSelector("form > button")).click();
		Actions builder = new Actions(driver);
		//7.Click the avatar icon
		
		//8.Click "Settings" and observe the displayed result
		//9.Click "Edit your password"
		//10.Send invalid password to fields 'Current Password'
		//11.Click "Change your Flickr password"

  	}
	
	@Test
	public void ChangePassWith11Cha() throws InterruptedException {
		//1.Navigate to Flickr Website (at http://www.flickr.com)
	  	System.out.println("launching chrome browser"); 
	  	System.setProperty("webdriver.chrome.driver", driverPath);
	  	System.out.println("Openning chrome browsers");
	  	driver = new ChromeDriver();
	  	driver.get(baseUrl);
	  	//2.Click on 'Log In' button
	  	driver.findElement(By.cssSelector(".gn-signin")).click();
	  	WebDriverWait wait = new WebDriverWait(driver, 30);
	  	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-email")));
	  	//3.Send 'Username' value to the field
		driver.findElement(By.id("login-email")).sendKeys("sakurakinomoto185@gmail.com");
		//4.Click on 'Next'
		driver.findElement(By.cssSelector("form > button")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-password")));
		//5.Send 'Password' value to the field
		driver.findElement(By.id("login-password")).sendKeys("Sakuraandusagi*123");
		//6.Click 'Log in' button
		driver.findElement(By.cssSelector("form > button")).click();
		Actions builder = new Actions(driver);
		//7.Click the avatar icon
		
		//8.Click "Settings" and observe the displayed result
		//9.Click "Edit your password"
		//10.Send 'Current Password' value and 'New Password' (11 characters) value to the field" (Current Password:'ngoc.187pm06660', New Password: '01234567890')
		//11.Click "Change your Flickr password"

  	}
	
	@Test
	public void ChangePassWithLeadSpace() throws InterruptedException {
		//1.Navigate to Flickr Website (at http://www.flickr.com)
	  	System.out.println("launching chrome browser"); 
	  	System.setProperty("webdriver.chrome.driver", driverPath);
	  	System.out.println("Openning chrome browsers");
	  	driver = new ChromeDriver();
	  	driver.get(baseUrl);
	  	//2.Click on 'Log In' button
	  	driver.findElement(By.cssSelector(".gn-signin")).click();
	  	WebDriverWait wait = new WebDriverWait(driver, 30);
	  	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-email")));
	  	//3.Send 'Username' value to the field
		driver.findElement(By.id("login-email")).sendKeys("sakurakinomoto185@gmail.com");
		//4.Click on 'Next'
		driver.findElement(By.cssSelector("form > button")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-password")));
		//5.Send 'Password' value to the field
		driver.findElement(By.id("login-password")).sendKeys("Sakuraandusagi*123");
		//6.Click 'Log in' button
		driver.findElement(By.cssSelector("form > button")).click();
		Actions builder = new Actions(driver);
		//7.Click the avatar icon
		
		//8.Click "Settings" and observe the displayed result
		//9.Click "Edit your password"
		//10.Send 'Current Password' value and 'New Password' (with leading space) value to the field (Current Password:'ngoc.187pm06660', New Password: ' 01234567890')
		//11.Click "Change your Flickr password"

  	}
}