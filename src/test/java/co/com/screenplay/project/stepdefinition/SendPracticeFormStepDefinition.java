package co.com.screenplay.project.stepdefinition;

import co.com.screenplay.project.models.StudentData;
import co.com.screenplay.project.tasks.FillStudentRegistrationFormTask;
import co.com.screenplay.project.tasks.FuntionsFormTask;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static co.com.screenplay.project.utils.Constans.ACTOR;


@Slf4j
public class SendPracticeFormStepDefinition {
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled(ACTOR); // Actor inicializado aquí
    }

    @And("accede a la sección de formulario")
    public void accesToFormSeccion() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                FuntionsFormTask.choose()
        );
    }

    @When("Completa el formulario con datos válidos")
    public void CompleteTheFormWithValidData() {
        StudentData studentData = new StudentData(
                "Ximena", "Medina", "ximena@example.com", "female",
                "1234567890", "13 Aug 2025", "Maths", "Music",
                "C:/images/photo.png", "Calle 123", "NCR", "Delhi"
        );
        OnStage.theActorInTheSpotlight().attemptsTo(
                FillStudentRegistrationFormTask.withData(studentData)
        );
    }

    @And("Lo envía")
    public void sendForm() {

    }

    @Then("Debería ver un mensaje de confirmación")
    public void shouldSeeAConfirmationMessage() {
    }

}
