package pe.choucair.paginas.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pe.choucair.paginas.base.PaginaBase;
import pe.choucair.paginas.producto.PaginaSeleccionarProductos;

public class Home extends PaginaBase {

	private By menu = By.xpath("//span[text()='Menú']");
	private String URL = "https://www.exito.com/";

	public Home(WebDriver driver) {
		super(driver);
	}

	public void cargarPaginaExito() {
		driver.get(URL);
	}

	public PaginaSeleccionarProductos cargarPaginaSelecionarProductos(String categoria, String subCategoria) {

		findElementClick(menu).click();;

        By productoCategoria = By.xpath("//p[contains(text(), '" + categoria + "')]");
        findElementClick(productoCategoria).click();

        By productoSubcategoria = By.xpath("//a[b[text()='" + subCategoria + "']]");
        findElementClick(productoSubcategoria).click();
		
		return new PaginaSeleccionarProductos(driver);

	}

}
