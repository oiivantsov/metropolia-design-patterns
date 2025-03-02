package flyweight.rpg_map;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Game extends Application {
    private static final int TILE_SIZE = 64;
    private static final int MAP_WIDTH = Map.WIDTH;
    private static final int MAP_HEIGHT = Map.HEIGHT;
    private static final int WINDOW_PADDING = 40; // extra space for borders

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Map map = createMap("City"); // Change to "Wilderness" for WildernessMap or "City" for CityMap

        int canvasWidth = MAP_WIDTH * TILE_SIZE;
        int canvasHeight = MAP_HEIGHT * TILE_SIZE;

        Canvas canvas = new Canvas(canvasWidth, canvasHeight);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        renderMap(gc, map);

        Pane root = new Pane();
        root.getChildren().add(canvas);
        Scene scene = new Scene(root, canvasWidth + WINDOW_PADDING, canvasHeight + WINDOW_PADDING);

        primaryStage.setScene(scene);
        primaryStage.setTitle("RPG Map");
        primaryStage.setWidth(canvasWidth + WINDOW_PADDING);
        primaryStage.setHeight(canvasHeight + WINDOW_PADDING);
//        primaryStage.setResizable(false); // resizing for fixed layout
        primaryStage.show();
    }

    private void renderMap(GraphicsContext gc, Map map) {
        for (int y = 0; y < MAP_HEIGHT; y++) {
            for (int x = 0; x < MAP_WIDTH; x++) {
                Tile tile = map.getTile(x, y);
                Image tileImage = tile.getTileImage();
                gc.drawImage(tileImage, x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }
    }

    public static Map createMap(String type) {
        return "City".equalsIgnoreCase(type) ? new CityMap() : new WildernessMap();
    }
}
