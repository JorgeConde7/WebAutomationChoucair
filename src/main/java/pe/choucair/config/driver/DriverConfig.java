package pe.choucair.config.driver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverConfig {

public enum NavegadorWeb{CHROME, FIREFOX}
	/*
	public static WebDriver getInstancia(NavegadorWeb navegador) {
		if(navegador== NavegadorWeb.FIREFOX) {
			return getFirefoxDriver();
		}
		return getChromeDriver();
	}

	private static WebDriver getChromeDriver() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	private static WebDriver getFirefoxDriver() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	*/
	
}
