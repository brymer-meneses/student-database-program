import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.*;
import MP.StudentDBDemo;
import MP.App;
import java.io.IOException;

public class dialogController {

    @FXML
    private Button btnOK;

    @FXML
    private Button btnDialogclose;

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
    }
}
