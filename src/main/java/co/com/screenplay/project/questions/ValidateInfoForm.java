package co.com.screenplay.project.questions;

import co.com.screenplay.project.models.StudentData;
import co.com.screenplay.project.tasks.FillStudentRegistrationFormTask;
import co.com.screenplay.project.utils.TableFormUtils;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Tasks;

import java.util.List;

import static co.com.screenplay.project.ui.PracticeFormPageUI.MODAL_VALUES;

public class ValidateInfoForm implements Question<Boolean> {
    private final StudentData data;

    public ValidateInfoForm(StudentData data) {
        this.data = data;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        //MODAL_ROWS es un Target que representa todas las filas (<tr>) de la tabla.
        //resolveAllFor(actor) obtiene una lista de elementos web (WebElementFacade) para que puedan leerse.
        List<WebElementFacade> rows = MODAL_VALUES.resolveAllFor(actor);

        boolean nameMatch = TableFormUtils.getValueFromTable(rows, "Student Name")
                .equals(data.getFirstName() + " " + data.getLastName());

        boolean emailMatch = TableFormUtils.getValueFromTable(rows, "Student Email")
                .equals(data.getEmail());

        return nameMatch && emailMatch;
    }

    public static ValidateInfoForm withParams(StudentData data) {
        return new ValidateInfoForm(data);
    }
}
