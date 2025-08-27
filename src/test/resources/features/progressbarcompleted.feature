# author: Ximena Medina Correa

Feature: Verificación de finalización del progress bar

  Como usuario del sitio web de pruebas
  Quiero iniciar la barra de progreso
  Para verificar que la aplicación actualiza el texto del botón y el porcentaje al finalizar

  Background:
    Given "ximena" abre el sitio web de pruebas

  @progressbar_complete
  Scenario: Finalización exitosa de la barra de progreso
    And Accede a la sección de barra de progreso
    When Inicia la barra de progreso
    Then El texto del botón debería ser "Reset"
    And El porcentaje de la barra debería ser "100%"
