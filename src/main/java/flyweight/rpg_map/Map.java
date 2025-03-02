package flyweight.rpg_map;

import java.util.Random;

public abstract class Map {
    static final int WIDTH = 10;
    static final int HEIGHT = 5;
    private final Tile[][] tiles = new Tile[HEIGHT][WIDTH];

    public Map() {
        generateMap();
    }

    private void generateMap() {
        Random random = new Random();
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                tiles[i][j] = createTile(random);
            }
        }
    }

    public abstract Tile createTile(Random random);

    public Tile getTile(int x, int y) {
        return tiles[y][x];
    }
}
