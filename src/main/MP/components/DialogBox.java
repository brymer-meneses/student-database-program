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

    private  Stage stage;

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

        stage.close();
    }

    private void commonLoad(String type) {
        this.type = type;


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/"+type+".fxml"));
        fxmlLoader.setController(this);
        Parent root;
        try {
            root = fxmlLoader.load();
        } catch (IOException e){
            e.printStackTrace();
            return;
        }

        stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initStyle(StageStyle.UNDECORATED);

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
    }
    public void load(String type) {
        commonLoad(type);

        stage.showAndWait();
    }


    public void load(String type, StudentData data) {
        commonLoad(type);

        name.setText(data.name);
        address.setText(data.address);
        studentNumber.setText(String.valueOf(data.studentNumber));
        saisId.setText(String.valueOf(data.saisId));

        stage.showAndWait();
    }

}
