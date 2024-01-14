package pe.choucair.paginas.producto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pe.choucair.helper.WebHelper;
import pe.choucair.paginas.base.PaginaBase;
import pe.choucair.paginas.carrito.PaginaCarrito;

public class PaginaSeleccionarProductos extends PaginaBase {
	
	private By btnAgregar;
	private By btnMas;
	private By btnCarrito = By.xpath("//button/span[text()='Carrito']");
	
    public PaginaSeleccionarProductos(WebDriver driver) {
        super(driver);
    }
    
    WebDriverWait wait = new WebDriverWait(driver, 10);
    public void seleccionarAleatorioProducto(int numProductosRequeridos){
    	
    	
        List<WebElement> productList = driver.findElements(By.xpath("//*[@id='__next']/main/section[5]/div/div[2]/div[2]/div[2]/ul/li"));

        int cantidadProductos = productList.size();
        System.out.println("cantidad de productos " +productList.size());
        
     // Generar una lista de numeros aleatorios
        List<Integer> numAleatorio = numerosAleatorios(cantidadProductos,numProductosRequeridos);
        

        for (int index : numAleatorio) {
        	System.out.println("index: "+index);
            WebElement product = productList.get(index);
            System.out.println("Producto seleccionado: " + product.getText());
            
            //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product);
            WebHelper.pausar();
            
            int indice=index+1;
            btnAgregar= By.xpath("//li['"+indice+"']//button[contains(@class,'DefaultStyle_default__vCozi')]");
            product.findElement(btnAgregar).click();
            
            WebHelper.pausar();
         // Hacer clic en el botón "más" en un número aleatorio entre 1 y 10
            
            List<Integer> agregarCantidadAleatoria = numerosAleatorios(10, 1);;
            int cantidadCompra =agregarCantidadAleatoria.get(0);
            System.out.println("cantidad aleatoria de productos: "+cantidadCompra);
            for (int i = 0; i < cantidadCompra; i++) {
            	int indice2=index+1;
            	WebHelper.pausar();
            	  btnMas= By.xpath("//li['"+indice2+"']//article//div[contains(@class,'QuantitySelectorDefault_defaultStyles__b4Srq ')]/button[2]");
            	
            	driver.findElement(btnMas).click();
  
                WebHelper.pausar();
            }
            
        }
        WebHelper.pausar();
    }

    public PaginaCarrito clicCarrito(){
    	WebHelper.pausar();
    	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(btnCarrito))).click();
    
        return new PaginaCarrito();
    }
    
    private static List<Integer> numerosAleatorios(int totalNumeros, int respuestaNumeros) {
        List<Integer> numeroCantidad = new ArrayList<>();
        
        for (int i = 0; i < totalNumeros; i++) {
        	numeroCantidad.add(i);
        }
        
        Collections.shuffle(numeroCantidad);
        return numeroCantidad.subList(0, Math.min(totalNumeros, respuestaNumeros));
    }
    
    
}
