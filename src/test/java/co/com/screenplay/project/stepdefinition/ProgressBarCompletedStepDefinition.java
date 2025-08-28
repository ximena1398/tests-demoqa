package co.com.screenplay.project.stepdefinition;

import co.com.screenplay.project.questions.ValidateTextButton;
import co.com.screenplay.project.tasks.AccesProgressBarSectionTask;
import co.com.screenplay.project.tasks.StartProgressBarTask;
import co.com.screenplay.project.ui.PracticeFormPageUI;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.screenplay.project.utils.Constans.ACTOR;
import static co.com.screenplay.project.utils.Constans.TIME_SHORT;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.equalTo;


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
        OnStage.theActorCalled(ACTOR).attemptsTo(StartProgressBarTask.start());
    }

    @Then("El texto del botón debería ser {string}")
    public void elTextoDelBotonDeberiaSer(String expectedTextButton) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(PracticeFormPageUI.BTN_RESET_PROGRESS_BAR, isVisible())
                        .forNoMoreThan(TIME_SHORT).seconds()
        );
        OnStage.theActorInTheSpotlight().should(
                seeThat(ValidateTextButton.es(PracticeFormPageUI.BTN_RESET_PROGRESS_BAR),
                        equalTo(expectedTextButton))
        );
    }

    @And("El porcentaje de la barra debería ser {string}")
    public void elPorcentajeDeLaBarraDeberíaSer(String expectedPercentage) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(PracticeFormPageUI.LABEL_PERCENTAJE_PROGRESS_BAR, isVisible())
                        .forNoMoreThan(TIME_SHORT).seconds()
        );
        OnStage.theActorInTheSpotlight().should(
                seeThat(ValidateTextButton.es(PracticeFormPageUI.LABEL_PERCENTAJE_PROGRESS_BAR),
                        equalTo(expectedPercentage))
        );
    }
}
