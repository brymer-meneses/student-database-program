package MP;

import MP.components.DatabaseEntry;
import MP.components.DialogBox;
import MP.core.LinkedList;

import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.fxml.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;

public class DashController {

    @FXML
    private Button btnMin, btnClose;

    @FXML
    private Button btnHome, btnView, btnAdd, btnDelete, btnEdit, btnSearch, btnHelp, btnOK, btnDialogclose;

    @FXML
    private Button saveAdd;

    @FXML
    private Pane homePane, viewPane, addPane, deletePane, editPane, searchPane, helpPane;

    @FXML
    private VBox viewEntries, searchEntries, editEntries, deleteEntries;

    @FXML
    private ScrollPane searchContent;

    @FXML
    private TextField searchField;

    @FXML
    private Pane nothingMatchedDialog, requireNotif;

    @FXML
    private Text charOnly1, charOnly1a, numOnly1, numOnly2;

    @FXML
    public TextField addSaisIdTextField, saisIdTextFielda, addStudentNumberTextField,
            studentNumberTextFielda, addNameTextField, addAddressTextField;

    public void handleAdd() {
        String inputName = addNameTextField.getText();
        String inputSAIS = addSaisIdTextField.getText();
        String inputStudentNumber = addStudentNumberTextField.getText();
        String inputAddress = addAddressTextField.getText();

        StudentData student = new StudentData(inputName, Integer.parseInt(inputSAIS), Integer.parseInt(inputStudentNumber), inputAddress);
        DialogBox dialogBox = new DialogBox();

        if (!inputName.matches("[a-zA-Z\\s]+") && inputName.length() > 0) {
            charOnly1.setVisible(true);
        }
        if (!inputSAIS.matches("[0-9]+") && inputSAIS.length() > 0) {
            numOnly1.setVisible(true);
        }
        if (!inputStudentNumber.matches("[0-9]+") && inputStudentNumber.length() > 0) {
            numOnly2.setVisible(true);
        }
        if (inputName.matches("[a-zA-Z\\s]+")) {
            charOnly1.setVisible(false);
        }
        if (inputSAIS.matches("[0-9s]+")) {
            numOnly1.setVisible(false);
        }

        if (inputStudentNumber.matches("[0-9s]+")) {
            numOnly2.setVisible(false);
        }

        if (inputStudentNumber.length() > 0) {
            addStudentNumberTextField
                    .setStyle("-fx-border-color: #6a7281;-fx-border-radius: 5; -fx-background-color: #1a1d20;");
        }

        if (inputName.length() > 0) {
            addNameTextField.setStyle("-fx-border-color: #6a7281;-fx-border-radius: 5; -fx-background-color: #1a1d20;");
        }

        if (inputSAIS.length() > 0) {
            addSaisIdTextField.setStyle("-fx-border-color: #6a7281;-fx-border-radius: 5; -fx-background-color: #1a1d20;");
        }

        if (inputAddress.length() > 0) {
            addAddressTextField.setStyle("-fx-border-color: #6a7281;-fx-border-radius: 5; -fx-background-color: #1a1d20;");
        }

        if (inputAddress.length() == 0 || inputName.length() == 0 || inputSAIS.length() == 0
                || inputStudentNumber.length() == 0) {
            requireNotif.setVisible(true);
        }

        if (inputAddress.length() == 0) {
            addAddressTextField.setStyle("-fx-border-color: #ff6767;-fx-border-radius: 5; -fx-background-color: #1a1d20;");
        }

        if (inputName.length() == 0) {
            charOnly1.setVisible(false);
            addNameTextField.setStyle("-fx-border-color: #ff6767;-fx-border-radius: 5; -fx-background-color: #1a1d20;");
        }

        if (inputSAIS.length() == 0) {
            numOnly1.setVisible(false);
            addSaisIdTextField.setStyle("-fx-border-color: #ff6767;-fx-border-radius: 5; -fx-background-color: #1a1d20;");
        }

        if (inputStudentNumber.length() == 0) {
            numOnly2.setVisible(false);
            addStudentNumberTextField
                    .setStyle("-fx-border-color: #ff6767;-fx-border-radius: 5; -fx-background-color: #1a1d20;");
        }

        if (inputAddress.length() > 0 && inputName.length() > 0 && inputSAIS.length() > 0 && inputStudentNumber.length() > 0)

        {
            requireNotif.setVisible(false);
        }

        if (inputAddress.length() > 0 && inputName.length() > 0 && inputSAIS.length() > 0 && inputStudentNumber.length() > 0
                && inputName.matches("[a-zA-Z\\s]+") && inputSAIS.matches("[0-9s]+") &&
                inputStudentNumber.matches("[0-9s]+")) {
            StudentDB database = StudentDB.readSavedData();
            System.out.println(inputName);
            System.out.println(inputAddress);
            StudentData element = new StudentData(inputName, Integer.parseInt(inputSAIS),
                    Integer.parseInt(inputStudentNumber), inputAddress);

            if (database.length() == 10) {
                dialogBox.load("warn_overflow", student);
                return;
            }

            if (database.isDuplicateOfDatabase(element)) {
                dialogBox.load("notif_added", student);
                return;
            }

            else if (database.length() < 10) {
                dialogBox.load("notif_add_success", student);
                addNameTextField.clear();
                addStudentNumberTextField.clear();
                addAddressTextField.clear();
                addSaisIdTextField.clear();
                database.addData(element);
            }
        }
    }

