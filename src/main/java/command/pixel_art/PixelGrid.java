package command.pixel_art;

public class PixelGrid {
    private final int size;
    private boolean[][] pixels;
    private int cursorX = 0, cursorY = 0;

    public PixelGrid(int size) {
        this.size = size;
        pixels = new boolean[size][size];
    }

    public int getSize() { return size; }

    public boolean[][] getPixels() { return pixels; }

    public void moveCursorUp() { if (cursorY > 0) cursorY--; }
    public void moveCursorDown() { if (cursorY < size - 1) cursorY++; }
    public void moveCursorLeft() { if (cursorX > 0) cursorX--; }
    public void moveCursorRight() { if (cursorX < size - 1) cursorX++; }

    public int getCursorX() { return cursorX; }
    public int getCursorY() { return cursorY; }

    public void togglePixel() { pixels[cursorY][cursorX] = !pixels[cursorY][cursorX]; }
}
