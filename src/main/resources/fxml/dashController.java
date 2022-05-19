package MP;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
// import javafx.fxml.FXML;
// import javafx.fxml.FXMLLoader;
// import javafx.scene.control.Button;
// import javafx.scene.layout.AnchorPane;
// import javafx.scene.layout.Pane;
// import javafx.stage.Stage;
// import javafx.event.ActionEvent;
// import javafx.scene.input.MouseEvent;
// import java.io.IOException;
// import javafx.application.Application;
// import javafx.scene.Parent;
// import javafx.scene.Scene;
// import java.net.URL;
// import javafx.fxml.FXML;
// import javafx.scene.control.Button;
// import java.util.ResourceBundle;
// import javafx.scene.layout.VBox;
// import javafx.event.ActionEvent;
// import javafx.fxml.FXML;
// import javafx.scene.control.TextArea;
// import javafx.scene.control.Button;
// import javafx.scene.layout.Pane;
// import javafx.scene.layout.VBox;
// import javafx.scene.text.Text;
// import javafx.fxml.FXML;
// import javafx.fxml.FXMLLoader;
// import javafx.scene.control.Button;
// import javafx.scene.layout.AnchorPane;
// import javafx.scene.layout.Pane;
// import javafx.stage.Stage;
// import javafx.event.ActionEvent;
// import javafx.scene.input.MouseEvent;
// import java.io.IOException;
// import javafx.application.Application;
// import javafx.scene.Parent;
// import javafx.scene.Scene;
// import java.net.URL;
// import javafx.fxml.FXML;
// import javafx.scene.control.Button;
// import java.util.ResourceBundle;
// import javafx.scene.layout.VBox;

public class dashController {

    @FXML
    private Pane Pane1;

    @FXML
    private Pane Pane10;

    @FXML
    private Pane Pane101;

    @FXML
    private Pane Pane11;

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
    private Button btnHelp1;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnMin;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnView;

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
    private VBox pnItems;

    @FXML
    private VBox pnItems1;

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
    private Button saveAdd;

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
    private Pane viewPane;

    @FXML
    public void handleClicks(ActionEvent actionEvent) throws IOException {
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
        }
        if (actionEvent.getSource() == btnHome) {
            homePane.setVisible(true);
            viewPane.setVisible(false);
            addPane.setVisible(false);
            searchPane.setVisible(false);
        }
        if (actionEvent.getSource() == btnEdit) {
            //Pane newPaneLoader = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/edit.fxml"));
            //PaneLoader.getChildren().add(newPaneLoader);
        }
        if (actionEvent.getSource() == btnAdd) {
            homePane.setVisible(false);
            viewPane.setVisible(false);
            addPane.setVisible(true);
            searchPane.setVisible(false);
        }
        if (actionEvent.getSource() == btnSearch) {
            //Pane newPaneLoader = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/search.fxml"));
            //PaneLoader.getChildren().add(newPaneLoader);
            homePane.setVisible(false);
            viewPane.setVisible(false);
            addPane.setVisible(false);
            searchPane.setVisible(true);
        }
        if (actionEvent.getSource() == btnDelete) {
            //Pane newPaneLoader = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/delete.fxml"));
            //PaneLoader.getChildren().add(newPaneLoader);
        }
        if (actionEvent.getSource() == btnHelp) {
            //Pane newPaneLoader = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/help.fxml"));
            //PaneLoader.getChildren().add(newPaneLoader);
        }
        //if (actionEvent.getSource() == btnTest) {
            //Pane1.setVisible(false);
            //name1.setVisible(false);
            //sais1.setVisible(false);
            //stunum1.setVisible(false);
            //addrerss1.setVisible(false);
            //name1.setText("HELLO");
            //btnTest.setVisible(false);
        //}
    }

}

