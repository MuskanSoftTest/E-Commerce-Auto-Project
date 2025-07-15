package TutorialsNinja.Register;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_006 {

	@Test
	public void verifyingNavigatingRegisterAccountWithMultipleWays() {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get("https://tutorialsninja.com/demo/");
	    
	    driver.findElement(By.xpath("(//li[@class='dropdown'])[1]")).click();
	    driver.findElement(By.xpath("(//a[normalize-space()='Register'])[1]")).click();
	    
	    Assert.assertTrue(driver.findElement(By.xpath("(//h1[normalize-space()='Register Account'])[1]")).isDisplayed());
	    driver.findElement(By.xpath("(//li[@class='dropdown'])[1]")).click();
	    driver.findElement(By.xpath("(//a[normalize-space()='Login'])[1]")).click();
	    driver.findElement(By.xpath("(//a[normalize-space()='Continue'])[1]")).click();
	    Assert.assertTrue(driver.findElement(By.xpath("(//h1[normalize-space()='Register Account'])[1]")).isDisplayed());

	    driver.findElement(By.xpath("(//li[@class='dropdown'])[1]")).click();
	    driver.findElement(By.xpath("(//a[normalize-space()='Login'])[1]")).click();
	    driver.findElement(By.xpath("(//a[@class='list-group-item'][normalize-space()='Register'])[1]")).click();
	    Assert.assertTrue(driver.findElement(By.xpath("(//h1[normalize-space()='Register Account'])[1]")).isDisplayed());

		
		driver.quit();
	
	}
	
	
}
