package co.com.screenplay.project.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomeUI extends PageObject {
    public static final Target ID_CARD_ELEMENTS = Target.the("Tarjeta elementos")
            .located(By.xpath("//div[contains (@class, 'category-cards')]//h5[contains (text(), 'Elements')]"));
    public static final Target BTN_ELEMENTS = Target.the("Botón elementos")
            .located(By.xpath("//div[@class='header-wrapper']//div[@class='header-text' and normalize-space()='Elements']"));
    public static final Target BTN_LIST_ELEMENTS = Target.the("Elemento de la lista por índice")
            .locatedBy("//div[@class='element-list collapse show']//li[@id='item-{0}']");
    public static final Target TEXT_RANDOM_NAME_BTN = Target.the("Texto random del nombre de los botones")
            .locatedBy("//h1[@class='text-center']");
    public static final Target CARD_FORMS = Target.the("Tarjeta formulario")
            .locatedBy("//div[contains (@class, 'category-cards')]//h5[contains (text(), 'Forms')]");
    public static final Target BTN_PRACTICE_FORM = Target.the("Botón formulario lista de elementos")
            .locatedBy("//li[@id='item-0']//span[text()='Practice Form']");
}
