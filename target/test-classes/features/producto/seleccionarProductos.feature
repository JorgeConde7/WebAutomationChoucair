Feature: Productos categoria y subcategoria


  Scenario Outline: Agregar Productos aleatorios al Carrito de Compra

		Given cargo la pagina Exito
    When selecciono una categoria <categoria> y subcategoria <subcategoria>
    And selecciono cantidad de <cantidad> productos aleatoramiente
    And ingreso al carrito de compras
    Then el nombre de los productos agregados debera ser igual que en el carrito
    And el total de los precios de los productos agregados debera ser igual que en el carrito
    And las cantidades de los productos agregados debera ser igual que en el carrito
    And el numero de productos agregados debe ser igual que en el carrito
    
    
    Examples:
    |categoria |subcategoria|cantidad|
    |"Tecnología" | "Computadores y accesorios"|2|