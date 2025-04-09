package blackjack.blackjack.ui;

import javax.swing.*;
import java.awt.*;

public class RestartPanel extends BackgroundPanel {
    public RestartPanel(Runnable onRestart, Runnable onQuit) {
        super("bgimage.png");
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(false);

        add(Box.createVerticalGlue());

        JLabel label = new JLabel("You Lost!");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setFont(new Font("SansSerif", Font.BOLD, 100));
        label.setForeground(Color.BLACK);
        add(label);
        add(Box.createVerticalStrut(20));

        ImageButton restartBtn = new ImageButton("playag.png");
        restartBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        restartBtn.addActionListener(e -> onRestart.run());
        add(restartBtn);
        add(Box.createVerticalStrut(15));

        ImageButton quitBtn = new ImageButton("exit.png");
        quitBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        quitBtn.addActionListener(e -> onQuit.run());
        add(quitBtn);

        add(Box.createVerticalGlue());
    }
}

