package MP.components;

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

    private boolean isDeletable;

    @FXML
    private VBox parent;

    public void setParent(VBox parent) {
        this.parent = parent;
    }

    public void setButtonFunction(String function) {
        if (function == null) {
            this.btn.setVisible(false);
        } else {
            this.btn.setVisible(true);
        }

        if (function == "delete") {
            this.btn.setText("Delete");
            this.btn.setOnAction((ActionEvent e) -> {
                this.handleDelete(e);
            });
        } else if (function == "edit") {
            this.btn.setText("Edit");
            this.btn.setOnAction((ActionEvent e) -> {
                this.handleEdit(e);
            });
        }
    }

    public void setData(StudentData student) {
        this.name.setText(student.name);
        this.saisId.setText(String.valueOf(student.saisID));
        this.address.setText(student.address);
        this.studentNumber.setText(String.valueOf(student.studentNumber));

    }

    public void handleEdit(ActionEvent e) {

    }

    public void handleDelete(ActionEvent actionEvent) {
        this.parent.getChildren().remove(this);
        StudentDB database = StudentDB.readSavedData();
        database.deleteData(this.name.getText(), Integer.parseInt(this.saisId.getText()));
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
