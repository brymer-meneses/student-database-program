package MP;

import MP.components.DatabaseEntry;
import MP.components.DialogBox;
import MP.linkedList.LinkedList;

import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AppController {

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

    private boolean validateInputs(String inputType) {
        String inputName, inputSaisId, inputStudentNumber, inputAddress;

        Text charOnlyReminder, numOnlyReminder1, numOnlyReminder2;

        TextField nameTextField, saisIdTextField, studentNumberTextField, addressTextField;

        Pane requireNotif;

        if (inputType.equals("edit")) {
            inputName = editNameTextField.getText();
            inputSaisId = editSaisIdTextField.getText();
            inputStudentNumber =  editStudentNumberTextField.getText();
            inputAddress = editAddressTextField.getText();

            charOnlyReminder = editCharOnlyReminder;
            numOnlyReminder1 = editNumOnlyReminder1;
            numOnlyReminder2 = editNumOnlyReminder2;

            requireNotif = editRequireNotif;

            nameTextField = editNameTextField;
            studentNumberTextField = editStudentNumberTextField;
            saisIdTextField = editSaisIdTextField;
            addressTextField = editAddressTextField;

        } else {
            inputName = addNameTextField.getText();
            inputSaisId = addSaisIdTextField.getText();
            inputStudentNumber = addStudentNumberTextField.getText();
            inputAddress = addAddressTextField.getText();

            charOnlyReminder = addCharOnlyReminder;
            numOnlyReminder1 = addNumOnlyReminder1;
            numOnlyReminder2 = addNumOnlyReminder2;

            requireNotif = addRequireNotif;

            nameTextField = addNameTextField;
            studentNumberTextField = addStudentNumberTextField;
            saisIdTextField = addSaisIdTextField;
            addressTextField = addAddressTextField;
        }

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
            Utils.setStyleWarning(studentNumberTextField);
        } else {
            Utils.setStyleNormal(studentNumberTextField);
        }

        if (inputName.isBlank()) {
            Utils.setStyleWarning(nameTextField);
        } else {
            Utils.setStyleNormal(nameTextField);
        }

        if (inputSaisId.isBlank()) {
            Utils.setStyleWarning(saisIdTextField);
        } else {
            Utils.setStyleNormal(saisIdTextField);
        }

        if (inputAddress.isBlank()) {
            Utils.setStyleWarning(addressTextField);
        } else {
            Utils.setStyleNormal(addressTextField);
        }

        return areAllInputsValid;

    }

    public void handleEdit() {

        boolean areAllInputsValid = validateInputs("edit");

        if (areAllInputsValid) {

            String inputName = editNameTextField.getText();
            String inputAddress = editAddressTextField.getText();
            int inputSaisId = Integer.parseInt(editSaisIdTextField.getText());
            int inputStudentNumber =  Integer.parseInt(editStudentNumberTextField.getText());

            StudentDB database = StudentDB.readSavedData();
            StudentData newStudent = new StudentData(inputName, inputSaisId, inputStudentNumber, inputAddress);

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
                    database.setCurrentEdit(inputName, inputSaisId, inputStudentNumber, inputAddress);
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

        boolean areAllInputsValid = validateInputs("add");

        if (areAllInputsValid) {

            String inputName = addNameTextField.getText();
            String inputAddress = addAddressTextField.getText();
            int inputSaisId = Integer.parseInt(addSaisIdTextField.getText());
            int inputStudentNumber =  Integer.parseInt(addStudentNumberTextField.getText());

            DialogBox dialogBox = new DialogBox();
            StudentDB database = StudentDB.readSavedData();
            StudentData student = new StudentData(inputName, inputSaisId, inputStudentNumber, inputAddress);

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

    /**
     *
     * @param location
     */
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

    public void changePage(String page) {

        homePane.setVisible(false);
        viewPane.setVisible(false);
        addPane.setVisible(false);
        searchPane.setVisible(false);
        deletePane.setVisible(false);
        editPane.setVisible(false);
        helpPane.setVisible(false);

        switch (page) {
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
