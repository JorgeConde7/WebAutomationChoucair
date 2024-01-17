package pe.choucair.paginas.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PaginaBase {

	protected WebDriver driver;
	public static WebDriverWait wait;

    public PaginaBase(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }
    
    public WebElement findElementClick(By locator) {   
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    
    public WebElement findElementLocated(By element) {   
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
    
    public void maximizarVentana() {
        driver.manage().window().maximize();
    }
}

