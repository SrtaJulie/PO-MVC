package src.controller;

public class Label {
    private String text;

    public Label(final String newText) {
        this.text = newText;
    }

    public Label() {
        this("");
    }

    public String getText() {
        return text;
    }

    public void setText(final String newText) {
        this.text = newText;
    }
}
