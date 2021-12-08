package stepsDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import drivers.GoogleChromeDriver;
import steps.AdidasBuscadorSteps;
import readExcel.ReadExcelFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class AdidasBuscadorDefinitions {

    AdidasBuscadorSteps adidasBuscadorSteps = new AdidasBuscadorSteps();
    @Given("^que me encuentro en la pagina de Adidas$")
    public void queMeEncuentroEnLaPaginaDeAdidas() {
        adidasBuscadorSteps.abrirPagina();
    }

    @When("^busque los productos en el archivo '(.*)' en pantalla$")
    public void busqueElProductoTenisSuperstar(String rutaExcel) throws IOException {
        ArrayList<Map<String, String>> listaProductos;
        listaProductos = ReadExcelFile.leerDatosDeHojaDeExcel(rutaExcel,"Hoja1");
        for (Map<String, String> datos: listaProductos){
            String producto = datos.get("Producto");
            adidasBuscadorSteps.buscarElementoEnAdidas(producto);
            adidasBuscadorSteps.validarElementoEnPantalla(producto);
        }

    }

    @Then("^podre ver en pantalla$")
    public void podreVerTenisSuperstarEnPantalla() {
        GoogleChromeDriver.driver.quit();
    }
}
