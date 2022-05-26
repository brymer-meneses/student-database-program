package MP;

import MP.components.DatabaseEntry;
import MP.components.DialogBox;
import MP.core.LinkedList;

import MP.interfaces.Callback;
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
    private Button btnHome, btnView, btnAdd, btnDelete, btnEdit, btnSearch, btnHelp;

    @FXML
    private Button saveAdd, saveEdit;

    @FXML
    private Pane homePane, viewPane, addPane, deletePane, editPane, searchPane, helpPane;

    @FXML
    private VBox viewEntries, searchEntries, editEntries, deleteEntries;

    @FXML
    private ScrollPane searchContent;

    @FXML
    private TextField searchField;

    @FXML
    private Pane nothingMatchedDialog, editRequireNotif, addRequireNotif;

    @FXML
    private Text editCharOnlyReminder, editNumOnlyReminder1, editNumOnlyReminder2;

    @FXML
    private Text addCharOnlyReminder, addNumOnlyReminder1, addNumOnlyReminder2;

    @FXML
    public TextField addSaisIdTextField, addStudentNumberTextField, addNameTextField, addAddressTextField;
    @FXML
    public TextField editSaisIdTextField, editStudentNumberTextField, editNameTextField, editAddressTextField;

    public void handleEdit() {
        String inputName = editNameTextField.getText();
        String inputSaisId = editSaisIdTextField.getText();
        String inputStudentNumber =  editStudentNumberTextField.getText();
        String inputAddress = editAddressTextField.getText();

        boolean isNameCharOnly = Utils.isCharOnly(inputName);
        boolean isSaisIdNumberOnly = Utils.isNumberOnly(inputSaisId);
        boolean isStudentNumberOnly = Utils.isNumberOnly(inputStudentNumber);

        boolean areSomeInputsBlank = inputAddress.isBlank() || inputName.isBlank() || inputSaisId.isBlank() || inputStudentNumber.isBlank();
        boolean areAllInputsValid = !areSomeInputsBlank && isNameCharOnly && isSaisIdNumberOnly && isStudentNumberOnly;

        editCharOnlyReminder.setVisible(!isNameCharOnly || inputName.isBlank());
        editNumOnlyReminder1.setVisible(!isSaisIdNumberOnly || inputSaisId.isBlank());
        editNumOnlyReminder2.setVisible(!isStudentNumberOnly || inputStudentNumber.isBlank());
        editRequireNotif.setVisible(areSomeInputsBlank);


        if (inputStudentNumber.isBlank()) {
            editNumOnlyReminder1.setVisible(false);
            Utils.setStyleWarning(addStudentNumberTextField);
        } else {
            Utils.setStyleNormal(addAddressTextField);
        }

        if (inputName.isBlank()) {
            editCharOnlyReminder.setVisible(false);
            Utils.setStyleWarning(addNameTextField);
        } else {
            Utils.setStyleNormal(addNameTextField);
        }

        if (inputSaisId.isBlank()) {
            editNumOnlyReminder1.setVisible(false);
            Utils.setStyleWarning(addSaisIdTextField);
        } else {
            Utils.setStyleNormal(addSaisIdTextField);
        }

        if (inputAddress.isBlank()) {
            Utils.setStyleWarning(addAddressTextField);
        } else {
            Utils.setStyleNormal(addAddressTextField);
        }

        if (areAllInputsValid) {
            StudentDB database = StudentDB.readSavedData();


            DialogBox dialogBox = new DialogBox();
            dialogBox.setConfirmButtonAction(()->{
                database.setCurrentEdit(inputName, Integer.parseInt(inputSaisId), Integer.parseInt(inputStudentNumber), inputAddress);
                database.editData(inputName, Integer.parseInt(inputSaisId));

                editSaisIdTextField.clear();
                editNameTextField.clear();
                editAddressTextField.clear();
                editNameTextField.clear();
            });
            dialogBox.load("confirm_edit");

        }


    }

    public void handleAdd() {
        String inputName = addNameTextField.getText();
        String inputSaisId = addSaisIdTextField.getText();
        String inputStudentNumber = addStudentNumberTextField.getText();
        String inputAddress = addAddressTextField.getText();

        boolean isNameCharOnly = Utils.isCharOnly(inputName);
        boolean isSaisIdNumberOnly = Utils.isNumberOnly(inputSaisId);
        boolean isStudentNumberOnly = Utils.isNumberOnly(inputStudentNumber);

        boolean areSomeInputsBlank = inputAddress.isBlank() || inputName.isBlank() || inputSaisId.isBlank() || inputStudentNumber.isBlank();
        boolean areAllInputsValid = !areSomeInputsBlank && isNameCharOnly && isSaisIdNumberOnly && isStudentNumberOnly;

        addCharOnlyReminder.setVisible(!isNameCharOnly || inputName.isBlank());
        addNumOnlyReminder1.setVisible(!isSaisIdNumberOnly || inputSaisId.isBlank());
        addNumOnlyReminder2.setVisible(!isStudentNumberOnly || inputStudentNumber.isBlank());
        addRequireNotif.setVisible(areSomeInputsBlank);

        if (inputName.isBlank()) {
            editCharOnlyReminder.setVisible(false);
            Utils.setStyleWarning(addNameTextField);
        } else {
            Utils.setStyleNormal(addNameTextField);
        }

        if (inputSaisId.isBlank()) {
            editNumOnlyReminder1.setVisible(false);
            Utils.setStyleWarning(addSaisIdTextField);
        } else {

            if (inputStudentNumber.isBlank()) {
                editNumOnlyReminder2.setVisible(false);
                Utils.setStyleWarning(addStudentNumberTextField);
            } else {
                Utils.setStyleNormal(addAddressTextField);
            }

            if (inputAddress.isBlank()) {
                Utils.setStyleWarning(addAddressTextField);
            } else {
                Utils.setStyleNormal(addAddressTextField);
            }

        }


        if (areAllInputsValid) {

            DialogBox dialogBox = new DialogBox();
            StudentDB database = StudentDB.readSavedData();
            StudentData student = new StudentData(inputName, Integer.parseInt(inputSaisId),
                    Integer.parseInt(inputStudentNumber), inputAddress);

            if (database.isDuplicateOfDatabase(student)) {
                dialogBox.load("warn_duplicate", student);
            } else if (database.length() + 1 > database.maxStorageLength) {
                dialogBox.load("warn_overflow", student);
            } else {
                dialogBox.load("notif_add_success", student);

                dialogBox.setConfirmButtonAction(()-> {
                    addNameTextField.clear();
                    addStudentNumberTextField.clear();
                    addAddressTextField.clear();
                    addSaisIdTextField.clear();
                    database.addData(student);
                });
            }


        }
    }

    public void populateEntries(String location) {
        StudentDB database = StudentDB.readSavedData();

        viewEntries.getChildren().clear();
        editEntries.getChildren().clear();
        deleteEntries.getChildren().clear();

        for (int i = 0; i < database.length(); i++) {
            String name = database.getData(i).name;
            int studentNumber = database.getData(i).studentNumber;
            int saisId = database.getData(i).saisId;
            String address = database.getData(i).address;

            switch (location) {
                case "view":
                    DatabaseEntry viewEntry = new DatabaseEntry("view", database.getData(i));
                    viewEntries.getChildren().add(viewEntry);
                    break;
                case "edit":
                    DatabaseEntry editEntry = new DatabaseEntry("edit", database.getData(i));

                    editEntry.setButtonAction(() -> {
                        editAddressTextField.setText(address);
                        editNameTextField.setText(name);
                        editSaisIdTextField.setText(String.valueOf(saisId));
                        editStudentNumberTextField.setText(String.valueOf(studentNumber));
                    });
                    editEntries.getChildren().add(editEntry);

                    break;
                case "delete":
                    DatabaseEntry deleteEntry = new DatabaseEntry("delete", database.getData(i));

                    deleteEntry.setButtonAction(()-> {
                        DialogBox dialogBox = new DialogBox();
                        dialogBox.setConfirmButtonAction(()-> {
                            database.deleteData(name, saisId);
                            deleteEntries.getChildren().remove(deleteEntry);
                        });
                        dialogBox.load("confirm_delete", new StudentData(name, saisId, studentNumber, address));
                    });

                    deleteEntries.getChildren().add(deleteEntry);
                    break;
            }
        }
    }

    public void handleSearch(String searchKeyword) {

        StudentDB database = StudentDB.readSavedData();
        LinkedList<StudentData> results = database.searchData(searchKeyword);

        searchEntries.getChildren().clear();

        if (results.length == 0) {
            nothingMatchedDialog.setVisible(true);
            searchContent.setVisible(false);
        } else if (results.length > 0) {

            nothingMatchedDialog.setVisible(false);
            searchContent.setVisible(true);

            for (int i = 0; i < results.length; i++) {
                DatabaseEntry entry = new DatabaseEntry("search", results.get(i));

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
                populateEntries("view");
                viewPane.setVisible(true);
                break;
            case "add":
                addPane.setVisible(true);
                break;
            case "search":
                searchPane.setVisible(true);
                break;
            case "delete":
                populateEntries("delete");
                deletePane.setVisible(true);
                break;
            case "edit":
                populateEntries("edit");
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
            navigateTo("view");
        } else if (clickedButton == btnHome) {
            navigateTo("home");
        } else if (clickedButton == btnEdit) {
            navigateTo("edit");
        } else if (clickedButton == btnAdd) {
            navigateTo("add");
        } else if (clickedButton == btnSearch) {
            navigateTo("search");
        } else if (clickedButton == btnDelete) {
            navigateTo("delete");
        } else if (clickedButton == btnHelp) {
            navigateTo("help");
        }

        if (clickedButton == saveAdd) {
            handleAdd();
        } else if (clickedButton == saveEdit) {
            handleEdit();
        }

    }


    @FXML
    public void keyPress(ActionEvent actionEvent) {
        searchContent.setVisible(true);
        handleSearch(String.valueOf(searchField.getText()));
    }
}
