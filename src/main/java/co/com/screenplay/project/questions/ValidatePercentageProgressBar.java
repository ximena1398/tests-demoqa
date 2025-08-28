package co.com.screenplay.project.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class ValidatePercentageProgressBar implements Question<String> {
    private final Target percentageButton;

    public ValidatePercentageProgressBar(Target percentageButton) {
        this.percentageButton = percentageButton;
    }

    @Override
    @Subject("{0} se obtiene el porcentage del label de la barra de progreso")
    public String answeredBy(Actor actor) {
        return Text.of(percentageButton).answeredBy(actor).trim();
    }

    public static ValidatePercentageProgressBar es(Target percentageButton){
        return new ValidatePercentageProgressBar(percentageButton);
    }
}
