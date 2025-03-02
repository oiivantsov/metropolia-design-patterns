package flyweight.rpg_map;

import java.util.Random;

public class CityMap extends Map {
    @Override
    public Tile createTile(Random random) {
        int choice = random.nextInt(3);
        return switch (choice) {
            case 0 -> new RoadTile();
            case 1 -> new ForestTile();
            default -> new BuildingTile();
        };
    }
}
