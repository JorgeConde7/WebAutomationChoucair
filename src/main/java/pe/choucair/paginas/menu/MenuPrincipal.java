package pe.choucair.paginas.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pe.choucair.paginas.producto.PaginaSeleccionarProductos;

public class MenuPrincipal  {
	
	private By menu= By.xpath("//span[text()='Menú']");
    
    private WebDriver driver;
    public static WebDriverWait wait;
    
    public MenuPrincipal(WebDriver driver) {
    	
    	this.driver = driver;
    }

    
    public PaginaSeleccionarProductos cargarPaginaSelecionarProductos(String categoria, String subCategoria) {
    	
    	//wait.until(ExpectedConditions.visibilityOf(driver.findElement(menu))).click();
    	
    	driver.findElement(menu).click();
    	
    	 By productoCategoria= By.xpath("//p[contains(text(), '"+categoria+"')]");
        //wait.until(ExpectedConditions.visibilityOfElementLocated(productoCategoria)).click();
        
        driver.findElement(productoCategoria).click();
        
         By productoSubcategoria= By.xpath("//a[b[text()='"+subCategoria+"']]");
        // wait.until(ExpectedConditions.visibilityOfElementLocated(productoSubcategoria)).click();
        
        driver.findElement(productoSubcategoria).click();
        
        return new PaginaSeleccionarProductos(driver);
    
    
    }
}
