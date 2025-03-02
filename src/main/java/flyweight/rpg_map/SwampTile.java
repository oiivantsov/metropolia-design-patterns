package flyweight.rpg_map;

import javafx.scene.image.Image;

public class SwampTile implements Tile {
    @Override
    public char getCharacter() {
        return 'S';
    }

    @Override
    public String getDescription() {
        return "Swamp";
    }

    @Override
    public void action() {
        System.out.println("You are in a swamp.");
    }

    @Override
    public Image getTileImage() {
        return TileGraphicFactory.getTileGraphic("Swamp");
    }
}
