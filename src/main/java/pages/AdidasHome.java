package pages;

import org.openqa.selenium.By;

public class AdidasHome {

    By txtBuscador = By.xpath("//input[@name='q' and @placeholder='Buscar']");


    public By getTxtBuscador() {
        return txtBuscador;
    }


}
