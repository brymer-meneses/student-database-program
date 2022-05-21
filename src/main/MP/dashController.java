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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.*;
import MP.StudentDBDemo;
import MP.App;
import java.io.IOException;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.fxml.*;

public class dashController {

    @FXML
    private Pane pane10b;

    @FXML
    private Pane pane10c;

    @FXML
    private Pane pane10d;

    @FXML
    private Pane pane1b;

    @FXML
    private Pane pane1c;

    @FXML
    private Pane pane1d;

    @FXML
    private Pane pane2b;

    @FXML
    private Pane pane2c;

    @FXML
    private Pane pane2d;

    @FXML
    private Pane pane3d;

    @FXML
    private Pane pane3b;

    @FXML
    private Pane pane3c;

    @FXML
    private Pane pane4b;

    @FXML
    private Pane pane4c;

    @FXML
    private Pane pane4d;

    @FXML
    private Pane pane5b;

    @FXML
    private Pane pane5c;

    @FXML
    private Pane pane5d;

    @FXML
    private Pane pane6b;

    @FXML
    private Pane pane6c;

    @FXML
    private Pane pane6d;

    @FXML
    private Pane pane7b;

    @FXML
    private Pane pane7c;

    @FXML
    private Pane pane7d;

    @FXML
    private Pane pane8b;

    @FXML
    private Pane pane8c;

    @FXML
    private Pane pane8d;

    @FXML
    private Pane pane9b;

    @FXML
    private Pane pane9c;

    @FXML
    private Pane pane9d;

    @FXML
    private Pane addPane;

    @FXML
    private Text address10a;

    @FXML
    private Text address10b;

    @FXML
    private Text address10c;

    @FXML
    private Text address10d;

    @FXML
    private Text address1a;

    @FXML
    private Text address1b;

    @FXML
    private Text address1c;

    @FXML
    private Text address1d;

    @FXML
    private Text address2a;

    @FXML
    private Text address2b;

    @FXML
    private Text address2c;

    @FXML
    private Text address2d;

    @FXML
    private Text address3a;

    @FXML
    private Text address3b;

    @FXML
    private Text address3c;

    @FXML
    private Text address3d;

    @FXML
    private Text address4a;

    @FXML
    private Text address4b;

    @FXML
    private Text address4c;

    @FXML
    private Text address4d;

    @FXML
    private Text address5a;

    @FXML
    private Text address5b;

    @FXML
    private Text address5c;

    @FXML
    private Text address5d;

    @FXML
    private Text address6a;

    @FXML
    private Text address6b;

    @FXML
    private Text address6c;

    @FXML
    private Text address6d;

    @FXML
    private Text address7d;

    @FXML
    private Text address7a;

    @FXML
    private Text address7b;

    @FXML
    private Text address7c;

    @FXML
    private Text address8a;

    @FXML
    private Text address8b;

    @FXML
    private Text address8c;

    @FXML
    private Text address8d;

    @FXML
    private Text address9a;

    @FXML
    private Text address9b;

    @FXML
    private Text address9c;

    @FXML
    private Text address9d;

    @FXML
    private TextField addressTxtfield;

    @FXML
    private TextField addressTxtfielda;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnClose;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnHelp;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnMin;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnView;

    @FXML
    private Text charOnly1;

    @FXML
    private Text charOnly1a;

    @FXML
    private Button delete1;

    @FXML
    private Button delete10;

    @FXML
    private Button delete2;

    @FXML
    private Button delete3;

    @FXML
    private Button delete4;

    @FXML
    private Button delete5;

    @FXML
    private Button delete6;

    @FXML
    private Button delete7;

    @FXML
    private Button delete8;

    @FXML
    private Button delete9;

    @FXML
    private Pane deletePane;

    @FXML
    private Button edit1;

    @FXML
    private Button edit10;

    @FXML
    private Button edit2;

    @FXML
    private Button edit3;

    @FXML
    private Button edit4;

    @FXML
    private Button edit5;

    @FXML
    private Button edit6;

    @FXML
    private Button edit7;

    @FXML
    private Button edit8;

    @FXML
    private Button edit9;

    @FXML
    private Pane editPane;

    @FXML
    private Pane helpPane;

    @FXML
    private Pane homePane;

    @FXML
    private Text name1;

    @FXML
    private Text name10a;

    @FXML
    private Text name10b;

    @FXML
    private Text name10c;

    @FXML
    private Text name10d;

    @FXML
    private Text name1a;

