package pe.choucair.paginas.carrito;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pe.choucair.paginas.base.PaginaBase;

public class PaginaCarrito extends PaginaBase {


	private By cantidadXproducto= By.xpath("//div[@class='exito-checkout-io-0-x-itemCartContent']//span[@data-molecule-quantity-und-value='true']");
	private By nameProducto= By.xpath("//div[@class='exito-checkout-io-0-x-itemCartContent']//span[@data-molecule-product-detail-name-span='true']");
	private By precioxProducto= By.xpath("//div[@class='exito-checkout-io-0-x-itemCartContent']//div[@data-molecule-product-detail-price-best-price='true']");
	private By precioTotalProductos= By.xpath("//div[@class='exito-checkout-io-0-x-summaryTotal']//span[2]");
	
	public PaginaCarrito(WebDriver driver) {
		super(driver);
	
	}
	
	
	public List<String> obtenerNombresProductosCarrito() {
		
        List<WebElement> elementosNombreProducto = driver.findElements(nameProducto);
        List<String> nombresProductos = new ArrayList<>();

        for (WebElement elemento : elementosNombreProducto) {

            nombresProductos.add(elemento.getText());
        }

        return nombresProductos;
    }

    public int obtenerNumeroProductosCarrito() {
        List<WebElement> elementosNombreProducto = driver.findElements(nameProducto);
        return elementosNombreProducto.size();
    }


	public List<Integer> obtenerCantidadesxProductosCarrito() {
		
		List <WebElement> elementosCantidadxProducto=driver.findElements(cantidadXproducto);
		List<Integer> cantidadxProductos = new ArrayList<>();
		
			for (WebElement elemento : elementosCantidadxProducto) {
		
				cantidadxProductos.add(Integer.parseInt(elemento.getText()));
		    }

		    return cantidadxProductos;
		
	}


	
	public double sumarPreciosProductosCarrito() {
	    double sumaTotal = 0.0;

	    List<WebElement> elementosPrecios = driver.findElements(precioxProducto);

	    for (WebElement elementoPrecio : elementosPrecios) {
	    	String precioTexto = elementoPrecio.getText().replace("$", "").replace(".", "").replace(",", ".");
	        double precio = Double.parseDouble(precioTexto);
	        sumaTotal += precio;
	        
	    }
	    System.out.println("Suma Total de Productos :"+sumaTotal);
	    return sumaTotal;
	}

    public double obtenerPrecioTotalCarrito() {
    	
        WebElement elementoPrecioTotal = findElementLocated(precioTotalProductos);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementoPrecioTotal);
        String precioTotalTexto = elementoPrecioTotal.getText().replace("$", "").replace(".", "").replace(",", ".");
        System.out.println("Precio Toal Carrito :"+precioTotalTexto);
        return Double.parseDouble(precioTotalTexto);
    }
	
	
}
