package application;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ScrollBarApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create UI components
        Text text = new Text("Dynamic Color Text");
        text.setStyle("-fx-font-size: 24px;");

        Slider redSlider = createSlider();
        Slider greenSlider = createSlider();
        Slider blueSlider = createSlider();
        Slider opacitySlider = createSlider();

        // Labels
        Label redLabel = new Label("Red:");
        Label greenLabel = new Label("Green:");
        Label blueLabel = new Label("Blue:");
        Label opacityLabel = new Label("Opacity:");

        // Bind text fill color to slider values
        text.fillProperty().bind(Bindings.createObjectBinding(() ->
                Color.color(
                        redSlider.getValue() / 255,
                        greenSlider.getValue() / 255,
                        blueSlider.getValue() / 255,
                        opacitySlider.getValue() / 255), // Opacity should be divided by 255
                redSlider.valueProperty(),
                greenSlider.valueProperty(),
                blueSlider.valueProperty(),
                opacitySlider.valueProperty()));

        // Layout setup
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.add(redLabel, 0, 0);
        grid.add(redSlider, 1, 0);
        grid.add(greenLabel, 0, 1);
        grid.add(greenSlider, 1, 1);
        grid.add(blueLabel, 0, 2);
        grid.add(blueSlider, 1, 2);
        grid.add(opacityLabel, 0, 3);
        grid.add(opacitySlider, 1, 3);
        grid.add(text, 0, 4, 2, 1);

        // Scene and Stage setup
        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setTitle("Color Selector");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Helper method to create sliders
    private Slider createSlider() {
        Slider slider = new Slider(0, 255, 128); // Adjust the range to 255 for RGB/Opacity
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(50);
        slider.setBlockIncrement(10);
        return slider;
    }

    public static void main(String[] args) {
        launch(args);
    }
}