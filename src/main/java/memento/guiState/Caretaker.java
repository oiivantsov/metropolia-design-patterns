package memento.guiState;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {
    private List<IMemento> undoHistory;
    private List<IMemento> redoHistory;

    public Caretaker() {
        this.undoHistory = new ArrayList<>();
        this.redoHistory = new ArrayList<>();
    }

    public void saveState(IMemento memento) {
        undoHistory.add(memento);
        redoHistory.clear();
    }

    public IMemento undo(IMemento currentState) {
        if (!undoHistory.isEmpty()) {
            redoHistory.add(currentState); // we need to save the current state before undoing to redo it later
            return undoHistory.remove(undoHistory.size() - 1);
        }
        return null;
    }

    public IMemento redo(IMemento currentState) {
        if (!redoHistory.isEmpty()) {
            undoHistory.add(currentState);
            return redoHistory.remove(redoHistory.size() - 1);
        }
        return null;
    }

    public List<IMemento> getUndoHistory() {
        return undoHistory;
    }
}
