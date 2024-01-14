package pe.choucair.paginas.base;

import org.openqa.selenium.WebDriver;

import pe.choucair.paginas.menu.MenuPrincipal;

public class PaginaBase {

	protected WebDriver driver;
	protected MenuPrincipal menuPrincipal;

    public PaginaBase(WebDriver driver) {
        this.driver = driver;
        this.menuPrincipal=new MenuPrincipal(driver);
    }
}

