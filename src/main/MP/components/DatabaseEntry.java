package MP.components;

import MP.interfaces.Callback;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import java.io.IOException;

import MP.StudentData;
import javafx.event.ActionEvent;
import javafx.fxml.*;

/**
 * The DatabaseEntry is a GUI component that is an abstraction
 * the boxes that is seen in the view, edit, and delete pages.
 *
 * This GUI component contains the information that shows name, SAIS ID,
 * student number and address of each entry in the database
 *
 */
public class DatabaseEntry extends Pane {
    @FXML
    private Text saisId, studentNumber;
    
    @FXML
    private Label name, address;

    @FXML
    private Button btn;

    private final String location;
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

    /**
     * Constructor for the DatabaseEntry GUI component. This is used to facilitate the
     * configuration of the entry.
     *
     * @param location the page wherein this GUI component is rendered
     * @param data the student data that is used to configure this entry
     */
    public DatabaseEntry(String location, StudentData data) {

        this.location = location;
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
        btn.setVisible(!location.equals("view") && !location.equals("search"));

        // Capitalize first letter of the string "type"
        String btnTitle =  location.substring(0, 1).toUpperCase() + location.substring(1);
        btn.setText(btnTitle);

        btn.setOnAction((ActionEvent e) -> {
            if (buttonAction != null) {
                buttonAction.call();
            }
        });

    }
}
