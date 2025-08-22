package co.com.screenplay.project.utils;

import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

public class TableFormUtils {
    public static String getValueFromTable(List<WebElementFacade> rows, String label) {
        for (WebElementFacade row : rows) {
            List<WebElementFacade> cells = row.thenFindAll("td");
            if (cells.size() == 2 && cells.get(0).getText().equalsIgnoreCase(label)) {
                return cells.get(1).getText();
            }
        }
        return "";
    }
}
