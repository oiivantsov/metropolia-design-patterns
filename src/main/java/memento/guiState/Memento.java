package memento.guiState;

import java.time.LocalDateTime;

public class Memento implements IMemento {
    private int[] options;
    private boolean isSelected;
    private LocalDateTime timestamp;

    public Memento(int[] options, boolean isSelected) {
        this.options = options.clone(); // Copy options array
        this.isSelected = isSelected;
        this.timestamp = LocalDateTime.now(); // Save timestamp
        System.out.println("Memento created");
    }

    public int[] getOptions() {
        return options;
    }

    public boolean isSelected() {
        return isSelected;
    }

    @Override
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
