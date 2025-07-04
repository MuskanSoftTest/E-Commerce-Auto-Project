package TutorialsNinja.Register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_001 {

	@Test
	public void verifyRegisterMandatoryFields() {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("muskan");
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("ambardekar");
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(generateNewEmail());
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("9009899098");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("pass1234");
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("pass1234");
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		
		String expectedHeading = "Your Account Has Been Created!";
		Assert.assertEquals(driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText(), expectedHeading);
		
		String actualProperDeatilOne = "Congratulations! Your new account has been successfully created!";
		String actualProperDeatilTwo = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String actualProperDeatilThree = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String actualProperDeatilFive = "contact us";
		
		String expectedProperDetails = driver.findElement(By.id("content")).getText();
		
		Assert.assertTrue(expectedProperDetails.contains(actualProperDeatilOne));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDeatilTwo));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDeatilThree));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDeatilFive));

		driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		driver.close();
	}
	
	public static String generateNewEmail() {
		String emailWithTimeSatmp = new Date().toString().replaceAll(" ", "").replaceAll(":", "")+ "@gmail.com";
        return emailWithTimeSatmp;
	}

}
