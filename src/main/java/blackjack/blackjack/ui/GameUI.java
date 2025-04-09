package blackjack.blackjack.ui;
import javax.swing.*;
import java.awt.*;

public class GameUI extends JFrame {
    private CardLayout cardLayout;
    private JPanel screens;

    public GameUI() {
        setTitle("Blackjack");
        setSize(1920, 1080);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        cardLayout = new CardLayout();
        screens = new JPanel(cardLayout);

        // Screens
        MainMenuPanel mainMenu = new MainMenuPanel(
                () -> showScreen("game"),
                () -> System.exit(0)
        );

        GamePanel gamePanel = new GamePanel(
                () -> showScreen("restart")
        );

        RestartPanel restartPanel = new RestartPanel(
                () -> showScreen("game"),
                () -> System.exit(0)
        );

        // Add screens
        screens.add(mainMenu, "menu");
        screens.add(gamePanel, "game");
        screens.add(restartPanel, "restart");

        add(screens);
        showScreen("menu");
        setVisible(true);
    }

    private void showScreen(String name) {
        cardLayout.show(screens, name);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GameUI::new);
    }
}
