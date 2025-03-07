package command.pixel_art.command;

import command.pixel_art.PixelGrid;

public class MoveCursorRightCommand implements Command {
    private final PixelGrid grid;

    public MoveCursorRightCommand(PixelGrid grid) { this.grid = grid; }

    @Override
    public void execute() { grid.moveCursorRight(); }
}
