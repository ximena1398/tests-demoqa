package co.com.screenplay.project.stepdefinition;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;


@Slf4j
public class SendPracticeFormStepDefinition {
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @When("Completa el formulario con datos válidos")
    public void CompleteTheFormWithValidData() {

    }

    @And("Lo envía")
    public void sendForm() {

    }

    @Then("Debería ver un mensaje de confirmación")
    public void shouldSeeAConfirmationMessage() {
    }
}
