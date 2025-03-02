package flyweight.rpg_map;

import javafx.scene.image.Image;

public interface Tile {
    char getCharacter();
    String getDescription();
    void action();
    Image getTileImage();
}
