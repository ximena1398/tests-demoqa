package co.com.screenplay.project.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

import static co.com.screenplay.project.ui.HomeUI.BTN_ELEMENTS;
import static co.com.screenplay.project.ui.HomeUI.BTN_LIST_ELEMENTS;
import static co.com.screenplay.project.utils.Constans.REMEMBER_TEXT_BTN_SUB_ELEMENTS;

//Lombok crea automáticamente el constructor con todos los atributos (en este caso, solo numberRandomBtn).
//Esto evita tener que escribir el constructor a mano.
@AllArgsConstructor
public class ChooseSubElementsRandomTask implements Task {
    private String numberRandomBtn;

    @Override
    @Step("{0} selecciona aleatoriamente la posición #numberRandomBtn de la sub función de elementos")
    public <T extends Actor> void performAs(T actor) {
        String number = numberRandomBtn;
        actor.attemptsTo(Scroll.to(BTN_ELEMENTS),
                Click.on(BTN_LIST_ELEMENTS.of(number)));

        //Se debe capturar el textpo del botón aleatorio seleccionado para poder compararlo en el Question
        //Se usa el mismo number por la posición aleatoria
        //resolveFor(actor) → busca el elemento real en el navegador abierto por ese actor
        //getText() → obtiene el texto que muestra ese elemento.
        String textBtn = BTN_LIST_ELEMENTS.of(number).resolveFor(actor).getText();

        //actor.remember(...) → guarda información en la memoria del actor para que esté disponible en pasos posteriores del mismo escenario.
        //REMEMBER_TEXT_BTN_SUB_ELEMENTS → es la clave con la que vas a recuperar luego el valor.
        //textBtn → es el valor guardado.
        actor.remember(REMEMBER_TEXT_BTN_SUB_ELEMENTS, textBtn);
    }

    //encapsulamiento de la clase generando un metodo: Tasks.instrumented es la forma recomendada en Screenplay
    //para instanciar Tasks, permitiendo que Serenity registre la tarea para los reportes.
    public static ChooseSubElementsRandomTask witchParams(String numberRandomBtn) {
        return Tasks.instrumented(ChooseSubElementsRandomTask.class, numberRandomBtn);
    }
}
