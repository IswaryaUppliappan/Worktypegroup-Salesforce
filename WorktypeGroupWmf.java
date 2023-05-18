package worktypeGroup.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class WorktypeGroupWmf {

	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[contains(@class,'slds-icon-waffle')]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement drop = driver.findElement(By.xpath("//p[text()='Work Type Groups']"));
		driver.executeScript("arguments[0].click();", drop);
		driver.findElement(By.xpath("//div[@title='New']")).click();
		WebElement c = driver.findElement(By.xpath("//textarea[contains(@class,'slds-textarea')]"));
		c.sendKeys("Automation");
		WebElement f = driver.findElement(By.xpath("//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click']"));
		driver.executeScript("arguments[0].click();", f);
		WebElement d = driver.findElement(By.xpath("(//span[text()='Capacity'])[1]"));
	    driver.executeScript("arguments[0].click();", d);
	    driver.findElement(By.xpath("(//button[text()='Save'])")).click();
	    String actual_Error=driver.findElement(By.xpath("//div[contains(@class,'slds-form-element__help')]")).getText();
	    String expected_Error= "Complete this field.";
	    Assert.assertEquals(actual_Error,expected_Error);
	    Assert.assertTrue(actual_Error.contains("Complete this field."));

	}

}
