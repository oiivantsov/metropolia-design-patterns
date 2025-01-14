package factory_method.rpg_map_generator;

import java.util.Random;

public abstract class Map {
    static final int WIDTH = 10;
    static final int HEIGHT = 5;
    Tile[][] tiles = new Tile[HEIGHT][WIDTH];

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

    public void display() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                System.out.print(tiles[i][j].getCharacter() + " ");
            }
            System.out.println();
        }
    }
}
