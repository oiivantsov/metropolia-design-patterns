package memento.guiState;

public class Controller {
    private Model model;
    private Gui gui;
    private Caretaker caretaker;

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.caretaker = new Caretaker();
    }

    public void setOption(int optionNumber, int choice) {
        saveToHistory();
        model.setOption(optionNumber, choice);
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveToHistory();
        model.setIsSelected(isSelected);
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void undo() {
        IMemento previousState = caretaker.undo(model.createMemento());
        if (previousState != null) {
            model.restoreState(previousState);
            gui.updateGui();
        }
    }

    public void redo() {
        IMemento redoState = caretaker.redo(model.createMemento());
        if (redoState != null) {
            model.restoreState(redoState);
            gui.updateGui();
        }
    }

    public void restoreFromHistory(int index) {
        if (index >= 0 && index < caretaker.getUndoHistory().size()) {
            IMemento selectedMemento = caretaker.getUndoHistory().get(index);
            model.restoreState(selectedMemento);
            caretaker.saveState(selectedMemento);
            gui.updateGui();
        }
    }

    private void saveToHistory() {
        IMemento currentState = model.createMemento();
        caretaker.saveState(currentState);
        String entry = "Saved at: " + currentState.getTimestamp();
        gui.addHistoryEntry(entry);
    }
}