    @FXML
    private Text name1b;

    @FXML
    private Text name1c;

    @FXML
    private Text name1d;

    @FXML
    private Text name2a;

    @FXML
    private Text name2b;

    @FXML
    private Text name2c;

    @FXML
    private Text name2d;

    @FXML
    private Text name3b;

    @FXML
    private Text name3a;

    @FXML
    private Text name3c;

    @FXML
    private Text name3d;

    @FXML
    private Text name4a;

    @FXML
    private Text name4b;

    @FXML
    private Text name4c;

    @FXML
    private Text name4d;

    @FXML
    private Text name5a;

    @FXML
    private Text name5b;

    @FXML
    private Text name5c;

    @FXML
    private Text name5d;

    @FXML
    private Text name6a;

    @FXML
    private Text name6b;

    @FXML
    private Text name6c;

    @FXML
    private Text name6d;

    @FXML
    private Text name7a;

    @FXML
    private Text name7b;

    @FXML
    private Text name7c;

    @FXML
    private Text name7d;

    @FXML
    private Text name8a;

    @FXML
    private Text name8b;

    @FXML
    private Text name8c;

    @FXML
    private Text name8d;

    @FXML
    private Text name9a;

    @FXML
    private Text name9b;

    @FXML
    private Text name9c;

    @FXML
    private Text name9d;

    @FXML
    private TextField nameTxtfield;

    @FXML
    private TextField nameTxtfielda;

    @FXML
    private Pane nomatchDialog;

    @FXML
    private Text numOnly1;

    @FXML
    private Text numOnly1a;

    @FXML
    private Text numOnly2;

    @FXML
    private Text numOnly2a;

    @FXML
    private Pane pane10a;

    @FXML
    private Pane pane1a;

    @FXML
    private Pane pane2a;

    @FXML
    private Pane pane3a;

    @FXML
    private Pane pane4a;

    @FXML
    private Pane pane5a;

    @FXML
    private Pane pane6a;

    @FXML
    private Pane pane7a;

    @FXML
    private Pane pane8a;

    @FXML
    private Pane pane9a;

    @FXML
    private VBox pnItems;

    @FXML
    private VBox pnItems1;

    @FXML
    private VBox pnItems11;

    @FXML
    private VBox pnItems2;

    @FXML
    private Pane requireNotif;

    @FXML
    private Pane requireNotifa;

    @FXML
    private Text sais10a;

    @FXML
    private Text sais10b;

    @FXML
    private Text sais10c;

    @FXML
    private Text sais10d;

    @FXML
    private Text sais1a;

    @FXML
    private Text sais1b;

    @FXML
    private Text sais1c;

    @FXML
    private Text sais1d;

    @FXML
    private Text sais2a;

    @FXML
    private Text sais2b;

    @FXML
    private Text sais2c;

    @FXML
    private Text sais2d;

    @FXML
    private Text sais3a;

    @FXML
    private Text sais3b;

    @FXML
    private Text sais3c;

    @FXML
    private Text sais3d;

    @FXML
    private Text sais4a;

    @FXML
    private Text sais4b;

    @FXML
    private Text sais4c;

    @FXML
    private Text sais4d;

    @FXML
    private Text sais5a;

    @FXML
    private Text sais5b;

    @FXML
    private Text sais5c;

    @FXML
    private Text sais5d;

    @FXML
    private Text sais6a;

    @FXML
    private Text sais6b;

    @FXML
    private Text sais6c;

    @FXML
    private Text sais6d;

    @FXML
    private Text sais7a;

    @FXML
    private Text sais7b;

    @FXML
    private Text sais7c;

    @FXML
    private Text sais7d;

    @FXML
    private Text sais8a;

    @FXML
    private Text sais8b;

    @FXML
    private Text sais8c;

    @FXML
    private Text sais8d;

    @FXML
    private Text sais9a;

    @FXML
    private Text sais9b;

    @FXML
    private Text sais9c;

    @FXML
    private Text sais9d;

    @FXML
    private TextField saisTxtfield;

    @FXML
    private TextField saisTxtfielda;

    @FXML
    private Button saveAdd;

    @FXML
    private Button saveAdd1;

    @FXML
    private Button saveEdit;

    @FXML
    private ScrollPane searchContent;

    @FXML
    private TextField searchField;

    @FXML
    private Button searchFunction;

    @FXML
    private Pane searchPane;

    @FXML
    private Text stunum10a;

    @FXML
    private Text stunum10b;

