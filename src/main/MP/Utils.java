package MP;

import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import javax.xml.crypto.Data;

/**
 * This class holds commonly used utility functions that are used throughout the program.
 */
public class Utils {

    /**
     * Check if string consists of characters only
     *
     * @param input the string to check
     * @return true if the condition is true otherwise returns false
     */
    public static boolean isCharOnly(String input) {
        return input.matches("[a-zA-Z\\s]+");
    }

    /**
     * Check if string consists of numbers only
     *
     * @param input the string to check
     * @return true if the condition is holds otherwise returns false
     */
    public static boolean isNumberOnly(String input) {
        return input.matches("[0-9]+");
    }


    /**
     * highlights the text field as red
     */
    public static void setStyleWarning(TextField input) {
        input.setStyle("-fx-border-color: #ff6767;-fx-border-radius: 5; -fx-background-color: #1a1d20;");
    }

    /**
     * undoes the effect of setStyleWarning
     */
    public static void setStyleNormal(TextField input) {
        input.setStyle("-fx-border-color: #6a7281;-fx-border-radius: 5; -fx-background-color: #1a1d20;");
    }

    /**
     * Check if two student data are equal, i.e. has sanme name
     * and same SAIS ID.
     *
     * @param s1 the first student
     * @param s2 the second student
     * @return true if the condition holds otherwise returns false
     */
    public static boolean isEqual(StudentData s1, StudentData s2) {

        boolean hasSameName = s1.name.equals(s2.name);
        boolean hasSameSaisId = s1.saisId == s2.saisId;

        return hasSameName && hasSameSaisId;
    }

    /**
     * Checks if the element is a duplicate of the database, that is
     * there exists an element of the database that is equal to the passed
     * StudentData.
     *
     * @param database the database that is checked
     * @param element the element that is passed
     *
     * @return true if the condition holds otherwise returns false
     */
    public static boolean isDuplicate(Database database, StudentData element) {

        for (int i = 0; i < database.length; i++) {

            if (Utils.isEqual(element , database.get(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the element is a duplicate of the database and has the
     * same index in the database, that is if they are "really" equal.
     *
     * @param database
     * @param element
     * @param index
     *
     * @return true if the condition holds otherwise returns false
     */
    public static boolean isEditingSameIndex(Database database, StudentData element, int index) {
        for (int i = 0; i < database.length; i++) {

            if (Utils.isEqual(element , database.get(i))) {
                if (index == i) {
                    return true;
                }

            }
        }
        return false;
    }

    /**
     * Checks if each field of the StudentData being passed contains the string keyword.
     *
     * @param student
     * @param keyword the keyword
     * @return
     */
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

    public static boolean validateInputs(
            TextField nameTF, TextField saisIdTF, TextField studentNumberTF, TextField addressTF,
            Text charOnlyReminder, Text numOnlyReminder1, Text numOnlyReminder2, Pane requireNotif ) {


        String inputName = nameTF.getText();
        String inputSaisId = saisIdTF.getText();
        String inputStudentNumber =  studentNumberTF.getText();
        String inputAddress = addressTF.getText();

        boolean isNameCharOnly = Utils.isCharOnly(inputName);
        boolean isSaisIdNumberOnly = Utils.isNumberOnly(inputSaisId);
        boolean isStudentNumberOnly = Utils.isNumberOnly(inputStudentNumber);

        boolean areSomeInputsBlank = inputAddress.isBlank() || inputName.isBlank() || inputSaisId.isBlank() || inputStudentNumber.isBlank();
        boolean areAllInputsValid = !areSomeInputsBlank && isNameCharOnly && isSaisIdNumberOnly && isStudentNumberOnly;

        charOnlyReminder.setVisible(!isNameCharOnly || inputName.isBlank());
        numOnlyReminder1.setVisible(!isSaisIdNumberOnly || inputSaisId.isBlank());
        numOnlyReminder2.setVisible(!isStudentNumberOnly || inputStudentNumber.isBlank());
        requireNotif.setVisible(areSomeInputsBlank);

        charOnlyReminder.setVisible(!isNameCharOnly);
        numOnlyReminder1.setVisible(!isSaisIdNumberOnly);
        numOnlyReminder2.setVisible(!isStudentNumberOnly);

        if (inputStudentNumber.isBlank()) {
            Utils.setStyleWarning(studentNumberTF);
        } else {
            Utils.setStyleNormal(studentNumberTF);
        }

        if (inputName.isBlank()) {
            Utils.setStyleWarning(nameTF);
        } else {
            Utils.setStyleNormal(nameTF);
        }

        if (inputSaisId.isBlank()) {
            Utils.setStyleWarning(saisIdTF);
        } else {
            Utils.setStyleNormal(saisIdTF);
        }

        if (inputAddress.isBlank()) {
            Utils.setStyleWarning(addressTF);
        } else {
            Utils.setStyleNormal(addressTF);
        }

        return areAllInputsValid;



    }
    public static boolean isOutOfRange(String saisId, String studentNumber) {
        try {
            Integer.parseInt(saisId);
            Integer.parseInt(studentNumber);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }


}