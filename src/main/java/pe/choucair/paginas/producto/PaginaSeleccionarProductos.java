package pe.choucair.paginas.producto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pe.choucair.helper.WebHelper;
import pe.choucair.paginas.base.PaginaBase;
import pe.choucair.paginas.carrito.PaginaCarrito;
import pe.choucair.util.Utilitarios;

public class PaginaSeleccionarProductos extends PaginaBase {

	private By btnAgregar;
	private By btnMas;
	private By btnCarrito = By.xpath("/html/body/div[1]/header/section/div/div[2]/div[2]/button");
	private By btnCerrarBanner = By.id("wps-overlay-close-button");
	private By listProducto = By.xpath("//li//article//section//h3//a");
	private List<String> listNombresProductosSeleccionados = new ArrayList<>();
	private List<Integer> cantidadesProductosSeleccionados = new ArrayList<>();
	WebElement product;
	private boolean bannerCerrado = false;

	public PaginaSeleccionarProductos(WebDriver driver) {
		super(driver);
	}

	public void seleccionarAleatorioProducto(int numProductosRequeridos) {

		List<WebElement> productList = driver.findElements(listProducto);

		int cantidadProductos = productList.size();

		// Generar una lista de numeros aleatorios

		List<Integer> numProductoAleatorio = Utilitarios.numerosAleatorios(cantidadProductos, numProductosRequeridos);

		for (int index : numProductoAleatorio) {

			product = productList.get(index - 1);
			System.out.println("Producto seleccionado: " + product.getText());

			// Agrego los nombres de los productos seleccionados a una lista
			listNombresProductosSeleccionados.add(product.getText());

			btnAgregar = By.xpath("//li[" + index + "]//article//button[contains(@class,'DefaultStyle_default')]");

			// product.findElement(btnAgregar).click();
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(btnAgregar));
			element.click();

			List<Integer> agregarCantidadAleatoria = Utilitarios.numerosAleatorios(9, 1);

			int cantidadCompra = agregarCantidadAleatoria.get(0);
			cantidadesProductosSeleccionados.add(cantidadCompra + 1);

			System.out.println("cantidad por productos: " + cantidadCompra);

			for (int i = 1; i <= cantidadCompra; i++) {

				btnMas = By.xpath("//li[" + index
						+ "]//article//div[contains(@class,'QuantitySelectorDefault_defaultStyles')]/button[2]");
				WebElement elementBtnMas = wait.until(ExpectedConditions.elementToBeClickable(btnMas));
				new Actions(driver).moveToElement(elementBtnMas).perform();

				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementBtnMas);
				elementBtnMas.click();
				WebHelper.pausar();
				cerrarBanner();
			}
			cerrarBanner();
		}

	}

	public PaginaCarrito clicCarrito() {

		try {
			WebElement carritoElement = driver.findElement(btnCarrito);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", carritoElement);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", carritoElement);
			WebHelper.pausar();
		} catch (NoSuchElementException e) {
			System.out.println("Elemento del carrito no encontrado: " + e.getMessage());
		} catch (ElementClickInterceptedException e) {
			System.out.println("Error al hacer clic en el carrito: " + e.getMessage());
		}
		return new PaginaCarrito(driver);
	}

	private void cerrarBanner() {

		try {
			if (!bannerCerrado) {
				driver.findElement(btnCerrarBanner).click();
				bannerCerrado = true;
				System.out.println("Banner cerrado.");
			}
		} catch (Exception e) {
			System.out.println("Banner no encontrado");
		}
	}

	// Validaciones

	public List<String> obtenerNombresProductosSeleccionados() {
		return listNombresProductosSeleccionados;
	}

	public int obtenerNumeroProductosSeleccionados() {
		int numeroProductosSeleccionados = cantidadesProductosSeleccionados.size();

		return numeroProductosSeleccionados;
	}

	public List<Integer> obtenerCantidadesProductosSeleccionados() {

		return cantidadesProductosSeleccionados;
	}

	public List<Double> obtenerTotalesPreciosProductosSeleccionados() {

		return null;
	}

}
