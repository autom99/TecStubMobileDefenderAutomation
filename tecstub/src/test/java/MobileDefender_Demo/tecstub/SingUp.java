package MobileDefender_Demo.tecstub;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class SingUp {
	
	@Test
	public void TestSignup() {
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);		
		
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		//disable notification chrome automated
		//options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
		//options.addArguments("headless");
		
		WebDriver driver = new ChromeDriver(options);	
		driver.manage().window().maximize();
		
		 //Adding wait 
		 driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

		//homepage URL as string
		String baseURL = "https://dev2.mobiledefenders.com/";
		
		try {			
			//Go to URL - Zoom sign in
			// Launch Website  
            driver.navigate().to(baseURL + "customer/account/create");   
            Thread.sleep(2000);
            
            //firstname
			WebElement elementFirstname = driver.findElement(By.id("firstname"));
            elementFirstname.clear();
            elementFirstname.sendKeys("Test Firstname");
            Thread.sleep(2000);
            
			//lastname
			WebElement elementLastname = driver.findElement(By.id("lastname"));
            elementLastname.clear();
            elementLastname.sendKeys("Test lastname");
            Thread.sleep(2000);
            
			//email_address
			WebElement elementemail_address = driver.findElement(By.id("email_address"));
            elementemail_address.clear();
            elementemail_address.sendKeys("test@mailezee.com");
            Thread.sleep(2000);
            
			//is_subscribed
			WebElement elementIs_subscribed = driver.findElement(By.id("is_subscribed"));
            elementIs_subscribed.click();
            Thread.sleep(2000);
            
            //scrolling page down
            JavascriptExecutor js = (JavascriptExecutor) driver;
            // This  will scroll down the page by  1500 pixel vertical		
            js.executeScript("window.scrollBy(0,1500)");
            
			//company
			WebElement elementcompany = driver.findElement(By.id("company"));
            elementcompany.clear();
            elementcompany.sendKeys("Test company");
            Thread.sleep(2000);
            
            //telephone
            WebElement elementtelephone = driver.findElement(By.id("telephone"));
            elementtelephone.clear();
            elementtelephone.sendKeys("9876541230");
            Thread.sleep(2000);
            
            //street_1
            WebElement elementstreet = driver.findElement(By.id("street_1"));
            elementstreet.clear();
            elementstreet.sendKeys("Test Street1");
            Thread.sleep(2000);
            
            //city - Phoenix -
            WebElement elementcity = driver.findElement(By.id("city"));
            elementcity.clear();
            elementcity.sendKeys("Phoenix");
            Thread.sleep(2000);
            
            //region_id -select any
            Select elementregion = new Select(driver.findElement(By.id("region_id")));
            elementregion.selectByIndex(3); 
            Thread.sleep(2000);

            //zip-85001
            WebElement elementZip = driver.findElement(By.id("zip"));
            elementZip.clear();
            elementZip.sendKeys("85001");
            Thread.sleep(2000);
            
            //password
            WebElement elementpassword = driver.findElement(By.id("password"));
            elementpassword.clear();
            elementpassword.sendKeys("Test@123#");
            Thread.sleep(2000);
            
            //confirmation
            WebElement elementconfirmation = driver.findElement(By.id("confirmation"));
            elementconfirmation.clear();
            elementconfirmation.sendKeys("Test@123#");
            Thread.sleep(2000);
            
			//Captcha
			WebElement elementCaptcha = driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']"));
			elementCaptcha.click();
			Thread.sleep(10000);
			
            //submit
            WebElement elementSubmit = driver.findElement(By.xpath("//span[text()='Submit']"));
            elementSubmit.click();
            Thread.sleep(2000);         
            
            //Assert
            String actualUrl= baseURL  + "customer/account/index/"; //https://dev2.mobiledefenders.com/customer/account/index/
			String expectedUrl = driver.getCurrentUrl(); 
			Assert.assertEquals(expectedUrl,actualUrl);
			Thread.sleep(2000);
			
			//logout
			//driver.navigate().to( baseURL + "customer/account/logout/");
			//System.out.println("Logout successfully.!");
			//Thread.sleep(2000);
		
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		finally{
			driver.close();
			driver.quit();
		}			
		
	}

}
