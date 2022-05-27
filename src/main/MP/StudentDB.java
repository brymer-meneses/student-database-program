package MP;

import java.io.Serializable;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import MP.components.DatabaseEntry;
import MP.components.DialogBox;

import MP.interfaces.DBInterface;
import MP.interfaces.Callback;

public class StudentDB implements Serializable, DBInterface {

    private Database database;
    public final  int maxStorageLength = 10;
    private final static String databasePath = "database.dat";
    private final static boolean shouldSaveChanges = true;

    @FXML private Button btnMin;
    @FXML private Button saveEdit;

    @FXML private Pane homePane, viewPane, addPane, deletePane, editPane, searchPane, helpPane;

    @FXML private VBox viewEntries, searchEntries, editEntries, deleteEntries;

    @FXML private ScrollPane searchContent;

    @FXML private TextField searchField;

    @FXML private Pane nothingMatchedDialog, editRequireNotif, addRequireNotif;

    @FXML private Text editCharOnlyReminder, editNumOnlyReminder1, editNumOnlyReminder2;

    @FXML private Text addCharOnlyReminder, addNumOnlyReminder1, addNumOnlyReminder2;

    @FXML public TextField addSaisIdTextField, addStudentNumberTextField, addNameTextField, addAddressTextField;
    @FXML public TextField editSaisIdTextField, editStudentNumberTextField, editNameTextField, editAddressTextField;

    private String currentEditName;
    private int currentEditSaisId;

    private void populateEntries(String page) {
        editEntries.getChildren().clear();
        deleteEntries.getChildren().clear();

        for (int i = 0; i < database.length; i++) {
            String name = database.get(i).name;
            int studentNumber = database.get(i).studentNumber;
            int saisId = database.get(i).saisId;
            String address = database.get(i).address;

            switch (page) {
                case "edit":
                    DatabaseEntry editEntry = new DatabaseEntry("edit", database.get(i));

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
                    DatabaseEntry deleteEntry = new DatabaseEntry("delete", database.get(i));

                    deleteEntry.setButtonAction(()-> {
                        DialogBox dialogBox = new DialogBox();
                        dialogBox.setConfirmButtonAction(()-> {

                            deleteData(name, saisId);
                            deleteEntries.getChildren().remove(deleteEntry);
                        });
                        dialogBox.load("confirm_delete", new StudentData(name, saisId, studentNumber, address));
                    });

                    deleteEntries.getChildren().add(deleteEntry);
                    break;
            }
        }
    }

    private void changePage(String page) {
        homePane.setVisible(false);
        viewPane.setVisible(false);
        addPane.setVisible(false);
        searchPane.setVisible(false);
        deletePane.setVisible(false);
        editPane.setVisible(false);

        switch (page) {
            case "home":
                homePane.setVisible(true);
                break;
            case "view":
                viewEntries.getChildren().clear();
                showData();
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
        }
    }


