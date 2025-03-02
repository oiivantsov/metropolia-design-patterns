package flyweight.rpg_map;

import javafx.scene.image.Image;

public class BuildingTile implements Tile {
    @Override
    public char getCharacter() {
        return 'B';
    }

    @Override
    public String getDescription() {
        return "Building";
    }

    @Override
    public void action() {
        System.out.println("You entered a building.");
    }

    @Override
    public Image getTileImage() {
        return TileGraphicFactory.getTileGraphic("Building");
    }
}
