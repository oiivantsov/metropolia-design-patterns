package factory_method.rpg_map_generator;

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
}
