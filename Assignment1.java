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
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class Assignment1 {
	WebDriver driver;
	@Before
	public void setUp() throws Exception  {
		System.setProperty("webdriver.chrome.driver","//.chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
		driver.manage().window().maximize(); // to maximize the window
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.SECONDS); //waiting time for window to open
	  }

	@After
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}
	
	@Test
	public void test1() throws InterruptedException, IOException {
		driver.findElement(By.className("btn")).click();
		WebElement dd = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[1]/div/div/div/[2]/div/div/div/div/div/[1]/div[1]/div[2]/div/div[1]/div/div[2]/div/select"));
		Select s1 = new Select(dd);
		s1.selectByIndex(0);
		Thread.sleep(500);
		driver.findElement(By.xpath("mobile")).click();
		driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[1]/div/div/div/[2]/div/div/div/div/div/[1]/div[1]/div[2]/div/div[1]/div/div[1]/div/input")).sendKeys("80,000");
        driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[1]/div/div/div/[2]/div/div/div/div/div/[1]/div[1]/div[2]/div/div[1]/div/div[1]/div/input")).sendKeys("10,000");
        driver.findElement(By.id("expenses")).clear();
        driver.findElement(By.id("expenses")).sendKeys("500");
        driver.findElement(By.id("homeloans")).clear();
        driver.findElement(By.id("homeloans")).sendKeys("0");
        driver.findElement(By.id("otherloans")).clear();
        driver.findElement(By.id("otherloans")).sendKeys("100");
        driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[1]/div/div/div/[2]/div/div/div/div/div/[1]/div[1]/div[2]/div/div[1]/div/div[1]/div/input")).sendKeys("0");
	    driver.findElement(By.id("credit")).clear();
		driver.findElement(By.id("credit")).sendKeys("10000");
		driver.findElement(By.id("btnBorrowCalculator")).click();
		String msg = driver.findElement(By.id("borrowResultTextAmount")).getText();//returns the visible text present between the start and end tags
		String msg1 = "479,000";
		Assert.assertEquals(msg, msg1);
		System.out.println("Estimated amount is : +msg");
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile,new File(".//screenshot/screen.png"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("start-over")).click();
		}
	
@Test
  public void test2() throws InterruptedException, IOException {
	 driver.findElement(By.id("expences")).clear();
	 driver.findElement(By.id("expences")).sendKeys("1");
	 Thread.sleep(500);
	 driver.findElement(By.id("btnBorrowCalculator")).click();
	 Thread.sleep(500);
	 File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	 FileUtils.copyFile(screenshotFile,new File(".//screenshot/screen.png1"));
	 String msg1 = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[1]/div/div/div[2]/div/div/div/div/div[1]/div[2]/div[2]/div/div")).getText();
	 String msg2= "Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500";
	 Assert.assertEquals(msg1, msg2);
	 Thread.sleep(1000);
		}
	
}
     


   
 