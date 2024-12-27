package cloudinspot.cloudinspotfunctionalautomation;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest {
	WebDriver driver;

	@BeforeMethod
	public void start() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@Test(priority = 1)
	public void emptySignIn() throws Exception {

		Properties props = new Properties();
		props.load(new FileInputStream("config.properties"));
		String qaurl = props.getProperty("qaurl");
		Thread.sleep(5000);
		driver.get(qaurl);
		driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
		Thread.sleep(10000);
	}

	@Test(priority = 2)
	public void invalidOrgId1SignInTest() throws Exception {
		Properties props = new Properties();
		props.load(new FileInputStream("config.properties"));
		String qaurl = props.getProperty("qaurl");
		String invalidorgid = props.getProperty("invalidorgid");
		String signinemail = props.getProperty("signinemail");
		String password = props.getProperty("password");
		Thread.sleep(5000);
		driver.get(qaurl);
		driver.findElement(By.xpath("//input[@id='org_id']")).sendKeys(invalidorgid);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(signinemail);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//img[@aria-label='Show Password']")).click();

		driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
		Thread.sleep(10000);
	}

	@Test(priority = 3)
	public void emptyOrgId2SignInTest() throws Exception {
		Properties props = new Properties();
		props.load(new FileInputStream("config.properties"));
		String qaurl = props.getProperty("qaurl");
		String invalidorgid = props.getProperty("invalidorgid");
		String signinemail = props.getProperty("signinemail");
		String password = props.getProperty("password");
		Thread.sleep(5000);
		driver.get(qaurl);
		driver.findElement(By.xpath("//input[@id='org_id']")).sendKeys("      ");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(signinemail);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//img[@aria-label='Show Password']")).click();

		driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
		Thread.sleep(10000);
	}

	@Test(priority = 4)
	public void invalidemailwithouat1() throws Exception {
		Properties props = new Properties();
		props.load(new FileInputStream("config.properties"));
		String qaurl = props.getProperty("qaurl");
		String orgid = props.getProperty("orgid");
		String password = props.getProperty("password");
		String invalidemailwithouat = props.getProperty("invalidemailwithouat");
		driver.get(qaurl);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='org_id']")).sendKeys(orgid);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(invalidemailwithouat);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//img[@aria-label='Show Password']")).click();

		driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
		Thread.sleep(10000);
	}

	@Test(priority = 5)
	public void invalidemailwithouatdot() throws Exception {
		Properties props = new Properties();
		props.load(new FileInputStream("config.properties"));
		String qaurl = props.getProperty("qaurl");
		String orgid = props.getProperty("orgid");
		String password = props.getProperty("password");
		String invalidemailwithouatdot = props.getProperty("invalidemailwithouatdot");
		driver.get(qaurl);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='org_id']")).sendKeys(orgid);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(invalidemailwithouatdot);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//img[@aria-label='Show Password']")).click();

		driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
		Thread.sleep(10000);
	}

	@Test(priority = 6)
	public void invalidemailwithouatdotat() throws Exception {
		Properties props = new Properties();
		props.load(new FileInputStream("config.properties"));
		String qaurl = props.getProperty("qaurl");
		String orgid = props.getProperty("orgid");
		String invalidemailwithouatdotat = props.getProperty("invalidemailwithouatdotat");
		String password = props.getProperty("password");
		driver.get(qaurl);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='org_id']")).sendKeys(orgid);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(invalidemailwithouatdotat);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//img[@aria-label='Show Password']")).click();

		driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
		Thread.sleep(10000);
	}

	@Test(priority = 7)
	public void emptyEmail1SignInTest() throws Exception {

		Properties props = new Properties();
		props.load(new FileInputStream("config.properties"));
		String qaurl = props.getProperty("qaurl");
		String orgid = props.getProperty("orgid");
		String password = props.getProperty("password");
		driver.get(qaurl);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='org_id']")).sendKeys(orgid);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("     ");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//img[@aria-label='Show Password']")).click();

		driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
		Thread.sleep(10000);
	}

	@Test(priority = 8)
	public void emptyPasswordSignInTest() throws Exception {

		Properties props = new Properties();
		props.load(new FileInputStream("config.properties"));
		String qaurl = props.getProperty("qaurl");
		String orgid = props.getProperty("orgid");
		String signinemail = props.getProperty("signinemail");
		String password = props.getProperty("password");
		driver.get(qaurl);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='org_id']")).sendKeys(orgid);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(signinemail);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//img[@aria-label='Show Password']")).click();

		driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
		Thread.sleep(10000);
	}

	@Test(priority = 9)
	public void invalidPassword1SignInTest() throws Exception {
		Properties props = new Properties();
		props.load(new FileInputStream("config.properties"));
		String qaurl = props.getProperty("qaurl");
		String orgid = props.getProperty("orgid");
		String signinemail = props.getProperty("signinemail");
		String invalidpassword = props.getProperty("invalidpassword");
		driver.get(qaurl);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='org_id']")).sendKeys(orgid);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(signinemail);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(invalidpassword);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//img[@aria-label='Show Password']")).click();

		driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
		Thread.sleep(10000);
	}

	@Test(priority = 10)
	public void validSignInTest() throws Exception {
		Properties props = new Properties();
		props.load(new FileInputStream("config.properties"));
		String qaurl = props.getProperty("qaurl");
		String orgid = props.getProperty("orgid");
		String signinemail = props.getProperty("signinemail");
		String password = props.getProperty("password");
		driver.get(qaurl);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='org_id']")).sendKeys(orgid);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(signinemail);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//img[@aria-label='Show Password']")).click();

		driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();

		Thread.sleep(15000);
		driver.findElement(By.xpath("//div[@class='arrow-icon']//*[name()='svg']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//div[@class='sub-menu-card__sign-out']")).click();
		Thread.sleep(10000);

	}

	@Test(priority = 11)
	public void termsOfUse() throws Exception {
		Properties props = new Properties();
		props.load(new FileInputStream("config.properties"));
		String qaurl = props.getProperty("qaurl");
		driver.get(qaurl);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[normalize-space()='Terms of Use']")).click();
		// Scroll to the bottom of the page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

		// Optionally, wait for some time to observe the scroll
		Thread.sleep(10000); // Adjust the time as necessary

	}

	@Test(priority = 12)
	public void MyProfile() throws Exception {
		Properties props = new Properties();
		props.load(new FileInputStream("config.properties"));
		String qaurl = props.getProperty("qaurl");
		String orgid = props.getProperty("orgid");
		String signinemail = props.getProperty("signinemail");
		String password = props.getProperty("password");
		Thread.sleep(10000);
		driver.get(qaurl);

		driver.findElement(By.xpath("//input[@id='org_id']")).sendKeys(orgid);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(signinemail);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//img[@aria-label='Show Password']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
		Thread.sleep(20000);

		driver.findElement(By.xpath("//div[@class='profileWrapper']//*[name()='svg']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='My Profile']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@class='my-profile__main__user-data__edit-button apply-loader']"))
				.click();
		Thread.sleep(5000);

		WebElement firstname = driver.findElement(By.xpath("//input[@id='firstName']"));

		WebElement lastname = driver.findElement(By.xpath("//input[@id='lastName']"));

		WebElement jobTitle = driver.findElement(By.xpath("//input[@id='jobTitle']"));

		Actions a = new Actions(driver);
		a.moveToElement(firstname).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
		a.moveToElement(lastname).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
		a.moveToElement(jobTitle).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
		Thread.sleep(5000);
		firstname.sendKeys("Nikhilesh");
		lastname.sendKeys("Nikhilesh");
		jobTitle.sendKeys("Nikhilesh");

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='OKAY']")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//button[@class='my-profile__main__user-data__edit-button apply-loader']"))
				.click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//button[normalize-space()='Cancel']")).click();
		driver.findElement(By.xpath("//div[@class='profileWrapper']//*[name()='svg']")).click();
		driver.findElement(By.xpath("//div[@class='sub-menu-card__sign-out']")).click();

		Thread.sleep(5000);

	}

	@Test(priority = 13)
	public void uploadProfilePic() throws Exception {
		Properties props = new Properties();
		props.load(new FileInputStream("config.properties"));
		String qaurl = props.getProperty("qaurl");
		String orgid = props.getProperty("orgid");
		String signinemail = props.getProperty("signinemail");
		String password = props.getProperty("password");
		Thread.sleep(10000);
		driver.get(qaurl);

		driver.findElement(By.xpath("//input[@id='org_id']")).sendKeys(orgid);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(signinemail);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//img[@aria-label='Show Password']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
		Thread.sleep(20000);

		driver.findElement(By.xpath("//div[contains(@class,'arrow-icon')]//*[name()='svg']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='My Profile']")).click();

		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[contains(@class,'cursor-pointer')]")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//button[normalize-space()='Upload']")).click();
		Thread.sleep(5000);

		// 1. Copy the path
		// 2. CTRL+ V
		// 3. Press Enter

		Robot rb = new Robot();
		rb.delay(10000);

		// put file fath in a clipboard
		StringSelection ss = new StringSelection("C:\\Users\\Admin\\Downloads\\cis-logo.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		// CTRIL+V
		rb.keyPress(KeyEvent.VK_CONTROL);// PRESS ON CTRL KEY
		rb.keyPress(KeyEvent.VK_V);// PRESS ON V KEY
		rb.delay(10000);

		rb.keyRelease(KeyEvent.VK_CONTROL);// RELEASE
		rb.keyRelease(KeyEvent.VK_V);
		rb.delay(10000);

		// ENTER
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		rb.delay(30000);
		driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
		Thread.sleep(10000);

	}
	
	@Test(priority = 14)
	public void removeProfilePic() throws Exception {
		Properties props = new Properties();
		props.load(new FileInputStream("config.properties"));
		String qaurl = props.getProperty("qaurl");
		String orgid = props.getProperty("orgid");
		String signinemail = props.getProperty("signinemail");
		String password = props.getProperty("password");
		Thread.sleep(10000);
		driver.get(qaurl);

		driver.findElement(By.xpath("//input[@id='org_id']")).sendKeys(orgid);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(signinemail);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//img[@aria-label='Show Password']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
		Thread.sleep(20000);

		driver.findElement(By.xpath("//div[contains(@class,'arrow-icon')]//*[name()='svg']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='My Profile']")).click();

		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[contains(@class,'cursor-pointer')]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//*[name()='svg'][@class='cursor-pointer icon '])[1]")).click();
		Thread.sleep(10000);		
	}
	

	@AfterMethod
	public void end() {
		driver.close();
	}

}
