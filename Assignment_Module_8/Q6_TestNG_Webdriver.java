package Assignment_Module_8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Q6_TestNG_Webdriver {
	@Test (priority = 1)
	public void chromeTest () {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sarika Namsha\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    System.out.println("chrome open");
	}
	@Test (priority = 3)
	public void edgeTest() {
    System.setProperty("webdriver.edge.driver", "C:\\Users\\Sarika Namsha\\Downloads\\edgedriver_win64 (2)\\msedgedriver.exe");
    WebDriver driver1 = new EdgeDriver();
    driver1.manage().window().maximize();
    System.out.println("edge open");
	}   
	@Test (priority = 2)
	public void ffTest() {
    System.setProperty("webdriver.gecko.driver", "C:\\Users\\Sarika Namsha\\Downloads\\geckodriver-v0.33.0-win64 (1)\\geckodriver.exe");
    WebDriver driver2 = new FirefoxDriver();
    driver2.manage().window().maximize();
    System.out.println("firefox open");
//    driver.get(url);
}
}
