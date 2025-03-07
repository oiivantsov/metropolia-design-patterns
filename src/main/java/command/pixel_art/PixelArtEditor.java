package command.pixel_art;

import command.pixel_art.command.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PixelArtEditor extends Application {
    private static final int GRID_SIZE = 8;
    private static final int CELL_SIZE = 50;

    private final PixelGrid grid = new PixelGrid(GRID_SIZE);
    private final Canvas canvas = new Canvas(GRID_SIZE * CELL_SIZE, GRID_SIZE * CELL_SIZE);
    private final GraphicsContext gc = canvas.getGraphicsContext2D();

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primaryStage) {
        Button generateCodeButton = new Button("Generate Java Code");
        generateCodeButton.setOnAction(e -> new GenerateJavaCodeCommand(grid).execute());

        VBox root = new VBox(canvas, generateCodeButton);
        Scene scene = new Scene(root);

        setupCanvas(scene);
        drawGrid();

        primaryStage.setTitle("Pixel Art Editor");
        primaryStage.setScene(scene);
        primaryStage.show();

        canvas.requestFocus();
    }

    public void setupCanvas(Scene scene) {
        canvas.setFocusTraversable(true);
        canvas.setOnKeyPressed(event -> {
            Command command = switch (event.getCode()) {
                case UP -> new MoveCursorUpCommand(grid);
                case DOWN -> new MoveCursorDownCommand(grid);
                case LEFT -> new MoveCursorLeftCommand(grid);
                case RIGHT -> new MoveCursorRightCommand(grid);
                case SPACE -> new TogglePixelCommand(grid);
                default -> null;
            };

            if (command != null) {
                command.execute();
                drawGrid();
                event.consume();
            }
        });

        canvas.setOnMouseClicked(e -> canvas.requestFocus());
    }

    public void drawGrid() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        boolean[][] pixels = grid.getPixels();
        for (int y = 0; y < GRID_SIZE; y++) {
            for (int x = 0; x < GRID_SIZE; x++) {
                gc.setFill(pixels[y][x] ? Color.GREEN : Color.WHITE);
                gc.fillRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                gc.setStroke(Color.GRAY);
                gc.strokeRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        }

        gc.setStroke(Color.GREEN);
        gc.strokeRect(grid.getCursorX() * CELL_SIZE, grid.getCursorY() * CELL_SIZE, CELL_SIZE, CELL_SIZE);
    }
}
