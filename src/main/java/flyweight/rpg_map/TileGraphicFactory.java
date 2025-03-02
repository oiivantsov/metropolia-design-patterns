package flyweight.rpg_map;

import javafx.scene.image.Image;
import java.util.HashMap;
import java.util.Map;

public class TileGraphicFactory {
    private static final Map<String, Image> tileGraphics = new HashMap<>();

    // effective control that only one instance of the image is created for each tile type
    public static Image getTileGraphic(String tileType) {
        if (!tileGraphics.containsKey(tileType)) {
            tileGraphics.put(tileType, loadImage(tileType));
        }
        return tileGraphics.get(tileType);
    }

    /*
    The attribution - flaticon.com images links:
        building: https://www.flaticon.com/free-icon/office-building_2098316
        forest: https://www.flaticon.com/free-icon/forest_532606
        road: https://www.flaticon.com/free-icon/road_2554922
        water: https://www.flaticon.com/free-icon/waterfall_4590717
        swamp: https://www.flaticon.com/free-icon/swamp_6057194
     */
    private static Image loadImage(String tileType) {
        String imagePath = "/images/" + tileType.toLowerCase() + ".png";
        return new Image(TileGraphicFactory.class.getResourceAsStream(imagePath));
    }
}