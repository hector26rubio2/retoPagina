Feature: HU-001 Buscador Adidas
  Yo como usuario de Adidas
  Quiero buscar un producto en la plataforma
  Para ver el nombre del producto en pantalla

  Scenario: Buscador producto
    Given que me encuentro en la pagina de Adidas
    When  busque los productos en el archivo 'src\test\java\dataExcel\datos.xlsx' en pantalla
    Then podre ver en pantalla
