package co.com.screenplay.project.stepdefinition.hook;

import co.com.screenplay.project.hook.OpenWeb;
import co.com.screenplay.project.utils.Time;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import org.hamcrest.Matchers;

import static co.com.screenplay.project.utils.Constans.*;
import static co.com.screenplay.project.utils.Time.waiting;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class Hook {
    @Before
    public void setTheStage(){
        // Configura automáticamente el driver de Chrome
        WebDriverManager.chromedriver().setup();

        OnStage.setTheStage(new OnlineCast());
    }

    @Given("{string} abre el sitio web de pruebas")
    public void openTheTestWebsite(String actor) {
        OnStage.theActorCalled(actor).attemptsTo(
                OpenWeb.browserURL(WEB_URL)
        );
        waiting(TIME_SHORT);
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        TheWebPage.title(),
                        Matchers.containsString(TITLE)
                )
        );
    }
}
