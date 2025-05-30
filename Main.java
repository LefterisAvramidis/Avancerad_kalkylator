import controller.CalculatorController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.CalculatorModel;
import utils.HistoryManager;
import utils.ThemeManager;
import view.CalculatorView;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView();
        CalculatorController controller = new CalculatorController(model, view);

        Scene scene = new Scene(view, 300, 500);
        ThemeManager.applyTheme(scene, false);

        view.history.setText(HistoryManager.loadHistory());

        view.themeToggle.setOnAction(e -> {
            boolean dark = view.themeToggle.isSelected();
            view.themeToggle.setText(dark ? "☀️ Light Mode" : "🌙 Dark Mode");
            ThemeManager.applyTheme(scene, dark);
        });

        view.clearHistoryButton.setOnAction(e -> {
            HistoryManager.clearHistory();
            view.history.clear();
        });

        primaryStage.setTitle("Avancerad Kalkylator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
