package flyweight.rpg_map;

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
}
