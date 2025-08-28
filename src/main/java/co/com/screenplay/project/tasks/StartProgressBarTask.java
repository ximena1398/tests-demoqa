package co.com.screenplay.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static co.com.screenplay.project.ui.PracticeFormPageUI.BTN_STAR_PROGRESS_BAR;

public class StartProgressBarTask implements Task {
    @Override
    @Step("{0} clic en el botón start para iniciar barra de progreso")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_STAR_PROGRESS_BAR)
        );
    }

    public static StartProgressBarTask start(){
        return Tasks.instrumented(StartProgressBarTask.class);
    }
}
