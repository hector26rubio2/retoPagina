##Reto de automatizacion pagina: 'adidas.co'
###Test Automaticación con carga de datos excel
para este reto se tenia que automatizar la busqueda de 5 productos por el buscador y verificar que  efectivamente fuera el producto buscado.

### Dependencias
como hemos trabajado en los proyectos de prueba

		+ implementation 'net.serenity-bdd:serenity-junit:2.0.80'.
		
		+ implementation 'net.serenity-bdd:serenity-cucumber:1.9.45'.
		
		+ implementation 'net.serenity-bdd:serenity-core:2.0.80'
		
		 +implementation 'org.slf4j:slf4j-simple:1.7.7'.
		 
		 +implementation group: 'org.apache.poi', name: 'poi', version: '3.17'.
		 
		 +implementation group: 'org.apache.poi', name: 'poi-ooxml', version: '3.17'

###Estructura

 Selenium POM+Cucumber
 
+ paquetes:
	+ runners: AdidasBuscadorStepsRunner.java.

	+ stepsDefinitions: AdidasBuscadorDefinitions.java.

			En el when creo una variable local de tipo   ArrayList<Map<String, String>> listaProductos; 
			Donde estaran los datos de prueba luego los recorro mediante un for-ech busco el producto en el atributo de clase adidasBuscadorSteps, 
			con el metodo  buscarElementoEnAdidas.
			Luego de buscarlo  con el mismo atributo con el metodo  validarElementoEnPantalla que verificara si es o no el producto.

	+ readExcel: ReadExcelFile.java

			 El paquete lo utilizo para estructurar el codigo.
			 La clase sirve para poder cargar el excel con el metodo "leerDatosDeHojaDeExcel", el cual como parametros recibe la ubicación del archivo 
			 y la hoja que se quiere leer y extrar los datos.
			 Ademas es estatico con esto no se necesita instanciar la clase para poder utilizarlo.

	+ dataExcel:  datos.xlsx

			 El paquete lo utilizo para estructurar el codigo.
			 El archivo  contiene los datos de prueba que son:
				Tenis Adizero Adios Pro 2.0.
				Tenis Superstar Star Wars.
				Morral Minnie.
				Camiseta Team Base.
				Chaqueta Deportiva Beckenbauer Blue Versión.

	+ features: AdidasBusqueda.feature

		Feature: HU-001 Buscador Adidas
		Yo como usuario de Adidas Quiero buscar un producto en la plataforma Para ver el nombre del producto en pantalla.
			Scenario: Buscador producto
			Given que me encuentro en la pagina de Adidas
			When  busque los productos en el archivo 'src\test\java\dataExcel\datos.xlsx' en pantalla
			Then podre ver en pantalla.
			
	* steps: AdidasBuscadorSteps.java
	  en esta clase tengo:
	  * buscarElementoEnAdidas(String producto):
	  		ingresa el nombre del producto en el buscador de la pagina  y lo busca.
	 * validarElementoEnPantalla(String producto) :
	 		valida que el producto en pantalla sea el mismo que sea el mismo de la prueba dle excel.
	+ pages

		* AdidasHome.java:
	 		 Contiene los Xpath necesarios de la vista principal de la pagina para realizar las pruebas en este caso el imput
			 "//input[@name='q' and @placeholder='Buscar']"

		* AdidasProducto.java:
	 		 Contiene los Xpath necesarios de la vista del procducto de la pagina para realizar las pruebas en este caso un span que
			 contiene el nombre el producto.
			 "//div[@class ='product-description___2cJO2']/h1[@data-auto-id='product-title' 
			 and @class='gl-heading gl-heading--regular gl-heading--italic name___1EbZs']//span[contains(text(), '"+producto+"')]"



