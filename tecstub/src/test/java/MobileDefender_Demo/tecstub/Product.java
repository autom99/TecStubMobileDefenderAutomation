package MobileDefender_Demo.tecstub;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import junit.framework.Assert;

@Test
public class Product {

	public void TestProduct() {

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

		//Instantiate Action Class        
		Actions actions = new Actions(driver);

		//homepage URL as string
		String baseURL = "https://dev2.mobiledefenders.com/";

		try {
			// Launch Website  
			driver.navigate().to(baseURL + "customer/account/login");   //https://dev2.mobiledefenders.com/android/samsung-repair-parts/galaxy-note-series.html
			driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

			//username
			WebElement elementusername = driver.findElement(By.id("email"));
			elementusername.clear();
			elementusername.sendKeys("test@mailezee.com"); 
			Thread.sleep(3000);

			//password
			WebElement elementPassword = driver.findElement(By.id("pass"));
			elementPassword.clear();
			elementPassword.sendKeys("Test@123#"); 
			Thread.sleep(3000);

			//button click SIGNIN
			WebElement elementButtonSignin = driver.findElement(By.id("send2"));	
			elementButtonSignin.click();
			Thread.sleep(3000);

			//click on any product page by Samsung
			driver.navigate().to(baseURL + "android/samsung-repair-parts/galaxy-note-series.html");
			driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

			//Retrieve WebElement 'Samsung Galaxy Note 2' to perform mouse hover 
			WebElement hoverImage1 = driver.findElement(By.id("product-collection-image-1587")); //product-collection-image-1587			
			//Mouse hover menuOption 'Samsung Galaxy Note 2'
			actions.moveToElement(hoverImage1).perform();
			Thread.sleep(2000);
			WebElement btnAddToCartOpt1 = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[6]/div[1]/div[1]/div[1]/div[5]/ul[1]/li[1]/div[1]/div[2]/div[1]/div[2]/div[2]/a[1]/span[1]"));
			btnAddToCartOpt1.click();
			System.out.println("LCD & Digitizer for Samsung Galaxy Note 2 - White\r\n" + "SKU:MDSA0012");
			Thread.sleep(10000);
			
			//Item-2
			WebElement hoverImage2 = driver.findElement(By.id("product-collection-image-1650")); //product-collection-image-1587			
			//Mouse hover menuOption 'Rear Camera for Samsung Galaxy Note 2'
			actions.moveToElement(hoverImage2).perform();	
			Thread.sleep(2000);
			WebElement btnAddToCartOpt2 = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[6]/div[1]/div[1]/div[1]/div[5]/ul[1]/li[20]/div[1]/div[2]/div[1]/div[2]/div[2]/a[1]/span[1]"));
			btnAddToCartOpt2.click();
			System.out.println("Rear Camera for Samsung Galaxy Note 2");
			Thread.sleep(5000);
			
			//build() method is used to compile all the actions into a single step 
			//actions.click().build().perform();

			//product-collection-image-1589

			//Go to cart
			driver.findElement(By.xpath("https://dev2.mobiledefenders.com/checkout/cart/?___SID=U")).click();
			Thread.sleep(5000);

			//checkout
			driver.findElement(By.xpath("//span[text()='Proceed to Checkout']")).click();
			Thread.sleep(5000);
			
			//Username
			driver.findElement(By.xpath("//input[@type='text'][@name='login[username]']")).sendKeys("test@mailezee.com");
			Thread.sleep(3000);

			//Password
			driver.findElement(By.xpath("//input[@type='password'][@name='login[password]']")).sendKeys("Test@123#");
			Thread.sleep(3000);

			//Login button
			driver.findElement(By.xpath("//span[text()='Login']")).click();
			Thread.sleep(3000);

			//Bill address
			driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[5]/div[1]/div[1]/div[1]/ol[1]/li[1]/div[2]/form[1]/fieldset[1]/div[1]/button[1]/span[1]/span[1]")).click();
			Thread.sleep(3000);

			//Your Delivery Window
			driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[5]/div[1]/div[1]/div[1]/ol[1]/li[3]/div[2]/form[1]/div[3]/button[1]/span[1]/span[1]")).click();
			Thread.sleep(5000);

			//Cash On Delivery
			driver.findElement(By.xpath("//label[contains(text(),'Cash On Delivery')]")).click();
			Thread.sleep(5000);

			//COD - Continue button
			driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[5]/div[1]/div[1]/div[1]/ol[1]/li[4]/div[2]/div[2]/button[1]/span[1]/span[1]")).click();
			Thread.sleep(5000);

			//Agree
			driver.findElement(By.xpath("//input[@type='checkbox'][@name='agreement[1]']")).click();
			Thread.sleep(5000);

			//Place Order
			driver.findElement(By.xpath("//span[text()='Place Order']")).click();
			Thread.sleep(5000);

			//Print preview
			driver.findElement(By.xpath("//a[text()='here to print']")).click();
			Thread.sleep(5000);
			
			//Dashboard
			driver.navigate().to(baseURL + "customer/account/");
			Thread.sleep(5000);
			
            //scrolling page down
            JavascriptExecutor js = (JavascriptExecutor) driver;
            // This  will scroll down the page by  500 pixel vertical		
            js.executeScript("window.scrollBy(0,500)");
            
			String actualUrl= baseURL  + "checkout/onepage/success/"; //https://dev2.mobiledefenders.com/checkout/onepage/success/
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