    @FXML
    private Text stunum10c;

    @FXML
    private Text stunum10d;

    @FXML
    private Text stunum1a;

    @FXML
    private Text stunum1b;

    @FXML
    private Text stunum1c;

    @FXML
    private Text stunum1d;

    @FXML
    private Text stunum2a;

    @FXML
    private Text stunum2b;

    @FXML
    private Text stunum2c;

    @FXML
    private Text stunum2d;

    @FXML
    private Text stunum3a;

    @FXML
    private Text stunum3b;

    @FXML
    private Text stunum3c;

    @FXML
    private Text stunum3d;

    @FXML
    private Text stunum4a;

    @FXML
    private Text stunum4b;

    @FXML
    private Text stunum4c;

    @FXML
    private Text stunum4d;

    @FXML
    private Text stunum5a;

    @FXML
    private Text stunum5b;

    @FXML
    private Text stunum5c;

    @FXML
    private Text stunum5d;

    @FXML
    private Text stunum6a;

    @FXML
    private Text stunum6b;

    @FXML
    private Text stunum6c;

    @FXML
    private Text stunum6d;

    @FXML
    private Text stunum7a;

    @FXML
    private Text stunum7b;

    @FXML
    private Text stunum7c;

    @FXML
    private Text stunum7d;

    @FXML
    private Text stunum8a;

    @FXML
    private Text stunum8b;

    @FXML
    private Text stunum8c;

    @FXML
    private Text stunum8d;

    @FXML
    private Text stunum9a;

    @FXML
    private Text stunum9b;

    @FXML
    private Text stunum9c;

    @FXML
    private Text stunum9d;

    @FXML
    private TextField stunumTxtfield;

    @FXML
    private TextField stunumTxtfielda;

    @FXML
    private Pane titlePane;

    @FXML
    private Pane viewPane;

    @FXML
    private Button actionDelete;

    @FXML
    private Label addressDelete;

    @FXML
    private Button btnDialogclose;

    @FXML
    private Button btnOK;

    @FXML
    private Label nameDelete;

    @FXML
    private Label saisDelete;

    @FXML
    private Label stunumDelete;

    @FXML
    private Button actionEdit;

    private int indexDelete;

    @FXML

