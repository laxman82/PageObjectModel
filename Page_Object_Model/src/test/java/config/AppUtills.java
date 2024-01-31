package config;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import ApplicationLayer.AdminLogout;
import ApplicationLayer.LoginPage;

public class AppUtills {
public static WebDriver driver;
public static Properties conpro;
@BeforeTest
public static void setup() throws Throwable, IOException {
	
	conpro=new Properties();
	conpro.load(new FileInputStream("./PropertyFile/environment.properties"));
	if(conpro.getProperty("Browser").equalsIgnoreCase("chrome"))
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(conpro.getProperty("Url"));
		LoginPage login=PageFactory.initElements(driver, LoginPage.class);
	    login.adminLogin("admin", "master");
	}else if(conpro.getProperty("Browser").equalsIgnoreCase("firefox"))
	{
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(conpro.getProperty("Url"));
		LoginPage login=PageFactory.initElements(driver, LoginPage.class);
	    login.adminLogin("admin", "master");
	}
	else {
		Reporter.log("browser is not matched",true);
	}	
}
@AfterTest
public static void tearDown() {
	AdminLogout logout=PageFactory.initElements(driver, AdminLogout.class);
	logout.adminlogout();
	driver.quit();
	
}
	
	
	
	
	
}
