package steps;

import drivers.GoogleChromeDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AdidasHome;
import pages.AdidasProducto;

public class AdidasBuscadorSteps {
    AdidasHome adidasHome = new AdidasHome();
    AdidasProducto adidasProducto = new AdidasProducto();

    public void abrirPagina() {
        GoogleChromeDriver.chromeWebDriver("https://www.adidas.co/");
    }

    public void buscarElementoEnAdidas(String producto) {
        escribirEnTexto(adidasHome.getTxtBuscador(), producto);
        enterEnElemtento(adidasHome.getTxtBuscador());
    }

    private void escribirEnTexto(By elemento, String texto) {
        GoogleChromeDriver.driver.findElement(elemento).sendKeys(texto);
    }

    private String obtenerTextoElemento(By elemento) {
        return GoogleChromeDriver.driver.findElement(elemento).getText();
    }

    private void enterEnElemtento(By elemento)
    {
        WebElement webElement = GoogleChromeDriver.driver.findElement(elemento);
        webElement.submit();
    }
    public void validarElementoEnPantalla(String producto) {
        adidasProducto.setTxtProducto(producto);
        Assert.assertEquals(producto.toUpperCase(),obtenerTextoElemento(adidasProducto.getTxtProducto()));

    }

}
