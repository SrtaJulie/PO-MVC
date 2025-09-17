package model;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private Integer value; // la donnée principale
    private final List<ModelListener> listeners; // la liste des observateurs

    public Model(final int newValue) {
        this.value = newValue;
        this.listeners = new ArrayList<>();
    }

    public Model() {
        this(10);
    }

    public int getValue() {
        return value;
    }

    public void setValue(final int newValue) {
        this.value = newValue;
        notifyListeners(); // important : prévenir les observateurs du changement
    }

    public void addModelListener(final ModelListener listener) {
        listeners.add(listener);
    }

    public void removeModelListener(final ModelListener listener) {
        listeners.remove(listener);
    }

    private void notifyListeners() {
        for (ModelListener listener : listeners) {
            listener.modelChange(this);
        }
    }
}
