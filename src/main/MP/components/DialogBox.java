package MP.components;

import MP.interfaces.Callback;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

import MP.StudentDB;
import MP.StudentData;

public class DialogBox extends Pane {

    @FXML
    private Button btnConfirm, btnClose, btnCancel;

    @FXML
    private Label name, saisId,  studentNumber, address;

    private String type;

    private Callback confirmButtonAction;

    private double xOffset = 0;
    private double yOffset = 0;
    public void setConfirmButtonAction(Callback callback) {
        this.confirmButtonAction = callback;
    }

    public void handleClicks(ActionEvent actionEvent) {
        Button clickedButton = (Button) actionEvent.getSource();

        if (clickedButton ==  btnConfirm) {
            if (confirmButtonAction != null) {
                confirmButtonAction.call();
            }
        }

        Stage stage = (Stage) btnConfirm.getScene().getWindow();
        stage.close();
    }

    public  void load(String type) {
        Parent root;
        this.type = type;


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/"+type+".fxml"));
        fxmlLoader.setController(this);
        try {
            root = (Parent) fxmlLoader.load();
        } catch (IOException e){
            e.printStackTrace();
            return;
        }

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.showAndWait();
    }


    public void load(String type, StudentData data) {
        Parent root;
        this.type = type;


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/"+type+".fxml"));
        fxmlLoader.setController(this);
        try {
            root = fxmlLoader.load();
        } catch (IOException e){
            e.printStackTrace();
            return;
        }

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initStyle(StageStyle.UNDECORATED);

        if (type.equals("confirm_delete")) {
            name.setText(data.name);
            studentNumber.setText(String.valueOf(data.studentNumber));
            saisId.setText(String.valueOf(data.saisId));
            address.setText(data.address);
        }

        // NOTE: the following methods enable the dialog box to be
        //        movable.
        root.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        root.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });

        stage.showAndWait();
    }

}
