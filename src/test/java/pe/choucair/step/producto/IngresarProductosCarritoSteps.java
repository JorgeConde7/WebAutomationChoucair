package pe.choucair.step.producto;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import pe.choucair.helper.WebHelper;
import pe.choucair.paginas.home.Home;
import pe.choucair.paginas.menu.MenuPrincipal;
import pe.choucair.paginas.producto.PaginaSeleccionarProductos;

import org.openqa.selenium.WebDriver;


public class IngresarProductosCarritoSteps {

	@Managed
	WebDriver driver;
	MenuPrincipal menuPrincipal;
	PaginaSeleccionarProductos paginaSeleccionarProductos;
	Home home;
	
    @Before
    public void configuracionInicial() {
    	home= new Home(driver);
    	menuPrincipal= new MenuPrincipal(driver);
    	paginaSeleccionarProductos = new PaginaSeleccionarProductos(driver);
    	System.out.println("Configuración inicial completada ."); 
    }
    
    @After
    public void liberarRecursos() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("cargo la pagina Exito")
    public void cargoLaPaginaExito() {
        home.cargarPaginaExito();
      
    }

	@When("selecciono una categoria {string} y subcategoria {string}")
	public void selecciono_una_categoria_y_subcategoria(String categoria, String subategoria) {
		menuPrincipal.cargarPaginaSelecionarProductos(categoria, subategoria);
		WebHelper.pausar();
	}
	
    @Then("selecciono cantidad de {int} productos aleatoramiente")
    public void selecciono_cantidad_de_productos_aleatoramiente(Integer cantidad) {
    	paginaSeleccionarProductos.seleccionarAleatorioProducto(cantidad);
    }

    @Then("ingreso al carrito de compras")
    public void ingreso_al_carrito_de_compras() {
    	paginaSeleccionarProductos.clicCarrito();
       
    }

    @Then("el nombre de los productos agregados debera ser igual que en el carrito")
    public void el_nombre_de_los_productos_agregados_debera_ser_igual_que_en_el_carrito() {
       
    }

    @Then("el total de los precios de los productos agregados debera ser igual que en el carrito")
    public void el_total_de_los_precios_de_los_productos_agregados_debera_ser_igual_que_en_el_carrito() {
      
    }

    @Then("las cantidades de los productos agregados debera ser igual que en el carrito")
    public void las_cantidades_de_los_productos_agregados_debera_ser_igual_que_en_el_carrito() {
        
    }

    @Then("el numero de productos agregados debe ser igual que en el carrito")
    public void el_numero_de_productos_agregados_debe_ser_igual_que_en_el_carrito() {
       
    }

}
