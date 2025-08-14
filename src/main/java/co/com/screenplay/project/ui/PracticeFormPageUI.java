package co.com.screenplay.project.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PracticeFormPageUI extends PageObject {
    public static final Target FIRST_NAME_FIELD = Target.the("campo de primer nombre")
            .located(By.id("firstName"));

    public static final Target LAST_NAME_FIELD = Target.the("campo apellido")
            .located(By.id("lastName"));

    public static final Target EMAIL_LABEL = Target.the("campo email")
            .located(By.id("userEmail"));

    public static final Target RADIO_MALE = Target.the("opción género masculino")
            .located(By.cssSelector("label[for='gender-radio-1']"));

    public static final Target RADIO_FEMALE = Target.the("opción género femenino")
            .located(By.cssSelector("label[for='gender-radio-2']"));

    public static final Target RADIO_OTHER = Target.the("opción género otro")
            .located(By.cssSelector("label[for='gender-radio-3']"));

    public static Target gender(String gender) {
        switch (gender.toLowerCase()) {
            case "male": return RADIO_MALE;
            case "female": return RADIO_FEMALE;
            case "other": return RADIO_OTHER;
            default: throw new IllegalArgumentException("Género no válido: " + gender);
        }
    }

    public static final Target NUMBER_LABEL = Target.the("campo número")
            .located(By.id("userNumber"));

    public static final Target DATE_OF_BIRTH_DATEPICKER = Target.the("selección fecha de nacimiento")
            .located(By.id("dateOfBirthInput"));

    public static final Target SUBJECT_LABEL = Target.the("campo asignatura")
            .located(By.id("subjectsInput"));

    public static final Target CHECKBOX_HOBBIE_DEPORTES = Target.the("opción deportes")
            .located(By.id("hobbies-checkbox-1"));

    public static final Target CHECKBOX_HOBBIE_READING = Target.the("opción lectura")
            .located(By.id("hobbies-checkbox-2"));

    public static final Target CHECKBOX_HOBBIE_MUSIC = Target.the("opción música")
            .located(By.id("hobbies-checkbox-3"));

    public static final Target UPLOAD_PICTURE_BUTTON = Target.the("botón cargar foto")
            .located(By.id("uploadPicture"));

    public static final Target DIRECCION_LABEL = Target.the("campo dirección")
            .located(By.id("currentAddress"));

    public static final Target STATE_DROPDOWN = Target.the("desplegable de estado")
            .located(By.id("state"));

    public static final Target CITY_DROPDOWN = Target.the("desplegable de ciudad")
            .located(By.id("city"));

    public static final Target BUTTON_SUBMIT = Target.the("botón enviar formulario")
            .located(By.id("submit"));

    //TARGET DINÁMICO
    public static Target VALUE_IN_MODAL(String label) {
        return Target.the("valor de " + label + " en el modal")
                .located(By.xpath("//td[text()='" + label + "']/following-sibling::td"));
    }

}