    public void handleClicks(ActionEvent actionEvent) {
        database = Database.readSavedFile();

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
                editData(currentEditName, currentEditSaisId);
                break;

        }

    }

    public void keyPress(ActionEvent actionEvent) {
        searchContent.setVisible(true);
        searchData(searchField.getText());
    }

    public void handleAdd() {
        boolean areAllInputsValid = Utils.validateInputs(addNameTextField, addSaisIdTextField, addStudentNumberTextField,
                addAddressTextField, addCharOnlyReminder, addNumOnlyReminder1, addNumOnlyReminder2, addRequireNotif);
        if (areAllInputsValid) {

            String inputName = addNameTextField.getText();
            String inputAddress = addAddressTextField.getText();
            int inputSaisId = Integer.parseInt(addSaisIdTextField.getText());
            int inputStudentNumber =  Integer.parseInt(addStudentNumberTextField.getText());

            DialogBox dialogBox = new DialogBox();
            StudentData student = new StudentData(inputName, inputSaisId, inputStudentNumber, inputAddress);

            Callback clearTextFields = () -> {
                addNameTextField.clear();
                addStudentNumberTextField.clear();
                addAddressTextField.clear();
                addSaisIdTextField.clear();
            };

            if (Utils.isDuplicate(database,student)) {
                dialogBox.setConfirmButtonAction(clearTextFields);
                dialogBox.load("warn_duplicate_for_add");
                return;
            }

            if (database.length + 1 > maxStorageLength) {
                dialogBox.setConfirmButtonAction(clearTextFields);
                dialogBox.load("warn_overflow");
            } else {

                dialogBox.setConfirmButtonAction(()-> {
                    clearTextFields.call();
                    addData(student);
                });

                dialogBox.load("notif_add_success");
            }


        }
    }
    @Override
    public boolean addData(StudentData dbd) {

        if (Utils.isDuplicate(database, dbd)) {
            return false;
        }
        if (database.length + 1 > maxStorageLength) {
            return false;
        }
        database.append(dbd);
        database.writeChangesToFile();
        return  true;

    }

    @Override
    public boolean deleteData(String name, int SAISID) {
        for (int i=0; i<database.length; i++) {
            StudentData element = database.get(i);
            if (element.name.equals(name) && element.saisId == SAISID) {

                database.delete(i);
                database.writeChangesToFile();

                return true;
            }
        }
        return false;
    }

    @Override
    public void searchData(String toSearch) {
        searchEntries.getChildren().clear();

        for (int i=0; i<database.length; i++) {
            StudentData element = database.get(i);

            if (Utils.keywordInEntries(database.get(i), toSearch)) {
                DatabaseEntry entry = new DatabaseEntry("search", element);
                searchEntries.getChildren().add(entry);
            }

        }
        return;
    }

    @Override
    public void showData() {

        for (int i=0; i<database.length; i++) {
            DatabaseEntry entry = new DatabaseEntry("view", database.get(i));
            viewEntries.getChildren().add(entry);
        }

        return;
    }

    @Override
    public boolean editData(String name, int SAISID) {

        boolean areAllInputsValid = Utils.validateInputs(editNameTextField, editSaisIdTextField, editStudentNumberTextField, editAddressTextField,
                editCharOnlyReminder, editNumOnlyReminder1, editNumOnlyReminder2, editRequireNotif );

        if (areAllInputsValid) {

            String updatedName = editNameTextField.getText();
            String updatedAddress = editAddressTextField.getText();
            int updatedSaisId = Integer.parseInt(editSaisIdTextField.getText());
            int updatedStudentNumber =  Integer.parseInt(editStudentNumberTextField.getText());

            StudentData updatedStudent = new StudentData(updatedName, updatedSaisId, updatedStudentNumber, updatedAddress);

            boolean isNewEntryDuplicate = Utils.isDuplicate(database, updatedStudent);

            DialogBox dialogBox = new DialogBox();

            Callback clearEditTextFields = () -> {
                editSaisIdTextField.clear();
                editNameTextField.clear();
                editAddressTextField.clear();
                editStudentNumberTextField.clear();
            };
            Callback saveNewUpdates = () -> {
                for (int i=0; i< database.length; i++) {
                    StudentData element = database.get(i);
                    if (element.name.equals(name) && element.saisId == SAISID) {
                        element.name = updatedName;
                        element.saisId = updatedSaisId;
                        element.address = updatedAddress;
                        element.studentNumber = updatedStudentNumber;
                    }
                }
            };


            if (isNewEntryDuplicate) {
                dialogBox.setConfirmButtonAction(clearEditTextFields);
                dialogBox.load("warn_duplicate_for_edit");
                return false;
            } else {
                dialogBox.setConfirmButtonAction(()->{
                    clearEditTextFields.call();
                    saveNewUpdates.call();
                    populateEntries("edit");
                });
                dialogBox.load("confirm_edit");
                return true;
            }

        }

        return false;
    }
}