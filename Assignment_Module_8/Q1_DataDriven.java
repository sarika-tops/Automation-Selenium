package Assignment_Module_8;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

import Excel.ExcelReader;
import util.DriverConnection;
	
public class Q1_DataDriven {
		static WebDriver driver;

		@BeforeClass
		public void openBrowser() {
			driver = new DriverConnection().getConnection();
			driver.get("https://careercenter.tops-int.com/");

		}

		@Test(dataProvider = "dp")
		public void logintest(CharSequence[] mobile, CharSequence[] password) throws InterruptedException {
			 WebElement num = driver.findElement(By.id("mobile"));
		        num.clear();
		        num.sendKeys(mobile);
		        WebElement pswd = driver.findElement(By.id("password"));
		        pswd.clear();
		        pswd.sendKeys(password);
		        Thread.sleep(2000);
		        WebElement login = driver.findElement(By.xpath("//form[@id='loginForm']/div[3]/input"));
		        login.click();	    
		}

		@DataProvider(name = "dp")
		public Object[][] data() {
			ExcelReader ex = new ExcelReader("C:\\Users\\Sarika Namsha\\Desktop\\topslogin.xlsx", "Login");
			int row = ex.rowCount();
			System.out.println("row : " + row);
			int col = ex.colCount();
			System.out.println("col : " + col);

			Object obj[][] = new Object[row - 1][col];

			for (int i = 1; i < row; i++) {
				for (int j = 0; j < col; j++) {
					String data = ex.getData(i, j);
					obj[i - 1][j] = data;
				}
			}
			return obj;
		}
	}
