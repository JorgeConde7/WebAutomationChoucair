package pe.choucair.paginas.home;


import org.openqa.selenium.WebDriver;

import pe.choucair.paginas.base.PaginaBase;


public class Home extends PaginaBase {
	
	
    public Home(WebDriver driver) {
        super(driver);
    }

    public void cargarPaginaExito(){
        driver.get("https://www.exito.com/");
    }



}
