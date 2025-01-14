package factory_method.rpg_map_generator;

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
