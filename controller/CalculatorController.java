package controller;

import model.CalculatorModel;
import view.CalculatorView;
import utils.HistoryManager;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class CalculatorController {
    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;

        setupButtons();
    }

    private void setupButtons() {
        String[][] layout = {
            {"7", "8", "9", "/"},
            {"4", "5", "6", "*"},
            {"1", "2", "3", "-"},
            {"0", ".", "(", ")"},
            {"C", "^", "%", "="}
        };

        for (int r = 0; r < layout.length; r++) {
            for (int c = 0; c < layout[r].length; c++) {
                final String label = layout[r][c];
                view.addButton(label, r, c, e -> handleInput(label));
            }
        }
    }

    private void handleInput(String input) {
        switch (input) {
            case "C" -> view.display.clear();
            case "=" -> evaluateExpression();
            default -> view.display.appendText(input);
        }
    }

    private void evaluateExpression() {
        try {
            String raw = view.display.getText()
                .replace("%", "/100")
                .replace("√", "sqrt");
            Expression expr = new ExpressionBuilder(raw).build();
            double result = expr.evaluate();
            String entry = raw + " = " + result;
            view.history.appendText(entry + "\n");
            HistoryManager.save(entry);
            view.display.setText(String.valueOf(result));
        } catch (Exception e) {
            view.display.setText("Fel: " + e.getMessage());
        }
    }
}
