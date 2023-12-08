package Assignment_Module_8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Q4_Simple_Webdriver {
	public static void main(String[] args) {
	      System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sarika Namsha\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
	      WebDriver driver = new ChromeDriver();
	      driver.manage().window().maximize();
	      System.out.println("chrome open");
	   //   driver.get(url);
	      
	      System.setProperty("webdriver.edge.driver", "C:\\Users\\Sarika Namsha\\Downloads\\edgedriver_win64 (2)\\msedgedriver.exe");
	      WebDriver driver1 = new EdgeDriver();
	      driver.manage().window().maximize();
	      System.out.println("edge open");
	//      driver.get(url);
	      
	      System.setProperty("webdriver.gecko.driver", "C:\\Users\\Sarika Namsha\\Downloads\\geckodriver-v0.33.0-win64 (1)\\geckodriver.exe");
	      WebDriver driver2 = new FirefoxDriver();
	      driver.manage().window().maximize();
	      System.out.println("firefox open");
	  //    driver.get(url);
}
}