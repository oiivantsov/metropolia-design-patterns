package flyweight.rpg_map;

import java.util.Random;

public class WildernessMap extends Map {
    @Override
    public Tile createTile(Random random) {
        int choice = random.nextInt(3);
        return switch (choice) {
            case 0 -> new SwampTile();
            case 1 -> new WaterTile();
            default -> new ForestTile();
        };
    }
}
