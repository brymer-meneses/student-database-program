package MP.components;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

import MP.StudentDB;
import MP.StudentData;

public class DialogBox extends Pane {

    @FXML
    private Button btnConfirm, btnClose, btnCancel;

    private StudentData data;
    private String type;

    public DatabaseEntry entryCaller;

    public void setEntryCaller(DatabaseEntry entryCaller) {
        this.entryCaller = entryCaller;
    }

    public void handleClicks(ActionEvent actionEvent) {
        Button clickedButton = (Button) actionEvent.getSource();
        StudentDB database = StudentDB.readSavedData();

        if (clickedButton ==  btnConfirm) {
            switch (type) {
                case "confirm_delete":
                    database.deleteData(data.name, data.saisID);
                    entryCaller.parent.getChildren().remove(entryCaller);
                    break;
                case "confirm_edit":
                    System.out.println("editing");
                    break;
            }

        }

        Stage stage = (Stage) btnConfirm.getScene().getWindow();
        stage.close();
    }


    public void load(String type, StudentData data) {
        this.data = data;
        this.type = type;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/"+type+".fxml"));
        fxmlLoader.setController(this);
        try {
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.initStyle(StageStyle.UNDECORATED);
            stage.showAndWait();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

}
