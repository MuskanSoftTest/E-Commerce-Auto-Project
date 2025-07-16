package TutorialsNinja.Register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC_RF_007 {

	@Test
	public void verifyRegisteringAccountByProvidingMismatchPassword() {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("muskan");
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("ambardekar");
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(generateNewEmail());
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("9009899098");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("pass1234");
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("pass12345");
		
        driver.findElement(By.xpath("(//input[@value='Continue'])[1]")).click();
		
		driver.findElement(By.xpath("(//div[contains(text(),'Password confirmation does not match password!')])[1]"));
		
		driver.quit();
	
	}
	
	public static String generateNewEmail() {
		String emailWithTimeSatmp = new Date().toString().replaceAll(" ", "").replaceAll(":", "")+ "@gmail.com";
        return emailWithTimeSatmp;
	}
}
