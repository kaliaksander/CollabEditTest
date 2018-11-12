package tests;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CollabEditTest  {

	  WebDriver  driver;
		
		@Test
		public void countOfRows() {
			//Change context
			driver.switchTo().defaultContent();
			WebElement frame = driver.findElement(By.id("frame_the_input"));
			driver.switchTo().frame(frame);
			String elem = driver.findElement(By.xpath("//*[@id=\"content_highlight\"]/span[1]")).getText();
			
			String[] elemSplitted = elem.split("\\n");
			int count = 0;
	        for(String a : elemSplitted) {
		        if (!a.isEmpty()) {
		            count++;		        
		      }
			}
	        System.out.println(count);
		}
		
		@BeforeMethod
		public void setUp() {
			driver  = utilities.DriverFactory.open("chrome");
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
			String webURL =  "http://collabedit.com/j6xhj";//"http://sdettraining.com/trguitransactions/AccountManagement.aspx";
			driver.get(webURL);
			//Make alert to be dissmissed
			driver.switchTo().alert().dismiss();
		}
		
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
  }






