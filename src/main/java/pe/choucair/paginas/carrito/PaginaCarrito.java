package pe.choucair.paginas.carrito;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pe.choucair.paginas.base.PaginaBase;

public class PaginaCarrito extends PaginaBase {


	private By cantidadXproducto= By.xpath("//div[@class='exito-checkout-io-0-x-itemCartContent']//span[@data-molecule-quantity-und-value='true']");
	private By nameProducto= By.xpath("//div[@class='exito-checkout-io-0-x-itemCartContent']//span[@data-molecule-product-detail-name-span='true']");
	
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


	public List<Double> obtenerTotalesPreciosProductosCarrito() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
