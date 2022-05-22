package MP;

import MP.StudentDBDemo;
import MP.components.DatabaseEntry;
import MP.core.LinkedList;
import MP.App;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;

import javafx.scene.paint.Color;

public class dashController {

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
    private TextField saisIDTextField, saisIDTextFielda, studentNumberTextField,
            studentNumberTextFielda, nameTextField, addressTextField;

    public void handleAdd() {
        String inputName = nameTextField.getText();
        String inputSAIS = saisIDTextField.getText();
        String inputStunum = studentNumberTextField.getText();
        String inputAddress = addressTextField.getText();

        if (!inputName.matches("[a-zA-Z\\s]+") && inputName.length() > 0) {
            charOnly1.setVisible(true);
        }
        if (!inputSAIS.matches("[0-9\\s]+") && inputSAIS.length() > 0) {
            numOnly1.setVisible(true);
        }
        if (!inputStunum.matches("[0-9\\s]+") && inputStunum.length() > 0) {
            numOnly2.setVisible(true);
        }
        if (inputName.matches("[a-zA-Z\\s]+")) {
            charOnly1.setVisible(false);
        }
        if (inputSAIS.matches("[0-9\\s]+")) {
            numOnly1.setVisible(false);
        }

        if (inputStunum.matches("[0-9\\s]+")) {
            numOnly2.setVisible(false);
        }

        if (inputStunum.length() > 0) {
            studentNumberTextField
                    .setStyle("-fx-border-color: #6a7281;-fx-border-radius: 5; -fx-background-color: #1a1d20;");
        }

        if (inputName.length() > 0) {
            nameTextField.setStyle("-fx-border-color: #6a7281;-fx-border-radius: 5; -fx-background-color: #1a1d20;");
        }

        if (inputSAIS.length() > 0) {
            saisIDTextField.setStyle("-fx-border-color: #6a7281;-fx-border-radius: 5; -fx-background-color: #1a1d20;");
        }

        if (inputAddress.length() > 0) {
            addressTextField.setStyle("-fx-border-color: #6a7281;-fx-border-radius: 5; -fx-background-color: #1a1d20;");
        }

        if (inputAddress.length() == 0 || inputName.length() == 0 || inputSAIS.length() == 0
                || inputStunum.length() == 0) {
            requireNotif.setVisible(true);
        }

        if (inputAddress.length() == 0) {
            addressTextField.setStyle("-fx-border-color: #ff6767;-fx-border-radius: 5; -fx-background-color: #1a1d20;");
        }

        if (inputName.length() == 0) {
            charOnly1.setVisible(false);
            nameTextField.setStyle("-fx-border-color: #ff6767;-fx-border-radius: 5; -fx-background-color: #1a1d20;");
        }

        if (inputSAIS.length() == 0) {
            numOnly1.setVisible(false);
            saisIDTextField.setStyle("-fx-border-color: #ff6767;-fx-border-radius: 5; -fx-background-color: #1a1d20;");
        }

        if (inputStunum.length() == 0) {
            numOnly2.setVisible(false);
            studentNumberTextField
                    .setStyle("-fx-border-color: #ff6767;-fx-border-radius: 5; -fx-background-color: #1a1d20;");
        }

        if (inputAddress.length() > 0 && inputName.length() > 0 && inputSAIS.length() > 0 && inputStunum.length() > 0)

        {
            requireNotif.setVisible(false);
        }

        if (inputAddress.length() > 0 && inputName.length() > 0 && inputSAIS.length() > 0 && inputStunum.length() > 0
                && inputName.matches("[a-zA-Z]+") && inputName.matches("[a-zA-Z]+") &&
                inputName.matches("[a-zA-Z]+")) {
            StudentDB database = StudentDB.readSavedData();
            System.out.println(inputName);
            System.out.println(inputAddress);
            StudentData element = new StudentData(inputName, Integer.parseInt(inputSAIS),
                    Integer.parseInt(inputStunum), inputAddress);

            if (database.length() == 10) {
                dialog("warn_overflow");
                return;
            }

            if (database.isDuplicateOfDatabase(element)) {
                dialog("notif_added");
                return;
            }

            else if (database.length() < 10) {
                dialog("notif_addsuccess");
                nameTextField.clear();
                studentNumberTextField.clear();
                addressTextField.clear();
                saisIDTextField.clear();
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
        for (int i = 0; i < database.length(); i++) {
            DatabaseEntry entry = new DatabaseEntry();

            entry.setData(database.getData(i));
            switch (location) {
                case "view":
                    entry.setButtonFunction(null);
                    viewEntries.getChildren().add(entry);
                    break;
                case "edit":
                    entry.setButtonFunction("edit");
                    editEntries.getChildren().add(entry);
                    break;
                case "delete":
                    entry.setButtonFunction("delete");
                    entry.setParent(deleteEntries);
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
                DatabaseEntry entry = new DatabaseEntry();
                entry.setData(results.get(i));
                entry.setButtonFunction(null);

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

    public void dialog(String pathFXML) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/" + pathFXML + ".fxml"));
        try {
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.initStyle(StageStyle.UNDECORATED);
            stage.showAndWait();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    @FXML
    public void keyPress(ActionEvent actionEvent) {
        searchContent.setVisible(true);
        handleSearch(String.valueOf(searchField.getText()));
    }
}
