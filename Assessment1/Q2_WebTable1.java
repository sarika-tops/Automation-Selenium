package Assessment1;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.DriverConnection;

// Task 1 : Verify that there are only 4 structure values present in the table with Selenium

public class Q2_WebTable1 {
            public static void main(String[] args) {
			WebDriver driver = new DriverConnection().getConnection();
			driver.get("https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html");
			List <WebElement> rowss = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/thead/tr/th"));
			System.out.println("Task 1 : Verify that there are only 4 structure values present in the table with Selenium");
			System.out.println("Total rows : " +rowss.size());
			List <WebElement> colData = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody"));
		    for (WebElement s : colData) {
		    	String str = s.getText();
		    	System.out.println("Structure values are : " +(str));
		    	System.out.println(" ");
		    }
		    
// Task 2 : Verify that the 6th row of the table (Last Row) has only two columns with Selenium	
			
			WebElement lr = driver.findElement(By.xpath("//div[@id='post-body-1325137018292710854']/div[1]/div[1]/div[5]/table/tfoot/tr"));
			System.out.println("Task 2 : Verify that the 6th row of the table (Last Row) has only two columns with Selenium");
			System.out.println("6th row of the table has only " +lr.getSize()+ "columns");
			System.out.println(lr.getText());
			System.out.println(" ");
		    
// Task 3 : Find the tallest structure in the table with Selenium
			
		    List <WebElement> rows = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody/tr"));
			int tallestHeight = 0;
		    String tallestStructure = " ";
		for(WebElement row : rows) {
			WebElement heightele = row.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody/tr/td[3]"));
			int height = Integer.parseInt(heightele.getText().replace("m", ""));
			if(height > tallestHeight) {
				tallestHeight = height;
				tallestStructure = driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody/tr/th[1]")).getText();
			}
			}		  
				System.out.println("Task 3 : Find the tallest structure in the table with Selenium");
		    	System.out.println("The tallest structure is : " + tallestStructure + " with a height of " +tallestHeight + "m");
		    	
			}
}
