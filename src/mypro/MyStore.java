package mypro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
public class MyStore {
	public String url="http://automationpractice.com/index.php";
	public WebDriver driver;

	@BeforeTest
	public void setURL() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.findElement(By.className("login")).sendKeys(Keys.ENTER); 
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	    
	}	
	
	  @Test(priority=0) 
	  public void registration() {
		  	driver.findElement(By.name("email_create")).sendKeys("srqponmlkjihgf@gmail.com");
		    driver.findElement(By.name("SubmitCreate")).sendKeys(Keys.ENTER);
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    driver.findElement(By.name("id_gender")).click();
		    driver.findElement(By.name("customer_firstname")).sendKeys("PRI");
		    driver.findElement(By.name("customer_lastname")).sendKeys("DBCA");
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    driver.findElement(By.name("passwd")).sendKeys("password");
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    Select days= new Select(driver.findElement(By.name("days")));
		    days.selectByValue("12");
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    Select month= new Select(driver.findElement(By.name("months")));
		    month.selectByValue("12");
		    Select years= new Select(driver.findElement(By.name("years")));
		    years.selectByValue("1998");
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    driver.findElement(By.name("firstname")).sendKeys("ABCD");
		    driver.findElement(By.name("lastname")).sendKeys("DBCA");
		    driver.findElement(By.name("address1")).sendKeys("221 B, Baker Street");
		    driver.findElement(By.name("city")).sendKeys("Leeds");
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    Select state= new Select(driver.findElement(By.name("id_state")));
		    state.selectByValue("12");
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    driver.findElement(By.name("postcode")).sendKeys("80047");
		    Select country= new Select(driver.findElement(By.name("id_country")));
		    country.selectByValue("21");
		    driver.findElement(By.name("phone_mobile")).sendKeys("0000112233");
		    driver.findElement(By.name("alias")).sendKeys("Leeds");
		    driver.findElement(By.name("submitAccount")).click();
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.linkText("Sign out")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }
	 
	@Test(priority = 1)
	public void loginCredentials() {
		driver.findElement(By.name("email")).sendKeys("sqrp@gmail.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElement(By.name("passwd")).sendKeys("password");
	    driver.findElement(By.name("SubmitLogin")).click(); 
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
		String expected= "My account - My Store";
		System.out.println("Expected Title: " + expected);
		String actual= driver.getTitle();
		System.out.println("Current Title: "+ actual);
		try {
			Assert.assertEquals(actual, expected);
			System.out.println("Title is same, so the user is Logged in");
		}catch(Throwable e) {
			System.out.println("Title is different, Failed Log in");
		}
	}
	
	
	@Test(priority = 2)
	public void searchbarAndAddToCart() {
		driver.findElement(By.name("search_query")).sendKeys("t-shirts");
		driver.findElement(By.name("submit_search")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Faded Short Sleeve T-shirts")).click();
		driver.findElement(By.name("Submit")).click();
	}
	
	
	/*
	 * @AfterTest public void endSession() {
	 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 * driver.quit(); }
	 */
    
    
}

