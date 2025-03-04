package flyweight.rpg_map;

import javafx.scene.image.Image;

public class WaterTile implements Tile {
    @Override
    public char getCharacter() {
        return 'W';
    }

    @Override
    public String getDescription() {
        return "Water";
    }

    @Override
    public void action() {
        System.out.println("You are in water.");
    }

    @Override
    public Image getTileImage() {
        return TileGraphicFactory.getTileGraphic("Water");
    }
}
