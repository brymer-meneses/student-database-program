package MP;


import MP.StudentDBDemo;
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

public class dashController 
{

    @FXML
    private Pane Pane1;

    @FXML
    private Pane Pane10;

    @FXML
    private Pane Pane101;

    @FXML
    private Pane Pane11;

    @FXML
    private Pane Pane12;

    @FXML
    private Pane Pane121;

    @FXML
    private Pane Pane1210;

    @FXML
    private Pane Pane12101;

    @FXML
    private Pane Pane12102;

    @FXML
    private Pane Pane12103;

    @FXML
    private Pane Pane12104;

    @FXML
    private Pane Pane12105;

    @FXML
    private Pane Pane12106;

    @FXML
    private Pane Pane12107;

    @FXML
    private Pane Pane12108;

    @FXML
    private Pane Pane12109;

    @FXML
    private Pane Pane122;

    @FXML
    private Pane Pane123;

    @FXML
    private Pane Pane124;

    @FXML
    private Pane Pane125;

    @FXML
    private Pane Pane126;

    @FXML
    private Pane Pane127;

    @FXML
    private Pane Pane128;

    @FXML
    private Pane Pane129;

    @FXML
    private Pane Pane2;

    @FXML
    private Pane Pane21;

    @FXML
    private Pane Pane3;

    @FXML
    private Pane Pane31;

    @FXML
    private Pane Pane4;

    @FXML
    private Pane Pane41;

    @FXML
    private Pane Pane5;

    @FXML
    private Pane Pane51;

    @FXML
    private Pane Pane6;

    @FXML
    private Pane Pane61;

    @FXML
    private Pane Pane7;

    @FXML
    private Pane Pane71;

    @FXML
    private Pane Pane8;

    @FXML
    private Pane Pane81;

    @FXML
    private Pane Pane9;

    @FXML
    private Pane Pane91;

    @FXML
    private Pane addPane;

    @FXML
    private Text address1;

    @FXML
    private Text address10;

    @FXML
    private Text address101;

    @FXML
    private Text address11;

    @FXML
    private Text address2;

    @FXML
    private Text address21;

    @FXML
    private Text address3;

    @FXML
    private Text address31;

    @FXML
    private Text address4;

    @FXML
    private Text address41;

    @FXML
    private Text address5;

    @FXML
    private Text address51;

    @FXML
    private Text address6;

    @FXML
    private Text address61;

    @FXML
    private Text address7;

    @FXML
    private Text address71;

    @FXML
    private Text address8;

    @FXML
    private Text address81;

    @FXML
    private Text address9;

    @FXML
    private TextField addressTxtfield;

    @FXML
    private TextField addressTxtfield1;

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
    private Text charOnly11;

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
    private Text name10;

    @FXML
    private Text name101;

    @FXML
    private Text name11;

    @FXML
    private Text name2;

    @FXML
    private Text name21;

    @FXML
    private Text name3;

    @FXML
    private Text name31;

    @FXML
    private Text name4;

    @FXML
    private Text name41;

    @FXML
    private Text name5;

    @FXML
    private Text name51;

    @FXML
    private Text name6;

    @FXML
    private Text name61;

    @FXML
    private Text name7;

    @FXML
    private Text name71;

    @FXML
    private Text name8;

    @FXML
    private Text name81;

    @FXML
    private Text name9;

    @FXML
    private Text name91;

    @FXML
    private TextField nameTxtfield;

    @FXML
    private TextField nameTxtfield1;

    @FXML
    private Pane nomatchDialog;

    @FXML
    private Text numOnly1;

    @FXML
    private Text numOnly11;

    @FXML
    private Text numOnly2;

    @FXML
    private Text numOnly21;

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
    private Pane requireNotif1;

    @FXML
    private Text sais1;

    @FXML
    private Text sais10;

    @FXML
    private Text sais101;

    @FXML
    private Text sais11;

    @FXML
    private Text sais2;

    @FXML
    private Text sais21;

    @FXML
    private Text sais3;

    @FXML
    private Text sais31;

    @FXML
    private Text sais4;

    @FXML
    private Text sais41;

    @FXML
    private Text sais5;

    @FXML
    private Text sais51;

    @FXML
    private Text sais6;

    @FXML
    private Text sais61;

    @FXML
    private Text sais7;

    @FXML
    private Text sais71;

    @FXML
    private Text sais8;

    @FXML
    private Text sais81;

    @FXML
    private Text sais9;

    @FXML
    private Text sais91;

    @FXML
    private TextField saisTxtfield;

    @FXML
    private TextField saisTxtfield1;

    @FXML
    private Button saveAdd;

    @FXML
    private Button saveAdd1;

    @FXML
    private Button saveAdd2;

    @FXML
    private ScrollPane searchContent;

    @FXML
    private TextField searchField;

    @FXML
    private Button searchFunction;

    @FXML
    private Pane searchPane;

    @FXML
    private Text stunum1;

    @FXML
    private Text stunum10;

