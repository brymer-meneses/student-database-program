package MP;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Utils {

    public static boolean isCharOnly(String input) {
        return input.matches("[a-zA-Z\\s]+");
    }

    public static boolean isNumberOnly(String input) {
        return input.matches("[0-9]+");
    }


    public static void setStyleWarning(TextField input) {
        input.setStyle("-fx-border-color: #ff6767;-fx-border-radius: 5; -fx-background-color: #1a1d20;");
    }

    public static void setStyleNormal(TextField input) {
        input.setStyle("-fx-border-color: #6a7281;-fx-border-radius: 5; -fx-background-color: #1a1d20;");
    }


}