package MP;

import javafx.application.*;
import javafx.scene.*;
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
    private static StudentDB database;

    public void initialize(String[] args, StudentDB database) {
        launch(args);
        App.database = database;
    }

    public static StudentDB getDatabase() {
        return App.database;
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
        // set transparent
        // here>>
        // primaryStage.getIcons().add(new
        // Image(this.getClass().getResourceAsStream("file:meowIcon.png")));
        // Image icon = new Image(getClass().getResourceAsStream("files:meowIcon.png"));
        // primaryStage.getIcons().add(icon);
        // primaryStage.getIcons().add(new Image("meowIcon.png"));
        // stage.setTitle("Wow!! Stackoverflow Icon");
        // Image icon = new Image(getClass().getResourceAsStream("icon.png"));
        // stage.getIcons().add(icon);
        primaryStage.setTitle("Meow Student Database");
        //scene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
