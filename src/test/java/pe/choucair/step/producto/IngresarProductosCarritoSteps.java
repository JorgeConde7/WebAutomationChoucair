package pe.choucair.step.producto;


import io.cucumber.java.After;
import io.cucumber.java.Before;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;

import pe.choucair.helper.WebHelper;
import pe.choucair.paginas.carrito.PaginaCarrito;
import pe.choucair.paginas.home.Home;
import pe.choucair.paginas.menu.MenuPrincipal;
import pe.choucair.paginas.producto.PaginaSeleccionarProductos;

import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;


public class IngresarProductosCarritoSteps {

	@Managed
	WebDriver driver;
	MenuPrincipal menuPrincipal;
	PaginaSeleccionarProductos paginaSeleccionarProductos;
	PaginaCarrito paginaCarrito;
	Home home;
	
    @Before
    public void configuracionInicial() {
    	//driver= DriverConfig.getInstancia(NavegadorWeb.CHROME);
    	home= new Home(driver);
    	menuPrincipal= new MenuPrincipal(driver);
    	paginaSeleccionarProductos = new PaginaSeleccionarProductos(driver);
    	paginaCarrito= new PaginaCarrito(driver);
    	
    	System.out.println("Configuracion inicial completada ."); 
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
    	
    	List<String> nombresEnSeleccion = paginaSeleccionarProductos.obtenerNombresProductosSeleccionados();
    	System.out.println("Nombre Productos Selecionados:"+nombresEnSeleccion);
    	
        List<String> nombresEnCarrito = paginaCarrito.obtenerNombresProductosCarrito();
        System.out.println("Nombre Productos Selecionados Carrito: "+nombresEnCarrito);

        Collections.sort(nombresEnSeleccion);
        Collections.sort(nombresEnCarrito);
        Assert.assertEquals(nombresEnCarrito, nombresEnSeleccion);
   
    }

    @Then("el total de los precios de los productos agregados debera ser igual que en el carrito")
    public void el_total_de_los_precios_de_los_productos_agregados_debera_ser_igual_que_en_el_carrito() {
    	
    	//List<Double> totalesEnSeleccion = paginaSeleccionarProductos.obtenerTotalesPreciosProductosSeleccionados();    	
       // List<Double> totalesEnCarrito = paginaCarrito.obtenerTotalesPreciosProductosCarrito();

       // Assert.assertEquals(totalesEnSeleccion, totalesEnCarrito);
    }

    @Then("las cantidades de los productos agregados debera ser igual que en el carrito")
    public void las_cantidades_de_los_productos_agregados_debera_ser_igual_que_en_el_carrito() {
    	
    	List<Integer> cantidadesEnSeleccion = paginaSeleccionarProductos.obtenerCantidadesProductosSeleccionados();
    	System.out.println("Cantidades x Producto: "+cantidadesEnSeleccion);
        List<Integer> cantidadesEnCarrito = paginaCarrito.obtenerCantidadesxProductosCarrito();
        System.out.println("Cantidades x Producto Carrito: "+cantidadesEnCarrito);
        
        Collections.sort(cantidadesEnCarrito);
        Collections.sort(cantidadesEnSeleccion);

        Assert.assertEquals(cantidadesEnSeleccion, cantidadesEnCarrito);
    }

    @Then("el numero de productos agregados debe ser igual que en el carrito")
    public void el_numero_de_productos_agregados_debe_ser_igual_que_en_el_carrito() {
    	
    	int numeroEnSeleccion = paginaSeleccionarProductos.obtenerNumeroProductosSeleccionados();
    	System.out.println("Numero de Productos Seleccionados: "+numeroEnSeleccion);
        int numeroEnCarrito = paginaCarrito.obtenerNumeroProductosCarrito();
        System.out.println("Numero de Productos Seleccionados Carrito: "+numeroEnCarrito);

        Assert.assertEquals(numeroEnSeleccion, numeroEnCarrito);
    }

}
