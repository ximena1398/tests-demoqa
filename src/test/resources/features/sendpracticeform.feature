# author: Ximena Medina Correa

Feature: Envío de formulario de prueba

  Yo como usuario del sitio web de pruebas
  Quiero completar y enviar un formulario
  Para verificar que la aplicación procesa correctamente la información

  Background:
    Given "ximena" abre el sitio web de pruebas

  @successful_form
  Scenario: Envío exitoso de formulario con datos válidos
    And accede a la sección de formulario
    When Completa el formulario con datos válidos
    Then Debería ver un mensaje de confirmación
