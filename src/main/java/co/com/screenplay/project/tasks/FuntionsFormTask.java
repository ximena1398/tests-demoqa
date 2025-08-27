package co.com.screenplay.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static co.com.screenplay.project.ui.HomeUI.*;
import static co.com.screenplay.project.utils.Constans.TIME_SHORT;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class FuntionsFormTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(CARD_FORMS),
                WaitUntil.the(CARD_FORMS, isEnabled()).forNoMoreThan(TIME_SHORT).seconds(),
                Click.on(CARD_FORMS),
                WaitUntil.the(BTN_PRACTICE_FORM, isEnabled()).forNoMoreThan(TIME_SHORT).seconds(),
                Click.on(BTN_PRACTICE_FORM)
        );
    }

    public static FuntionsFormTask choose() {
        return Tasks.instrumented(FuntionsFormTask.class);
    }
}
