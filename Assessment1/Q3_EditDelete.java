package Assessment1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.DriverConnection;

// Task 1 : Write a script to click on Edit button for given name
// Task 2 : Write a Script to click on Delete button for given name

public class Q3_EditDelete {
            public static void main(String[] args) throws InterruptedException {
		    WebDriver driver = new DriverConnection().getConnection();
		    driver.get("https://demoqa.com/webtables");
		    
		    WebElement edit = driver.findElement(By.xpath("//span[@id='edit-record-1']"));
		    edit.click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//button[@class='close']/span[1]")).click();
		    WebElement delete = driver.findElement(By.xpath("//span[@id='delete-record-1']"));
		    delete.click();
			}
}
