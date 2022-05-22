package MP.components;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;

import MP.StudentData;
import javafx.event.ActionEvent;
import javafx.fxml.*;

public class DatabaseEntry extends Pane {
    @FXML
    private Text name, saisId, address, studentNumber;

    @FXML
    private Button btnDelete;

    private int index;
    private boolean isDeletable;

    public void setData(int index, boolean isDeletable, StudentData student) {
        this.index = index;
        this.name.setText(student.name);
        this.saisId.setText(String.valueOf(student.saisID));
        this.address.setText(student.address);
        this.studentNumber.setText(String.valueOf(student.studentNumber));
        this.isDeletable = isDeletable;

        if (isDeletable) {
            btnDelete.setVisible(true);
        }
    }

    @FXML
    public void handleDelete(ActionEvent actionEvent) {
        this.setVisible(false);
    }

    public DatabaseEntry() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "/fxml/DatabaseEntry.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
