package co.com.screenplay.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

import static co.com.screenplay.project.ui.HomeUI.*;

public class AccesProgressBarSectionTask implements Task {
    @Override
    @Step("{0} selección del ID card WIDGETS para ingreso a ítem Progress Bar")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(BTN_WIDGETS),
                Click.on(BTN_WIDGETS),
                Scroll.to(BTN_LIST_PROGRESS_BAR),
                Click.on(BTN_LIST_PROGRESS_BAR)
        );
    }

    public static AccesProgressBarSectionTask open(){
        return Tasks.instrumented(AccesProgressBarSectionTask.class);
    }
}
