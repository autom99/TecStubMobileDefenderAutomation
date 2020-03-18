package MobileDefender_Demo.tecstub;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import junit.framework.Assert;

@Test
public class SignIn {

	public void TestSignIn() {
		
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);		
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		//disable notification chrome automated
		//options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
		//options.addArguments("headless");
		
		WebDriver driver = new ChromeDriver(options);	
		driver.manage().window().maximize();

		//homepage URL as string
		String baseURL = "https://dev2.mobiledefenders.com/"; 
		  
		try {			
			// Launch Website  
            driver.navigate().to(baseURL + "customer/account/login");   
            Thread.sleep(2000);
			
			//signin username
			WebElement elementusername = driver.findElement(By.id("email"));
			elementusername.clear();
			elementusername.sendKeys("test@mailezee.com"); 

			//signin password
			WebElement elementPassword = driver.findElement(By.id("pass"));
			elementPassword.clear();
			elementPassword.sendKeys("Test@123#"); 
			
			//button click SIGNIN
			WebElement elementButtonSignin = driver.findElement(By.id("send2"));	
			elementButtonSignin.click();
			Thread.sleep(3000);
			
			String actualUrl= baseURL  + "customer/account/"; //https://dev2.mobiledefenders.com/customer/account/index/
			String expectedUrl= driver.getCurrentUrl(); 
			Assert.assertEquals(expectedUrl,actualUrl);
			
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		finally{
			driver.close();
			driver.quit();
		}			
	}
}
