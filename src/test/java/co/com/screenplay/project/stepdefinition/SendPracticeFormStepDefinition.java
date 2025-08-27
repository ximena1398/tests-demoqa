package co.com.screenplay.project.stepdefinition;

import co.com.screenplay.project.models.StudentData;
import co.com.screenplay.project.questions.ValidateInfoForm;
import co.com.screenplay.project.tasks.FillStudentRegistrationFormTask;
import co.com.screenplay.project.tasks.FuntionsFormTask;
import co.com.screenplay.project.ui.PracticeFormPageUI;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.targets.Target;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;  // <-- CORRECCIÓN AQUÍ
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

@Slf4j
public class SendPracticeFormStepDefinition {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @And("accede a la sección de formulario")
    public void accesToFormSeccion() {
        theActorInTheSpotlight().attemptsTo(
                FuntionsFormTask.choose()
        );
    }

    @When("Completa el formulario con datos válidos")
    public void CompleteTheFormWithValidData() {
        List<Target> hobbies = Arrays.asList(
                PracticeFormPageUI.CHECKBOX_HOBBIE_DEPORTES,
                PracticeFormPageUI.CHECKBOX_HOBBIE_MUSIC
        );

        StudentData studentData = new StudentData(
                "Ximena", "Medina", "ximena@example.com", "female",
                "1234567890", "13 Aug 2025", "Maths", hobbies,
                "C:/Users/Ximena/Downloads/1724721548849.jpg", "Calle 123", "NCR", "Agra"
        );

        theActorInTheSpotlight().remember("studentData", studentData);

        theActorInTheSpotlight().attemptsTo(
                FillStudentRegistrationFormTask.withData(studentData)
        );
    }

    @Then("Debería ver un mensaje de confirmación")
    public void shouldSeeAConfirmationMessage() {
        StudentData rememberedData = theActorInTheSpotlight().recall("studentData");
        //theActorInTheSpotlight(): obtiene el actor que está ejecutando la prueba.
        //should(...): indica que se va a hacer una verificación.
        //seeThat(...): ejecuta la Question (ValidateInfoForm) para obtener un resultado.
        //is(true): compara el resultado con true.
        //Si ValidateInfoForm devuelve true, la prueba pasa.
        //Si devuelve false, lanza la excepción que viste antes.
        theActorInTheSpotlight().should(
                seeThat(
                        ValidateInfoForm.withParams(rememberedData),
                        is(true)
                )
        );
    }
}
