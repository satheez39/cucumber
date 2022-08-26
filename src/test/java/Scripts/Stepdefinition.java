package Scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Stepdefinition {
	
	public WebDriver driver;
	@Given("open the browser and enter the valid url")
	public void open_the_browser_and_enter_the_valid_url() throws Throwable { 
		WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver(); 
		driver.manage().window().maximize(); 
		driver.get("https://www.facebook.com");
		driver.manage().timeouts(). implicitlyWait(10,TimeUnit. SECONDS);
	}
	@When("user enters valid username")
	public void user_enters_valid_username() throws Throwable {
		driver.findElement(By.id("email")).sendKeys("user"); 
	}

	@When("user enters valid password")
	public void user_enters_valid_password() throws Throwable {
		driver.findElement(By.name("pass")).sendKeys("pass");
	}

	@When("click login button")
	public void click_login_button() throws Throwable {
		driver.findElement(By.name("login")).click(); 
	}

	@Then("user should in homepage of the application")
	public void user_should_in_homepage_of_the_application() throws Throwable {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Facebook – log in or sign up");
	}


}
