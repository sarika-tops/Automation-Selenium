package Assignment_Module_8;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

import Excel.ExcelReader;
import util.DriverConnection;

public class Q2_KeywordDriven {
		static WebDriver driver;

		@BeforeClass
		public void openBrowser() {
			driver = new DriverConnection().getConnection();
			driver.get("https://www.browserstack.com/users/sign_in");

		}

		@Test(dataProvider = "dp")
		public void logintest(String Email, String pass) throws InterruptedException {
			String email = String.valueOf(Email);
			String pas = String.valueOf(pass);
			System.out.println(email + " " + pass);
			WebElement emailid = driver.findElement(By.xpath("//input[@id='user_email_login']"));
			emailid.clear();
			emailid.sendKeys(Email);
			
			WebElement password = driver.findElement(By.xpath("//input[@id='user_password']"));
			password.clear();
			password.sendKeys(pas);
			System.out.println("Pass no entered");
			Thread.sleep(2000);
			
			WebElement LoginIn = driver.findElement(By.xpath("(//*[@id=\"signin_signup_form\"]/div[1]/div/div[1]/fieldset/div[9]/a)"));
			LoginIn.click();
			System.out.println("Login clicked");
			Thread.sleep(2000);
			
			WebElement MailId = driver.findElement(By.name("identifier"));
			MailId.sendKeys("pradhika438@gmail.com");
			System.out.println("Mailid entered");
			
			
			WebElement Next = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span"));
			Next.click();
			System.out.println("Next Button clicked");
			

			WebElement Signout_Menu = driver.findElement(By.id("account-menu-toggle"));
			Signout_Menu.click();
			System.out.println("Signout menue clicked");

			WebElement Signout_But = driver.findElement(By.id("sign_out_link"));
			Signout_But.click();
			System.out.println("Signout Button clicked");
		}

		@DataProvider(name = "dp")
		public Object[][] data() {
			ExcelReader ex = new ExcelReader("C:\\Users\\Sarika Namsha\\Desktop\\topslogin.xlsx", "Keyword");
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