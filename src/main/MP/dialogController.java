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

public class dialogController {

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
    public void handleClicks(ActionEvent actionEvent) throws IOException 
    {
        if (actionEvent.getSource() == btnOK) {
            Stage stage = (Stage) btnOK.getScene().getWindow();
            stage.close();
        }
        if (actionEvent.getSource() == btnDialogclose) {
            Stage stage = (Stage) btnDialogclose.getScene().getWindow();
            stage.close();
        }
        if (actionEvent.getSource() == actionDelete) {
            Stage stage = (Stage) actionDelete.getScene().getWindow();
            stage.close();
            dialog("notif_deleted");
        }
        // if (actionEvent.getSource() == actionDelete) {
        //     dialog("notif_deleted");
        //     //delete function of the specified entry
        //     Stage stage = (Stage) actionDelete.getScene().getWindow();
        //     stage.close();
        // }
        
    }
    public void dialog(String pathFXML) throws IOException 
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/"+pathFXML+".fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.showAndWait();
    }
}
