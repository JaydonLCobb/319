package newpackage;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class HW4 {
	static WebDriver driver;
	
	static String pathChromeDriver="C:\\chromedriver.exe";
	static String pathLoginPage="C:\\Users\\caydn\\Documents\\319hw\\validation.html";
	
	String txtFirstName="txtFirstName";
	String txtLastName="txtLastName";
	String selectGender="selectGender";
	String selectState="selectState";
	String txtEmail = "txtEmail";
	String txtPhone = "txtPhone";
	String txtAddress = "txtAddress";
	String txtFinalResult = "labelNotifytxtFinalResult";
	String btnValidate="btnValidate";
	

	@BeforeClass
	public static void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", pathChromeDriver);
		driver= new ChromeDriver() ;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@AfterClass
	public static void closeBrowser() {
		driver.quit();
	}
	
	@Test
	public void loginSuccessTest() throws InterruptedException {
		driver.get(pathLoginPage);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='"+txtFirstName+"']")).sendKeys("coms319");
		driver.findElement(By.xpath("//input[@id='"+txtLastName+"']")).sendKeys("lab10");
		//drop down
		Select selectGender = new Select(driver.findElement(By.name("selectGender")));
		selectGender.selectByVisibleText("Male");
		
		Select selectState = new Select(driver.findElement(By.name("selectState")));
		selectState.selectByVisibleText("Iowa");
		
		// normal
		driver.findElement(By.xpath("//input[@id='"+txtEmail+"']")).sendKeys("jcobb@iastate.edu");
		driver.findElement(By.xpath("//input[@id='"+txtPhone+"']")).sendKeys("123-456-7890");
		driver.findElement(By.xpath("//input[@id='"+txtAddress+"']")).sendKeys("Ames,Ia");


		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='"+btnValidate+"']")).click();

		String strMessage=driver.findElement(By.xpath("//label[@id='"+txtFinalResult+"']")).getText();
		assertEquals(strMessage, "OK");
	}

	@Test
	public void loginFailedTest() throws InterruptedException {
		driver.get(pathLoginPage);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='"+txtFirstName+"']")).sendKeys("coms319");
		driver.findElement(By.xpath("//input[@id='"+txtLastName+"']")).sendKeys("lab10");
		//drop down
		Select selectGender = new Select(driver.findElement(By.name("selectGender")));
		selectGender.selectByVisibleText("Male");
		
		Select selectState = new Select(driver.findElement(By.name("selectState")));
		selectState.selectByVisibleText("Iowa");
		
		// normal
		driver.findElement(By.xpath("//input[@id='"+txtEmail+"']")).sendKeys("jcobb@iastate.edu");
		driver.findElement(By.xpath("//input[@id='"+txtPhone+"']")).sendKeys("0");
		driver.findElement(By.xpath("//input[@id='"+txtAddress+"']")).sendKeys("Ames,Ia");


		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='"+btnValidate+"']")).click();

		String strMessage=driver.findElement(By.xpath("//label[@id='"+txtFinalResult+"']")).getText();
		assertEquals(strMessage, "Error");
	}
}
	
