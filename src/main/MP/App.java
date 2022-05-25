package MP;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.paint.Color;

public class App extends Application {
    // define your offsets here
    private double xOffset = 0;
    private double yOffset = 0;

    public void initialize(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/DashFX.fxml"));
        primaryStage.initStyle(StageStyle.TRANSPARENT);

        // grab your root here
        root.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        // move around here
        root.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - xOffset);
            primaryStage.setY(event.getScreenY() - yOffset);
        });
        Scene scene = new Scene(root);
        primaryStage.setTitle("Meow Student Database");
        primaryStage.getIcons().add(new Image(this.getClass().getResourceAsStream("/icons/meowIcon.png")));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
