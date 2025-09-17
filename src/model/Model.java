package model;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private Integer value; // la donnée principale
    private List<ModelListener> listeners; // la liste des observateurs

    public Model() {
        this.value = 0;
        this.listeners = new ArrayList<>();
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer newValue) {
        this.value = newValue;
        notifyListeners(); // important : prévenir les observateurs du changement
    }

    public void addModelListener(ModelListener listener) {
        listeners.add(listener);
    }

    public void removeModelListener(ModelListener listener) {
        listeners.remove(listener);
    }

    private void notifyListeners() {
        for (ModelListener listener : listeners) {
            listener.modelChange(this);
        }
    }
}