    public void handleClicks(ActionEvent actionEvent) throws IOException {
        // name1a.setText("SAMPLE1");
        // name1b.setText("SAMPLE1");
        // name1c.setText("SAMPLE1");
        // name1d.setText("SAMPLE1");

        if (actionEvent.getSource() == btnMin) {
            Stage stage = (Stage) btnMin.getScene().getWindow();
            stage.setIconified(true);
        }
        if (actionEvent.getSource() == btnClose) {
            Stage stage = (Stage) btnClose.getScene().getWindow();
            stage.close();
        }
        if (actionEvent.getSource() == btnView) {
            dataGenerator();
            homePane.setVisible(false);
            viewPane.setVisible(true);
            addPane.setVisible(false);
            searchPane.setVisible(false);
            deletePane.setVisible(false);
            editPane.setVisible(false);
            helpPane.setVisible(false);
        }
        if (actionEvent.getSource() == btnHome) {
            homePane.setVisible(true);
            viewPane.setVisible(false);
            addPane.setVisible(false);
            searchPane.setVisible(false);
            deletePane.setVisible(false);
            editPane.setVisible(false);
            helpPane.setVisible(false);
        }
        if (actionEvent.getSource() == btnEdit) {
            dataGenerator();
            homePane.setVisible(false);
            viewPane.setVisible(false);
            addPane.setVisible(false);
            searchPane.setVisible(false);
            deletePane.setVisible(false);
            editPane.setVisible(true);
            helpPane.setVisible(false);
        }
        if (actionEvent.getSource() == btnAdd) {
            dataGenerator();
            homePane.setVisible(false);
            viewPane.setVisible(false);
            addPane.setVisible(true);
            searchPane.setVisible(false);
            deletePane.setVisible(false);
            editPane.setVisible(false);
            helpPane.setVisible(false);
        }
        if (actionEvent.getSource() == btnSearch) {
            dataGenerator();
            homePane.setVisible(false);
            viewPane.setVisible(false);
            addPane.setVisible(false);
            searchPane.setVisible(true);
            deletePane.setVisible(false);
            editPane.setVisible(false);
            helpPane.setVisible(false);
        }
        if (actionEvent.getSource() == btnDelete) {
            dataGenerator();
            homePane.setVisible(false);
            viewPane.setVisible(false);
            addPane.setVisible(false);
            searchPane.setVisible(false);
            deletePane.setVisible(true);
            editPane.setVisible(false);
            helpPane.setVisible(false);
        }
        if (actionEvent.getSource() == btnHelp) {
            homePane.setVisible(false);
            viewPane.setVisible(false);
            addPane.setVisible(false);
            searchPane.setVisible(false);
            deletePane.setVisible(false);
            editPane.setVisible(false);
            helpPane.setVisible(true);
        }
        if (actionEvent.getSource() == saveAdd) {
            addUIFunction();
        }
        if (actionEvent.getSource() == searchFunction) {
            searchUIFunction(String.valueOf(searchField.getText()));
        }
        if (actionEvent.getSource() == delete1) {
            String nameLog = name1d.getText();
            String saisLog = sais1d.getText();
            String stunumLog = stunum1d.getText();
            String addressLog = address1d.getText();
            System.out.println("Gate CHECK1");
            deleteUIFunction(0, nameLog, saisLog, stunumLog, addressLog);
        }
        if (actionEvent.getSource() == delete2) {
            String nameLog = name2d.getText();
            String saisLog = sais2d.getText();
            String stunumLog = stunum2d.getText();
            String addressLog = address2d.getText();
            deleteUIFunction(1, nameLog, saisLog, stunumLog, addressLog);
        }
        if (actionEvent.getSource() == delete3) {
            String nameLog = name3d.getText();
            String saisLog = sais3d.getText();
            String stunumLog = stunum3d.getText();
            String addressLog = address3d.getText();
            deleteUIFunction(2, nameLog, saisLog, stunumLog, addressLog);
        }
        if (actionEvent.getSource() == delete4) {
            String nameLog = name4d.getText();
            String saisLog = sais4d.getText();
            String stunumLog = stunum4d.getText();
            String addressLog = address4d.getText();
            deleteUIFunction(3, nameLog, saisLog, stunumLog, addressLog);
        }
        if (actionEvent.getSource() == delete5) {
            String nameLog = name5d.getText();
            String saisLog = sais5d.getText();
            String stunumLog = stunum5d.getText();
            String addressLog = address5d.getText();
            deleteUIFunction(4, nameLog, saisLog, stunumLog, addressLog);
        }
        if (actionEvent.getSource() == delete6) {
            String nameLog = name6d.getText();
            String saisLog = sais6d.getText();
            String stunumLog = stunum6d.getText();
            String addressLog = address6d.getText();
            deleteUIFunction(5, nameLog, saisLog, stunumLog, addressLog);
        }
        if (actionEvent.getSource() == delete7) {
            String nameLog = name7d.getText();
            String saisLog = sais7d.getText();
            String stunumLog = stunum7d.getText();
            String addressLog = address7d.getText();
            deleteUIFunction(6, nameLog, saisLog, stunumLog, addressLog);
        }
        if (actionEvent.getSource() == delete8) {
            String nameLog = name8d.getText();
            String saisLog = sais8d.getText();
            String stunumLog = stunum8d.getText();
            String addressLog = address8d.getText();
            deleteUIFunction(7, nameLog, saisLog, stunumLog, addressLog);
        }
        if (actionEvent.getSource() == delete9) {
            String nameLog = name9d.getText();
            String saisLog = sais9d.getText();
            String stunumLog = stunum9d.getText();
            String addressLog = address9d.getText();
            deleteUIFunction(8, nameLog, saisLog, stunumLog, addressLog);
        }
        if (actionEvent.getSource() == delete10) {
            String nameLog = name10d.getText();
            String saisLog = sais10d.getText();
            String stunumLog = stunum10d.getText();
            String addressLog = address10d.getText();
            deleteUIFunction(9, nameLog, saisLog, stunumLog, addressLog);
        }
        if (actionEvent.getSource() == edit1) {
            String nameLog = name1c.getText();
            String saisLog = sais1c.getText();
            String stunumLog = stunum1c.getText();
            String addressLog = address1c.getText();
            editUIFunction(0, nameLog, saisLog, stunumLog, addressLog);
        }
        if (actionEvent.getSource() == edit2) {
            String nameLog = name2c.getText();
            String saisLog = sais2c.getText();
            String stunumLog = stunum2c.getText();
            String addressLog = address2c.getText();
            editUIFunction(1, nameLog, saisLog, stunumLog, addressLog);
        }
        if (actionEvent.getSource() == edit3) {
            String nameLog = name3c.getText();
            String saisLog = sais3c.getText();
            String stunumLog = stunum3c.getText();
            String addressLog = address3c.getText();
            editUIFunction(2, nameLog, saisLog, stunumLog, addressLog);
        }
        if (actionEvent.getSource() == edit4) {
            String nameLog = name4c.getText();
            String saisLog = sais4c.getText();
            String stunumLog = stunum4c.getText();
            String addressLog = address4c.getText();
            editUIFunction(3, nameLog, saisLog, stunumLog, addressLog);
        }
        if (actionEvent.getSource() == edit5) {
            String nameLog = name5c.getText();
            String saisLog = sais5c.getText();
            String stunumLog = stunum5c.getText();
            String addressLog = address5c.getText();
            editUIFunction(4, nameLog, saisLog, stunumLog, addressLog);
        }
        if (actionEvent.getSource() == edit6) {
            String nameLog = name6c.getText();
            String saisLog = sais6c.getText();
            String stunumLog = stunum6c.getText();
            String addressLog = address6c.getText();
            editUIFunction(5, nameLog, saisLog, stunumLog, addressLog);
        }
        if (actionEvent.getSource() == edit7) {
            String nameLog = name7c.getText();
            String saisLog = sais7c.getText();
            String stunumLog = stunum7c.getText();
            String addressLog = address7c.getText();
            editUIFunction(6, nameLog, saisLog, stunumLog, addressLog);
        }
        if (actionEvent.getSource() == edit8) {
            String nameLog = name8c.getText();
            String saisLog = sais8c.getText();
            String stunumLog = stunum8c.getText();
            String addressLog = address8c.getText();
            editUIFunction(7, nameLog, saisLog, stunumLog, addressLog);
        }
        if (actionEvent.getSource() == edit9) {
            String nameLog = name9c.getText();
            String saisLog = sais9c.getText();
            String stunumLog = stunum9c.getText();
            String addressLog = address9c.getText();
            editUIFunction(8, nameLog, saisLog, stunumLog, addressLog);
        }
        if (actionEvent.getSource() == edit10) {
            String nameLog = name10c.getText();
            String saisLog = sais10c.getText();
            String stunumLog = stunum10c.getText();
            String addressLog = address10c.getText();
            editUIFunction(9, nameLog, saisLog, stunumLog, addressLog);
        }
        if (actionEvent.getSource() == saveEdit) {
            saveEditFunction();
        }
        if (actionEvent.getSource() == btnOK) {
            Stage stage = (Stage) btnOK.getScene().getWindow();
            stage.close();
            dataGenerator();
        }
        if (actionEvent.getSource() == btnDialogclose) {
            Stage stage = (Stage) btnDialogclose.getScene().getWindow();
            stage.close();
        }
        if (actionEvent.getSource() == actionDelete) {
            // dataGenerator();
            StudentDB database = StudentDB.readSavedData();
            Stage stage = (Stage) actionDelete.getScene().getWindow();
            stage.close();

            database.deleteData(database.getData(indexDelete).name, database.getData(indexDelete).saisID);

            dialog("notif_deleted");// testline
            System.out.println("TEST GATE1");
            // dataGenerator();
            System.out.println("TEST GATE2");
            // update entries
        }
        if (actionEvent.getSource() == actionEdit) {
            Stage stage = (Stage) actionEdit.getScene().getWindow();
            stage.close();
            dialog("notif_savedchanges");// testline
            // overwrite changes
            // dialog("notif_savedchanges");
            // update entries
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

            containNameA[i].setText(String.valueOf(database.getData(i).name));
            containSaisA[i].setText(String.valueOf(database.getData(i).saisID));
            containStunumA[i].setText(String.valueOf(database.getData(i).studentNumber));
            containAddressA[i].setText(String.valueOf(database.getData(i).address));

            containNameC[i].setText(String.valueOf(database.getData(i).name));
            containSaisC[i].setText(String.valueOf(database.getData(i).saisID));
            containStunumC[i].setText(String.valueOf(database.getData(i).studentNumber));
            containAddressC[i].setText(String.valueOf(database.getData(i).address));

            containNameD[i].setText(String.valueOf(database.getData(i).name));
            containSaisD[i].setText(String.valueOf(database.getData(i).saisID));
            containStunumD[i].setText(String.valueOf(database.getData(i).studentNumber));
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
        this.indexDelete = numList;
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
