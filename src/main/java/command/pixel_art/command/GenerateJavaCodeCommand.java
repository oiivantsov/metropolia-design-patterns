package command.pixel_art.command;

import command.pixel_art.PixelGrid;

public class GenerateJavaCodeCommand implements Command {
    private final PixelGrid grid;

    public GenerateJavaCodeCommand(PixelGrid grid) { this.grid = grid; }

    @Override
    public void execute() {
        System.out.println("int[][] pixelArt = {");
        boolean[][] pixels = grid.getPixels();
        for (int y = 0; y < grid.getSize(); y++) {
            System.out.print("    { ");
            for (int x = 0; x < grid.getSize(); x++) {
                System.out.print((pixels[y][x] ? 1 : 0) + (x < grid.getSize() - 1 ? ", " : ""));
            }
            System.out.println(" },");
        }
        System.out.println("};");
    }
}
