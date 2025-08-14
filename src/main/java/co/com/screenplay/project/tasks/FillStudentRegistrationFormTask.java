package co.com.screenplay.project.tasks;

import co.com.screenplay.project.models.StudentData;
import co.com.screenplay.project.ui.PracticeFormPageUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

import static co.com.screenplay.project.ui.PracticeFormPageUI.EMAIL_LABEL;
import static co.com.screenplay.project.ui.PracticeFormPageUI.SUBJECT_LABEL;
import static co.com.screenplay.project.utils.Constans.TIME_SHORT;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class FillStudentRegistrationFormTask implements Task {
    private final StudentData data;

    public FillStudentRegistrationFormTask(StudentData data) {
        this.data = data;
    }

    @Override
    @Step("{0} completa los campos del formulario")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                //Escribe el valor firstName del modelo en el campo FIRST_NAME de la página.
                Enter.theValue(data.getFirstName()).into(PracticeFormPageUI.FIRST_NAME_FIELD),
                Enter.theValue(data.getLastName()).into(PracticeFormPageUI.LAST_NAME_FIELD),

                Scroll.to(EMAIL_LABEL),
                WaitUntil.the(EMAIL_LABEL, isEnabled()).forNoMoreThan(TIME_SHORT).seconds(),
                Enter.theValue(data.getEmail()).into(EMAIL_LABEL),
                //Haz clic en el radio button de género que corresponda al valor que tiene data.getGender()
                Click.on(PracticeFormPageUI.gender(data.getGender())),
                Enter.theValue(data.getMobile()).into(PracticeFormPageUI.NUMBER_LABEL),
                Enter.theValue(data.getDateOfBirth()).into(PracticeFormPageUI.DATE_OF_BIRTH_DATEPICKER),

                //Seleccionar subject: Pone el foco en el campo de Subjects para que pueda escribir.
                Click.on(SUBJECT_LABEL),
                //Escribe el valor que tienes en data.getSubjects(), Le dice a Serenity en qué campo poner ese texto
                //y Simula presionar la tecla Enter para que el autocomplete de Subjects seleccione esa opción.
                Enter.theValue(data.getSubjects())
                        .into(SUBJECT_LABEL)
                        .thenHit(Keys.ENTER)
        );
    }

    public static FillStudentRegistrationFormTask withData(StudentData data) {
        return Tasks.instrumented(FillStudentRegistrationFormTask.class, data);
    }
}
