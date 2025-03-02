package flyweight.rpg_map;

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
}
