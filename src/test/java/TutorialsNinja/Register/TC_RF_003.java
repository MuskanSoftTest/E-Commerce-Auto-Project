package TutorialsNinja.Register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_003 {

	@Test
	public void verifyRegisterMyAccountWithoutFillFields() {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String expectedFirstNameWarning = "First Name must be between 1 and 32 characters!";
		String expectedLastNameWarning = "Last Name must be between 1 and 32 characters!";
		String expectedEmailWarning = "E-Mail Address does not appear to be valid!";
		String expectedTelephoneNoWarning = "Telephone must be between 3 and 32 characters!";
		String expectedPasswordWarning = "Password must be between 4 and 20 characters!";
		String expectedPrivacyPolicyWarning = "Warning: You must agree to the Privacy Policy!";
		
		Assert.assertEquals(driver.findElement(By.xpath("(//div[contains(text(),'First Name must be between 1 and 32 characters!')])[1]")).getText(), expectedFirstNameWarning);
		Assert.assertEquals(driver.findElement(By.xpath("(//div[contains(text(),'Last Name must be between 1 and 32 characters!')])[1]")).getText(), expectedLastNameWarning);
		Assert.assertEquals(driver.findElement(By.xpath("(//div[contains(text(),'E-Mail Address does not appear to be valid!')])[1]")).getText(), expectedEmailWarning);
		Assert.assertEquals(driver.findElement(By.xpath("(//div[contains(text(),'Telephone must be between 3 and 32 characters!')])[1]")).getText(), expectedTelephoneNoWarning);
		Assert.assertEquals(driver.findElement(By.xpath("(//div[contains(text(),'Password must be between 4 and 20 characters!')])[1]")).getText(), expectedPasswordWarning);
		Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='alert alert-danger alert-dismissible'])[1]")).getText(), expectedPrivacyPolicyWarning);
		
		driver.quit();
		
		
		

	}

}
