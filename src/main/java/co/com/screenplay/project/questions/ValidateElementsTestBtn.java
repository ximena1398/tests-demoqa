package co.com.screenplay.project.questions;

import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import static co.com.screenplay.project.ui.HomeUI.TEXT_RANDOM_NAME_BTN;

@Slf4j //Para utilizar las funciones de log
public class ValidateElementsTestBtn implements Question<Boolean> {
    private String validateTextSubElementBtn;

    public ValidateElementsTestBtn(String validateTextSubElementBtn) {
        this.validateTextSubElementBtn = validateTextSubElementBtn;
    }

    @Override
    @Subject("{0} se realiza validación del elemento capturado con dicho parámetro #validateTextSubElementBtn")
    public Boolean answeredBy(Actor actor) {
        boolean result;
        String validTextBtnHeader = TEXT_RANDOM_NAME_BTN.resolveFor(actor).getText();
        if (validTextBtnHeader != null && validateTextSubElementBtn.equals(validTextBtnHeader)) {
            log.info(validTextBtnHeader);
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public static ValidateElementsTestBtn witchParams(String validateTextSubElementBtn) {
        return new ValidateElementsTestBtn(validateTextSubElementBtn);
    }
}
