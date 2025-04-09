package blackjack.blackjack.ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GamePanel extends JPanel {
    private Image backgroundImage;

    public GamePanel(Runnable onGameEnd) {
        setLayout(new BorderLayout());

        try {
            backgroundImage = ImageIO.read(new File("src/main/resources/bg.jpg")); // Replace with getResource if bundled
        } catch (IOException e) {
            System.out.println("Background image not found.");
        }

        // Card areas
        JLabel dealerCards = new JLabel("Dealer: [Cards here]");
        JLabel playerCards = new JLabel("Player: [Cards here]");
        dealerCards.setForeground(Color.WHITE);
        playerCards.setForeground(Color.WHITE);

        JPanel cardPanel = new JPanel(new GridLayout(2, 1));
        cardPanel.setOpaque(false);
        cardPanel.add(dealerCards);
        cardPanel.add(playerCards);

        // Control buttons
        JPanel buttonPanel = new JPanel();
        JButton hit = new JButton("Hit");
        JButton stand = new JButton("Stand");

        hit.addActionListener(e -> {
            System.out.println("Hit pressed");
            // Connect to controller
        });

        stand.addActionListener(e -> {
            System.out.println("Stand pressed");
            onGameEnd.run(); // Go to restart screen
        });

        buttonPanel.add(hit);
        buttonPanel.add(stand);

        buttonPanel.setOpaque(false); // So background is visible
        add(cardPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
