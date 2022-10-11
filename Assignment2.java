package demo1;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class Assignment2 {
	WebDriver driver;
	@Before
	public void SetUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","//.chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
	}
	
	@After
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
	
	}
	
	@Test(priority=0)
	public void test() throws InterruptedException, IOException {
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
		driver.findElement(By.id("email_create")).sendKeys("ashutosh1@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span")).click();
		driver.findElement(By.id("id_gender1")).click();
		driver.findElement(By.id("customer_firstname")).sendKeys("Ashutosh");
		driver.findElement(By.id("customer_lastname")).sendKeys("choubey");
		driver.findElement(By.id("passwd")).sendKeys("choubey420");
		Thread.sleep(500);
		WebElement day=driver.findElement(By.id("days"));
		Select s1 = new Select(day);
		s1.selectByValue("1");
		Thread.sleep(500);
		WebElement mon=driver.findElement(By.id("months"));
		Select s2 = new Select(mon);
		s2.selectByIndex(1);
		Thread.sleep(500);
		WebElement year=driver.findElement(By.id("years"));
		Select s3 = new Select(year);
		s3.selectByIndex(10);
		Thread.sleep(500);
		driver.findElement(By.id("newsletter")).click();
		driver.findElement(By.id("optin")).click();
		driver.findElement(By.id("firstname")).clear();
		driver.findElement(By.id("firstname")).sendKeys("Ashutosh");
		driver.findElement(By.id("lastname")).clear();
		driver.findElement(By.id("lastname")).sendKeys("choubey");
		driver.findElement(By.id("company")).sendKeys("Infosys");
		driver.findElement(By.id("address")).sendKeys("350, hebbal,electronics city,mysore,karnataka,570027");
		driver.findElement(By.id("city")).sendKeys("Mysore");
		WebElement city=driver.findElement(By.id("id_state"));
		Select s4 = new Select(city);
		s4.selectByIndex(2);
		Thread.sleep(500);
		driver.findElement(By.id("postcode")).sendKeys("46120");
		Thread.sleep(500);
		WebElement country=driver.findElement(By.id("id_country"));
		Select s5 = new Select(country);
		s5.selectByIndex(1);
		driver.findElement(By.id("other")).sendKeys("Good");
		driver.findElement(By.id("phone_mobile")).sendKeys("7677733383");
		driver.findElement(By.id("submitAccount")).click();
		String actualMsg = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span")).getText();
		String expectedMsg = "Ashutosh choubey";
		Assert.assertEquals(actualMsg, expectedMsg);
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile,new File(".//screenshot/screen.png2"));
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")).click();

	}
		
		@Test(priority=1)
		public void test2() throws InterruptedException, IOException {
			driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).clear();
			driver.findElement(By.id("email")).sendKeys("ashutosh1@gmail.com");
			driver.findElement(By.id("passwd")).sendKeys("choubey420");
			driver.findElement(By.id("submitLogin")).click();
			driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a")).click();
			Actions act = new Actions(driver);
			WebElement ho = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img"));
			act.moveToElement(ho).perform();
			driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]/span")).click();
			driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")).click();
			driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span")).click();
			driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button/span")).click();
			driver.findElement(By.id("cgv")).click();
			driver.findElement(By.xpath("//*[@id=\"form\"]/p/button/span")).click();
			Thread.sleep(500);
			String truevalue = driver.findElement(By.xpath("//*[@id=\"product_1_1_0_754114\"]/td[2]/p/a")).getText();
			String expectedvalue = "Faded Short Sleeve T-shirts";
			Assert.assertEquals(truevalue, expectedvalue);
			Thread.sleep(500);
			driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a/span")).click();
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile,new File(".//screenshot/screen.png3");
			driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")).click();
			Thread.sleep(500);
		
		
	}
}
