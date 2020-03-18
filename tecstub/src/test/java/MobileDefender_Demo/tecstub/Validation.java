package MobileDefender_Demo.tecstub;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Validation {

	WebDriver driver;

	String baseURL = "https://dev2.mobiledefenders.com/";

	//Launch browser
	@Test
	public void LaunchBrowser() {

		try {
			String projectPath = System.getProperty("user.dir");
			System.out.println(projectPath);		
			System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver.exe");

			WebDriver driver = new ChromeDriver();	
			driver.manage().window().maximize();
			Thread.sleep(5000);

			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);	

			// Launch Website  
			driver.navigate().to(baseURL);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*-------------------------------TESTCASE: SIGNUP PAGE ----------------------------------------*/
	
	//Verifying elements on Registration page
	@Test
	public void verifyElemntsOnPageTest()
	{
		LaunchBrowser();

		try {	
			// Launch Website  
			driver.navigate().to(baseURL + "customer/account/create"); 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);	

			//logo
			WebElement websiteTestLogo = driver.findElement(By.xpath("//img[@alt='Mobile Defenders']"));
			websiteTestLogo.isDisplayed();

			//Signup page title
			WebElement signUpTitle = driver.findElement(By.xpath("//h1[text()='Create an Account']"));
			signUpTitle.isDisplayed();

			//Captcha code
			WebElement captcha = driver.findElement(By.xpath("//div[text()='reCAPTCHA']"));
			captcha.isDisplayed();

			//firstname
			WebElement elementFirstname = driver.findElement(By.id("firstname"));
			elementFirstname.isDisplayed();

			//lastname
			WebElement elementLastname = driver.findElement(By.id("lastname"));
			elementLastname.isDisplayed();

			//email_address
			WebElement elementemail_address = driver.findElement(By.id("email_address"));
			elementemail_address.isDisplayed();

			//is_subscribed
			WebElement elementIs_subscribed = driver.findElement(By.id("is_subscribed"));
			elementIs_subscribed.isDisplayed();

			//scrolling page down
			JavascriptExecutor js = (JavascriptExecutor) driver;
			// This  will scroll down the page by  1500 pixel vertical		
			js.executeScript("window.scrollBy(0,1500)");

			//company
			WebElement elementcompany = driver.findElement(By.id("company"));
			elementcompany.isDisplayed();

			//telephone
			WebElement elementtelephone = driver.findElement(By.id("telephone"));
			elementtelephone.isDisplayed();

			//street_1
			WebElement elementstreet = driver.findElement(By.id("street_1"));
			elementstreet.isDisplayed();

			//city - Phoenix -
			WebElement elementcity = driver.findElement(By.id("city"));
			elementcity.isDisplayed();

			//region_id -select any
			Select elementregion = new Select(driver.findElement(By.id("region_id")));
			elementregion.isMultiple();

			//zip-85001
			WebElement elementZip = driver.findElement(By.id("zip"));
			elementZip.isDisplayed();

			//password
			WebElement elementpassword = driver.findElement(By.id("password"));
			elementpassword.isDisplayed();

			//confirmation
			WebElement elementconfirmation = driver.findElement(By.id("confirmation"));
			elementconfirmation.isDisplayed();

			//Captcha
			WebElement elementCaptcha = driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']"));
			elementCaptcha.isDisplayed();

			//submit
			WebElement elementSubmit = driver.findElement(By.xpath("//span[text()='Submit']"));
			elementSubmit.isDisplayed();

		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}


	//Verifying redirection to the landing page
	@Test
	public void landingPageRedirectionTest()
	{
		LaunchBrowser();

		
		try {
			// Launch Website  
			driver.navigate().to(baseURL + "customer/account/create"); 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			
			WebElement websiteTestLogo = driver.findElement(By.xpath("//img[@alt='Mobile Defenders']"));
			websiteTestLogo.click();

			String expectedURL = "https://dev2.mobiledefenders.com/";
			String actualURL = driver.getCurrentUrl();
			Assert.assertEquals(actualURL, expectedURL);

			//String expectedTitle = "";

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	// Registration with all valid data
	@Test
	public void validRegistrationTest(){

		try {
			
			LaunchBrowser();
			
			// Launch Website  
			driver.navigate().to(baseURL + "customer/account/create"); 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			
			//firstname
			WebElement elementFirstname = driver.findElement(By.id("firstname"));
			elementFirstname.clear();
			elementFirstname.sendKeys("Test Firstname");

			//lastname
			WebElement elementLastname = driver.findElement(By.id("lastname"));
			elementLastname.clear();
			elementLastname.sendKeys("Test lastname");

			//email_address
			WebElement elementemail_address = driver.findElement(By.id("email_address"));
			elementemail_address.clear();
			elementemail_address.sendKeys("test1@mailezee.com");

			//is_subscribed
			WebElement elementIs_subscribed = driver.findElement(By.id("is_subscribed"));
			elementIs_subscribed.click();

			//scrolling page down
			JavascriptExecutor js = (JavascriptExecutor) driver;
			// This  will scroll down the page by  1500 pixel vertical		
			js.executeScript("window.scrollBy(0,1500)");

			//company
			WebElement elementcompany = driver.findElement(By.id("company"));
			elementcompany.clear();
			elementcompany.sendKeys("Test company");

			//telephone
			WebElement elementtelephone = driver.findElement(By.id("telephone"));
			elementtelephone.clear();
			elementtelephone.sendKeys("9876541230");

			//street_1
			WebElement elementstreet = driver.findElement(By.id("street_1"));
			elementstreet.clear();
			elementstreet.sendKeys("Test Street1");

			//city - Phoenix -
			WebElement elementcity = driver.findElement(By.id("city"));
			elementcity.clear();
			elementcity.sendKeys("Phoenix");

			//region_id -select any
			Select elementregion = new Select(driver.findElement(By.id("region_id")));
			elementregion.selectByIndex(3); 

			//zip-85001
			WebElement elementZip = driver.findElement(By.id("zip"));
			elementZip.clear();
			elementZip.sendKeys("85001");

			//password
			WebElement elementpassword = driver.findElement(By.id("password"));
			elementpassword.clear();
			elementpassword.sendKeys("Test@123#");

			//confirmation
			WebElement elementconfirmation = driver.findElement(By.id("confirmation"));
			elementconfirmation.clear();
			elementconfirmation.sendKeys("Test@123#");

			//Captcha
			WebElement elementCaptcha = driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']"));
			elementCaptcha.click();
			Thread.sleep(10000);

			//submit
			WebElement elementSubmit = driver.findElement(By.xpath("//span[text()='Submit']"));
			elementSubmit.click();       

			//Assert
			String actualUrl= baseURL  + "customer/account/index/"; //https://dev2.mobiledefenders.com/customer/account/index/
			String expectedUrl = driver.getCurrentUrl(); 
			Assert.assertEquals(expectedUrl,actualUrl);

			//logout
			driver.navigate().to( baseURL + "customer/account/logout/");
			System.out.println("Logout successfully.!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	// Registration without providing Company Name field
	@Test
	public void emptyCompanyNameTest()
	{
		try {
			LaunchBrowser();
			
			// Launch Website  
			driver.navigate().to(baseURL + "customer/account/create"); 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			
			//firstname
			WebElement elementFirstname = driver.findElement(By.id("firstname"));
			elementFirstname.clear();
			elementFirstname.sendKeys("Test Firstname");

			//lastname
			WebElement elementLastname = driver.findElement(By.id("lastname"));
			elementLastname.clear();
			elementLastname.sendKeys("Test lastname");

			//email_address
			WebElement elementemail_address = driver.findElement(By.id("email_address"));
			elementemail_address.clear();
			elementemail_address.sendKeys("test1@mailezee.com");

			//is_subscribed
			WebElement elementIs_subscribed = driver.findElement(By.id("is_subscribed"));
			elementIs_subscribed.click();

			//scrolling page down
			JavascriptExecutor js = (JavascriptExecutor) driver;
			// This  will scroll down the page by  1500 pixel vertical		
			js.executeScript("window.scrollBy(0,1500)");

			//company
			WebElement elementcompany = driver.findElement(By.id("company"));
			elementcompany.clear();
			elementcompany.sendKeys("");

			//telephone
			WebElement elementtelephone = driver.findElement(By.id("telephone"));
			elementtelephone.clear();
			elementtelephone.sendKeys("9876541230");

			//street_1
			WebElement elementstreet = driver.findElement(By.id("street_1"));
			elementstreet.clear();
			elementstreet.sendKeys("Test Street1");

			//city - Phoenix -
			WebElement elementcity = driver.findElement(By.id("city"));
			elementcity.clear();
			elementcity.sendKeys("Phoenix");

			//region_id -select any
			Select elementregion = new Select(driver.findElement(By.id("region_id")));
			elementregion.selectByIndex(3); 

			//zip-85001
			WebElement elementZip = driver.findElement(By.id("zip"));
			elementZip.clear();
			elementZip.sendKeys("85001");

			//password
			WebElement elementpassword = driver.findElement(By.id("password"));
			elementpassword.clear();
			elementpassword.sendKeys("Test@123#");

			//confirmation
			WebElement elementconfirmation = driver.findElement(By.id("confirmation"));
			elementconfirmation.clear();
			elementconfirmation.sendKeys("Test@123#");

			//Captcha
			WebElement elementCaptcha = driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']"));
			elementCaptcha.click();
			Thread.sleep(10000);

			//submit
			WebElement elementSubmit = driver.findElement(By.xpath("//span[text()='Submit']"));
			elementSubmit.click();       

			//Assert
			String actualUrl= baseURL  + "customer/account/index/"; //https://dev2.mobiledefenders.com/customer/account/index/
			String expectedUrl = driver.getCurrentUrl(); 
			Assert.assertEquals(expectedUrl,actualUrl);

			//logout
			driver.navigate().to( baseURL + "customer/account/logout/");
			System.out.println("Logout successfully.!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	// Registration without providing FirstName field
	@Test
	public void emptyNameTest()
	{
		try {

			LaunchBrowser();
			
			// Launch Website  
			driver.navigate().to(baseURL + "customer/account/create"); 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			
			String expectedErrorMsg = "This is a required field";

			//firstname
			WebElement elementFirstname = driver.findElement(By.id("firstname"));
			elementFirstname.clear();
			elementFirstname.sendKeys("");

			//lastname
			WebElement elementLastname = driver.findElement(By.id("lastname"));
			elementLastname.clear();
			elementLastname.sendKeys("Test lastname");

			//email_address
			WebElement elementemail_address = driver.findElement(By.id("email_address"));
			elementemail_address.clear();
			elementemail_address.sendKeys("test1@mailezee.com");

			//is_subscribed
			WebElement elementIs_subscribed = driver.findElement(By.id("is_subscribed"));
			elementIs_subscribed.click();

			//scrolling page down
			JavascriptExecutor js = (JavascriptExecutor) driver;
			// This  will scroll down the page by  1500 pixel vertical		
			js.executeScript("window.scrollBy(0,1500)");

			//company
			WebElement elementcompany = driver.findElement(By.id("company"));
			elementcompany.clear();
			elementcompany.sendKeys("Test company");

			//telephone
			WebElement elementtelephone = driver.findElement(By.id("telephone"));
			elementtelephone.clear();
			elementtelephone.sendKeys("9876541230");

			//street_1
			WebElement elementstreet = driver.findElement(By.id("street_1"));
			elementstreet.clear();
			elementstreet.sendKeys("Test Street1");

			//city - Phoenix -
			WebElement elementcity = driver.findElement(By.id("city"));
			elementcity.clear();
			elementcity.sendKeys("Phoenix");

			//region_id -select any
			Select elementregion = new Select(driver.findElement(By.id("region_id")));
			elementregion.selectByIndex(3); 

			//zip-85001
			WebElement elementZip = driver.findElement(By.id("zip"));
			elementZip.clear();
			elementZip.sendKeys("85001");

			//password
			WebElement elementpassword = driver.findElement(By.id("password"));
			elementpassword.clear();
			elementpassword.sendKeys("Test@123#");

			//confirmation
			WebElement elementconfirmation = driver.findElement(By.id("confirmation"));
			elementconfirmation.clear();
			elementconfirmation.sendKeys("Test@123#");

			//Captcha
			WebElement elementCaptcha = driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']"));
			elementCaptcha.click();
			Thread.sleep(10000);

			//submit
			WebElement elementSubmit = driver.findElement(By.xpath("//span[text()='Submit']"));
			elementSubmit.click();                   

			String actualErrorMsg = elementFirstname.getText();

			Assert.assertEquals(actualErrorMsg, expectedErrorMsg);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	// Registration without providing user email field
	@Test
	public void emptyEmailTest()
	{
		try {
			LaunchBrowser();
			
			// Launch Website  
			driver.navigate().to(baseURL + "customer/account/create"); 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			
			//firstname
			WebElement elementFirstname = driver.findElement(By.id("firstname"));
			elementFirstname.clear();
			elementFirstname.sendKeys("Test Firstname");

			//lastname
			WebElement elementLastname = driver.findElement(By.id("lastname"));
			elementLastname.clear();
			elementLastname.sendKeys("Test lastname");

			//is_subscribed
			WebElement elementIs_subscribed = driver.findElement(By.id("is_subscribed"));
			elementIs_subscribed.click();

			//scrolling page down
			JavascriptExecutor js = (JavascriptExecutor) driver;
			// This  will scroll down the page by  1500 pixel vertical		
			js.executeScript("window.scrollBy(0,1500)");

			//company
			WebElement elementcompany = driver.findElement(By.id("company"));
			elementcompany.clear();
			elementcompany.sendKeys("Test company");

			//telephone
			WebElement elementtelephone = driver.findElement(By.id("telephone"));
			elementtelephone.clear();
			elementtelephone.sendKeys("9876541230");

			//street_1
			WebElement elementstreet = driver.findElement(By.id("street_1"));
			elementstreet.clear();
			elementstreet.sendKeys("Test Street1");

			//city - Phoenix -
			WebElement elementcity = driver.findElement(By.id("city"));
			elementcity.clear();
			elementcity.sendKeys("Phoenix");

			//region_id -select any
			Select elementregion = new Select(driver.findElement(By.id("region_id")));
			elementregion.selectByIndex(3); 

			//zip-85001
			WebElement elementZip = driver.findElement(By.id("zip"));
			elementZip.clear();
			elementZip.sendKeys("85001");

			//password
			WebElement elementpassword = driver.findElement(By.id("password"));
			elementpassword.clear();
			elementpassword.sendKeys("Test@123#");

			//confirmation
			WebElement elementconfirmation = driver.findElement(By.id("confirmation"));
			elementconfirmation.clear();
			elementconfirmation.sendKeys("Test@123#");

			//Captcha
			WebElement elementCaptcha = driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']"));
			elementCaptcha.click();
			Thread.sleep(10000);

			//submit
			WebElement elementSubmit = driver.findElement(By.xpath("//span[text()='Submit']"));
			elementSubmit.click();       

			String expectedErrorMsg = "This is a required field";

			//email_address
			WebElement elementemail_address = driver.findElement(By.id("email_address"));
			elementemail_address.clear();
			elementemail_address.sendKeys("");
			String actualErrorMsg = elementemail_address.getText();

			Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	// Registration with email id which already have account
	@Test
	public void invalidEmailTest()
	{
		try {
			LaunchBrowser();
			
			// Launch Website  
			driver.navigate().to(baseURL + "customer/account/create"); 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			
			WebElement companyName = driver.findElement(By.name("organization_name"));
			companyName.sendKeys("TestCompany");

			WebElement fullName = driver.findElement(By.name("name"));
			fullName.sendKeys("TestName");

			WebElement password = driver.findElement(By.name("password"));
			password.sendKeys("Test@123");

			WebElement phone = driver.findElement(By.name("phone"));
			phone.sendKeys("9876543210");

			//Captcha
			WebElement elementCaptcha = driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']"));
			elementCaptcha.click();
			Thread.sleep(10000);

			WebElement termsOfServices = driver.findElement(By.id("terms_of_service"));
			termsOfServices.click();

			WebElement signUp = driver.findElement(By.xpath("//button[contains(@class,'btn sign-up-btn-2 btn-block')]"));
			signUp.click();

			String expectedErrorMsg = "This email is already registered";

			WebElement email = driver.findElement(By.name("email"));
			email.sendKeys("test@mailezee.com");
			String actualErrorMsg = email.getText();

			Assert.assertEquals(actualErrorMsg, expectedErrorMsg);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	// Registration without providing password field
	@Test
	public void emptyPasswordTest()
	{
		try {
			LaunchBrowser();
			
			// Launch Website  
			driver.navigate().to(baseURL + "customer/account/create"); 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			
			//firstname
			WebElement elementFirstname = driver.findElement(By.id("firstname"));
			elementFirstname.clear();
			elementFirstname.sendKeys("Test Firstname");

			//lastname
			WebElement elementLastname = driver.findElement(By.id("lastname"));
			elementLastname.clear();
			elementLastname.sendKeys("Test lastname");

			//is_subscribed
			WebElement elementIs_subscribed = driver.findElement(By.id("is_subscribed"));
			elementIs_subscribed.click();

			//scrolling page down
			JavascriptExecutor js = (JavascriptExecutor) driver;
			// This  will scroll down the page by  1500 pixel vertical		
			js.executeScript("window.scrollBy(0,1500)");

			//company
			WebElement elementcompany = driver.findElement(By.id("company"));
			elementcompany.clear();
			elementcompany.sendKeys("Test company");

			//telephone
			WebElement elementtelephone = driver.findElement(By.id("telephone"));
			elementtelephone.clear();
			elementtelephone.sendKeys("9876541230");

			//street_1
			WebElement elementstreet = driver.findElement(By.id("street_1"));
			elementstreet.clear();
			elementstreet.sendKeys("Test Street1");

			//city - Phoenix -
			WebElement elementcity = driver.findElement(By.id("city"));
			elementcity.clear();
			elementcity.sendKeys("Phoenix");

			//region_id -select any
			Select elementregion = new Select(driver.findElement(By.id("region_id")));
			elementregion.selectByIndex(3); 

			//zip-85001
			WebElement elementZip = driver.findElement(By.id("zip"));
			elementZip.clear();
			elementZip.sendKeys("85001");

			//password
			WebElement elementpassword = driver.findElement(By.id("password"));
			elementpassword.clear();
			elementpassword.sendKeys("");

			//confirmation
			WebElement elementconfirmation = driver.findElement(By.id("confirmation"));
			elementconfirmation.clear();
			elementconfirmation.sendKeys("Test@123#");

			//Captcha
			WebElement elementCaptcha = driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']"));
			elementCaptcha.click();
			Thread.sleep(10000);

			//submit
			WebElement elementSubmit = driver.findElement(By.xpath("//span[text()='Submit']"));
			elementSubmit.click();    

			String expectedErrorMsg = "This is a required field.";

			String actualErrorMsg = elementpassword.getText();

			Assert.assertEquals(actualErrorMsg, expectedErrorMsg);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	// Registration with invalid password
	@Test
	public void inValidPasswordTest()
	{
		try {
			LaunchBrowser();
			
			// Launch Website  
			driver.navigate().to(baseURL + "customer/account/create"); 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			
			//firstname
			WebElement elementFirstname = driver.findElement(By.id("firstname"));
			elementFirstname.clear();
			elementFirstname.sendKeys("Test Firstname");

			//lastname
			WebElement elementLastname = driver.findElement(By.id("lastname"));
			elementLastname.clear();
			elementLastname.sendKeys("Test lastname");

			//is_subscribed
			WebElement elementIs_subscribed = driver.findElement(By.id("is_subscribed"));
			elementIs_subscribed.click();

			//scrolling page down
			JavascriptExecutor js = (JavascriptExecutor) driver;
			// This  will scroll down the page by  1500 pixel vertical		
			js.executeScript("window.scrollBy(0,1500)");

			//company
			WebElement elementcompany = driver.findElement(By.id("company"));
			elementcompany.clear();
			elementcompany.sendKeys("Test company");

			//telephone
			WebElement elementtelephone = driver.findElement(By.id("telephone"));
			elementtelephone.clear();
			elementtelephone.sendKeys("9876541230");

			//street_1
			WebElement elementstreet = driver.findElement(By.id("street_1"));
			elementstreet.clear();
			elementstreet.sendKeys("Test Street1");

			//city - Phoenix -
			WebElement elementcity = driver.findElement(By.id("city"));
			elementcity.clear();
			elementcity.sendKeys("Phoenix");

			//region_id -select any
			Select elementregion = new Select(driver.findElement(By.id("region_id")));
			elementregion.selectByIndex(3); 

			//zip-85001
			WebElement elementZip = driver.findElement(By.id("zip"));
			elementZip.clear();
			elementZip.sendKeys("85001");

			//password
			WebElement elementpassword = driver.findElement(By.id("password"));
			elementpassword.clear();
			elementpassword.sendKeys("");

			//confirmation
			WebElement elementconfirmation = driver.findElement(By.id("confirmation"));
			elementconfirmation.clear();
			elementconfirmation.sendKeys("Test@123#");

			//Captcha
			WebElement elementCaptcha = driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']"));
			elementCaptcha.click();
			Thread.sleep(10000);

			//submit
			WebElement elementSubmit = driver.findElement(By.xpath("//span[text()='Submit']"));
			elementSubmit.click();    

			String expectedErrorMsg = "Please enter 6 or more characters. Leading or trailing spaces will be ignored.";

			String actualErrorMsg = elementpassword.getText();

			Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
			//Please enter 6 or more characters. Leading or trailing spaces will be ignored.
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}


	// Registration without providing user phone number field
	@Test
	public void emptyPhoneTest()
	{
		try {
			LaunchBrowser();
			
			// Launch Website  
			driver.navigate().to(baseURL + "customer/account/create"); 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

			String expectedErrorMsg = "This is a required field";

			//firstname
			WebElement elementFirstname = driver.findElement(By.id("firstname"));
			elementFirstname.clear();
			elementFirstname.sendKeys("");

			//lastname
			WebElement elementLastname = driver.findElement(By.id("lastname"));
			elementLastname.clear();
			elementLastname.sendKeys("Test lastname");

			//email_address
			WebElement elementemail_address = driver.findElement(By.id("email_address"));
			elementemail_address.clear();
			elementemail_address.sendKeys("test1@mailezee.com");

			//is_subscribed
			WebElement elementIs_subscribed = driver.findElement(By.id("is_subscribed"));
			elementIs_subscribed.click();

			//scrolling page down
			JavascriptExecutor js = (JavascriptExecutor) driver;
			// This  will scroll down the page by  1500 pixel vertical		
			js.executeScript("window.scrollBy(0,1500)");

			//company
			WebElement elementcompany = driver.findElement(By.id("company"));
			elementcompany.clear();
			elementcompany.sendKeys("Test company");

			//telephone
			WebElement elementtelephone = driver.findElement(By.id("telephone"));
			elementtelephone.clear();
			elementtelephone.sendKeys("");

			//street_1
			WebElement elementstreet = driver.findElement(By.id("street_1"));
			elementstreet.clear();
			elementstreet.sendKeys("Test Street1");

			//city - Phoenix -
			WebElement elementcity = driver.findElement(By.id("city"));
			elementcity.clear();
			elementcity.sendKeys("Phoenix");

			//region_id -select any
			Select elementregion = new Select(driver.findElement(By.id("region_id")));
			elementregion.selectByIndex(3); 

			//zip-85001
			WebElement elementZip = driver.findElement(By.id("zip"));
			elementZip.clear();
			elementZip.sendKeys("85001");

			//password
			WebElement elementpassword = driver.findElement(By.id("password"));
			elementpassword.clear();
			elementpassword.sendKeys("Test@123#");

			//confirmation
			WebElement elementconfirmation = driver.findElement(By.id("confirmation"));
			elementconfirmation.clear();
			elementconfirmation.sendKeys("Test@123#");

			//Captcha
			WebElement elementCaptcha = driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']"));
			elementCaptcha.click();
			Thread.sleep(10000);

			//submit
			WebElement elementSubmit = driver.findElement(By.xpath("//span[text()='Submit']"));
			elementSubmit.click();                   

			String actualErrorMsg = elementtelephone.getText();

			Assert.assertEquals(actualErrorMsg, expectedErrorMsg);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	// Registration with providing invalid user phone number field
	@Test
	public void emptyZipTest()
	{
		try {

			LaunchBrowser();
			
			// Launch Website  
			driver.navigate().to(baseURL + "customer/account/create"); 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			
			String expectedErrorMsg = "This is a required field";

			//firstname
			WebElement elementFirstname = driver.findElement(By.id("firstname"));
			elementFirstname.clear();
			elementFirstname.sendKeys("Test firstname");

			//lastname
			WebElement elementLastname = driver.findElement(By.id("lastname"));
			elementLastname.clear();
			elementLastname.sendKeys("Test lastname");

			//email_address
			WebElement elementemail_address = driver.findElement(By.id("email_address"));
			elementemail_address.clear();
			elementemail_address.sendKeys("test1@mailezee.com");

			//is_subscribed
			WebElement elementIs_subscribed = driver.findElement(By.id("is_subscribed"));
			elementIs_subscribed.click();

			//scrolling page down
			JavascriptExecutor js = (JavascriptExecutor) driver;
			// This  will scroll down the page by  1500 pixel vertical		
			js.executeScript("window.scrollBy(0,1500)");

			//company
			WebElement elementcompany = driver.findElement(By.id("company"));
			elementcompany.clear();
			elementcompany.sendKeys("Test company");

			//telephone
			WebElement elementtelephone = driver.findElement(By.id("telephone"));
			elementtelephone.clear();
			elementtelephone.sendKeys("9876541230");

			//street_1
			WebElement elementstreet = driver.findElement(By.id("street_1"));
			elementstreet.clear();
			elementstreet.sendKeys("Test Street1");

			//city - Phoenix -
			WebElement elementcity = driver.findElement(By.id("city"));
			elementcity.clear();
			elementcity.sendKeys("Phoenix");

			//region_id -select any
			Select elementregion = new Select(driver.findElement(By.id("region_id")));
			elementregion.selectByIndex(3); 

			//zip-85001
			WebElement elementZip = driver.findElement(By.id("zip"));
			elementZip.clear();
			elementZip.sendKeys("");

			//Captcha
			WebElement elementCaptcha = driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']"));
			elementCaptcha.click();
			Thread.sleep(10000);

			//password
			WebElement elementpassword = driver.findElement(By.id("password"));
			elementpassword.clear();
			elementpassword.sendKeys("Test@123#");

			//confirmation
			WebElement elementconfirmation = driver.findElement(By.id("confirmation"));
			elementconfirmation.clear();
			elementconfirmation.sendKeys("Test@123#");

			//submit
			WebElement elementSubmit = driver.findElement(By.xpath("//span[text()='Submit']"));
			elementSubmit.click();                   

			String actualErrorMsg = elementZip.getText();

			Assert.assertEquals(actualErrorMsg, expectedErrorMsg);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	// Registration without accepting terms and condition tickbox
	@Test
	public void uncheckedCaptchaTest()
	{
		try {
			LaunchBrowser();

			// Launch Website  
			driver.navigate().to(baseURL + "customer/account/create"); 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			
			String expectedErrorMsg = "This is a required field";

			//firstname
			WebElement elementFirstname = driver.findElement(By.id("firstname"));
			elementFirstname.clear();
			elementFirstname.sendKeys("");

			//lastname
			WebElement elementLastname = driver.findElement(By.id("lastname"));
			elementLastname.clear();
			elementLastname.sendKeys("Test lastname");

			//email_address
			WebElement elementemail_address = driver.findElement(By.id("email_address"));
			elementemail_address.clear();
			elementemail_address.sendKeys("test1@mailezee.com");

			//is_subscribed
			WebElement elementIs_subscribed = driver.findElement(By.id("is_subscribed"));
			elementIs_subscribed.click();

			//scrolling page down
			JavascriptExecutor js = (JavascriptExecutor) driver;
			// This  will scroll down the page by  1500 pixel vertical		
			js.executeScript("window.scrollBy(0,1500)");

			//company
			WebElement elementcompany = driver.findElement(By.id("company"));
			elementcompany.clear();
			elementcompany.sendKeys("Test company");

			//telephone
			WebElement elementtelephone = driver.findElement(By.id("telephone"));
			elementtelephone.clear();
			elementtelephone.sendKeys("9876541230");

			//street_1
			WebElement elementstreet = driver.findElement(By.id("street_1"));
			elementstreet.clear();
			elementstreet.sendKeys("Test Street1");

			//city - Phoenix -
			WebElement elementcity = driver.findElement(By.id("city"));
			elementcity.clear();
			elementcity.sendKeys("Phoenix");

			//region_id -select any
			Select elementregion = new Select(driver.findElement(By.id("region_id")));
			elementregion.selectByIndex(3); 

			//zip-85001
			WebElement elementZip = driver.findElement(By.id("zip"));
			elementZip.clear();
			elementZip.sendKeys("85001");

			//password
			WebElement elementpassword = driver.findElement(By.id("password"));
			elementpassword.clear();
			elementpassword.sendKeys("Test@123#");

			//confirmation
			WebElement elementconfirmation = driver.findElement(By.id("confirmation"));
			elementconfirmation.clear();
			elementconfirmation.sendKeys("Test@123#");

			//Captcha
			WebElement elementCaptcha = driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']"));
			//elementCaptcha.click();

			//submit
			WebElement elementSubmit = driver.findElement(By.xpath("//span[text()='Submit']"));
			elementSubmit.click();                   


			String actualErrorMsg = elementCaptcha.getText();

			Assert.assertEquals(actualErrorMsg, expectedErrorMsg);

		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	//Password and confrim password mismatch
	@Test
	// Password and Confirm Password should be matched.
	public void passwordConfirmpwdMatchingTest() {

		try {
			LaunchBrowser();

			// Launch Website  
			driver.navigate().to(baseURL + "customer/account/create"); 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			
			String expectedErrorMsg = "Please make sure your passwords match.";

			//firstname
			WebElement elementFirstname = driver.findElement(By.id("firstname"));
			elementFirstname.clear();
			elementFirstname.sendKeys("test firstname");

			//lastname
			WebElement elementLastname = driver.findElement(By.id("lastname"));
			elementLastname.clear();
			elementLastname.sendKeys("Test lastname");

			//email_address
			WebElement elementemail_address = driver.findElement(By.id("email_address"));
			elementemail_address.clear();
			elementemail_address.sendKeys("test1@mailezee.com");

			//is_subscribed
			WebElement elementIs_subscribed = driver.findElement(By.id("is_subscribed"));
			elementIs_subscribed.click();

			//scrolling page down
			JavascriptExecutor js = (JavascriptExecutor) driver;
			// This  will scroll down the page by  1500 pixel vertical		
			js.executeScript("window.scrollBy(0,1500)");

			//company
			WebElement elementcompany = driver.findElement(By.id("company"));
			elementcompany.clear();
			elementcompany.sendKeys("Test company");

			//telephone
			WebElement elementtelephone = driver.findElement(By.id("telephone"));
			elementtelephone.clear();
			elementtelephone.sendKeys("9876541230");

			//street_1
			WebElement elementstreet = driver.findElement(By.id("street_1"));
			elementstreet.clear();
			elementstreet.sendKeys("Test Street1");

			//city - Phoenix -
			WebElement elementcity = driver.findElement(By.id("city"));
			elementcity.clear();
			elementcity.sendKeys("Phoenix");

			//region_id -select any
			Select elementregion = new Select(driver.findElement(By.id("region_id")));
			elementregion.selectByIndex(3); 

			//zip-85001
			WebElement elementZip = driver.findElement(By.id("zip"));
			elementZip.clear();
			elementZip.sendKeys("85001");

			//password
			WebElement elementpassword = driver.findElement(By.id("password"));
			elementpassword.clear();
			elementpassword.sendKeys("Test@123#");

			//confirmation
			WebElement elementconfirmation = driver.findElement(By.id("confirmation"));
			elementconfirmation.clear();
			elementconfirmation.sendKeys("Test@123#1");

			//Captcha
			WebElement elementCaptcha = driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']"));
			elementCaptcha.click();
			Thread.sleep(10000);

			//submit
			WebElement elementSubmit = driver.findElement(By.xpath("//span[text()='Submit']"));
			elementSubmit.click();                   

			String actualErrorMsg = elementconfirmation.getText();

			Assert.assertEquals(actualErrorMsg, expectedErrorMsg);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*-------------------------------TESTCASE: LOGIN PAGE ----------------------------------------*/
	
	//empty Login credential
	@Test	
	public void emptyLoginTest() {
		
		try {
			String expectedErrorMsg = "This is a required field.";
			
			LaunchBrowser();
			
			// Launch Website  
			driver.navigate().to(baseURL + "customer/account/login"); 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			
			//signin username
			WebElement elementusername = driver.findElement(By.id("email"));
			elementusername.clear();
			elementusername.sendKeys(""); 

			//signin password
			WebElement elementPassword = driver.findElement(By.id("pass"));
			elementPassword.clear();
			elementPassword.sendKeys(""); 
			
			//button click SIGNIN
			WebElement elementButtonSignin = driver.findElement(By.id("send2"));	
			elementButtonSignin.click();
			
			String actualErrorMsg = elementusername.getText();

			Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	//invalidCredentials using INVALID EMAIL/USERNAME
	@Test
	public void invalidUsernameTest() {
		try {
			String expectedErrorMsg = "Please enter a valid email address. For example johndoe@domain.com.";
			
			LaunchBrowser();
			
			// Launch Website  
			driver.navigate().to(baseURL + "customer/account/login"); 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			
			//signin username
			WebElement elementusername = driver.findElement(By.id("email"));
			elementusername.clear();
			elementusername.sendKeys("test"); 

			//signin password
			WebElement elementPassword = driver.findElement(By.id("pass"));
			elementPassword.clear();
			elementPassword.sendKeys("Test@123#"); 
			
			//button click SIGNIN
			WebElement elementButtonSignin = driver.findElement(By.id("send2"));	
			elementButtonSignin.click();
			
			String actualErrorMsg = elementusername.getText();

			Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	//invalidPassword-valid username
	@Test
	public void invalidPasswordTest() {
		try {
			String expectedErrorMsg = "";
			
			LaunchBrowser();
			
			// Launch Website  
			driver.navigate().to(baseURL + "customer/account/login"); 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			
			//signin username
			WebElement elementusername = driver.findElement(By.id("email"));
			elementusername.clear();
			elementusername.sendKeys("test@mailezee.com"); 

			//signin password
			WebElement elementPassword = driver.findElement(By.id("pass"));
			elementPassword.clear();
			elementPassword.sendKeys("Test@1234567879#"); 
			
			//button click SIGNIN
			WebElement elementButtonSignin = driver.findElement(By.id("send2"));	
			elementButtonSignin.click();
			
			String actualErrorMsg = elementPassword.getText();

			Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	//Valid correct username/password
	@Test
	public void validCredentialsTest() {
		
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
			e.printStackTrace();
		}
	}


}
