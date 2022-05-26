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

/**
 * The DatabaseEntry is a GUI component that is an abstraction
 * the boxes that is seen in the view, edit, and delete pages.
 *
 * This GUI component contains the information that shows name, sais ID,
 * student number and address of each entry in the database.
 *
 */
public class DatabaseEntry extends Pane {
    @FXML
    private Text name, saisId, address, studentNumber;

    @FXML
    private Button btn;

    private final String type;
    private final StudentData data;
    private DialogBox dialogBox;

    private Callback buttonAction;

    private double xOffset = 0;
    private double yOffset = 0;

    /**
     * This function sets the data for the `buttonAction` field. It receives
     * a lambda function that gets executed whenever the button that is on the right
     * in it gets pressed.
     *
     * @param buttonAction Lambda function that gets "called" when the
     *                     button is pressed.
     */
    public void setButtonAction(Callback buttonAction) {
        this.buttonAction = buttonAction;
    }

    public DatabaseEntry(String type, StudentData data) {

        this.type = type;
        this.data = data;


        FXMLLoader root = new FXMLLoader(getClass().getResource(
                "/fxml/DatabaseEntry.fxml"));
        root.setRoot(this);
        root.setController(this);

        try {
            root.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }


        this.name.setText(data.name);
        this.saisId.setText(String.valueOf(data.saisId));
        this.address.setText(data.address);
        this.studentNumber.setText(String.valueOf(data.studentNumber));

        // Configure the button
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
}
