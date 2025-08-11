#author: Ximena Medina Correa

Feature: Abrir una pagina web

  Yo como Ximena
  Quiero realizar una prueba de abrir un sitio
  Para comprobar la robustez y control de errores de la aplicacion
  Background:
    Given "ximena" abre el sitio web de pruebas

  @successful #este decorador se encuentra en la clase Runner del scenario en TAGS
    #El escenario debe indicar correctamente lo que se pretende realizar con la prueba
  Scenario: validacion en la funcion del ID Card Elements
    And desea validar la funcion de la carta de elementos
    When selecciona aleatoriamente una de las subfunciones
    Then visualizara en la cabecera el nombre de la opción elegida