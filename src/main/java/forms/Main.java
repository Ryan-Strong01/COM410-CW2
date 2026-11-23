package forms;

import javax.swing.SwingUtilities;

/** Entry point: shows the splash screen, then the main menu. */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SplashScreen(() -> {
                MainMenu menu = new MainMenu();
                // Later: menu.setOnNewGame(...), menu.setOnHighScores(...)
                menu.setVisible(true);
            }).start();
        });
    }
}
