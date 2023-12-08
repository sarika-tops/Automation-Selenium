package Assessment1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Excel.ExcelReader;
import util.DriverConnection;

// Task 1 : verify that test pass or fail
// Task 2 : Parameterised your script using testing and take input from excel sheet
// Task 3 : Take screenshot for Failed test cases

public class Q4_LoginTestCase {
	WebDriver driver;

	@BeforeClass
	public void openBrowser() {
		driver = new DriverConnection().getConnection();
		driver.get("https://demo.guru99.com/v4/index.php");
	}
	
	public static void getSreenShot(WebDriver driver,String path) throws InterruptedException {
		TakesScreenshot ss = (TakesScreenshot)driver;		
		File source = ss.getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		try {
			FileUtils.copyFile(source, dest);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "dp")
	public void logintest(String UserId, String Password) throws InterruptedException {
		System.out.println(UserId + " " + Password);
		WebElement username = driver.findElement(By.name("uid"));
		username.clear();
		username.sendKeys(UserId);
		Thread.sleep(2000);
		WebElement password = driver.findElement(By.name("password"));
		password.clear();
		password.sendKeys(Password);
		Thread.sleep(2000);
		WebElement login = driver.findElement(By.name("btnLogin"));
		getSreenShot(driver, "C:\\Screenshot\\mysse1.png");
		System.out.println("ss done");
		login.click();
//		getSreenShot(driver, "C:\\Screenshot\\mysse1.png");
//		System.out.println("ss done");
	}
	
	@DataProvider(name = "dp")
    public static Object[][] data(){
    	ExcelReader ex = new ExcelReader("C:\\Users\\Sarika Namsha\\Desktop\\AssessmentTask.xlsx", "Login");
    	int row = ex.rowCount();
    	System.out.println(row);
    	int col = ex.colCount();
    	System.out.println(col);
    	Object o[][] = new Object[row-1][col];
    	
    	for(int i=1; i<row; i++) {
    		for(int j=0; j<col; j++) {
    			String data = ex.getData(i, j);
    			o[i-1][j] = data;
    		}
    	}
    	return o;
    }
}
