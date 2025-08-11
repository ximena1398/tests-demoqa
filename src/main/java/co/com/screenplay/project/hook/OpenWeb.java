package co.com.screenplay.project.hook;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenWeb implements Task {
    //EnvironmentVariables es una interfaz de Serenity que sirve para acceder a valores definidos en archivos de
    //configuración como: serenity.conf, serenity.properties, environment.properties, Variables de entorno del
    //sistema. En resumen: es el “puente” entre tu código y las configuraciones externas.
    private EnvironmentVariables environmentVariables;
    private String webUrl;

    public OpenWeb(String webUrl) {
        this.webUrl = webUrl;
    }

    @Override
    @Step("{0} abre el navegador web") //se agrega con el fin de mencionar lo que se pretende realizar con la tarea
    public <T extends Actor> void performAs(T actor) {
        String pathWebURL = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(webUrl);
        actor.attemptsTo(Open.url(pathWebURL));
    }

    public static Performable browserURL(String webUrl) {
        return instrumented(OpenWeb.class,webUrl);
    }
}
