package flyweight.rpg_map;

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
