package utils;

import javafx.scene.Scene;

public class ThemeManager {
    private static final String LIGHT = "style/light.css";
    private static final String DARK = "style/dark.css";

    public static void applyTheme(Scene scene, boolean isDark) {
        scene.getStylesheets().clear();
        scene.getStylesheets().add(isDark ? DARK : LIGHT);
    }
}
