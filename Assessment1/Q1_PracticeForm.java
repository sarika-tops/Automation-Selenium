package Assessment1;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

// Task 1 : Write script to fill this form using selenium webdriver https://demoqa.com/automation-practice-form
// Task 2 : Write script to take screenshot of filled form

public class Q1_PracticeForm {
	        public static void getScreenshot(WebDriver driver, String path) {
			          TakesScreenshot ss = (TakesScreenshot)driver;
		  	          File source = ss.getScreenshotAs(OutputType.FILE);
		  	          File dest = new File(path);
		  	          try {
							    FileUtils.copyFile(source, dest);
							    System.out.println("ss taken");
						} catch (Exception e) {
							    e.printStackTrace();
						}
	        }
	        public static void main(String[] args) throws InterruptedException {
	    		WebDriver driver = new util.DriverConnection().getConnection();
	    		driver.get("https://demoqa.com/automation-practice-form");

	    		driver.findElement(By.id("firstName")).sendKeys("Sara");
	    		driver.findElement(By.id("lastName")).sendKeys("Namsha");
	    		driver.findElement(By.id("userEmail")).sendKeys("Snamsha@gmail.com");
	    		driver.findElement(By.xpath("//label[text() ='Female']")).click();
	    		driver.findElement(By.id("userNumber")).sendKeys("7485914258");

	    		WebElement datepick = driver.findElement(By.id("dateOfBirthInput"));
	    		datepick.click();
	    		Thread.sleep(2000);

	    		WebElement years = driver.findElement(By.className("react-datepicker__year-select"));
	    		Select year = new Select(years);
	    		year.selectByVisibleText("1997");

	    		WebElement months = driver.findElement(By.className("react-datepicker__month-select"));
	    		Select month = new Select(months);
	    		month.selectByIndex(4);

	    		WebElement date = driver.findElement(By.xpath("//div[@class='react-datepicker__month']/div[2]/div[1]"));
	    		date.click();

	    		Thread.sleep(2000);
	    		JavascriptExecutor js = (JavascriptExecutor) driver;
	    		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	    		Thread.sleep(2000);
	    		
	    		WebElement sub = driver.findElement(By.xpath("//div[@id='subjectsWrapper']/div[2]/div/div/div[1]"));
	    		Actions action = new Actions(driver);
	    		action.click(sub)
	    				.sendKeys("English")
	    				.sendKeys(Keys.ARROW_DOWN)
	    				.sendKeys(Keys.ENTER)
	    				.pause(Duration.ofSeconds(2))
	    				.sendKeys("Hindi")
	    				.sendKeys(Keys.ARROW_DOWN)
	    				.sendKeys(Keys.ENTER)
	    				.build().perform();
	    				
	    		WebElement hobbies = driver.findElement(By.xpath("//*[@id='hobbiesWrapper']/div[2]/div[1]/label"));
	    		hobbies.click();

	    		WebElement btn = driver.findElement(By.id("uploadPicture"));
	    		btn.sendKeys("C:\\Users\\Sarika Namsha\\Downloads\\pexels-brett-sayles-1322185.jpg");
	    		Thread.sleep(2000);
	    		
	    		driver.findElement(By.id("currentAddress")).sendKeys("Ahmedabad");
	    		Thread.sleep(2000);
	    		getScreenshot(driver, "C:\\Screenshot\\pf.png");
//	    		WebElement state = driver.findElement(By.xpath("//div[@id='state']/div/div[2]/div"));
//	    		Actions action1 = new Actions(driver);
//	    		action1.click(state).pause(Duration.ofSeconds(2)).sendKeys("Rajasthan").sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

	    	}
			}

