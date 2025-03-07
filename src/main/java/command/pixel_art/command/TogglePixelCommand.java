package command.pixel_art.command;

import command.pixel_art.PixelGrid;

public class TogglePixelCommand implements Command {
    private final PixelGrid grid;

    public TogglePixelCommand(PixelGrid grid) { this.grid = grid; }

    @Override
    public void execute() { grid.togglePixel(); }
}
