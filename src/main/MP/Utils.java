package MP;

import javafx.scene.control.TextField;

/**
 * This class holds commonly used utility functions that are used throughout the program.
 */
public class Utils {

    /**
     *
     * @param input
     * @return
     */
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

    public static boolean isEqual(StudentData s1, StudentData s2) {

        boolean hasSameName = s1.name.equals(s2.name);
        boolean hasSameSaisId = s1.saisId == s2.saisId;

        return hasSameName && hasSameSaisId;
    }

    public static  boolean keywordInEntries(StudentData student, String keyword) {

        keyword = keyword.toLowerCase();

        if (student.name.toLowerCase().contains(keyword))
            return true;

        if (student.address.toLowerCase().contains(keyword))
            return true;

        if (Integer.toString(student.saisId).contains(keyword))
            return true;

        if (Integer.toString(student.studentNumber).contains(keyword))
            return true;

        return false;

    }


}