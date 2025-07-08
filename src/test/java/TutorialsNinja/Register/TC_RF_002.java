package TutorialsNinja.Register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_002 {

	@Test
	public void verifyRegisterWithAllFields() {
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
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("pass1234");
		driver.findElement(By.xpath("(//input[@name='newsletter'])[1]")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("(//a[normalize-space()='Success'])[1]")).isDisplayed());
		
		String expectedProperDetailsOne = "Your Account Has Been Created!";
				
		String expectedProperDetailsTwo	= "Congratulations! Your new account has been successfully created!";

		String expectedProperDetailsThree = "You can now take advantage of member privileges to enhance your online shopping experience with us.";

		String expectedProperDetailsFour ="If you have ANY questions about the operation of this online shop, please e-mail the store owner.";

		String expectedProperDetailsFive ="A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please";
	
		String expectedProperDetailsSix = "contact us.";
		
		String actualProperDetails = driver.findElement(By.xpath("(//div[@id='content'])[1]")).getText();
		
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsOne));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsTwo));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsThree));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsFour));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsFive));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsSix));
		
        driver.findElement(By.linkText("Continue")).click();		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
		driver.close();
	
	}
	
	public static String generateNewEmail() {
		String emailWithTimeSatmp = new Date().toString().replaceAll(" ", "").replaceAll(":", "")+ "@gmail.com";
        return emailWithTimeSatmp;
	}
}
