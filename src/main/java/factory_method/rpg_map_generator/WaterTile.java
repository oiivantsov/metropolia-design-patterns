package factory_method.rpg_map_generator;

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
}
