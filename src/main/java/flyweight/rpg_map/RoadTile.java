package flyweight.rpg_map;

import javafx.scene.image.Image;

public class RoadTile implements Tile {
    @Override
    public char getCharacter() {
        return 'R';
    }

    @Override
    public String getDescription() {
        return "Road";
    }

    @Override
    public void action() {
        System.out.println("You are on a road.");
    }

    @Override
    public Image getTileImage() {
        return TileGraphicFactory.getTileGraphic("Road");
    }
}