    public void showEntriesIn(String location) {
        StudentDB database = StudentDB.readSavedData();
        LinkedList<StudentData> students = database.showData();
        viewEntries.getChildren().clear();
        editEntries.getChildren().clear();
        deleteEntries.getChildren().clear();

        DatabaseEntry entry;
        for (int i = 0; i < database.length(); i++) {

            switch (location) {
                case "view":
                    entry = new DatabaseEntry("view", database.getData(i), viewEntries);
                    viewEntries.getChildren().add(entry);
                    break;
                case "edit":
                    entry = new DatabaseEntry("edit", database.getData(i), editEntries);
                    editEntries.getChildren().add(entry);
                    break;
                case "delete":
                    entry = new DatabaseEntry("delete", database.getData(i),deleteEntries);
                    deleteEntries.getChildren().add(entry);
                    break;
            }
        }
    }

    public void handleSearch(String searchKeyword) {

        StudentDB database = StudentDB.readSavedData();
        LinkedList<StudentData> results = database.searchData(searchKeyword);

        if (results.length == 0) {
            nothingMatchedDialog.setVisible(true);
            searchContent.setVisible(false);
        } else if (results.length > 0) {
            searchEntries.getChildren().clear();

            nothingMatchedDialog.setVisible(false);
            searchContent.setVisible(true);

            for (int i = 0; i < results.length; i++) {
                DatabaseEntry entry = new DatabaseEntry("search", database.getData((i)), searchEntries);

                searchEntries.getChildren().add(entry);
            }
        }

    }

    public void navigateTo(String paneName) {

        homePane.setVisible(false);
        viewPane.setVisible(false);
        addPane.setVisible(false);
        searchPane.setVisible(false);
        deletePane.setVisible(false);
        editPane.setVisible(false);
        helpPane.setVisible(false);

        switch (paneName) {
            case "home":
                homePane.setVisible(true);
                break;
            case "view":
                viewPane.setVisible(true);
                break;
            case "add":
                addPane.setVisible(true);
                break;
            case "search":
                searchPane.setVisible(true);
                break;
            case "delete":
                deletePane.setVisible(true);
                break;
            case "edit":
                editPane.setVisible(true);
                break;
            case "help":
                helpPane.setVisible(true);
                break;
        }
    }

    @FXML
    public void handleClicks(ActionEvent actionEvent) {

        Button clickedButton = (Button) actionEvent.getSource();

        if (clickedButton == btnMin) {
            Stage stage = (Stage) btnMin.getScene().getWindow();
            stage.setIconified(true);
        } else if (clickedButton == btnClose) {
            Stage stage = (Stage) btnClose.getScene().getWindow();
            stage.close();
        }

        if (clickedButton == btnView) {
            showEntriesIn("view");
            navigateTo("view");
        } else if (clickedButton == btnHome) {
            navigateTo("home");
        } else if (clickedButton == btnEdit) {
            showEntriesIn("edit");
            navigateTo("edit");
        } else if (clickedButton == btnAdd) {
            navigateTo("add");
        } else if (clickedButton == btnSearch) {
            navigateTo("search");
        } else if (clickedButton == btnDelete) {
            showEntriesIn("delete");
            navigateTo("delete");
        } else if (clickedButton == btnHelp) {
            // dataGenerator();
            navigateTo("help");
        }

        if (clickedButton == saveAdd) {
            handleAdd();
        }

        if (actionEvent.getSource() == btnOK) {
            Stage stage = (Stage) btnOK.getScene().getWindow();
            stage.close();
        } else if (actionEvent.getSource() == btnDialogclose) {
            Stage stage = (Stage) btnDialogclose.getScene().getWindow();
            stage.close();
        }

    }


    @FXML
    public void keyPress(ActionEvent actionEvent) {
        searchContent.setVisible(true);
        handleSearch(String.valueOf(searchField.getText()));
    }
}
