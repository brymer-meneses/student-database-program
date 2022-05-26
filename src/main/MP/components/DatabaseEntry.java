package MP.components;

import MP.DashController;
import MP.interfaces.Callback;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;

import javax.swing.Action;

import MP.StudentDB;
import MP.StudentData;
import javafx.event.ActionEvent;
import javafx.fxml.*;

public class DatabaseEntry extends Pane {
    @FXML
    private Text name, saisId, address, studentNumber;

    @FXML
    private Button btn;

    @FXML
    public VBox parent;

    private final String type;
    private final StudentData data;
    private DialogBox dialogBox;

    private Callback buttonAction;

    public void setButtonAction(Callback buttonAction) {
        this.buttonAction = buttonAction;
    }
    private void configureButton() {

        btn.setVisible(!type.equals("view") && !type.equals("search"));

        // Capitalize first letter of the string "type"
        String btnTitle =  type.substring(0, 1).toUpperCase() + type.substring(1);
        btn.setText(btnTitle);

        btn.setOnAction((ActionEvent e) -> {
            if (buttonAction != null) {
                buttonAction.call();
            }
        });

    }


    public DatabaseEntry(String type, StudentData data, VBox parent) {

        this.type = type;
        this.data = data;
        this.parent = parent;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "/fxml/DatabaseEntry.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        this.name.setText(data.name);
        this.saisId.setText(String.valueOf(data.saisId));
        this.address.setText(data.address);
        this.studentNumber.setText(String.valueOf(data.studentNumber));

        configureButton();

    }
}
