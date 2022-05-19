package MP;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.net.URL;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.util.ResourceBundle;
import javafx.scene.layout.VBox;

public class viewController {

    @FXML
    private Pane Pane1;

    @FXML
    private Text addrerss1;

    @FXML
    private Button btnTest;

    @FXML
    private Text name1;

    @FXML
    private VBox pnItems;

    @FXML
    private VBox pnItems1;

    @FXML
    private Text sais1;

    @FXML
    private Text stunum1;

    @FXML
    public void handleClicks(ActionEvent actionEvent) throws IOException {
        if (actionEvent.getSource() == btnTest) {
            //Pane1.setVisible(false);
            //name1.setVisible(false);
            //sais1.setVisible(false);
            //stunum1.setVisible(false);
            //addrerss1.setVisible(false);
            name1.setText("HELLO");
            btnTest.setVisible(false);
        }

    }
}