    @FXML
    private Text stunum101;

    @FXML
    private Text stunum11;

    @FXML
    private Text stunum2;

    @FXML
    private Text stunum21;

    @FXML
    private Text stunum3;

    @FXML
    private Text stunum31;

    @FXML
    private Text stunum4;

    @FXML
    private Text stunum41;

    @FXML
    private Text stunum5;

    @FXML
    private Text stunum51;

    @FXML
    private Text stunum6;

    @FXML
    private Text stunum61;

    @FXML
    private Text stunum7;

    @FXML
    private Text stunum71;

    @FXML
    private Text stunum8;

    @FXML
    private Text stunum81;

    @FXML
    private Text stunum9;

    @FXML
    private Text stunum91;

    @FXML
    private TextField stunumTxtfield;

    @FXML
    private TextField stunumTxtfield1;

    @FXML
    private Pane titlePane;

    @FXML
    private Pane viewPane;




    @FXML
    
    public void handleClicks(ActionEvent actionEvent) throws IOException 
    {

        if (actionEvent.getSource() == btnMin) {
            Stage stage = (Stage) btnMin.getScene().getWindow();
            stage.setIconified(true);
        }
        if (actionEvent.getSource() == btnClose) {
            Stage stage = (Stage) btnClose.getScene().getWindow();
            stage.close();
        }
        if (actionEvent.getSource() == btnView) {
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
            homePane.setVisible(false);
            viewPane.setVisible(false);
            addPane.setVisible(false);
            searchPane.setVisible(false);
            deletePane.setVisible(false);
            editPane.setVisible(true);
            helpPane.setVisible(false);
        }
        if (actionEvent.getSource() == btnAdd) {
            homePane.setVisible(false);
            viewPane.setVisible(false);
            addPane.setVisible(true);
            searchPane.setVisible(false);
            deletePane.setVisible(false);
            editPane.setVisible(false);
            helpPane.setVisible(false);
            nameTxtfield.setText("OWO");
        }
        if (actionEvent.getSource() == btnSearch) {
            homePane.setVisible(false);
            viewPane.setVisible(false);
            addPane.setVisible(false);
            searchPane.setVisible(true);
            deletePane.setVisible(false);
            editPane.setVisible(false);
            helpPane.setVisible(false);
        }
        if (actionEvent.getSource() == btnDelete) {
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
        if (actionEvent.getSource() == saveAdd) 
        {
            addUIFunction();
        }
        if (actionEvent.getSource() == searchFunction) 
        {
            searchUIFunction();
        }
        if (actionEvent.getSource() == delete1) 
        {
            deleteUIFunction(0);
        }
        if (actionEvent.getSource() == delete2) 
        {
            deleteUIFunction(1);
        }
        if (actionEvent.getSource() == delete3) 
        {
            deleteUIFunction(2);
        }
        if (actionEvent.getSource() == delete4) 
        {
            deleteUIFunction(3);
        }
        if (actionEvent.getSource() == delete5) 
        {
            deleteUIFunction(4);
        }
        if (actionEvent.getSource() == delete6) 
        {
            deleteUIFunction(5);
        }
        if (actionEvent.getSource() == delete7) 
        {
            deleteUIFunction(6);
        }
        if (actionEvent.getSource() == delete8) 
        {
            deleteUIFunction(7);
        }
        if (actionEvent.getSource() == delete9) 
        {
            deleteUIFunction(8);
        }
        if (actionEvent.getSource() == delete10) 
        {
            deleteUIFunction(9);
        }
        if (actionEvent.getSource() == edit1) 
        {
            editUIFunction(0);
            String inputName = name1.getText();
            String inputSAIS = sais1.getText();
            String inputStunum = stunum1.getText();
            String inputAddress = address1.getText();
        }
        if (actionEvent.getSource() == edit2) 
        {
            editUIFunction(1);
        }
        if (actionEvent.getSource() == edit3) 
        {
            editUIFunction(2);
        }
        if (actionEvent.getSource() == edit4) 
        {
            editUIFunction(3);
        }
        if (actionEvent.getSource() == edit5) 
        {
            editUIFunction(4);
        }
        if (actionEvent.getSource() == edit6) 
        {
            editUIFunction(5);
        }
        if (actionEvent.getSource() == edit7) 
        {
            editUIFunction(6);
        }
        if (actionEvent.getSource() == edit8) 
        {
            editUIFunction(7);
        }
        if (actionEvent.getSource() == edit9) 
        {
            editUIFunction(8);
        }
        if (actionEvent.getSource() == edit10) 
        {
            editUIFunction(9);
        }



    }
    @FXML
    public void keyPress(ActionEvent event) throws IOException 
    {
        searchContent.setVisible(true);
        searchUIFunction();
        
        
    }
    public void dataGenerator()
    {
        StudentDB database = App.getDatabase();
        //sdk.getData(0).name;
        //if (database.length > 0){
            Pane1.setVisible(true);
            name1.setVisible(true);
            sais1.setVisible(true);
            stunum1.setVisible(true);
            address1.setVisible(true);
            name1.setText(String.valueOf(database.getData(0).name));
            sais1.setText(String.valueOf(database.getData(0).saisID));
            stunum1.setText(String.valueOf(database.getData(0).studentNumber));
            address1.setText(String.valueOf(database.getData(0).address));
        //}
    }
    public void dialog(String pathFXML) throws IOException 
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/"+pathFXML+".fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
    public void searchUIFunction() throws IOException
    {
        //if no found match
            nomatchDialog.setVisible(true);
        //if found match
            //nomatchDialog.setVisible(false);
        //searchContent.setVisible(true);
        //load the match entries 
    }
    public void deleteUIFunction(int numList) throws IOException
    {
        //if no found match
            nomatchDialog.setVisible(true);
        //if found match
            //nomatchDialog.setVisible(false);
        //searchContent.setVisible(true);
        //load the match entries 
    }
    public void editUIFunction(int numList) throws IOException
    {
        String nameCall = "name"+(numList+1);
        System.out.println(nameCall);
        nameTxtfield.setText(nameCall);
        //stunumTxtfield.setText(name+(numList+1));
        //addressTxtfield.setText(name+(numList+1));
        //saisTxtfield.setText(name+(numList+1));
    }
    public void addUIFunction() throws IOException 
    {
        String inputName = nameTxtfield.getText();
        String inputSAIS = saisTxtfield.getText();
        String inputStunum = stunumTxtfield.getText();
        String inputAddress = addressTxtfield.getText();
        // accept spaces but not just spaces
        if(inputName.matches("[a-zA-Z\s]+") == false && inputName.length() > 0)
        {
            charOnly1.setVisible(true);
        }
        if(inputSAIS.matches("[0-9\s]+") == false && inputSAIS.length() > 0)
        {
            numOnly1.setVisible(true);
        }
        if(inputStunum.matches("[0-9\s]+") == false && inputStunum.length() > 0)
        {
            numOnly2.setVisible(true);
        }
        if(inputName.matches("[a-zA-Z\s]+") == true)
        {
            charOnly1.setVisible(false);
        }
        if(inputSAIS.matches("[0-9\s]+") == true)
        {
            numOnly1.setVisible(false);
        }
        if(inputStunum.matches("[0-9\s]+") == true)
        {
            numOnly2.setVisible(false);
        }
        if(inputStunum.length() > 0)
        {
            stunumTxtfield.setStyle("-fx-border-color: #6a7281;-fx-border-radius: 5; -fx-background-color: #1a1d20;");
        }
        if(inputName.length() > 0)
        {
            nameTxtfield.setStyle("-fx-border-color: #6a7281;-fx-border-radius: 5; -fx-background-color: #1a1d20;");
        }
        if(inputSAIS.length() > 0)
        {
            saisTxtfield.setStyle("-fx-border-color: #6a7281;-fx-border-radius: 5; -fx-background-color: #1a1d20;");
        }
        if(inputAddress.length() > 0)
        {
            addressTxtfield.setStyle("-fx-border-color: #6a7281;-fx-border-radius: 5; -fx-background-color: #1a1d20;");
        }
        
        if(inputAddress.length() == 0 || inputName.length() == 0 || inputSAIS.length() == 0 || inputStunum.length() == 0)
        {
            requireNotif.setVisible(true);
            if(inputAddress.length() == 0)
            {
                addressTxtfield.setStyle("-fx-border-color: #ff6767;-fx-border-radius: 5; -fx-background-color: #1a1d20;");
            }
            if(inputName.length() == 0)
            {
                nameTxtfield.setStyle("-fx-border-color: #ff6767;-fx-border-radius: 5; -fx-background-color: #1a1d20;");
            }
            if(inputSAIS.length() == 0)
            {
                saisTxtfield.setStyle("-fx-border-color: #ff6767;-fx-border-radius: 5; -fx-background-color: #1a1d20;");
            }
            if(inputStunum.length() == 0)
            {
                stunumTxtfield.setStyle("-fx-border-color: #ff6767;-fx-border-radius: 5; -fx-background-color: #1a1d20;");
            }
        }
        else if (inputAddress.length() > 0 && inputName.length() > 0 && inputSAIS.length() > 0 && inputStunum.length() > 0)
        {
            requireNotif.setVisible(false);
        }
        if (inputAddress.length() > 0 && inputName.length() > 0 && inputSAIS.length() > 0 && inputStunum.length() > 0
                && inputName.matches("[a-zA-Z]+") == true && inputName.matches("[a-zA-Z]+") == true && inputName.matches("[a-zA-Z]+") == true)
        {
            //CHECK for pre-existing 
            dialog("notif_added");
                //check for sdb length
                dialog("warn_overflow");
                    //add a new linked list
                    //save then
                    dialog("notif_addsuccess");
                    //clear the txtfield
        }
    }
}
