package memento.guiState;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Gui extends Application {

    // create a GUI with three adjacent ColorBoxes and one CheckBox below them
    private Controller controller;
    private ColorBox colorBox1;
    private ColorBox colorBox2;
    private ColorBox colorBox3;
    private CheckBox checkBox;

    private ObservableList<String> historyItems = FXCollections.observableArrayList();

    public void start(Stage stage) {

        controller = new Controller(this);

        // Insets for margin and padding
        Insets insets = new Insets(10, 10, 10, 10);

        // Create three ColorBoxes
        colorBox1 = new ColorBox(1, controller);
        colorBox2 = new ColorBox(2, controller);
        colorBox3 = new ColorBox(3, controller);

        // Create a CheckBox
        checkBox = new CheckBox("Click me!");
        checkBox.setPadding(insets);

        // Add the ColorBoxes and CheckBox to a HBox
        HBox hBox = new HBox(colorBox1.getRectangle(), colorBox2.getRectangle(), colorBox3.getRectangle());
        hBox.setSpacing(10);

        hBox.setMargin(colorBox1.getRectangle(), insets);
        hBox.setMargin(colorBox2.getRectangle(), insets);
        hBox.setMargin(colorBox3.getRectangle(), insets);


        Label label1 = new Label("Press Ctrl-Z to undo the last change.");
        Label label2 = new Label("Press Ctrl-Y to redo");
        label1.setPadding(insets);
        label2.setPadding(insets);

        // create a VBox that contains the HBox and the CheckBox
        VBox vBox = new VBox(hBox, checkBox, label1, label2);
        // call controller when the CheckBox is clicked
        checkBox.setOnAction(event -> {
            controller.setIsSelected(checkBox.isSelected());
        });

        // Set the HBox to be the root of the Scene
        Scene scene = new Scene(vBox);
        scene.setOnKeyPressed(event -> {
            if (event.isControlDown() && event.getCode() == KeyCode.Z) {
                // Ctrl-Z: undo
                System.out.println("Undo key combination pressed");
                controller.undo();
            } else if (event.isControlDown() && event.getCode() == KeyCode.Y) {
                // Ctrl-Y: redo
                controller.redo();
            }
        });

        Button historyButton = new Button("Show History");
        historyButton.setOnAction(e -> showHistoryWindow());
        vBox.getChildren().add(historyButton);


        stage.setScene(scene);
        stage.setTitle("Memento Pattern Example");
        stage.show();
    }

    public void updateGui() {
        // called after restoring state from a Memento
        colorBox1.setColor(controller.getOption(1));
        colorBox2.setColor(controller.getOption(2));
        colorBox3.setColor(controller.getOption(3));
        checkBox.setSelected(controller.getIsSelected());
    }

    private void showHistoryWindow() {
        Stage historyStage = new Stage();
        ListView<String> listView = new ListView<>(historyItems);
        listView.setOnMouseClicked(event -> {
            int index = listView.getSelectionModel().getSelectedIndex();
            controller.restoreFromHistory(index);
        });

        VBox vBox = new VBox(listView);
        historyStage.setScene(new Scene(vBox));
        historyStage.setTitle("History Window");
        historyStage.show();
    }

    public void addHistoryEntry(String entry) {
        historyItems.add(entry);
    }
}
