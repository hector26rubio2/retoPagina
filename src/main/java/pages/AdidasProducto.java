package pages;

import org.openqa.selenium.By;

public class AdidasProducto {

    By txtProducto;

    public By getTxtProducto() {
        return txtProducto;
    }

    public void setTxtProducto(String producto) {
        this.txtProducto = By.xpath("//div[@class ='product-description___2cJO2']" +
                "/h1[@data-auto-id='product-title'" +
                " and @class='gl-heading gl-heading--regular gl-heading--italic name___1EbZs']" +
                "//span[contains(text(), '"+producto+"')]");
    }
}
