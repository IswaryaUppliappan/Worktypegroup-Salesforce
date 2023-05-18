package worktypeGroup.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class WorktypeGroupDelete {

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
		WebElement y = driver.findElement(By.xpath("//input[@name='WorkTypeGroup-search-input']"));
		y.clear();
		y.sendKeys("Salesforce Automation by Iswarya");
		Thread.sleep(3000);
		WebElement g = driver.findElement(By.xpath("//div[@class='forceVirtualActionMarker forceVirtualAction']"));
		driver.executeScript("arguments[0].click();", g);
		WebElement o = driver.findElement(By.xpath("//div[@title='Delete']"));
		driver.executeScript("arguments[0].click();", o);
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		driver.findElement(By.xpath("//input[@name='WorkTypeGroup-search-input']")).sendKeys("Salesforce Automation by Iswarya");
        String actual_Result=driver.findElement(By.xpath("//div[@class='emptyContentInner slds-text-align_center']")).getText();
		String expected_Result="No items to display.";
		Assert.assertEquals(actual_Result,expected_Result);
	}

}
