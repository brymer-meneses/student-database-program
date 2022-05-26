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
    private Button btnMin;
    @FXML
    private Button saveEdit;

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

    private String currentEditName;
    private int currentEditSaisId;

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

        editCharOnlyReminder.setVisible(!isNameCharOnly);
        editNumOnlyReminder1.setVisible(!isSaisIdNumberOnly);
        editNumOnlyReminder2.setVisible(!isStudentNumberOnly);

        if (inputStudentNumber.isBlank()) {
            editNumOnlyReminder2.setVisible(true);
            Utils.setStyleWarning(editStudentNumberTextField);
        } else {
            editNumOnlyReminder2.setVisible(false);
            Utils.setStyleNormal(editStudentNumberTextField);
        }

        if (inputName.isBlank()) {
            editCharOnlyReminder.setVisible(true);
            Utils.setStyleWarning(editNameTextField);
        } else {
            editCharOnlyReminder.setVisible(false);
            Utils.setStyleNormal(editNameTextField);
        }

        if (inputSaisId.isBlank()) {
            editNumOnlyReminder1.setVisible(true);
            Utils.setStyleWarning(editSaisIdTextField);
        } else {
            editNumOnlyReminder1.setVisible(false);
            Utils.setStyleNormal(editSaisIdTextField);
        }

        if (inputAddress.isBlank()) {
            Utils.setStyleWarning(editAddressTextField);
        } else {
            Utils.setStyleNormal(editAddressTextField);
        }

        if (areAllInputsValid) {
            StudentDB database = StudentDB.readSavedData();
            StudentData newStudent = new StudentData(inputName, Integer.parseInt(inputSaisId), Integer.parseInt(inputStudentNumber), inputAddress);

            DialogBox dialogBox = new DialogBox();

            boolean isNewEntryDuplicate = database.isDuplicateOfDatabase(newStudent);

            if (isNewEntryDuplicate) {
                dialogBox.setConfirmButtonAction(()->{
                    editSaisIdTextField.clear();
                    editNameTextField.clear();
                    editAddressTextField.clear();
                    editStudentNumberTextField.clear();
                });
                dialogBox.load("warn_duplicate_for_edit");
            } else {
                dialogBox.setConfirmButtonAction(()->{
                    database.setCurrentEdit(inputName, Integer.parseInt(inputSaisId), Integer.parseInt(inputStudentNumber), inputAddress);
                    database.editData(currentEditName, currentEditSaisId);

                    editSaisIdTextField.clear();
                    editNameTextField.clear();
                    editAddressTextField.clear();
                    editStudentNumberTextField.clear();

                    // refresh contents
                    populateEntries("edit");
                });
                dialogBox.load("confirm_edit");
            }

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

        if (inputStudentNumber.isBlank()) {
            addNumOnlyReminder2.setVisible(true);
            Utils.setStyleWarning(addStudentNumberTextField);
        } else {
            addNumOnlyReminder2.setVisible(false);
            Utils.setStyleNormal(addStudentNumberTextField);
        }

        if (inputName.isBlank()) {
            addCharOnlyReminder.setVisible(true);
            Utils.setStyleWarning(addNameTextField);
        } else {
            addCharOnlyReminder.setVisible(false);
            Utils.setStyleNormal(addNameTextField);
        }

        if (inputSaisId.isBlank()) {
            addNumOnlyReminder1.setVisible(true);
            Utils.setStyleWarning(addSaisIdTextField);
        } else {
            addNumOnlyReminder1.setVisible(false);
            Utils.setStyleNormal(addSaisIdTextField);
        }

        if (inputAddress.isBlank()) {
            Utils.setStyleWarning(addAddressTextField);
        } else {
            Utils.setStyleNormal(addAddressTextField);
        }
        
        if (Utils.isCharOnly(inputName)) {
            addCharOnlyReminder.setVisible(false);
        } else {
            addCharOnlyReminder.setVisible(true);
        }

        if (Utils.isNumberOnly(inputSaisId)) {
            addNumOnlyReminder1.setVisible(false);
        } else {
            addNumOnlyReminder1.setVisible(true);
        }

        if (Utils.isNumberOnly(inputStudentNumber)) {
            addNumOnlyReminder2.setVisible(false);
        } else {
            addNumOnlyReminder2.setVisible(true);
        }


        if (areAllInputsValid) {

            DialogBox dialogBox = new DialogBox();
            StudentDB database = StudentDB.readSavedData();
            StudentData student = new StudentData(inputName, Integer.parseInt(inputSaisId),
                    Integer.parseInt(inputStudentNumber), inputAddress);

            if (database.isDuplicateOfDatabase(student)) {
                dialogBox.setConfirmButtonAction(()-> {
                    addNameTextField.clear();
                    addStudentNumberTextField.clear();
                    addAddressTextField.clear();
                    addSaisIdTextField.clear();
                });
                dialogBox.load("warn_duplicate_for_add");
                return;
            }

            if (database.length() + 1 > database.maxStorageLength) {
                dialogBox.setConfirmButtonAction(()-> {
                    addNameTextField.clear();
                    addStudentNumberTextField.clear();
                    addAddressTextField.clear();
                    addSaisIdTextField.clear();
                });
                dialogBox.load("warn_overflow");
            } else {

                dialogBox.setConfirmButtonAction(()-> {
                    addNameTextField.clear();
                    addStudentNumberTextField.clear();
                    addAddressTextField.clear();
                    addSaisIdTextField.clear();
                    database.addData(student);
                });

                dialogBox.load("notif_add_success");
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
                        saveEdit.setDisable(false);
                        editAddressTextField.setText(address);
                        editNameTextField.setText(name);
                        editSaisIdTextField.setText(String.valueOf(saisId));
                        editStudentNumberTextField.setText(String.valueOf(studentNumber));

                        currentEditName = name;
                        currentEditSaisId = saisId;
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

    public void changePage(String paneName) {

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
                saveEdit.setDisable(true);
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
        String clickedButtonId = clickedButton.getId();
        Stage stage = (Stage) btnMin.getScene().getWindow();

        switch (clickedButtonId) {
            case "btnMin":
                stage.setIconified(true);
                break;
            case "btnClose":
                stage.close();
                break;
            case "btnView":
                changePage("view");
                break;
            case "btnHome":
                changePage("home");
                break;
            case "btnEdit":
                changePage("edit");
                saveEdit.setDisable(true);
                break;
            case "btnAdd":
                changePage("add");
                break;
            case "btnSearch":
                changePage("search");
                break;
            case "btnDelete":
                changePage("delete");
                break;
            case "saveAdd":
                handleAdd();
                break;
            case "saveEdit":
                handleEdit();
                break;

        }
    }


    @FXML
    public void keyPress(ActionEvent actionEvent) {
        searchContent.setVisible(true);
        handleSearch(searchField.getText());
    }
}
