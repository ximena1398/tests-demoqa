package co.com.screenplay.project.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class ValidateTextButton implements Question<String>{
    private final Target botonReset;

    public ValidateTextButton(Target botonReset) {
        this.botonReset = botonReset;
    }

    @Override
    @Subject("{0} se obtiene el valor del texto del botón botonReset")
    public String answeredBy(Actor actor) {
        return Text.of(botonReset).answeredBy(actor).trim();
    }

    public static ValidateTextButton es(Target boton) {
        return new ValidateTextButton(boton);
    }
}
