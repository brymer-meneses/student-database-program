package MP;

import MP.StudentDBDemo;
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
    private Pane pane10b,
            pane10c, pane10d, pane1b, pane1c, pane1d, pane2b, pane2c, pane2d, pane3d, pane3b, pane3c, pane4b, pane4c,
            pane4d, pane5b, pane5c, pane5d, pane6b, pane6c, pane6d, pane7b, pane7c, pane7d, pane8b, pane8c, pane8d,
            pane9b, pane9c, pane9d, pane10a, pane1a, pane2a, pane3a, pane4a, pane5a, pane6a,
            pane7a, pane8a, pane9a, addPane, deletePane;

    @FXML
    private Text address10a, address10b, address10c, address10d, address1a, address1b, address1c, address1d, address2a,
            address2b, address2c, address2d, address3a, address3b, address3c, address3d, address4a, address4b,
            address4c, address4d, address5a, address5b, address5c, address5d, address6a, address6b, address6c,
            address6d, address7d, address7a, address7b, address7c, address8a, address8b, address8c, address8d,
            address9a, address9b, address9c, address9d;

    @FXML
    private TextField addressTxtfield, addressTxtfielda;

    @FXML
    private Text charOnly1, charOnly1a;

    @FXML
    private Button btnAdd, btnClose, btnDelete, btnEdit, btnHelp, btnHome, btnMin, btnSearch, btnView,
            delete1, delete10, delete2, delete3, delete4, delete5, delete6, delete7, delete8, delete9,
            edit10, edit1, edit2, edit3, edit4, edit5, edit6, edit7, edit8, edit9,
            saveAdd, saveAdd1, saveEdit;

    @FXML
    private Button actionEdit, actionDelete, btnDialogclose, btnOK, searchFunction;

    @FXML
    private Pane editPane, helpPane, homePane;

    @FXML
    private Text name1, name10a, name10b, name10c, name10d, name1a, name1b,
            name1c, name1d, name2a, name2b, name2c, name2d, name3b, name3a, name3c,
            name3d, name4a, name4b, name4c, name4d, name5a, name5b, name5c, name5d, name6a,
            name6b, name6c, name6d, name7a, name7b, name7c, name7d, name8a, name8b,
            name8c, name8d, name9a, name9b, name9c, name9d;

    @FXML
    private TextField nameTxtfield, nameTxtfielda;

    @FXML
    private Text numOnly1, numOnly1a, numOnly2, numOnly2a;

    @FXML
    private Pane requireNotif, requireNotifa;

    @FXML
    private VBox pnItems, pnItems1, pnItems11, pnItems2;

    @FXML
    private Text sais10a, sais10b, sais10d, sais1a, sais1b, sais1c, sais1d,
            sais2a, sais2b, sais2c, sais2d, sais3a, sais3b, sais3c, sais3d, sais4a,
            sais4b, sais4c, sais4d, sais5a, sais5b, sais5c, sais5d, sais6a, sais6b,
            sais6c, sais6d, sais7a, sais7b, sais7c, sais7d, sais8a, sais8b, sais8c,
            sais8d, sais9a, sais9b, sais9c, sais9d, sais10c;

    @FXML
    private TextField saisTxtfield, saisTxtfielda, stunumTxtfield, stunumTxtfielda, searchField;

    @FXML
    private ScrollPane searchContent;

    @FXML
    private Pane searchPane, titlePane, viewPane, nomatchDialog;

    @FXML
    private Text stunum10a, stunum10b, stunum10c, stunum10d, stunum1a, stunum1b,
            stunum1c, stunum1d, stunum2a, stunum2b, stunum2c, stunum2d, stunum3a,
            stunum3b, stunum3c, stunum3d, stunum4a, stunum4b, stunum4c, stunum4d,
            stunum5a, stunum5b, stunum5c, stunum6c, stunum6d, stunum5d, stunum6a,
            stunum6b, stunum7a, stunum7b, stunum7c, stunum7d, stunum8a,
            stunum8b, stunum8c, stunum8d, stunum9a, stunum9b, stunum9c,
            stunum9d;

    @FXML
    private Label addressDelete, nameDelete, saisDelete, stunumDelete;

    @FXML
    private int indexDelete;

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

    };

    @FXML
    public void handleClicks(ActionEvent actionEvent) throws IOException {
        // name1a.setText("SAMPLE1");
        // name1b.setText("SAMPLE1");
        // name1c.setText("SAMPLE1");
        // name1d.setText("SAMPLE1");

        if (actionEvent.getSource() == btnMin) {
            Stage stage = (Stage) btnMin.getScene().getWindow();
            stage.setIconified(true);
        } else if (actionEvent.getSource() == btnClose) {
            Stage stage = (Stage) btnClose.getScene().getWindow();
            stage.close();
        }

        if (actionEvent.getSource() == btnView) {
            dataGenerator();
            navigateTo("view");

        } else if (actionEvent.getSource() == btnHome) {
            navigateTo("home");
        } else if (actionEvent.getSource() == btnEdit) {
            dataGenerator();
            navigateTo("edit");
        } else if (actionEvent.getSource() == btnAdd) {
            dataGenerator();
            navigateTo("add");
        } else if (actionEvent.getSource() == btnSearch) {
            dataGenerator();
            navigateTo("search");
        } else if (actionEvent.getSource() == btnDelete) {
            dataGenerator();
            navigateTo("delete");
        } else if (actionEvent.getSource() == btnHelp) {
            dataGenerator();
            navigateTo("help");
        }

        if (actionEvent.getSource() == saveAdd) {
            addUIFunction();
        } else if (actionEvent.getSource() == searchFunction) {
            searchUIFunction(String.valueOf(searchField.getText()));
        }

        Button[] deleteButtons = { delete1, delete2, delete3, delete4, delete5, delete6, delete7, delete8, delete9,
                delete10 };
        Text[] namesGroupD = { name1d, name2d, name3d, name4d, name5d, name6d, name7d, name8d, name9d, name10d };
        Text[] saisGroupD = { sais1d, sais2d, sais3d, sais4d, sais5d, sais6d, sais7d, sais8d, sais9d, sais10d };
        Text[] stunumGroupD = { stunum1d, stunum2d, stunum3d, stunum4d, stunum5d, stunum6d, stunum7d, stunum8d,
                stunum9d, stunum10d };
        Text[] addressGroupD = { address1d, address2d, address3d, address4d, address5d, address6d, address7d, address8d,
                address9d, address10d };

        for (int i = 0; i < 10; i++) {
            if (actionEvent.getSource() == deleteButtons[i]) {
                this.indexDelete = i;
                String inputName = namesGroupD[i].getText();
                String inputSais = saisGroupD[i].getText();
                String inputStunum = stunumGroupD[i].getText();
                String inputAddress = addressGroupD[i].getText();
                deleteUIFunction(i, inputName, inputSais, inputStunum, inputAddress);
            }
        }

        Button[] editButtons = { edit1, edit2, edit3, edit4, edit5, edit6, edit7, edit8, edit9, edit10 };
        Text[] namesGroupC = { name1c, name2c, name3c, name4c, name5c, name6c, name7c, name8c, name9c, name10c };
        Text[] saisGroupC = { sais1c, sais2c, sais3c, sais4c, sais5c, sais6c, sais7c, sais8c, sais9c, sais10c };
        Text[] stunumGroupC = { stunum1c, stunum2c, stunum3c, stunum4c, stunum5c, stunum6c, stunum7c, stunum8c,
                stunum9d, stunum10d };
        Text[] addressGroupC = { address1c, address2c, address3c, address4c, address5c, address6c, address7c, address8c,
                address9d, address10d };

        for (int i = 0; i < 10; i++) {
            if (actionEvent.getSource() == editButtons[i]) {
                String inputName = namesGroupC[i].getText();
                String inputSais = saisGroupC[i].getText();
                String inputStunum = stunumGroupC[i].getText();
                String inputAddress = addressGroupC[i].getText();
                editUIFunction(i, inputName, inputSais, inputStunum, inputAddress);
            }
        }

        if (actionEvent.getSource() == actionDelete) {
            // dataGenerator();
            StudentDB database = StudentDB.readSavedData();
            Stage stage = (Stage) actionDelete.getScene().getWindow();
            stage.close();

            database.deleteData(database.getData(indexDelete).name, database.getData(indexDelete).saisID);

            System.out.println(indexDelete);
            dialog("notif_deleted");// testline
            // update entries
        } else if (actionEvent.getSource() == actionEdit) {
            Stage stage = (Stage) actionEdit.getScene().getWindow();
            stage.close();
            dialog("notif_savedchanges");// testline
            // overwrite changes
            // dialog("notif_savedchanges");
            // update entries
        }

        if (actionEvent.getSource() == saveEdit) {
            saveEditFunction();
        } else if (actionEvent.getSource() == btnOK) {
            Stage stage = (Stage) btnOK.getScene().getWindow();
            stage.close();
            dataGenerator();
        } else if (actionEvent.getSource() == btnDialogclose) {
            Stage stage = (Stage) btnDialogclose.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    public void keyPress(ActionEvent event) throws IOException {
        searchContent.setVisible(true);
        searchUIFunction(String.valueOf(searchField.getText()));
    }

    public void dataGenerator() {
        StudentDB database = StudentDB.readSavedData();

        Pane[] panesA = { pane1a, pane2a, pane3a, pane4a, pane5a, pane6a, pane7a, pane8a, pane9a, pane10a };
        Text[] containNameA = { name1a, name2a, name3a, name4a, name5a, name6a, name7a, name8a, name9a, name10a };
        Text[] containSaisA = { sais1a, sais2a, sais3a, sais4a, sais5a, sais6a, sais7a, sais8a, sais9a, sais10a };
        Text[] containStunumA = { stunum1a, stunum2a, stunum3a, stunum4a, stunum5a, stunum6a, stunum7a, stunum8a,
                stunum9a, stunum10a };
        Text[] containAddressA = { address1a, address2a, address3a, address4a, address5a, address6a, address7a,
                address8a, address9a, address10a };

        Pane[] panesC = { pane1c, pane2c, pane3c, pane4c, pane5c, pane6c, pane7c, pane8c, pane9c, pane10c };
        Text[] containNameC = { name1c, name2c, name3c, name4c, name5c, name6c, name7c, name8c, name9c, name10c };
        Text[] containSaisC = { sais1c, sais2c, sais3c, sais4c, sais5c, sais6c, sais7c, sais8c, sais9c, sais10c };
        Text[] containStunumC = { stunum1c, stunum2c, stunum3c, stunum4c, stunum5c, stunum6c, stunum7c, stunum8c,
                stunum9c, stunum10c };
        Text[] containAddressC = { address1c, address2c, address3c, address4c, address5c, address6c, address7c,
                address8c, address9c, address10c };

        Pane[] panesD = { pane1d, pane2d, pane3d, pane4d, pane5d, pane6d, pane7d, pane8d, pane9d, pane10d };
        Text[] containNameD = { name1d, name2d, name3d, name4d, name5d, name6d, name7d, name8d, name9d, name10d };
        Text[] containSaisD = { sais1d, sais2d, sais3d, sais4d, sais5d, sais6d, sais7d, sais8d, sais9d, sais10d };
        Text[] containStunumD = { stunum1d, stunum2d, stunum3d, stunum4d, stunum5d, stunum6d, stunum7d, stunum8d,
                stunum9d, stunum10d };
        Text[] containAddressD = { address1d, address2d, address3d, address4d, address5d, address6d, address7d,
                address8d, address9d, address10d };

        Button[] deleteArray = { delete1, delete2, delete3, delete4, delete5, delete6, delete7, delete8, delete9,
                delete10 };
        Button[] editArray = { edit1, edit2, edit3, edit4, edit5, edit6, edit7, edit8, edit9, edit10 };

        for (int i = 0; i < 10; i++) {
            panesA[i].setVisible(false);
            panesC[i].setVisible(false);
            panesD[i].setVisible(false);

            // containNameA[i].setText("...loading data...");
            // containSaisA[i].setText("...loading data...");
            // containStunumA[i].setText("...loading data...");
            // containAddressA[i].setText("...loading data...");

            // containNameC[i].setText("...loading data...");
            // containSaisC[i].setText("...loading data...");
            // containStunumC[i].setText("...loading data...");
            // containAddressC[i].setText("...loading data...");

            // containNameD[i].setText("...loading data...");
            // containSaisD[i].setText("...loading data...");
            // containStunumD[i].setText("...loading data...");
            // containAddressD[i].setText("...loading data...");
        }

        int dataLoad = database.length();

        for (int i = 0; i < dataLoad; i++) {
            panesA[i].setVisible(true);
            panesC[i].setVisible(true);
            panesD[i].setVisible(true);

            StudentData element = database.getData(i);

            containNameA[i].setText(String.valueOf(element.name));
            containSaisA[i].setText(String.valueOf(element.saisID));
            containStunumA[i].setText(String.valueOf(element.studentNumber));
            containAddressA[i].setText(String.valueOf(element.address));

            containNameC[i].setText(String.valueOf(element.name));
            containSaisC[i].setText(String.valueOf(element.saisID));
            containStunumC[i].setText(String.valueOf(element.studentNumber));
            containAddressC[i].setText(String.valueOf(element.address));

            containNameD[i].setText(String.valueOf(element.name));
            containSaisD[i].setText(String.valueOf(element.saisID));
            containStunumD[i].setText(String.valueOf(element.studentNumber));
            containAddressD[i].setText(String.valueOf(database.getData(i).address));
        }
    }

    public void searchEntry(String pathFXML) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/" + pathFXML + ".fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.showAndWait();
    }

    public void dialog(String pathFXML) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/" + pathFXML + ".fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.showAndWait();
    }

    public void searchUIFunction(String searchKeyword) throws IOException {
        StudentDB database = StudentDB.readSavedData();

        Pane[] panes = { pane1b, pane2b, pane3b, pane4b, pane5b, pane6b, pane7b, pane8b, pane9b, pane10b };
        Text[] containName = { name1b, name2b, name3b, name4b, name5b, name6b, name7b, name8b, name9b, name10b };
        Text[] containSais = { sais1b, sais2b, sais3b, sais4b, sais5b, sais6b, sais7b, sais8b, sais9b, sais10b };
        Text[] containStunum = { stunum1b, stunum2b, stunum3b, stunum4b, stunum5b, stunum6b, stunum7b, stunum8b,
                stunum9b, stunum10b };
        Text[] containAddress = { address1b, address2b, address3b, address4b, address5b, address6b, address7b,
                address8b, address9b, address10b };

        if (database.searchData(searchKeyword).length == 0)// revise
        {
            nomatchDialog.setVisible(true);
            searchContent.setVisible(false);
        } else if (database.searchData(searchKeyword).length > 0)// revise
        {
            nomatchDialog.setVisible(false);
            searchContent.setVisible(true);

            LinkedList<StudentData> results = database.searchData(searchKeyword);

            for (int i = 0; i < panes.length; i++) {
                panes[i].setVisible(false);
            }

            for (int i = 0; i < results.length; i++) {
                panes[i].setVisible(true);
                containName[i].setText(String.valueOf(results.get(i).name));
                containSais[i].setText(String.valueOf(results.get(i).saisID));
                containStunum[i].setText(String.valueOf(results.get(i).studentNumber));
                containAddress[i].setText(String.valueOf(results.get(i).address));
            }
        }
    }

    public void editUIFunction(int numList, String nameLog, String saisLog, String stunumLog, String addressLog)
            throws IOException {
        saveEdit.setDisable(false);
        // System.out.println(nameLog);
        // System.out.println(saisLog);
        // System.out.println(stunumLog);
        // System.out.println(addressLog);
        nameTxtfielda.setText(nameLog);
        saisTxtfielda.setText(saisLog);
        stunumTxtfielda.setText(stunumLog);
        addressTxtfielda.setText(addressLog);
    }

    public void deleteUIFunction(int numList, String nameLog, String saisLog, String stunumLog, String addressLog)
            throws IOException {

        dialog("confirm_delete");
        // nameDelete.setText(nameLog);
        // stunumDelete.setText(stunumLog);
        // addressDelete.setText(addressLog);
        // saisDelete.setText(saisLog);
    }

    public void saveEditFunction() throws IOException 
    {
        String inputName = nameTxtfielda.getText();
        String inputSAIS = saisTxtfielda.getText();
        String inputStunum = stunumTxtfielda.getText();
        String inputAddress = addressTxtfielda.getText();

        if(!inputName.matches("[a-zA-Z\s]+") && inputName.length() > 0)
        {
            charOnly1a.setVisible(true);
        }
        if(!inputSAIS.matches("[0-9\s]+") && inputSAIS.length() > 0)
        {
            numOnly1a.setVisible(true);
        }
        if(!inputStunum.matches("[0-9\s]+")&& inputStunum.length() > 0)
        {
            numOnly2a.setVisible(true);
        }
        if(inputName.matches("[a-zA-Z\s]+") )
        {
            charOnly1a.setVisible(false);
        }
        if(inputSAIS.matches("[0-9\s]+") )
        {
            numOnly1a.setVisible(false);
        }
        if(inputStunum.matches("[0-9\s]+") )
        {
            numOnly2a.setVisible(false);
        }
        if(inputStunum.length() > 0)
        {
            stunumTxtfielda.setStyle("-fx-border-color: #6a7281;-fx-border-radius: 5; -fx-background-color: #1a1d20;");
        }
        if(inputName.length() > 0)
        {
            nameTxtfielda.setStyle("-fx-border-color: #6a7281;-fx-border-radius: 5; -fx-background-color: #1a1d20;");
        }
        if(inputSAIS.length() > 0)
        {
            saisTxtfielda.setStyle("-fx-border-color: #6a7281;-fx-border-radius: 5; -fx-background-color: #1a1d20;");
        }
        if(inputAddress.length() > 0)
        {
            addressTxtfielda.setStyle("-fx-border-color: #6a7281;-fx-border-radius: 5; -fx-background-color: #1a1d20;");
        }
        
        if(inputAddress.length() == 0 || inputName.length() == 0 || inputSAIS.length() == 0 || inputStunum.length() == 0)
        {
            requireNotifa.setVisible(true);
            if(inputAddress.length() == 0)
            {
                addressTxtfielda.setStyle("-fx-border-color: #ff6767;-fx-border-radius: 5; -fx-background-color: #1a1d20;");
            }
            if(inputName.length() == 0)
            {
                charOnly1a.setVisible(false);
                nameTxtfielda.setStyle("-fx-border-color: #ff6767;-fx-border-radius: 5; -fx-background-color: #1a1d20;");
            }
            if(inputSAIS.length() == 0)
            {
                numOnly1a.setVisible(false);
                saisTxtfielda.setStyle("-fx-border-color: #ff6767;-fx-border-radius: 5; -fx-background-color: #1a1d20;");
            }
            if(inputStunum.length() == 0)
            {
                numOnly2a.setVisible(false);
                stunumTxtfielda.setStyle("-fx-border-color: #ff6767;-fx-border-radius: 5; -fx-background-color: #1a1d20;");
            }
        }
        else if (inputAddress.length() > 0 && inputName.length() > 0 && inputSAIS.length() > 0 && inputStunum.length() > 0)
        {
            requireNotifa.setVisible(false);
        }
        if (inputAddress.length() > 0 && inputName.length() > 0 && inputSAIS.length() > 0 && inputStunum.length() > 0
                && inputName.matches("[a-zA-Z]+")  && inputName.matches("[a-zA-Z]+")  && inputName.matches("[a-zA-Z]+") )
        {
            //CHECK for pre-existing 
                //is the pre-existing the one being edited
                    dialog("notif_edited");
                //if not
                    dialog("confirm_edit");
                    // //add a new linked list
                    // //save then
                    // dialog("notif_addsuccess");
                    // //clear the txtfield
        }
    }

    public void addUIFunction() throws IOException 
    {
        String inputName = nameTxtfield.getText();
        String inputSAIS = saisTxtfield.getText();
        String inputStunum = stunumTxtfield.getText();
        String inputAddress = addressTxtfield.getText();

        if (!inputName.matches("[a-zA-Z\s]+")  && inputName.length() > 0) {
            charOnly1.setVisible(true);
        }
        if (!inputSAIS.matches("[0-9\s]+")  && inputSAIS.length() > 0) {
            numOnly1.setVisible(true);
        }
        if (!inputStunum.matches("[0-9\s]+")  && inputStunum.length() > 0) {
            numOnly2.setVisible(true);
        }
        if (inputName.matches("[a-zA-Z\s]+") ) {
            charOnly1.setVisible(false);
        }
        if (inputSAIS.matches("[0-9\s]+") ) {
            numOnly1.setVisible(false);
        }

        if (inputStunum.matches("[0-9\s]+") ) {
            numOnly2.setVisible(false);
        }

        if (inputStunum.length() > 0) {
            stunumTxtfield.setStyle("-fx-border-color: #6a7281;-fx-border-radius: 5; -fx-background-color: #1a1d20;");
        }

        if (inputName.length() > 0) {
            nameTxtfield.setStyle("-fx-border-color: #6a7281;-fx-border-radius: 5; -fx-background-color: #1a1d20;");
        }

        if (inputSAIS.length() > 0) {
            saisTxtfield.setStyle("-fx-border-color: #6a7281;-fx-border-radius: 5; -fx-background-color: #1a1d20;");
        }

        if (inputAddress.length() > 0) {
            addressTxtfield.setStyle("-fx-border-color: #6a7281;-fx-border-radius: 5; -fx-background-color: #1a1d20;");
        }
        
        if (inputAddress.length() == 0 || inputName.length() == 0 || inputSAIS.length() == 0 || inputStunum.length() == 0) {
            requireNotif.setVisible(true);

            if (inputAddress.length() == 0) {
                addressTxtfield.setStyle("-fx-border-color: #ff6767;-fx-border-radius: 5; -fx-background-color: #1a1d20;");
            }

            if (inputName.length() == 0) {
                charOnly1.setVisible(false);
                nameTxtfield.setStyle("-fx-border-color: #ff6767;-fx-border-radius: 5; -fx-background-color: #1a1d20;");
            }

            if (inputSAIS.length() == 0) {
                numOnly1.setVisible(false);
                saisTxtfield.setStyle("-fx-border-color: #ff6767;-fx-border-radius: 5; -fx-background-color: #1a1d20;");
            }

            if(inputStunum.length() == 0) {
                numOnly2.setVisible(false);
                stunumTxtfield.setStyle("-fx-border-color: #ff6767;-fx-border-radius: 5; -fx-background-color: #1a1d20;");
            }
        }
        else if (inputAddress.length() > 0 && inputName.length() > 0 && inputSAIS.length() > 0 && inputStunum.length() > 0) {
            requireNotif.setVisible(false);
        }

        // if (inputAddress.length() > 0 && inputName.length() > 0 && inputSAIS.length() > 0 && inputStunum.length() > 0
        //         && inputName.matches("[a-zA-Z]+")  && inputName.matches("[a-zA-Z]+")  && inputName.matches("[a-zA-Z]+") ) {
            StudentDB database = StudentDB.readSavedData();
            System.out.println(inputName);
            System.out.println(inputAddress);
            StudentData element = new StudentData(inputName, Integer.parseInt(inputSAIS), Integer.parseInt(inputStunum), inputAddress);

            if(database.length() == 10) {
                dialog("warn_overflow");
                return;
            }

            if (database.isDuplicateOfDatabase(element)) {
                dialog("notif_added");
                return;
            }

            else if(database.length() < 10) {    
                dialog("notif_addsuccess");
                nameTxtfield.clear();
                stunumTxtfield.clear();
                addressTxtfield.clear();
                saisTxtfield.clear();
            }    
    // }
    }
}
