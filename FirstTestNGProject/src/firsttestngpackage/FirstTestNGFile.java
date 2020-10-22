package firsttestngpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTestNGFile {
	public String baseUrl = "https://www.flickr.com/";
	String driverPath = "C:\\Users\\duy.187pm13901\\Downloads\\FireFox\\FirefoxDriver.exe";
	public WebDriver driver;
	  @Test
	  public void f() {
		  System.out.println("launching firefox browser"); 
	      System.setProperty("webdriver.gecko.driver", driverPath);
	      System.out.println("Openning firefox browsers");
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);
	      String expectedTitle = "Find your inspiration. | Flickr";
	      String actualTitle = driver.getTitle();
	      Assert.assertEquals(actualTitle, expectedTitle);
	      driver.close();
	
	  }
}
