package src.controller;

import java.util.ArrayList;
import java.util.List;

public class Button {
    private final List<ActionListener> listeners;
    private boolean enabled;

    public Button(final boolean enabled) {
        this.enabled = enabled;
        this.listeners = new ArrayList<>();
    }

    public Button() {
        this(true);
    }

    public void addActionListener(final ActionListener listener) {
        listeners.add(listener);
    }

    public void removeActionListener(final ActionListener listener) {
        listeners.remove(listener);
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(final boolean enabled) {
        this.enabled = enabled;
    }

    // Méthode pour "simuler" un clic sur le bouton
    public void click() {
        if (!enabled) return;

        for (ActionListener listener : listeners) {
            listener.actionPerformed();
        }
    }
}
