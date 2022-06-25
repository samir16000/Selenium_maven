package pack1_maven;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class LoginTest {
	WebDriver driver;

	@Test
	public void login() throws InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		WebElement username = driver.findElement(By.xpath("//input[@name='txtUsername']"));
		username.sendKeys("Admin");
		WebElement password = driver.findElement(By.xpath("//input[@name='txtPassword']"));
		password.sendKeys("admin123");
		WebElement login = driver.findElement(By.xpath("//input[@name='Submit']"));
		login.click();
		WebElement welcombtn = driver.findElement(By.xpath("//a[@id='welcome']"));
		welcombtn.click();
		Thread.sleep(4000);
		WebElement logoutbtn = driver.findElement(By.xpath("//a[@href=\"/index.php/auth/logout\"]"));
		logoutbtn.click();

	}
	@Test
	public void synchTest() throws InterruptedException {
		driver.get("http://omayo.blogspot.com/");
		WebElement dropdownbtn = driver.findElement(By.xpath("//button[@class='dropbtn']"));
		dropdownbtn.click();
		Thread.sleep(3000);
		WebElement LinkFacebook = driver.findElement(By.linkText("Facebook"));
		LinkFacebook.click();
	}	

	@BeforeClass // tout ce qui va s executer avant les tests(preconditions)
	public void setup() {
		// System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();// chercher le chemin du driver
		driver = new ChromeDriver(); // une instance du navigateur chrome
		driver.manage().window().maximize();

	}

	@AfterClass // tout ce qui va s executer apres les tests les tests(post conditions)
	public void tearDown() {
		// driver.quit();
	}

}
