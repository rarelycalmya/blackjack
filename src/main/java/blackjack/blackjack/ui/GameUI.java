package blackjack.blackjack.ui;

import blackjack.blackjack.controller.GameController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameUI extends JFrame {
    private GameController controller;
    private JTextArea outputArea;
    private JButton startButton;

    public GameUI() {
        super("Blackjack Game");

        controller = new GameController();

        setLayout(new BorderLayout());
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        startButton = new JButton("Start Game");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });
        add(startButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void startGame() {
        controller.startGame();

        StringBuilder sb = new StringBuilder();
        sb.append("Player's Hand: ").append(controller.getPlayer().getHand()).append("\n");
        sb.append("Player's Score: ").append(controller.getPlayer().getScore()).append("\n\n");

        sb.append("Dealer's Hand: ").append(controller.getDealer().getHand()).append("\n");
        sb.append("Dealer's Score: ").append(controller.getDealer().getScore()).append("\n\n");

        sb.append(controller.getWinnerMessage());

        outputArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GameUI());
    }
}
