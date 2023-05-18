package worktypeGroup.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class WorktypeGroupEdit {

	public static void main(String[] args) throws InterruptedException {
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
		driver.findElement(By.xpath("//input[@name='WorkTypeGroup-search-input']")).sendKeys("Salesforce Automation by Iswarya");
		Thread.sleep(3000);
		WebElement g = driver.findElement(By.xpath("(//div[@class='forceVirtualActionMarker forceVirtualAction'])[2]"));
		driver.executeScript("arguments[0].click();", g);
		 WebElement o = driver.findElement(By.xpath("//div[@title='Edit']"));
			driver.executeScript("arguments[0].click();", o);
		WebElement c = driver.findElement(By.xpath("//textarea[contains(@class,'slds-textarea')]"));
		c.sendKeys("Automation");
		WebElement f = driver.findElement(By.xpath("//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click']"));
		driver.executeScript("arguments[0].click();", f);
		WebElement d = driver.findElement(By.xpath("(//span[text()='Capacity'])[1]"));
	    driver.executeScript("arguments[0].click();", d);
	    driver.findElement(By.xpath("(//button[text()='Save'])")).click();
	    WebElement s = driver.findElement(By.xpath("(//a[text()='Salesforce Automation by Iswarya'])[1]"));
	    driver.executeScript("arguments[0].click();", s);
	    String actual_Result=driver.findElement(By.xpath("(//span[contains(@class,'test-id__field-value slds-form-element__static slds-grow word-break-ie11')])[2]")).getText();
        String  expected_Result= "Automation";
        Assert.assertEquals(actual_Result,expected_Result);
	  
		
	}

}
