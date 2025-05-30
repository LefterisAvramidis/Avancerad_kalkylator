package view;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

public class CalculatorView extends VBox {
    public TextField display = new TextField();
    public TextArea history = new TextArea();
    public GridPane buttonsGrid = new GridPane();
    public ToggleButton themeToggle = new ToggleButton("🌙 Dark Mode");
    public Button clearHistoryButton = new Button("🗑️ Rensa historik");

    public CalculatorView() {
        display.setEditable(false);
        display.setFont(Font.font(20));
        display.setPrefHeight(40);

        history.setEditable(false);
        history.setPrefRowCount(5);

        buttonsGrid.setHgap(10);
        buttonsGrid.setVgap(10);
        buttonsGrid.setPadding(new Insets(10));

        themeToggle.setPrefWidth(140);
        clearHistoryButton.setPrefWidth(140);

        this.setPadding(new Insets(15));
        this.setSpacing(10);
        this.getChildren().addAll(display, buttonsGrid, history, themeToggle, clearHistoryButton);
    }

    public void addButton(String label, int row, int col, javafx.event.EventHandler<javafx.event.ActionEvent> handler) {
        Button btn = new Button(label);
        btn.setPrefSize(60, 60);
        btn.setOnAction(handler);
        buttonsGrid.add(btn, col, row);
    }
}
