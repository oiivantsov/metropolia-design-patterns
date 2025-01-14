package factory_method.rpg_map_generator;

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
}