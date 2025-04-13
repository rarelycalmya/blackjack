package blackjack.blackjack;

import javax.swing.SwingUtilities;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import blackjack.blackjack.ui.GameUI;

@SpringBootApplication
public class BlackjackApplication {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GameUI(); // assuming GameUI extends JFrame and sets up everything
        });
    }
}
