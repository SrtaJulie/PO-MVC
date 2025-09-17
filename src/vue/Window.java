package app;

import model.Model;
import model.ModelListener;
import view.Button;
import view.Label;

import java.awt.event.ActionEvent;

public class Window {
    private final Button btn10;
    private final Button btn20;
    private final Button btn30;
    private final Label lblValue;
    private final Label lblText;
    private final Model model;

    public Window() {
        btn10 = new Button();
        btn20 = new Button();
        btn30 = new Button();
        lblValue = new Label();
        lblText = new Label();

        model = new Model();

        buildControllers();
        buildViews();
    }

    private void buildControllers() {
        btn10.addActionListener((ActionEvent aEvent) -> {
            model.setValue(10);
        });

        btn20.addActionListener((ActionEvent aEvent) -> {
            model.setValue(20);
        });

        btn30.addActionListener((ActionEvent aEvent) -> {
            model.setValue(30);
        });
    }

    private void buildViews() {
        final ModelListener lblValueListener = (aModel) -> {
            lblValue.setText(Integer.toString(aModel.getValue()));
        };

        final ModelListener lblTextListener = (aModel) -> {
            lblText.setText(convertToText(aModel.getValue()));
        };

        model.addModelListener(lblValueListener);
        model.addModelListener(lblTextListener);

        // init des labels avec la valeur initiale
        lblValueListener.modelChange(model);
        lblTextListener.modelChange(model);
    }

    private String convertToText(int aValue) {
        return "Coucou " + aValue;
    }
}
