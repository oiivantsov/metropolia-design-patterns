package command.pixel_art.command;

import command.pixel_art.PixelGrid;

public class MoveCursorUpCommand implements Command {
    private final PixelGrid grid;

    public MoveCursorUpCommand(PixelGrid grid) { this.grid = grid; }

    @Override
    public void execute() { grid.moveCursorUp(); }
}
