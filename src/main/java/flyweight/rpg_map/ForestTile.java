package flyweight.rpg_map;

import javafx.scene.image.Image;

public class ForestTile implements Tile {
    public char getCharacter() {
        return 'F';
    }

    public String getDescription() {
        return "Forest";
    }

    public void action() {
        System.out.println("You are in a forest. You can hear the birds chirping.");
    }

    @Override
    public Image getTileImage() {
        return TileGraphicFactory.getTileGraphic("Forest");
    }
}
