package command.pixel_art.command;

import command.pixel_art.PixelGrid;

public class MoveCursorDownCommand implements Command {
    private final PixelGrid grid;

    public MoveCursorDownCommand(PixelGrid grid) { this.grid = grid; }

    @Override
    public void execute() { grid.moveCursorDown(); }
}
