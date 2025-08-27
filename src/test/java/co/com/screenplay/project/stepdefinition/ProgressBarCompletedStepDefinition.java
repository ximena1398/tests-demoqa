package co.com.screenplay.project.stepdefinition;

import co.com.screenplay.project.tasks.AccesProgressBarSectionTask;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static co.com.screenplay.project.utils.Constans.ACTOR;


public class ProgressBarCompletedStepDefinition {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @And("Accede a la sección de barra de progreso")
    public void AccedeALaSeccionDeBarraDeProgreso() {
        OnStage.theActorCalled(ACTOR).attemptsTo(AccesProgressBarSectionTask.open());
    }

    @When("Inicia la barra de progreso")
    public void iniciaLaBarraDeProgreso() {
    }

    @Then("El texto del botón debería ser {string}")
    public void elTextoDelBotónDeberíaSer(String arg0) {
    }

    @And("El porcentaje de la barra debería ser {string}")
    public void elPorcentajeDeLaBarraDeberíaSer(String arg0) {
    }
}
